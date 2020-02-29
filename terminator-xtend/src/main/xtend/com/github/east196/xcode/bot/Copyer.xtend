package com.github.east196.xcode.bot

import com.google.common.base.Charsets
import com.google.common.base.Function
import com.google.common.io.Files
import java.io.File
import org.apache.commons.io.FileUtils
import org.eclipse.xtend.lib.annotations.Accessors

class Copyer {
	def static void main(String[] args) {
		smartCopy(
			'''E:\workspace\github\east196\java\maker\maker\src\main\xtend\cn\tung\system\maker\util''',
			'''E:\workspace\github\east196\java\maker\maker\src\main\xtend\com\github\east196\maker\util'''
		)
//		var copyer = new Copyer();
//		copyer.deleteNoneLines(
//			'''C:\Users\Administrator\git\maker\party\src\main\java\cn\tung\javacn\FreqWordsHandler.java''')
	}

	// E:\workspace\github\east196\java\maker\maker\src\main\xtend\cn\tung\system\maker
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
			println(file)
		]
		files.forEach [ file |
			if (!file.directory) {
				val path = file.absolutePath
				println(path)
				val content = Files.toString(file, Charsets.UTF_8)
				copy(contentTrans.apply(content), pathTrans.apply(path))
			}

		]
	}

	static def copy(CharSequence content, String path) {
		val file = new File(path)
		Files.createParentDirs(file)
		Files.write(content, file, Charsets.UTF_8)
	}

	def deleteNoneLines(String path) {
		this.pathTrans = [src|src]
		this.infoTrans = [src|src.split(System.lineSeparator).filter[!it.trim.nullOrEmpty].join(System.lineSeparator)]
		copy(path)
	}

	def copy(String path, String... ext) {
		var file = new File(path)
		if (file.isFile) {
			transFile(file)
		} else {
			var String[] exts = null
			if(!ext.empty) exts = ext
			val files = FileUtils.listFiles(file, exts, true)
			files.forEach[it.transFile]
		}
	}

	def transFile(File srcFile) {
		var distPath = pathTrans.apply(srcFile.absolutePath)
		println('''«srcFile.absolutePath» «distPath»''')

		var ext = Files.getFileExtension(srcFile.absolutePath)
		if (#{"java", "xtend", "txt", "xml", "proto"}.contains(ext)) {
			var srcInfo = Files.toString(srcFile, Charsets.UTF_8)
			var distInfo = infoTrans.apply(srcInfo)
			var distFile = new File(distPath)
			Files.createParentDirs(distFile)
			Files.write(distInfo, distFile, Charsets.UTF_8)
		} else { // 非文本暂时不能替换
			var distFile = new File(distPath)
			Files.createParentDirs(distFile)
			Files.copy(srcFile, distFile)
		}
	}

	@Accessors
	Function<String, String> pathTrans;
	@Accessors
	Function<String, String> infoTrans;

}
