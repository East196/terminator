package com.github.east196.terminator.xtend.bot


import java.util.ArrayList
import java.util.List
import org.apache.poi.hwpf.usermodel.Table
import org.eclipse.xtend.lib.annotations.Data

class UniformInterfaceGene {
	def static void main(String[] args) {
//		val basePackageName = "io.device.uniform"
//		val basePath='''/src/main/xtend/io/device/uniform/'''
//		var src= '''/src/main/resources/设备与设备管理平台交互接口20151215.doc'''

		val projectPath ='''E:\workspace\github\east196\java\xcode'''
		val basePackageName = "io.device.uniform"
		val basePath=projectPath+'''/src/main/java/io/device/uniform'''
		var src= '''E:\backup\xcode\POI接口文档160725.doc'''
		val tables = Bots.tables(src)
		println("--表格总数："+tables.size())
		
		//5张表，
		//1: method，url，comment
		//2,3,4: name，require，type,comment
		//5: msg,comment
		var httpReqResps=newArrayList()
		for (var tableNum = 2; tableNum < tables.length; tableNum=tableNum+5) {
			if(tableNum>=17&&tableNum<53)tableNum++//日志相关的有六张表,第1张表和第3张视重复的
			var httpReqResp = httpReqRespFrom(tables, tableNum)
			httpReqResps.add(httpReqResp)
		}

		httpReqResps.filter[it.reqPrams.size>0].forEach[httpReqResp|
			var content = reqQuery(basePackageName+".req", httpReqResp)
			var klassType = httpReqResp.reqQueryKlassType
			var path = '''«basePath»/req/«klassType».java'''
			println(path)
			println(content)
			Bots.copy(content,path)
		]

		
		httpReqResps.filter[it.reqBodyItems.size>0].forEach[httpReqResp|
			var content = reqBody(basePackageName+".req", httpReqResp)
			var klassType = httpReqResp.reqBodyKlassType
			var path = '''«basePath»/req/«klassType».java'''
			Bots.copy(content,path)
		]
		
		httpReqResps.forEach[httpReqResp|
			var klassType = httpReqResp.respKlassType
			var content = resp(basePackageName+".resp", httpReqResp)
			var path = '''«basePath»/resp/«klassType».java'''
			Bots.copy(content,path)
		]
		
		httpReqResps.forEach[httpReqResp|
			val indexs=httpReqResp.respItems.filter[it.unnormal].map[httpReqResp.respItems.indexOf(it)]
			indexs.forEach[index|
				var klassType = httpReqResp.respItems.get(index).type
				var content = respSub(basePackageName+".resp", httpReqResp,index)
				var path = '''«basePath»/resp/«klassType».java'''
				Bots.copy(content,path)
			]
		]
		
		var klassType="UniformDeviceHttp"
		var content = http(basePackageName,klassType, httpReqResps)
		var path = '''«basePath»/«klassType».java'''
		Bots.copy(content,path)

		klassType="UniformDeviceController"
		content = controller(basePackageName,klassType, httpReqResps)
		path = '''«basePath»/«klassType».java'''
		Bots.copy(content,path)		
		
	}
	


	

	
	def static httpReqRespFrom(ArrayList<Table> tables, int tableNum) {
		var reqTable=tables.get(tableNum)
		println(tables.indexOf(reqTable))
		var req = reqFrom(reqTable)
		
		var reqPramsTable=tables.get(tableNum+1)
		var reqPrams = reqPramsFrom(reqPramsTable)
		
		var reqBodyTable=tables.get(tableNum+2)
		var reqBodyItems = reqBodyItemsFrom(reqBodyTable)
		
		var respItemsTable=tables.get(tableNum+3)
		var respItems = respItemsFrom(respItemsTable)
		
		var httpReqResp=new HttpReqResp(req,reqPrams,reqBodyItems,respItems)
		httpReqResp
	}
	
	def static respItemsFrom(Table respItemsTable) {
		var List<RespItem> respItems=newArrayList()
		for (var j = 1; j < respItemsTable.numRows; j++) {
			var row=respItemsTable.getRow(j)
			if(!row.getCell(1).text.trim.nullOrEmpty){
				var String name=row.getCell(0).text.trim
				var String type=row.getCell(1).text.trim
				var String comment=row.getCell(2).text.split(System.lineSeparator).join.trim
				var respItem=new RespItem(name,type,comment)
				respItems.add(respItem)
			}
		}
		respItems
	}
	
