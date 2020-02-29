package com.github.east196.xcode.bot

import com.google.common.base.Charsets
import com.google.common.io.Files
import java.io.File
import java.io.FileInputStream
import org.apache.poi.hwpf.HWPFDocument
import org.apache.poi.hwpf.usermodel.TableIterator
import java.util.function.Function

class Bots {
	def static void main(
		String[] args) {
		printClassDefine("TypeInMore/type	defaultType	mongoType	esType")
	}
	
	def fakeIt(String func){
		// http vs cmd
	}
	
	def static ok(String ok){
		switch (ok.toUpperCase){
			case "YES": true
			case 'Y': true
			case 'OK': true
			case 'ON': true
			case 'O': true
			default: false
		}
	}

	def static Function<String, String> noop() {
		[in|in]
	}
	
	def static smartCopy(String fromDir, String toDir) {
		val fixedToDir = if (toDir.endsWith("\\")) {
				toDir
			} else {
				toDir + "\\"
			}
		val Function<String, String> pathTrans = [path|path.replace(fromDir, fixedToDir)]
		val fromPackage = getPackage(fromDir)
		val toPackage = getPackage(toDir)
		val Function<String, String> contentTrans = [content|content.replace(fromPackage, toPackage)]
		copy(fromDir, pathTrans, contentTrans)
	}

	def static getPackage(String path) {
		var package = ""
		if (path.contains('''\src\main\xtend\''')) {
			package = path.split("xtend").get(1).split('''\\''').filter[!it.contains(".") && !it.isNullOrEmpty].
				join(".")
		}
		if (path.contains('''\src\main\java\''')) {
			package = path.split("java").get(1).split('''\\''').filter[!it.contains(".") && !it.isNullOrEmpty].join(".")
		}
		package
	}

	def static copy(String dir, Function<String, String> pathTrans, Function<String, String> contentTrans) {
		if(pathTrans == null && contentTrans == null) return;
		println("start")
		val files = Files.fileTreeTraverser.children(new File(dir))
		files.forEach [ file |
			val path = file.absolutePath
			val content = Files.toString(file, Charsets.UTF_8)
			println(path)
			copy(contentTrans.apply(content), pathTrans.apply(path))
		]
	}

	static def copy(CharSequence content, String path) {
		val file = new File(path)
		Files.createParentDirs(file)
		Files.write(content, file, Charsets.UTF_8)
	}

	static def printClassDefine(String info) {
		val klass = info.split('/').get(0)
		val klassType = klass.toFirstUpper
		val fields = info.split('/').get(1).split('\t')
		print('''
import com.google.common.base.Objects;
import lombok.Data;

@Data
public class «klassType» {

	«FOR f : fields»
	private String «f»;
	«ENDFOR»
}		
		''')
	}

	static def doc(String path) {
		var is = new FileInputStream(path)
		new HWPFDocument(is)
	}

	static def tables(String path) {
		var range = path.doc.range
		val tables = newArrayList()
		var tableIterator = new TableIterator(range)
		while (tableIterator.hasNext) {
			var table = tableIterator.next()
			tables.add(table)
		}
		tables
	}

}
