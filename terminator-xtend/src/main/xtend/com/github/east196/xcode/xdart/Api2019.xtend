package com.github.east196.xcode.xdart

import com.github.east196.xcode.bot.Bots
import com.github.east196.xcode.model.Field
import com.github.east196.xcode.model.GeneResult
import com.github.east196.xcode.model.Project
import com.github.east196.xcode.model.Record
import com.github.east196.xcode.model.Three
import java.util.List
import org.apache.poi.hwpf.usermodel.Table
import org.eclipse.xtend.lib.annotations.Data

class Api2019 {

	def static void main(String[] args) {
		var src = '''E:\backup\xcode\API_EM_NEW(1).doc'''
		gene(src)
	}

	public def static void gene(String src) {
		val tables = Bots.tables(src)
		println("--表格总数：" + tables.size())

		val projecttable = tables.filter[it.getRow(0).getCell(0).text.trim.equalsIgnoreCase("project")].get(0)
		val datatables = tables.filter[it.getRow(0).getCell(0).text.trim.equalsIgnoreCase("vo")]
		val resttables = tables.filter[it.getRow(0).getCell(0).text.trim.equalsIgnoreCase("rest")]

		val projectThree = table2project(projecttable)
		datatables.forEach [ table |
			val three = table2data(projectThree, table)
			three.project = projectThree.project
			threeEntityGene(three).copy
		]

		val httpReqResps = resttables.map [ table |
			println(table.getRow(0).getCell(1).text)
			val rest = table2rest(projectThree.project, table)
			rest
		].toList

		httpReqResps.forEach [ rest |
			var Three project = rest.project

			var Three headers = rest.headers
			geneEntity(headers, project)

			var Three params = rest.params
			geneEntity(params, project)

			var Three reqBody = rest.reqBody
			geneEntity(reqBody, project)

			var Three respBody = rest.respBody
			geneEntity(respBody, project)
		]

		val controllerName = projectThree.project.name.toFirstUpper + "Controller"
		val feignName = projectThree.project.name.toFirstUpper + "FeignClient"
		val retrofit2Name = projectThree.project.name.toFirstUpper + "Retrofit2Client"
		val basePath = projectThree.project.path
		val javaPath = projectThree.project.root.split("\\.").join("\\")
		var packageName = projectThree.project.name.toFirstLower

		var content = controller(projectThree,
			httpReqResps)
		var path = '''«basePath»\src\main\java\«javaPath»\«packageName»\«projectThree.project.name.toFirstUpper»Controller.java'''
		new GeneResult(content, path).copy

		content = service(projectThree,
			httpReqResps)
		path = '''«basePath»\src\main\java\«javaPath»\«packageName»\«projectThree.project.name.toFirstUpper»Service.java'''
		new GeneResult(content, path).copy

		content = retrofit2(projectThree,
			httpReqResps)
		path = '''«basePath»\src\main\java\«javaPath»\«packageName»\«projectThree.project.name.toFirstUpper»Retrofit2Client.java'''
		new GeneResult(content, path).copy

		content = retrofit2remote(projectThree, httpReqResps)
		path = '''«basePath»\src\main\java\«javaPath»\«packageName»\Retrofit2Remote.java'''
		new GeneResult(content, path).copy

		content = feign(projectThree,
			httpReqResps)
		path = '''«basePath»\src\main\java\«javaPath»\«packageName»\«projectThree.project.name.toFirstUpper»FeignClient.java'''
		new GeneResult(content, path).copy

		content = client(projectThree,
			httpReqResps)
		path = '''«basePath»\src\main\java\«javaPath»\«packageName»\«projectThree.project.name.toFirstUpper»Client.java'''
		new GeneResult(content, path).copy

		content = dio(projectThree,
			httpReqResps)
		path = '''«basePath»\src\main\java\«javaPath»\«packageName»\«projectThree.project.name.toFirstUpper»DioClient.dart'''
		new GeneResult(content, path).copy

		content = mockResp(projectThree,
			httpReqResps)
		path = '''«basePath»\src\main\java\«javaPath»\«packageName»\«projectThree.project.name.toFirstUpper»MockResp.js'''
		new GeneResult(content, path).copy
	}