	def static reqBodyItemsFrom(Table reqBodyTable) {
		var List<ReqItem> reqBodyItems=newArrayList()
		for (var j = 1; j < reqBodyTable.numRows; j++) {
			var row=reqBodyTable.getRow(j)
			
			println(row.getCell(1).text.trim)
			if(!row.getCell(1).text.trim.nullOrEmpty){
				var String name=row.getCell(0).text.trim
				var String require=row.getCell(1).text.trim
				var String type=row.getCell(2).text.trim
				var String comment=row.getCell(3).text.split(System.lineSeparator).join.trim
				var reqItem=new ReqItem(name,require,type,comment)
				reqBodyItems.add(reqItem)
			}
		}
		println(reqBodyItems.length)
		reqBodyItems
	}
	
	def static reqPramsFrom(Table reqPramsTable) {
		var List<ReqItem> reqPrams=newArrayList()
		for (var j = 1; j < reqPramsTable.numRows; j++) {
			var row=reqPramsTable.getRow(j)
			if(!row.getCell(1).text.trim.nullOrEmpty){
				var String name=row.getCell(0).text.trim
				var String require=row.getCell(1).text.trim
				var String type=row.getCell(2).text.trim
				var String comment=row.getCell(3).text.split(System.lineSeparator).join.trim
				var reqItem=new ReqItem(name,require,type,comment)
				reqPrams.add(reqItem)
			}
		}
		reqPrams
	}
	
	def static reqFrom(Table reqTable) {	
		var String method=reqTable.getRow(1).getCell(1).text.trim
		var String url=reqTable.getRow(2).getCell(1).text.trim.replace("IP:PORT/xxx","").replace("IP:PORT","")
		var String name=reqTable.getRow(2).getCell(1).text.trim.replace("IP:PORT/xxx/","").replace("IP:PORT/","").replace(".do","").split("/").map[it.toFirstUpper].join.toFirstLower
		var String comment=reqTable.getRow(2).getCell(2).text.split(System.lineSeparator).join.trim
		var req=new Req(method,url,name,comment)
		req
	}
	
	def static http(String basePackageName,String klassType, List<HttpReqResp> httpReqResps) {
		'''
		package «basePackageName»;
		
		
		«IF httpReqResps.exists[it.req.method=="GET"]»import retrofit.http.GET;«ENDIF»
		«IF httpReqResps.exists[it.req.method=="POST"]»import retrofit.http.POST;«ENDIF»
		import retrofit.http.Query;
		import retrofit.http.QueryMap;
		import retrofit.http.Body;
		
		import java.util.Map;

		«FOR http : httpReqResps»
		«IF http.reqBodyItems.size>0»import «basePackageName».req.«http.reqBodyKlassType»;«ENDIF»
		«ENDFOR»
«««		import «basePackageName».resp.DefaultResp;		
		«FOR http : httpReqResps.filter[it.respItems.size>2]»
		import «basePackageName».resp.«http.respKlassType»;
		«ENDFOR»
		
		public interface «klassType» {
			
			«FOR http : httpReqResps»
			/** «http.req.comment» */
			«http.methodAnnotation»("«http.req.url»")
			«http.respKlassType» «http.req.name»(
			«FOR f : http.reqPrams SEPARATOR ","»@Query("«f.javaName»")		«f.type» «f.javaName»
			«ENDFOR»«IF http.reqBodyItems.size>0»@Body «http.reqBodyKlassType» «http.reqBodyKlassType.toFirstLower»«ENDIF»);

			/** «http.req.comment» */
			«http.methodAnnotation»("«http.req.url»")
			«http.respKlassType» «http.req.name»ByMap(
			«IF http.reqPrams.size>0»@QueryMap Map<String,Object> queryMap
			«ENDIF»«IF http.reqBodyItems.size>0»@Body «http.reqBodyKlassType» «http.reqBodyKlassType.toFirstLower»«ENDIF»);			
			«ENDFOR»
			
		}
		'''
	}

