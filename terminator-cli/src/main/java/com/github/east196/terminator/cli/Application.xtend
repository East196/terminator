package com.github.east196.terminator.cli

import com.github.east196.terminator.xtend.bot.AndroidXmlHandler
import com.github.east196.terminator.xtend.bot.Bots
import com.github.east196.terminator.xtend.meta.DocMetaParser
import com.github.east196.terminator.xtend.model.Three
import com.github.east196.terminator.xtend.rest.AntDVue2018
import com.github.east196.terminator.xtend.rest.Api2018
import com.github.east196.terminator.xtend.rest.Mysql2018
import java.util.List
import org.apache.commons.cli.CommandLine
import org.apache.commons.cli.CommandLineParser
import org.apache.commons.cli.DefaultParser
import org.apache.commons.cli.HelpFormatter
import org.apache.commons.cli.Option
import org.apache.commons.cli.Options
import org.boon.Boon

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

		option = new Option("x", "androidxml", false, "解析优化AndroidXml并生成findViewById代码")
		option.setRequired(false)
		options.addOption(option)

		option = new Option("e", "entity2bean", false, "解析Entity并生成Bean")
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
			if (commandLine.hasOption(Character.valueOf('x').charValue)) {
				AndroidXmlHandler.handleXml(file)
			}
			if (commandLine.hasOption(Character.valueOf('e').charValue)) {
				AndroidXmlHandler.entity2beanByDir(file)
			}
		}else{
			System.out.println("必须填写-d")
			// 格式化输出
			new HelpFormatter().printHelp("java -jar xcode.jar", options, true)
			return;
			
		}
	}
}