	protected def static void geneEntity(Three part, Three project) {
		if (part.fields.length > 0) {
			part.project = project.project
			threeEntityGene(part).copy
		}
	}

	protected def static CharSequence threeEntityContent(Three three) {
		var Project project = three.project
		var Record record = three.record
		var List<Field> fields = three.fields
		if (!record.name.endsWith("RespBody") && fields.size == 0) {
			return ''''''
		}
		var content = entity(project, record, fields)
		content
	}

	protected def static CharSequence threeEntityPath(Three three) {

		val basePath = three.project.path
		val javaPath = three.project.root.split("\\.").join("\\")
		var packageName = three.project.name.toFirstLower
		var Project project = three.project
		var Record record = three.record
		var List<Field> fields = three.fields
		if (!record.name.endsWith("RespBody") && fields.size == 0) {
			return ''''''
		}
		var path = '''«basePath»\src\main\java\«javaPath»\«packageName»\vo\«record.name.toFirstUpper».java'''
		path
	}

	protected def static GeneResult threeEntityGene(Three three) {
		var content = threeEntityContent(three)
		var path = threeEntityPath(three)
		println(path)
		println(content)
		new GeneResult(content, path)
	}

	def static table2rest(Project projectInfo, Table table) {
		var Three project = threeFrom(projectInfo, table)
		var Three headers = threeFrom(table, "Headers")
		var Three params = threeFrom(table, "Params")
		var Three reqBody = threeFrom(table, "ReqBody")
		var Three reqBodyEntity = threeFrom(table, "请求体")
		var Three respBody = threeFrom(table, "RespBody")
		var Three respBodyEntity = threeFrom(table, "响应体")
		new HttpReqResp(project, headers, params, reqBody, reqBodyEntity, respBody, respBodyEntity)
	}

	def static Three threeFrom(Project project, Table table) {
		var Record record = recordFrom(table)
		new Three(project, record, null)
	}

	def static Three threeFrom(Table table, String type) {
		var Project project = new Project
		var Record record = recordFrom(table)
		record.name = record.name + type.toFirstUpper
		new Three(project, record, fieldsFrom(table, type))
	}

	def static recordFrom(Table resttable) {
		var record = new Record
		record.method = resttable.getRow(1).getCell(1).text.trim
		record.url = resttable.getRow(2).getCell(1).text.trim
		record.name = resttable.getRow(0).getCell(1).text.trim
		record.label = resttable.getRow(0).getCell(3).text.trim
		record.doc = resttable.getRow(1).getCell(3).text.trim
		record
	}

	def static fieldsFrom(Table resttable, String type) {
		var List<Field> fields = newArrayList()
		for (var j = 3; j < resttable.numRows; j++) {
			var row = resttable.getRow(j)
			var rowType = row.getCell(0).text.trim
			if (rowType.equalsIgnoreCase(type) && !row.getCell(1).text.trim.nullOrEmpty) {
				var field = new Field()
				field.name = row.getCell(1).text.trim
				field.name = field.name.replace(" ", "_").split("_").map[item|item.toFirstUpper].join().toFirstLower
				field.type = row.getCell(2).text.trim
				field.label = row.getCell(3).text.trim
				field.doc = row.getCell(3).text.trim
				fields.add(field)
			}
		}
		fields
	}

