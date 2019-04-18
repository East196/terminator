package com.github.east196.xcode

import com.github.east196.xcode.meta.DocMetaParser
import com.github.east196.xcode.model.Three
import java.util.List
import org.apache.commons.cli.CommandLine
import org.apache.commons.cli.CommandLineParser
import org.apache.commons.cli.DefaultParser
import org.apache.commons.cli.HelpFormatter
import org.apache.commons.cli.Option
import org.apache.commons.cli.Options
import com.github.east196.xcode.bot.Bots
import org.boon.Boon
import com.github.east196.xcode.rest.Mysql2018
import com.github.east196.xcode.rest.AntDVue2018
import com.github.east196.xcode.rest.Api2018

class Application {

	def static void main(String[] args) {
		var Options options = new Options()

		var Option option = new Option("d", "doc", true, "导入的doc文件") // 短选项，长选项，选项后是否有参数，描述
		option.setRequired(false) // 必须设置
		options.addOption(option)

		option = new Option("j", "json", true, "导出的json文件")
		option.setRequired(false)
		options.addOption(option)

		option = new Option("b", "back", false, "生成后端代码文件")
		option.setRequired(false)
		options.addOption(option)

		option = new Option("f", "front", false, "生成前端代码文件")
		option.setRequired(false)
		options.addOption(option)

		option = new Option("a", "android", false, "生成Android端代码文件")
		option.setRequired(false)
		options.addOption(option)

		option = new Option("h", "help", false, "查看帮助")
		options.addOption(option)
		//
		var CommandLineParser parser = new DefaultParser()
		var CommandLine commandLine = parser.parse(options, args)
		// 判断
		if (commandLine.hasOption(Character.valueOf('h').charValue)) {
			// 格式化输出
			new HelpFormatter().printHelp("java -jar xcode.jar", options, true)
			return;
		}
		if (commandLine.hasOption(Character.valueOf('d').charValue)) {
			// 获取参数
			var String file = commandLine.getOptionValue(Character.valueOf('d').charValue)

			if (commandLine.hasOption(Character.valueOf('j').charValue)) {
				var List<Three> threes = new DocMetaParser().action(file)
				System.out.println(Boon.toPrettyJson(threes))
				var String json = commandLine.getOptionValue(Character.valueOf('j').charValue)
				Bots.copy(Boon.toPrettyJson(threes), json)
			}
			if (commandLine.hasOption(Character.valueOf('b').charValue)) {
				var List<Three> threes = new DocMetaParser().action(file)
				System.out.println(Boon.toPrettyJson(threes))
				new DocMetaParser().action(file).filter[three|three.record.geneOk.trim == ""].forEach [ three |
					Mysql2018.geneAll(three)
				]
			}
			if (commandLine.hasOption(Character.valueOf('f').charValue)) {
				var List<Three> threes = new DocMetaParser().action(file)
				System.out.println(Boon.toPrettyJson(threes))
				new DocMetaParser().action(file).filter[three|three.record.geneOk.trim == ""].forEach [ three |
					AntDVue2018.geneAll(three)
				]
			}
			if (commandLine.hasOption(Character.valueOf('a').charValue)) {
				Api2018.gene(file)
			}
		}
	}
}
