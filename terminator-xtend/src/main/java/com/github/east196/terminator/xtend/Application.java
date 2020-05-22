package com.github.east196.terminator.xtend;

import com.github.east196.terminator.xtend.bot.AndroidXmlHandler;
import com.github.east196.terminator.xtend.bot.Bots;
import com.github.east196.terminator.xtend.meta.DocMetaParser;
import com.github.east196.terminator.xtend.model.Record;
import com.github.east196.terminator.xtend.model.Three;
import com.github.east196.terminator.xtend.rest.AntDVue2018;
import com.github.east196.terminator.xtend.rest.Api2018;
import com.github.east196.terminator.xtend.rest.Mysql2018;
import com.google.common.base.Objects;
import java.util.List;
import java.util.function.Consumer;
import javax.annotation.Generated;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.boon.Boon;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public class Application {
  public static void main(final String[] args) {
    try {
      Options options = new Options();
      Option option = new Option("d", "doc", true, "导入的doc文件");
      option.setRequired(false);
      options.addOption(option);
      Option _option = new Option("j", "json", true, "导出的json文件");
      option = _option;
      option.setRequired(false);
      options.addOption(option);
      Option _option_1 = new Option("b", "back", false, "生成后端代码文件");
      option = _option_1;
      option.setRequired(false);
      options.addOption(option);
      Option _option_2 = new Option("f", "front", false, "生成前端代码文件");
      option = _option_2;
      option.setRequired(false);
      options.addOption(option);
      Option _option_3 = new Option("a", "android", false, "生成Android端代码文件");
      option = _option_3;
      option.setRequired(false);
      options.addOption(option);
      Option _option_4 = new Option("x", "androidxml", false, "解析优化AndroidXml并生成findViewById代码");
      option = _option_4;
      option.setRequired(false);
      options.addOption(option);
      Option _option_5 = new Option("e", "entity2bean", false, "解析Entity并生成Bean");
      option = _option_5;
      option.setRequired(false);
      options.addOption(option);
      Option _option_6 = new Option("h", "help", false, "查看帮助");
      option = _option_6;
      options.addOption(option);
      CommandLineParser parser = new DefaultParser();
      CommandLine commandLine = parser.parse(options, args);
      Character _valueOf = Character.valueOf('h');
      char _charValue = _valueOf.charValue();
      boolean _hasOption = commandLine.hasOption(_charValue);
      if (_hasOption) {
        HelpFormatter _helpFormatter = new HelpFormatter();
        _helpFormatter.printHelp("java -jar xcode.jar", options, true);
        return;
      }
      Character _valueOf_1 = Character.valueOf('d');
      char _charValue_1 = _valueOf_1.charValue();
      boolean _hasOption_1 = commandLine.hasOption(_charValue_1);
      if (_hasOption_1) {
        Character _valueOf_2 = Character.valueOf('d');
        char _charValue_2 = _valueOf_2.charValue();
        String file = commandLine.getOptionValue(_charValue_2);
        Character _valueOf_3 = Character.valueOf('j');
        char _charValue_3 = _valueOf_3.charValue();
        boolean _hasOption_2 = commandLine.hasOption(_charValue_3);
        if (_hasOption_2) {
          DocMetaParser _docMetaParser = new DocMetaParser();
          List<Three> threes = _docMetaParser.action(file);
          String _prettyJson = Boon.toPrettyJson(threes);
          System.out.println(_prettyJson);
          Character _valueOf_4 = Character.valueOf('j');
          char _charValue_4 = _valueOf_4.charValue();
          String json = commandLine.getOptionValue(_charValue_4);
          String _prettyJson_1 = Boon.toPrettyJson(threes);
          Bots.copy(_prettyJson_1, json);
        }
        Character _valueOf_5 = Character.valueOf('b');
        char _charValue_5 = _valueOf_5.charValue();
        boolean _hasOption_3 = commandLine.hasOption(_charValue_5);
        if (_hasOption_3) {
          DocMetaParser _docMetaParser_1 = new DocMetaParser();
          List<Three> threes_1 = _docMetaParser_1.action(file);
          String _prettyJson_2 = Boon.toPrettyJson(threes_1);
          System.out.println(_prettyJson_2);
          DocMetaParser _docMetaParser_2 = new DocMetaParser();
          List<Three> _action = _docMetaParser_2.action(file);
          final Function1<Three, Boolean> _function = (Three three) -> {
            Record _record = three.getRecord();
            String _geneOk = _record.getGeneOk();
            String _trim = _geneOk.trim();
            return Boolean.valueOf(Objects.equal(_trim, ""));
          };
          Iterable<Three> _filter = IterableExtensions.<Three>filter(_action, _function);
          final Consumer<Three> _function_1 = (Three three) -> {
            Mysql2018.geneAll(three);
          };
          _filter.forEach(_function_1);
        }
        Character _valueOf_6 = Character.valueOf('f');
        char _charValue_6 = _valueOf_6.charValue();
        boolean _hasOption_4 = commandLine.hasOption(_charValue_6);
        if (_hasOption_4) {
          DocMetaParser _docMetaParser_3 = new DocMetaParser();
          List<Three> threes_2 = _docMetaParser_3.action(file);
          String _prettyJson_3 = Boon.toPrettyJson(threes_2);
          System.out.println(_prettyJson_3);
          DocMetaParser _docMetaParser_4 = new DocMetaParser();
          List<Three> _action_1 = _docMetaParser_4.action(file);
          final Function1<Three, Boolean> _function_2 = (Three three) -> {
            Record _record = three.getRecord();
            String _geneOk = _record.getGeneOk();
            String _trim = _geneOk.trim();
            return Boolean.valueOf(Objects.equal(_trim, ""));
          };
          Iterable<Three> _filter_1 = IterableExtensions.<Three>filter(_action_1, _function_2);
          final Consumer<Three> _function_3 = (Three three) -> {
            AntDVue2018.geneAll(three);
          };
          _filter_1.forEach(_function_3);
        }
        Character _valueOf_7 = Character.valueOf('a');
        char _charValue_7 = _valueOf_7.charValue();
        boolean _hasOption_5 = commandLine.hasOption(_charValue_7);
        if (_hasOption_5) {
          Api2018.gene(file);
        }
        Character _valueOf_8 = Character.valueOf('x');
        char _charValue_8 = _valueOf_8.charValue();
        boolean _hasOption_6 = commandLine.hasOption(_charValue_8);
        if (_hasOption_6) {
          AndroidXmlHandler.handleXml(file);
        }
        Character _valueOf_9 = Character.valueOf('e');
        char _charValue_9 = _valueOf_9.charValue();
        boolean _hasOption_7 = commandLine.hasOption(_charValue_9);
        if (_hasOption_7) {
          AndroidXmlHandler.entity2beanByDir(file);
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