	def static entity(Project project, Record record, List<Field> fields) {
		var klassType = record.name.toFirstUpper
		var packageName = project.name.toFirstLower
		val basePackageName = project.root
		val commonPackageName = project.root.split("\\.").subList(0, project.root.split("\\.").length - 1).join(".")

		'''
			package «basePackageName».«packageName».vo;
			
			import java.util.List;
			import java.util.Date;
			import java.util.HashMap;
			import java.util.Map;
			import java.util.ArrayList;
			
			import lombok.Data;
			
			
			import «commonPackageName».common.Converts;
			import «commonPackageName».common.vo.*;
			
			@Data
			public class «klassType» {
			
				«FOR f : fields»
					/** «f.doc» «f.label» **/
					private «f.javaType» «f.name.toFirstLower»;	
				«ENDFOR»
			
				public Map<String,Object> toMap(){
					Map<String,Object> map = new HashMap<>();
					«FOR f : fields»
						map.put("«f.name.toFirstLower»",«f.name.toFirstLower»);	
					«ENDFOR»
					return map;
				}
			
				public List<NameValuePair> toNameValuePairs(){
					List<NameValuePair> nameValuePairs = new ArrayList<>();
					«FOR f : fields»
						NameValuePair «f.name.toFirstLower»pair = new NameValuePair("«f.name.toFirstLower»",«f.name.toFirstLower».toString());	
						nameValuePairs.add(«f.name.toFirstLower»pair);
					«ENDFOR»
					return nameValuePairs;
				}
				
			«««				public static «klassType» fromMap(Map<String,Object> map){
«««					«klassType» «klassType.toFirstLower» = new «klassType»();
«««					«FOR f : fields»
«««						«klassType.toFirstLower».set«f.name.toFirstUpper»(Converts.to«f.javaType»(map.get("«f.name.toFirstLower»")));
«««					«ENDFOR»
«««					return «klassType.toFirstLower»;
«««				}
			
			}
			'''
	}

	def static retrofit2remote(Three projectThree, List<HttpReqResp> httpReqResps) {
		var packageName = projectThree.project.name.toFirstLower
		val basePackageName = projectThree.project.root
		'''
package «basePackageName».«packageName»;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import com.google.gson.GsonBuilder;

public class Retrofit2Remote {

	private static final String BASE_URL = "http://httpbin.org/";
	private static final String TOKEN_NAME = "X-Access-Token";

	private static String token = null;

	private static String getToken() {
		return token;
	}

	public static OkHttpClient okHttpClient;
	public static Retrofit retrofit;

	static {
		class TokenHeaderInterceptor implements Interceptor {

			@Override
			public Response intercept(Chain chain) throws IOException {
				String token = getToken();
				if (StringUtils.isEmpty(token)) {
					Request originalRequest = chain.request();
					return chain.proceed(originalRequest);
				} else {
					Request originalRequest = chain.request();
					Request updateRequest = originalRequest.newBuilder().header(TOKEN_NAME, token).build();
					return chain.proceed(updateRequest);
				}
			}

		}

		okHttpClient = new OkHttpClient.Builder().addNetworkInterceptor(new TokenHeaderInterceptor()).build();
		retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
				.addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create()))
				.client(okHttpClient).build();

	}

}
		'''
	}

	def static retrofit2(Three projectThree, List<HttpReqResp> httpReqResps) {
		val controllerName = projectThree.project.name.toFirstUpper + "Controller"
		val feignName = projectThree.project.name.toFirstUpper + "FeignClient"
		val retrofit2Name = projectThree.project.name.toFirstUpper + "Retrofit2Client"
		val basePath = projectThree.project.path
		val javaPath = projectThree.project.root.split("\\.").join("\\")
		var packageName = projectThree.project.name.toFirstLower
		val basePackageName = projectThree.project.root
		val commonPackageName = projectThree.project.root.split("\\.").subList(0,
			projectThree.project.root.split("\\.").length - 1).
			join(
				".")

		'''
				package «basePackageName».«packageName»;
				
				«IF httpReqResps.exists[it.respBody.record.method.equalsIgnoreCase("GET")]»import retrofit2.http.GET;«ENDIF»
				«IF httpReqResps.exists[it.respBody.record.method.equalsIgnoreCase("POST")]»import retrofit2.http.POST;«ENDIF»
				«IF httpReqResps.exists[it.respBody.record.method.equalsIgnoreCase("DELETE")]»import retrofit2.http.DELETE;«ENDIF»
				import retrofit2.http.Query;
				import retrofit2.http.QueryMap;
				import retrofit2.http.Body;
				import retrofit2.Call;
				
				import java.util.Map;
				import java.util.Date;
				import java.util.List;
				
				
				import «basePackageName».«packageName».vo.*;
				import «commonPackageName».common.vo.*;
				
				
				public interface «retrofit2Name» {
					
				«FOR http : httpReqResps»
					/** «http.respBody.record.label» */
					@«http.respBody.record.method.toUpperCase»("/yjfirewall/api/v1/«http.respBody.record.url»")
					Call<«IF http.respBody.fields.size>0»DataResponse<«http.respBody.record.name.toFirstUpper»>
					«ELSEIF http.respBodyEntity.fields.size>0»DataResponse<«http.respBodyEntity.fields.get(0).type.toFirstUpper»>
					«ELSE»Response«ENDIF»> «http.respBody.record.name.replace("RespBody","").toFirstLower»(
					«FOR f : http.params.fields SEPARATOR ","»@Query("«f.javaName»")«f.javaType.toFirstUpper» «f.javaName»
					«ENDFOR»
					«IF http.reqBody.fields.size>0 && http.params.fields.size>0»,«ENDIF»
					«IF http.reqBody.fields.size>0»@Body «http.reqBody.record.name.toFirstUpper» «http.reqBody.record.name.toFirstLower»«ENDIF»
					«IF http.reqBodyEntity.fields.size>0 && http.params.fields.size>0»,«ENDIF»
					«IF http.reqBodyEntity.fields.size>0»@Body «http.reqBodyEntity.fields.get(0).type.toFirstUpper» «http.reqBodyEntity.fields.get(0).name.toFirstLower»«ENDIF»
					);
				«ENDFOR»
				}
			'''
		}

