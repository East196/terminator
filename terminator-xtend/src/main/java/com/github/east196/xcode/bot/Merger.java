package com.github.east196.xcode.bot;

import com.github.east196.xcode.model.Code;
import com.google.common.base.Objects;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Generated;
import org.boon.Sets;
import org.boon.core.reflection.BeanUtils;
import org.boon.core.reflection.Reflection;
import org.boon.core.reflection.fields.FieldAccess;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public class Merger {
  public static <T extends Object> T mergeNotNullToFirst(final Class<T> destKlass, final Object... srcs) {
    T dest = Reflection.<T>newInstance(destKlass);
    return Merger.<T>mergeNotNullToFirstUnSafe(dest, srcs);
  }
  
  public static <T extends Object> T mergeNotNullToFirst(final T template, final Object... srcs) {
    T dest = BeanUtils.<T>copy(template);
    return Merger.<T>mergeNotNullToFirstUnSafe(dest, srcs);
  }
  
  private static <T extends Object> T mergeNotNullToFirstUnSafe(final T dest, final Object... srcs) {
    for (final Object src : srcs) {
      {
        Set<String> ignores = Sets.<String>set();
        Map<String, FieldAccess> fieldMap = BeanUtils.getFieldsFromObject(src);
        Set<Map.Entry<String, FieldAccess>> _entrySet = fieldMap.entrySet();
        for (final Map.Entry<String, FieldAccess> entry : _entrySet) {
          {
            System.out.println(entry);
            FieldAccess _value = entry.getValue();
            Object _object = _value.getObject(src);
            boolean _tripleEquals = (_object == null);
            if (_tripleEquals) {
              String _key = entry.getKey();
              ignores.add(_key);
            }
          }
        }
        BeanUtils.copyProperties(src, dest, ignores);
      }
    }
    return dest;
  }
  
  public static <T extends Object> T mergeToFirst(final T template, final Object... srcs) {
    T dest = BeanUtils.<T>copy(template);
    for (final Object src : srcs) {
      BeanUtils.copyProperties(src, dest);
    }
    return dest;
  }
  
  public static void main(final String[] args) {
    CharSequence all = Merger.mergeK2K(Code.class, Code.class);
    InputOutput.<CharSequence>println(all);
  }
  
  public static CharSequence mergeK2K(final Class klassDest, final Class klassSrc) {
    CharSequence _xblockexpression = null;
    {
      List<Field> destFields = Reflection.getFields(klassDest);
      List<Field> srcFields = Reflection.getFields(klassSrc);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import ");
      String _name = klassSrc.getName();
      _builder.append(_name, "");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.append("import ");
      String _name_1 = klassDest.getName();
      _builder.append(_name_1, "");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("// ");
      String _simpleName = klassSrc.getSimpleName();
      String _firstUpper = StringExtensions.toFirstUpper(_simpleName);
      _builder.append(_firstUpper, "");
      _builder.append(" from = new ");
      String _simpleName_1 = klassSrc.getSimpleName();
      String _firstUpper_1 = StringExtensions.toFirstUpper(_simpleName_1);
      _builder.append(_firstUpper_1, "");
      _builder.append("();");
      _builder.newLineIfNotEmpty();
      _builder.append("// ");
      String _simpleName_2 = klassDest.getSimpleName();
      String _firstUpper_2 = StringExtensions.toFirstUpper(_simpleName_2);
      _builder.append(_firstUpper_2, "");
      _builder.append(" to = new ");
      String _simpleName_3 = klassDest.getSimpleName();
      String _firstUpper_3 = StringExtensions.toFirstUpper(_simpleName_3);
      _builder.append(_firstUpper_3, "");
      _builder.append("();");
      _builder.newLineIfNotEmpty();
      _builder.append("// merge");
      String _simpleName_4 = klassDest.getSimpleName();
      String _firstUpper_4 = StringExtensions.toFirstUpper(_simpleName_4);
      _builder.append(_firstUpper_4, "");
      _builder.append("To");
      String _simpleName_5 = klassSrc.getSimpleName();
      String _firstUpper_5 = StringExtensions.toFirstUpper(_simpleName_5);
      _builder.append(_firstUpper_5, "");
      _builder.append("(to,from);");
      _builder.newLineIfNotEmpty();
      _builder.append("public static void merge");
      String _simpleName_6 = klassDest.getSimpleName();
      String _firstUpper_6 = StringExtensions.toFirstUpper(_simpleName_6);
      _builder.append(_firstUpper_6, "");
      _builder.append("To");
      String _simpleName_7 = klassSrc.getSimpleName();
      String _firstUpper_7 = StringExtensions.toFirstUpper(_simpleName_7);
      _builder.append(_firstUpper_7, "");
      _builder.append("(");
      String _simpleName_8 = klassSrc.getSimpleName();
      String _firstUpper_8 = StringExtensions.toFirstUpper(_simpleName_8);
      _builder.append(_firstUpper_8, "");
      _builder.append(" to,");
      String _simpleName_9 = klassDest.getSimpleName();
      String _firstUpper_9 = StringExtensions.toFirstUpper(_simpleName_9);
      _builder.append(_firstUpper_9, "");
      _builder.append(" from){");
      _builder.newLineIfNotEmpty();
      {
        for(final Field destField : destFields) {
          {
            for(final Field srcField : srcFields) {
              {
                String _name_2 = srcField.getName();
                String _name_3 = destField.getName();
                boolean _equals = Objects.equal(_name_2, _name_3);
                if (_equals) {
                  _builder.append("\t");
                  _builder.append("if(isNotEmpty(from.get");
                  String _name_4 = srcField.getName();
                  String _firstUpper_10 = StringExtensions.toFirstUpper(_name_4);
                  _builder.append(_firstUpper_10, "\t");
                  _builder.append("())){");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("to.set");
                  String _name_5 = destField.getName();
                  String _firstUpper_11 = StringExtensions.toFirstUpper(_name_5);
                  _builder.append(_firstUpper_11, "\t\t");
                  _builder.append("(from.get");
                  String _name_6 = srcField.getName();
                  String _firstUpper_12 = StringExtensions.toFirstUpper(_name_6);
                  _builder.append(_firstUpper_12, "\t\t");
                  _builder.append("());");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append("}");
                  _builder.newLine();
                }
              }
            }
          }
        }
      }
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("// ");
      String _simpleName_10 = klassSrc.getSimpleName();
      String _firstUpper_13 = StringExtensions.toFirstUpper(_simpleName_10);
      _builder.append(_firstUpper_13, "");
      _builder.append(" from = new ");
      String _simpleName_11 = klassSrc.getSimpleName();
      String _firstUpper_14 = StringExtensions.toFirstUpper(_simpleName_11);
      _builder.append(_firstUpper_14, "");
      _builder.append("();");
      _builder.newLineIfNotEmpty();
      _builder.append("// ");
      String _simpleName_12 = klassDest.getSimpleName();
      String _firstUpper_15 = StringExtensions.toFirstUpper(_simpleName_12);
      _builder.append(_firstUpper_15, "");
      _builder.append(" to = copy");
      String _simpleName_13 = klassDest.getSimpleName();
      String _firstUpper_16 = StringExtensions.toFirstUpper(_simpleName_13);
      _builder.append(_firstUpper_16, "");
      _builder.append("To");
      String _simpleName_14 = klassSrc.getSimpleName();
      String _firstUpper_17 = StringExtensions.toFirstUpper(_simpleName_14);
      _builder.append(_firstUpper_17, "");
      _builder.append("(from);");
      _builder.newLineIfNotEmpty();
      _builder.append("public static ");
      String _simpleName_15 = klassDest.getSimpleName();
      String _firstUpper_18 = StringExtensions.toFirstUpper(_simpleName_15);
      _builder.append(_firstUpper_18, "");
      _builder.append(" copy");
      String _simpleName_16 = klassDest.getSimpleName();
      String _firstUpper_19 = StringExtensions.toFirstUpper(_simpleName_16);
      _builder.append(_firstUpper_19, "");
      _builder.append("To");
      String _simpleName_17 = klassSrc.getSimpleName();
      String _firstUpper_20 = StringExtensions.toFirstUpper(_simpleName_17);
      _builder.append(_firstUpper_20, "");
      _builder.append("(");
      String _simpleName_18 = klassDest.getSimpleName();
      String _firstUpper_21 = StringExtensions.toFirstUpper(_simpleName_18);
      _builder.append(_firstUpper_21, "");
      _builder.append(" from){");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      String _simpleName_19 = klassDest.getSimpleName();
      String _firstUpper_22 = StringExtensions.toFirstUpper(_simpleName_19);
      _builder.append(_firstUpper_22, "\t");
      _builder.append(" to = new ");
      String _simpleName_20 = klassDest.getSimpleName();
      String _firstUpper_23 = StringExtensions.toFirstUpper(_simpleName_20);
      _builder.append(_firstUpper_23, "\t");
      _builder.append("();");
      _builder.newLineIfNotEmpty();
      {
        for(final Field destField_1 : destFields) {
          {
            for(final Field srcField_1 : srcFields) {
              {
                String _name_7 = srcField_1.getName();
                String _name_8 = destField_1.getName();
                boolean _equals_1 = Objects.equal(_name_7, _name_8);
                if (_equals_1) {
                  _builder.append("\t");
                  _builder.append("if(isNotEmpty(from.get");
                  String _name_9 = srcField_1.getName();
                  String _firstUpper_24 = StringExtensions.toFirstUpper(_name_9);
                  _builder.append(_firstUpper_24, "\t");
                  _builder.append("())){");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("to.set");
                  String _name_10 = destField_1.getName();
                  String _firstUpper_25 = StringExtensions.toFirstUpper(_name_10);
                  _builder.append(_firstUpper_25, "\t\t");
                  _builder.append("(from.get");
                  String _name_11 = srcField_1.getName();
                  String _firstUpper_26 = StringExtensions.toFirstUpper(_name_11);
                  _builder.append(_firstUpper_26, "\t\t");
                  _builder.append("());");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append("}");
                  _builder.newLine();
                }
              }
            }
          }
        }
      }
      _builder.append("\t");
      _builder.append("return to;");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("public static boolean isNotEmpty(Object object){");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("return object != null;");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
}