	def static controller(String basePackageName,String klassType, List<HttpReqResp> httpReqResps) {
		'''
		package «basePackageName»;
		
		import org.springframework.web.bind.annotation.RequestBody;
		import org.springframework.web.bind.annotation.RequestMapping;
		import org.springframework.web.bind.annotation.RequestMethod;
		import org.springframework.web.bind.annotation.RestController;

		«FOR http : httpReqResps.filter[it.reqPrams.size>0]»
		import «basePackageName».req.«http.reqQueryKlassType»;
		«ENDFOR»
		«FOR http : httpReqResps.filter[it.reqBodyItems.size>0]»
		import «basePackageName».req.«http.reqBodyKlassType»;
		«ENDFOR»
«««		import «basePackageName».resp.DefaultResp;		
		«FOR http : httpReqResps.filter[it.respItems.size>2]»
		import «basePackageName».resp.«http.respKlassType»;
		«ENDFOR»

		@RestController
		@RequestMapping("uniform")		
		public class «klassType» {
			
			«FOR http : httpReqResps»
			/** «http.req.comment» */
			@RequestMapping(value = "«http.req.url»", method = RequestMethod.«http.req.method»)
			«http.respKlassType» «http.req.name»(
			«IF http.reqPrams.size>0»«http.reqQueryKlassType» «http.reqQueryKlassType.toFirstLower»«ENDIF»
			«IF http.reqPrams.size>0 && http.reqBodyItems.size>0»,«ENDIF»
			«IF http.reqBodyItems.size>0»@RequestBody «http.reqBodyKlassType» «http.reqBodyKlassType.toFirstLower»«ENDIF»
			) {
				«IF http.reqPrams.size>0»System.out.println(«http.reqQueryKlassType.toFirstLower»);«ENDIF»
				«IF http.reqBodyItems.size>0»System.out.println(«http.reqBodyKlassType.toFirstLower»);«ENDIF»
				return new «http.respKlassType»();
			}
			
			«ENDFOR»
			
		}
		'''
	}
	
	// TODO 是否需要吧queryMap和from提取出来做编解码器
	def static reqQuery(String basePackageName,HttpReqResp httpReqResp){
		val fields = httpReqResp.reqPrams
		var klassType=httpReqResp.reqQueryKlassType
		'''
		package «basePackageName»;
		
		import java.util.HashMap;
		import java.util.Map;
		
«««		import io.vertx.core.http.HttpServerRequest;
		import org.apache.commons.lang3.builder.HashCodeBuilder;
		import org.apache.commons.lang3.builder.EqualsBuilder;
		import org.apache.commons.lang3.builder.ToStringBuilder;
		import org.apache.commons.lang3.builder.ToStringStyle;
		«IF fields.exists[it.name!=it.javaName]»
		import com.google.gson.annotations.SerializedName;
		«ENDIF»
		
		public class «klassType» {
			
			«FOR f : fields»
			/** «f.comment» */
			«IF f.name!=f.javaName»
			@SerializedName("«f.name»")
			«ENDIF»
			private «f.type» «f.javaName»;
			«ENDFOR»
			
			public Map<String,Object> toQueryMap(){
		        Map<String,Object> queryMap=new HashMap<>();
				«FOR f : fields»
				queryMap.put("«f.javaName»",«f.javaName»);
				«ENDFOR»
		        return queryMap;
			}
			
«««			public static «klassType» from(HttpServerRequest httpServerRequest){
«««				«klassType» «klassType.toFirstLower»=new «klassType»();
«««				«FOR f : fields»
«««				«IF f.type.toLowerCase.startsWith("boolean")»
«««				«klassType.toFirstLower».set«f.javaName.toFirstUpper»(Boolean.parseBoolean(httpServerRequest.getParam("«f.javaName»")));
«««				«ENDIF»
«««				«IF f.type.toLowerCase.startsWith("double")»
«««				«klassType.toFirstLower».set«f.javaName.toFirstUpper»(Double.parseDouble(httpServerRequest.getParam("«f.javaName»")));
«««				«ENDIF»
«««				«IF f.type.toLowerCase.startsWith("int")»
«««				«klassType.toFirstLower».set«f.javaName.toFirstUpper»(Integer.parseInt(httpServerRequest.getParam("«f.javaName»")));
«««				«ENDIF»
«««				«IF f.type.toLowerCase.startsWith("string")»
«««				«klassType.toFirstLower».set«f.javaName.toFirstUpper»(httpServerRequest.getParam("«f.javaName»"));
«««				«ENDIF»
«««				«ENDFOR»
«««				return «klassType.toFirstLower»;
«««			}
			
			public «klassType»(){}
			
			public «klassType»(«fields.map[it.type+" "+it.javaName].join(",")»){
				«FOR f : fields»
				this.«f.javaName»=«f.javaName»;
				«ENDFOR»
			}
			
			«FOR f : fields»
			public «f.type» get«f.javaName.toFirstUpper»() {
				return «f.javaName»;
			}

			public void set«f.javaName.toFirstUpper»(«f.type» «f.javaName») {
				this.«f.javaName» = «f.javaName»;
			}
			
			«ENDFOR»
			@Override 
			public int hashCode() {
				return HashCodeBuilder.reflectionHashCode(this);
			}
		
			@Override 
			public boolean equals(Object other) {
				return EqualsBuilder.reflectionEquals(this, other);
			}

			@Override 
			public String toString() {
				return ToStringBuilder.reflectionToString(this,ToStringStyle.DEFAULT_STYLE);
			}
			
		}
		'''
	}
	