		def static feign(Three projectThree, List<HttpReqResp> httpReqResps) {
			val controllerName = projectThree.project.name.toFirstUpper + "Controller"
			val feignName = projectThree.project.name.toFirstUpper + "FeignClient"
			val retrofit2Name = projectThree.project.name.toFirstUpper + "Retrofit2Client"
			val basePath = projectThree.project.path
			val javaPath = projectThree.project.root.split("\\.").join("\\")
			var packageName = projectThree.project.name.toFirstLower
			val basePackageName = projectThree.project.root
			val commonPackageName = projectThree.project.root.split("\\.").subList(0,
				projectThree.project.root.split("\\.").length - 1).join(".")

			'''
				package «basePackageName».«packageName»;
				
				import java.util.Date;
				import java.util.List;
				import java.util.Map;
				
				import org.springframework.cloud.openfeign.FeignClient;
				import org.springframework.web.bind.annotation.PathVariable;
				import org.springframework.web.bind.annotation.RequestBody;
				import org.springframework.web.bind.annotation.RequestMapping;
				import org.springframework.web.bind.annotation.RequestMethod;
				import org.springframework.web.bind.annotation.RequestParam;
				
				
				import «basePackageName».«packageName».vo.*;
				import «commonPackageName».common.vo.*;
				
				@FeignClient(url = "${feign.restcli.request.url}/", name = "«feignName.toFirstLower»")
				public interface «feignName» {
					
					«FOR http : httpReqResps»
						/** «http.respBody.record.label» */
						@RequestMapping(value="«http.respBody.record.url»",method=RequestMethod.«http.respBody.record.method.toUpperCase»)
						«IF http.respBody.fields.size>0»DataResponse<«http.respBody.record.name.toFirstUpper»>
						«ELSEIF http.respBodyEntity.fields.size>0»DataResponse<«http.respBodyEntity.fields.get(0).type.toFirstUpper»>
						«ELSE»Response«ENDIF» «http.respBody.record.name.replace("RespBody","").toFirstLower»(
						«FOR f : http.params.fields SEPARATOR ","»@RequestParam("«f.javaName»")«f.javaType.toFirstUpper» «f.javaName»
						«ENDFOR»
						«IF http.reqBody.fields.size>0 && http.params.fields.size>0»,«ENDIF»
						«IF http.reqBody.fields.size>0»@RequestBody «http.reqBody.record.name.toFirstUpper» «http.reqBody.record.name.toFirstLower»«ENDIF»
						«IF http.reqBodyEntity.fields.size>0 && http.params.fields.size>0»,«ENDIF»
						«IF http.reqBodyEntity.fields.size>0»@RequestBody «http.reqBodyEntity.fields.get(0).type.toFirstUpper» «http.reqBodyEntity.fields.get(0).name.toFirstLower»«ENDIF»
						);
					«ENDFOR»
				}
			'''
		}

