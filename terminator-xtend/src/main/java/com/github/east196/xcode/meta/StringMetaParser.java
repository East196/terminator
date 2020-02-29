package com.github.east196.xcode.meta;

import com.github.east196.xcode.meta.MetaParser;
import com.github.east196.xcode.model.Field;
import com.github.east196.xcode.model.Project;
import com.github.east196.xcode.model.Record;
import com.github.east196.xcode.model.Three;
import java.util.Collections;
import java.util.List;
import javax.annotation.Generated;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public class StringMetaParser implements MetaParser {
  @Override
  public List<Three> action(final String info) {
    List<Three> _xblockexpression = null;
    {
      final Project project = new Project();
      String[] _split = info.split("/");
      final String klass = _split[0];
      final Record record = new Record();
      record.setName(klass);
      String[] _split_1 = info.split("/");
      String _get = _split_1[1];
      String[] _split_2 = _get.split(" ");
      final Function1<String, Boolean> _function = (String it) -> {
        boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(it);
        return Boolean.valueOf((!_isNullOrEmpty));
      };
      Iterable<String> _filter = IterableExtensions.<String>filter(((Iterable<String>)Conversions.doWrapArray(_split_2)), _function);
      final Function1<String, Field> _function_1 = (String fieldInfo) -> {
        final String[] fieldInfos = fieldInfo.split(":");
        Field field = new Field();
        String _get_1 = fieldInfos[0];
        field.setName(_get_1);
        int _length = fieldInfos.length;
        boolean _equals = (_length == 2);
        if (_equals) {
          String _get_2 = fieldInfos[1];
          field.setType(_get_2);
        } else {
          field.setType("string");
        }
        int _length_1 = fieldInfos.length;
        boolean _equals_1 = (_length_1 == 3);
        if (_equals_1) {
          String _get_3 = fieldInfos[2];
          field.setLabel(_get_3);
        } else {
          field.setLabel("");
        }
        return field;
      };
      Iterable<Field> _map = IterableExtensions.<String, Field>map(_filter, _function_1);
      final List<Field> fields = IterableExtensions.<Field>toList(_map);
      Three _three = new Three(project, record, fields);
      _xblockexpression = Collections.<Three>unmodifiableList(CollectionLiterals.<Three>newArrayList(_three));
    }
    return _xblockexpression;
  }
}