	def static reqBody(String basePackageName,HttpReqResp httpReqResp){
		val fields = httpReqResp.reqBodyItems
		var klassType=httpReqResp.reqBodyKlassType
		'''
		package «basePackageName»;
		
		import org.apache.commons.lang3.builder.HashCodeBuilder;
		import org.apache.commons.lang3.builder.EqualsBuilder;
		import org.apache.commons.lang3.builder.ToStringBuilder;
		import org.apache.commons.lang3.builder.ToStringStyle;
		«IF fields.exists[it.name!=it.javaName]»
		import com.google.gson.annotations.SerializedName;
		«ENDIF»
		
		public class «klassType» {
			
			«FOR f : fields»
			/** «f.comment» */
			«IF f.name!=f.javaName»
			@SerializedName("«f.name»")
			«ENDIF»
			private «f.type» «f.javaName»;
			«ENDFOR»
			
			public «klassType»(){}
			
			public «klassType»(«fields.map[it.type+" "+it.javaName].join(",")»){
				«FOR f : fields»
				this.«f.javaName»=«f.javaName»;
				«ENDFOR»
			}
			
			«FOR f : fields»
			public «f.type» get«f.javaName.toFirstUpper»() {
				return «f.javaName»;
			}

			public void set«f.javaName.toFirstUpper»(«f.type» «f.javaName») {
				this.«f.javaName» = «f.javaName»;
			}
			
			«ENDFOR»
			@Override 
			public int hashCode() {
				return HashCodeBuilder.reflectionHashCode(this);
			}
		
			@Override 
			public boolean equals(Object other) {
				return EqualsBuilder.reflectionEquals(this, other);
			}

			@Override 
			public String toString() {
				return ToStringBuilder.reflectionToString(this,ToStringStyle.DEFAULT_STYLE);
			}
			
		}
		'''
	}

	def static resp(String basePackageName,HttpReqResp httpReqResp){
		val fields = httpReqResp.respItems.filter[!it.name.startsWith("|")]
		var klassType=httpReqResp.req.name.toFirstUpper+"Resp"
		if(httpReqResp.respItems.size==2)klassType="DefaultResp"
		'''
		package «basePackageName»;
		
		import org.apache.commons.lang3.builder.HashCodeBuilder;
		import org.apache.commons.lang3.builder.EqualsBuilder;
		import org.apache.commons.lang3.builder.ToStringBuilder;
		import org.apache.commons.lang3.builder.ToStringStyle;
		«IF fields.exists[it.name!=it.javaName]»
		import com.google.gson.annotations.SerializedName;
		«ENDIF»
		
		public class «klassType» {
			
			«FOR f : fields»
			/** «f.label» */
			«IF f.name!=f.javaName»
			@SerializedName("«f.name»")
			«ENDIF»
			private «f.type» «f.javaName»;
			«ENDFOR»
			
			public «klassType»(){}
			
			public «klassType»(«fields.map[it.type+" "+it.javaName].join(",")»){
				«FOR f : fields»
				this.«f.javaName»=«f.javaName»;
				«ENDFOR»
			}
			
			«FOR f : fields»
			public «f.type» get«f.javaName.toFirstUpper»() {
				return «f.javaName»;
			}

			public void set«f.javaName.toFirstUpper»(«f.type» «f.javaName») {
				this.«f.javaName» = «f.javaName»;
			}
			
			«ENDFOR»
			@Override 
			public int hashCode() {
				return HashCodeBuilder.reflectionHashCode(this);
			}
		
			@Override 
			public boolean equals(Object other) {
				return EqualsBuilder.reflectionEquals(this, other);
			}

			@Override 
			public String toString() {
				return ToStringBuilder.reflectionToString(this,ToStringStyle.DEFAULT_STYLE);
			}
			
		}
		'''
	}