		def static client(Three projectThree, List<HttpReqResp> httpReqResps) {
			val controllerName = projectThree.project.name.toFirstUpper + "Controller"
			val clientName = projectThree.project.name.toFirstUpper + "Client"
			val retrofit2Name = projectThree.project.name.toFirstUpper + "Retrofit2Client"
			val basePath = projectThree.project.path
			val javaPath = projectThree.project.root.split("\\.").join("\\")
			var packageName = projectThree.project.name.toFirstLower
			val basePackageName = projectThree.project.root
			val commonPackageName = projectThree.project.root.split("\\.").subList(0,
				projectThree.project.root.split("\\.").length - 1).join(".")

			'''
				package «basePackageName».«packageName»;
				
				import java.util.Date;
				import java.util.List;
				import java.util.Map;
				
				
				import «basePackageName».«packageName».vo.*;
				import «commonPackageName».common.vo.*;
				
				public interface «clientName» {
					
					«FOR http : httpReqResps»
						/** «http.respBody.record.label» */
						«IF http.respBody.fields.size>0»DataResponse<«http.respBody.record.name.toFirstUpper»>
						«ELSEIF http.respBodyEntity.fields.size>0»DataResponse<«http.respBodyEntity.fields.get(0).type.toFirstUpper»>
						«ELSE»Response«ENDIF» «http.respBody.record.name.replace("RespBody","").toFirstLower»(
						«FOR f : http.params.fields SEPARATOR ","»«f.javaType.toFirstUpper» «f.javaName»
						«ENDFOR»
						«IF http.reqBody.fields.size>0 && http.params.fields.size>0»,«ENDIF»
						«IF http.reqBody.fields.size>0»«http.reqBody.record.name.toFirstUpper» «http.reqBody.record.name.toFirstLower»«ENDIF»
						«IF http.reqBodyEntity.fields.size>0 && http.params.fields.size>0»,«ENDIF»
						«IF http.reqBodyEntity.fields.size>0»«http.reqBodyEntity.fields.get(0).type.toFirstUpper» «http.reqBodyEntity.fields.get(0).name.toFirstLower»«ENDIF»
						);
					«ENDFOR»
				}
			'''
		}

