package com.github.east196.terminator.xtend.meta;

import com.github.east196.terminator.xtend.meta.MetaParser;
import com.github.east196.terminator.xtend.model.Field;
import com.github.east196.terminator.xtend.model.Project;
import com.github.east196.terminator.xtend.model.Record;
import com.github.east196.terminator.xtend.model.Three;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.hwpf.usermodel.Table;
import org.apache.poi.hwpf.usermodel.TableCell;
import org.apache.poi.hwpf.usermodel.TableIterator;
import org.apache.poi.hwpf.usermodel.TableRow;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public class DocMetaParser implements MetaParser {
  @Override
  public List<Three> action(final String docx) {
    ArrayList<Three> _xblockexpression = null;
    {
      final ArrayList<Table> tables = DocMetaParser.tables(docx);
      final Table projectTable = tables.get(0);
      final TableRow projectRow = projectTable.getRow(3);
      Project project = new Project();
      TableCell _cell = projectRow.getCell(0);
      String _text = _cell.text();
      String _trim = _text.trim();
      project.setVersion(_trim);
      TableCell _cell_1 = projectRow.getCell(1);
      String _text_1 = _cell_1.text();
      String _trim_1 = _text_1.trim();
      project.setName(_trim_1);
      TableCell _cell_2 = projectRow.getCell(2);
      String _text_2 = _cell_2.text();
      String _trim_2 = _text_2.trim();
      project.setLabel(_trim_2);
      TableCell _cell_3 = projectRow.getCell(3);
      String _text_3 = _cell_3.text();
      String _trim_3 = _text_3.trim();
      project.setPath(_trim_3);
      TableCell _cell_4 = projectRow.getCell(4);
      String _text_4 = _cell_4.text();
      String _trim_4 = _text_4.trim();
      project.setRoot(_trim_4);
      TableCell _cell_5 = projectRow.getCell(5);
      String _text_5 = _cell_5.text();
      String _trim_5 = _text_5.trim();
      project.setPort(_trim_5);
      final TableRow webRow = projectTable.getRow(4);
      TableCell _cell_6 = webRow.getCell(3);
      String _text_6 = _cell_6.text();
      String _trim_6 = _text_6.trim();
      project.setWebPath(_trim_6);
      TableCell _cell_7 = webRow.getCell(4);
      String _text_7 = _cell_7.text();
      String _trim_7 = _text_7.trim();
      project.setWebRoot(_trim_7);
      InputOutput.<Project>println(project);
      final ArrayList<Three> threes = CollectionLiterals.<Three>newArrayList();
      for (int i = 1; (i < tables.size()); i++) {
        {
          Table table = tables.get(i);
          Record record = new Record();
          final TableRow recordOkRow = table.getRow(0);
          TableCell _cell_8 = recordOkRow.getCell(1);
          String _text_8 = _cell_8.text();
          String _trim_8 = _text_8.trim();
          record.setGeneOk(_trim_8);
          final TableRow recordRow = table.getRow(3);
          String _id = project.getId();
          record.setProjectId(_id);
          TableCell _cell_9 = recordRow.getCell(0);
          String _text_9 = _cell_9.text();
          String _trim_9 = _text_9.trim();
          record.setDbType(_trim_9);
          TableCell _cell_10 = recordRow.getCell(1);
          String _text_10 = _cell_10.text();
          String _trim_10 = _text_10.trim();
          String _firstLower = StringExtensions.toFirstLower(_trim_10);
          record.setName(_firstLower);
          TableCell _cell_11 = recordRow.getCell(2);
          String _text_11 = _cell_11.text();
          String _trim_11 = _text_11.trim();
          record.setLabel(_trim_11);
          TableCell _cell_12 = recordRow.getCell(3);
          String _text_12 = _cell_12.text();
          String _trim_12 = _text_12.trim();
          record.setDoc(_trim_12);
          InputOutput.<Record>println(record);
          final ArrayList<Field> fields = CollectionLiterals.<Field>newArrayList();
          for (int rowIndex = 6; (rowIndex < table.numRows()); rowIndex++) {
            {
              TableRow fieldRow = table.getRow(rowIndex);
              InputOutput.<TableRow>print(fieldRow);
              Field field = new Field();
              String _id_1 = project.getId();
              field.setProjectId(_id_1);
              String _id_2 = record.getId();
              field.setRecordId(_id_2);
              TableCell _cell_13 = fieldRow.getCell(0);
              String _text_13 = _cell_13.text();
              String _trim_13 = _text_13.trim();
              field.setType(_trim_13);
              TableCell _cell_14 = fieldRow.getCell(1);
              String _text_14 = _cell_14.text();
              String _trim_14 = _text_14.trim();
              field.setName(_trim_14);
              TableCell _cell_15 = fieldRow.getCell(2);
              String _text_15 = _cell_15.text();
              String _trim_15 = _text_15.trim();
              field.setLabel(_trim_15);
              TableCell _cell_16 = fieldRow.getCell(3);
              String _text_16 = _cell_16.text();
              String _trim_16 = _text_16.trim();
              field.setDoc(_trim_16);
              TableCell _cell_17 = fieldRow.getCell(4);
              String _text_17 = _cell_17.text();
              String _trim_17 = _text_17.trim();
              field.setRequired(_trim_17);
              TableCell _cell_18 = fieldRow.getCell(5);
              String _text_18 = _cell_18.text();
              String _trim_18 = _text_18.trim();
              field.setKeyType(_trim_18);
              TableCell _cell_19 = fieldRow.getCell(6);
              String _text_19 = _cell_19.text();
              String _trim_19 = _text_19.trim();
              field.setSortIndex(_trim_19);
              TableCell _cell_20 = fieldRow.getCell(7);
              String _text_20 = _cell_20.text();
              String _trim_20 = _text_20.trim();
              field.setShow(_trim_20);
              TableCell _cell_21 = fieldRow.getCell(8);
              String _text_21 = _cell_21.text();
              String _trim_21 = _text_21.trim();
              field.setValid(_trim_21);
              String _valid = field.getValid();
              int _length = _valid.length();
              boolean _equals = (_length == 0);
              if (_equals) {
                field.setValid("{}");
              }
              InputOutput.<Field>println(field);
              fields.add(field);
            }
          }
          final Three three = new Three(project, record, fields);
          threes.add(three);
        }
      }
      _xblockexpression = threes;
    }
    return _xblockexpression;
  }
  
  public static HWPFDocument doc(final String path) {
    try {
      HWPFDocument _xblockexpression = null;
      {
        FileInputStream is = new FileInputStream(path);
        _xblockexpression = new HWPFDocument(is);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static ArrayList<Table> tables(final String path) {
    HWPFDocument _doc = DocMetaParser.doc(path);
    return DocMetaParser.tables(_doc);
  }
  
  public static ArrayList<Table> tables(final InputStream is) {
    try {
      HWPFDocument _hWPFDocument = new HWPFDocument(is);
      return DocMetaParser.tables(_hWPFDocument);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static ArrayList<Table> tables(final HWPFDocument doc) {
    ArrayList<Table> _xblockexpression = null;
    {
      Range range = doc.getRange();
      final ArrayList<Table> tables = CollectionLiterals.<Table>newArrayList();
      TableIterator tableIterator = new TableIterator(range);
      while (tableIterator.hasNext()) {
        {
          Table table = tableIterator.next();
          tables.add(table);
        }
      }
      _xblockexpression = tables;
    }
    return _xblockexpression;
  }
}