	def static respSub(String basePackageName,HttpReqResp httpReqResp,int index){
		var fields = newArrayList()
		var break=false
		for(var i=index+1;i<httpReqResp.respItems.size;i++){
			val item=httpReqResp.respItems.get(i)
			if(item.name.startsWith("|")&&break==false){
				var String name=item.name.replace("|","")
				var String type=item.type
				var String comment=item.label
				var respItem=new RespItem(name,type,comment)
				fields.add(respItem)
			}else{
				break=true
			}
		}
		var klassType=httpReqResp.respItems.get(index).type
		'''
		package «basePackageName»;
		
		import org.apache.commons.lang3.builder.HashCodeBuilder;
		import org.apache.commons.lang3.builder.EqualsBuilder;
		import org.apache.commons.lang3.builder.ToStringBuilder;
		import org.apache.commons.lang3.builder.ToStringStyle;
		«IF fields.exists[it.name!=it.javaName]»
		import com.google.gson.annotations.SerializedName;
		«ENDIF»
		
		public class «klassType» {
			
			«FOR f : fields»
			/** «f.label» */
			«IF f.name!=f.javaName»
			@SerializedName("«f.name»")
			«ENDIF»
			private «f.type» «f.javaName»;
			«ENDFOR»
			
			public «klassType»(){}
			
			public «klassType»(«fields.map[it.type+" "+it.javaName].join(",")»){
				«FOR f : fields»
				this.«f.javaName»=«f.javaName»;
				«ENDFOR»
			}
			
			«FOR f : fields»
			public «f.type» get«f.javaName.toFirstUpper»() {
				return «f.javaName»;
			}

			public void set«f.javaName.toFirstUpper»(«f.type» «f.javaName») {
				this.«f.javaName» = «f.javaName»;
			}
			
			«ENDFOR»
			@Override 
			public int hashCode() {
				return HashCodeBuilder.reflectionHashCode(this);
			}
		
			@Override 
			public boolean equals(Object other) {
				return EqualsBuilder.reflectionEquals(this, other);
			}

			@Override 
			public String toString() {
				return ToStringBuilder.reflectionToString(this,ToStringStyle.DEFAULT_STYLE);
			}
			
		}
		'''
	}


	//TODO 将生成器使用的类 转为 接口，以提高通用性
	@Data
	static class HttpReqResp {
		Req req
		List<ReqItem> reqPrams
		List<ReqItem> reqBodyItems
		List<RespItem> respItems
		
		def  methodAnnotation() {
			switch (req.method){
				case "GET":"@GET"
				case "POST":"@POST"
				default:"@POST"
			}
		}
		
			
		def  reqBodyKlassType() {
			req.name.toFirstUpper+"ReqBody"
		}
		def  reqQueryKlassType() {
			req.name.toFirstUpper+"ReqQuery"
		}
		
		def  respKlassType() {
			var klassType=req.name.toFirstUpper+"Resp"
			if(respItems.size==2)klassType="DefaultResp"
			klassType
		}
	}
	
	@Data
	static class Req{
		String method
		String url
		String name
		String comment
		def javaName(){
			javaNameFrom(name)
		}
	}
	

	
	@Data
	static class ReqItem {
		String name
		String require
		String type
		String comment
		def javaName(){
			javaNameFrom(name)
		}
	}
	
	
	@Data
	static class RespItem {
		String name
		String type
		String label
		def javaName(){
			javaNameFrom(name)
		}
		
		def  unnormal(){
			! #["string","int","double","boolean"].contains(type.toLowerCase)&&!name.startsWith("|")
		}
	}
	
		def static javaNameFrom(String name){
			switch (name) {
				/**转换关键字和不规则字符 */
				default : name
			}
		}
	
}