		def static controller(Three projectThree, List<HttpReqResp> httpReqResps) {
			val controllerName = projectThree.project.name.toFirstUpper + "Controller"
			val serviceName = projectThree.project.name.toFirstUpper + "Service"
			val feignName = projectThree.project.name.toFirstUpper + "FeignClient"
			val retrofit2Name = projectThree.project.name.toFirstUpper + "Retrofit2Client"
			val basePath = projectThree.project.path
			val javaPath = projectThree.project.root.split("\\.").join("\\")
			var packageName = projectThree.project.name.toFirstLower
			val basePackageName = projectThree.project.root
			val commonPackageName = projectThree.project.root.split("\\.").subList(0,
				projectThree.project.root.split("\\.").length - 1).join(".")

			'''
				package «basePackageName».«packageName»;
				
				import java.util.Date;
				import java.util.List;
				import java.util.Map;
				
				import org.springframework.beans.factory.annotation.Autowired;
				import org.springframework.web.bind.annotation.PathVariable;
				import org.springframework.web.bind.annotation.RequestBody;
				import org.springframework.web.bind.annotation.RequestMapping;
				import org.springframework.web.bind.annotation.RequestMethod;
				import org.springframework.web.bind.annotation.RequestParam;
				import org.springframework.web.bind.annotation.RestController;
				
				
				import «basePackageName».«packageName».vo.*;
				import «commonPackageName».common.vo.*;
				
				@RestController
				public class «controllerName» {
					
					@Autowired
					«serviceName» «serviceName.toFirstLower»;
					
					
					«FOR http : httpReqResps»
						/** «http.respBody.record.label» */
						@RequestMapping(value="«http.respBody.record.url»",method=RequestMethod.«http.respBody.record.method.toUpperCase»)
						public «IF http.respBody.fields.size>0»DataResponse<«http.respBody.record.name.toFirstUpper»>
						«ELSEIF http.respBodyEntity.fields.size>0»DataResponse<«http.respBodyEntity.fields.get(0).type.toFirstUpper»>
						«ELSE»Response«ENDIF» «http.respBody.record.name.replace("RespBody","").toFirstLower»(
						«FOR f : http.params.fields SEPARATOR ","»
							@RequestParam(value="«f.javaName»"«IF f.javaName =="pageNo"»,required = false, defaultValue = "1"«ENDIF»«IF f.javaName == "pageSize" »,required = false, defaultValue = "20"«ENDIF»)«f.javaType.toFirstUpper» «f.javaName»
						«ENDFOR»
						«IF http.reqBody.fields.size>0 && http.params.fields.size>0»,«ENDIF»
						«IF http.reqBody.fields.size>0»@RequestBody «http.reqBody.record.name.toFirstUpper» «http.reqBody.record.name.toFirstLower»«ENDIF»
						«IF http.reqBodyEntity.fields.size>0 && http.params.fields.size>0»,«ENDIF»
						«IF http.reqBodyEntity.fields.size>0»@RequestBody «http.reqBodyEntity.fields.get(0).type.toFirstUpper» «http.reqBodyEntity.fields.get(0).name.toFirstLower»«ENDIF»
						){
							«IF http.params.fields.exists[f|f.javaName =="pageNo"]»
								if (queryMap.containsKey("pageNo") && queryMap.containsKey("pageSize")) {
									pageNo = Integer.parseInt(queryMap.get("pageNo"));
									pageSize = Integer.parseInt(queryMap.get("pageSize"));
								}
							«ENDIF»
							return «serviceName.toFirstLower».«http.respBody.record.name.replace("RespBody","").toFirstLower»(
						«FOR f : http.params.fields SEPARATOR ","»«f.javaName»
						«ENDFOR»
						«IF http.reqBody.fields.size>0 && http.params.fields.size>0»,«ENDIF»
						«IF http.reqBody.fields.size>0»«http.reqBody.record.name.toFirstLower»«ENDIF»
						«IF http.reqBodyEntity.fields.size>0 && http.params.fields.size>0»,«ENDIF»
						«IF http.reqBodyEntity.fields.size>0»«http.reqBodyEntity.fields.get(0).name.toFirstLower»«ENDIF»					
							);
						}
					«ENDFOR»
				}
			'''
		}

		def static service(Three projectThree, List<HttpReqResp> httpReqResps) {
			val serviceName = projectThree.project.name.toFirstUpper + "Service"
			val feignName = projectThree.project.name.toFirstUpper + "FeignClient"
			val retrofit2Name = projectThree.project.name.toFirstUpper + "Retrofit2Client"
			val basePath = projectThree.project.path
			val javaPath = projectThree.project.root.split("\\.").join("\\")
			var packageName = projectThree.project.name.toFirstLower
			val basePackageName = projectThree.project.root
			val commonPackageName = projectThree.project.root.split("\\.").subList(0,
				projectThree.project.root.split("\\.").length - 1).join(".")

			'''
				package «basePackageName».«packageName»;
				
				import java.util.Date;
				import java.util.List;
				import java.util.Map;
				
				
				import «basePackageName».«packageName».vo.*;
				import «commonPackageName».common.vo.*;
				
				public interface «serviceName» {
					
					«FOR http : httpReqResps»
						/** «http.respBody.record.label» */
						«IF http.respBody.fields.size>0»DataResponse<«http.respBody.record.name.toFirstUpper»>
						«ELSEIF http.respBodyEntity.fields.size>0»DataResponse<«http.respBodyEntity.fields.get(0).type.toFirstUpper»>
						«ELSE»Response«ENDIF» «http.respBody.record.name.replace("RespBody","").toFirstLower»(
						«FOR f : http.params.fields SEPARATOR ","»«f.javaType.toFirstUpper» «f.javaName»
						«ENDFOR»
						«IF http.reqBody.fields.size>0 && http.params.fields.size>0»,«ENDIF»
						«IF http.reqBody.fields.size>0»«http.reqBody.record.name.toFirstUpper» «http.reqBody.record.name.toFirstLower»«ENDIF»
						«IF http.reqBodyEntity.fields.size>0 && http.params.fields.size>0»,«ENDIF»
						«IF http.reqBodyEntity.fields.size>0»«http.reqBodyEntity.fields.get(0).type.toFirstUpper» «http.reqBodyEntity.fields.get(0).name.toFirstLower»«ENDIF»
						);
					«ENDFOR»
				}
			'''
		}

		def static dio(Three projectThree, List<HttpReqResp> httpReqResps) {
			'''
				import 'package:dio/dio.dart';
				import 'package:helloflutter/dios.dart';

				
				«FOR http : httpReqResps»
					/** «http.respBody.record.label» */					
					Future<Response> «http.respBody.record.name.replace("RespBody","").toFirstLower»() async {
						print('«http.respBody.record.name.replace("RespBody","").toFirstLower»');
						Dio dio = Dios.getInstance();
						Response response = await dio.«http.respBody.record.method.toLowerCase»<Map>(
						"https://www.easy-mock.com/mock/5cfb5e002226854b9e1c1236/yjapp«http.respBody.record.url»");
						print(response.data)
						return response;
					}
					
				«ENDFOR»
			'''
		}
		
		def static mockResp(Three projectThree, List<HttpReqResp> httpReqResps) {
			'''
				«FOR http : httpReqResps»
					/** «http.respBody.record.label» */					
					var «http.respBody.record.name.replace("RespBody","").toFirstLower» = {
						"code":200,
						"msg":"ok",
						"result": { // «http.respBodyEntity.fields.size» «http.respBody.fields.size»
						«FOR f :http.respBody.fields SEPARATOR ",\n"»
							"«f.name»":"@string"
						«ENDFOR»
						«FOR f :http.respBodyEntity.fields SEPARATOR ",\n"»
							"«f.name»":"@string"
						«ENDFOR»
						}
					}
					
				«ENDFOR»
			'''
		}

		@Data
		static class HttpReqResp {
			Three project
			Three headers
			Three params
			Three reqBody
			Three reqBodyEntity // 2
			Three respBody
			Three respBodyEntity // 2
		}

		def static table2data(Three projectThree, Table table) {
			var Project project = projectThree.project
			var recordRow = table.getRow(0)
			var Record record = new Record
			record.name = recordRow.getCell(1).text.trim
			record.label = recordRow.getCell(2).text.trim
			record.doc = recordRow.getCell(3).text.trim

			var List<Field> fields = newArrayList()
			for (var j = 2; j < table.numRows; j++) {
				var row = table.getRow(j)
				if (!row.getCell(1).text.trim.nullOrEmpty) {
					var field = new Field()
					field.name = row.getCell(0).text.trim
					field.name = field.name.replace(" ", "_").split("_").map[item|item.toFirstUpper].join().toFirstLower
					field.type = row.getCell(1).text.trim
					field.label = row.getCell(2).text.trim
					field.doc = row.getCell(3).text.trim
					fields.add(field)
				}

			}
			new Three(project, record, fields)
		}

		def static table2project(Table projectTable) {
			val projectRow = projectTable.getRow(3)
			var project = new Project
			project.version = projectRow.getCell(0).text.trim
			project.name = projectRow.getCell(1).text.trim
			project.label = projectRow.getCell(2).text.trim
			project.path = projectRow.getCell(3).text.trim
			project.root = projectRow.getCell(4).text.trim
			project.port = projectRow.getCell(5).text.trim

			val webRow = projectTable.getRow(4)
			project.webPath = webRow.getCell(3).text.trim
			project.webRoot = webRow.getCell(4).text.trim

			val androidRow = projectTable.getRow(5)
			project.androidPath = webRow.getCell(3).text.trim
			project.androidRoot = webRow.getCell(4).text.trim
			println(project)

			new Three(project, null, null)
		}
	}
	