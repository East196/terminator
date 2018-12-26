package com.github.east196.xcode

import com.github.east196.xcode.bot.Bots
import com.github.east196.xcode.model.Field
import com.github.east196.xcode.model.Project
import com.github.east196.xcode.model.Record
import java.util.List
import org.boon.Lists

class AntDVue2018 {

	def static void main(String[] args) {
		Base.init('''E:\backup\xcode\统一数据文档20181209.doc''').forEach [ three |
			gene(three.project, three.record, three.fields)
		]
	}

	def static gene(Project project, Record record, List<Field> fields) {

		val webPath = project.webPath
		
		var CharSequence content=''''''
		var path=""
		

		content = recordlist(project, record, fields)
		path = '''«webPath»\src\views\device\«record.name.toFirstUpper»List.vue'''
		println(path)
		Bots.copy(content, path)
		
		content = recordsearch(project, record, fields)
		path = '''«webPath»\src\views\device\«record.name.toFirstUpper»Search.vue'''
		println(path)
		Bots.copy(content, path)

	}
	def static recordsearch(Project project, Record record, List<Field> fields) {
		val searchFields = fields.filter[it.show.contains("S")].toList
		val sfas = Lists.slcEnd(searchFields,2)
		val sfbs = Lists.slc(searchFields,2)
		'''
<template>
  <div class="table-page-search-wrapper">
    <a-form layout="inline" @submit="handleSubmit" :autoFormCreate="(form)=>{this.form = form}">
      <a-row :gutter="48">
«FOR sf : sfas»
«IF sf.keyType == "M21"|| sf.keyType =="121"»
<a-col :md="8" :sm="24">
		<a-form-item
		  label="«sf.label»"
		  fieldDecoratorId="«sf.name»_id_LIKE"
		  :fieldDecoratorOptions="{rules: [
		  ]}"
		>
			<a-select placeholder="请选择" :defaultActiveFirstOption="false">
			  <a-select-option v-for="d in «sf.name»s" :key="d.id">{{d.name}}</a-select-option>
			</a-select>
		</a-form-item>
</a-col>
«ELSEIF sf.type == "date"»
«ELSEIF sf.type == "datetime"»
«ELSE»
        <a-col :md="8" :sm="24">
          <a-form-item
            label="«sf.label»"
            fieldDecoratorId="«sf.name»_LIKE"
		  :fieldDecoratorOptions="{rules: [
		  ]}"
          >
            <a-input/>
          </a-form-item>
        </a-col>
«ENDIF»
«ENDFOR»
        <template v-if="advanced">

«FOR sf : sfbs»
«IF sf.keyType == "M21"|| sf.keyType =="121"»
<a-col :md="8" :sm="24">
		<a-form-item
		  label="«sf.label»"
		  fieldDecoratorId="«sf.name»_id_LIKE"
		  :fieldDecoratorOptions="{rules: [
		  ]}"
		>
			<a-select placeholder="请选择" :defaultActiveFirstOption="false">
			  <a-select-option v-for="d in «sf.name»s" :key="d.id">{{d.«IF fields.filter[it.name=="label"].toList.length>0»label«ELSE»name«ENDIF»}}</a-select-option>
			</a-select>
		</a-form-item>
</a-col>
«ELSEIF sf.type == "date"»
«ELSEIF sf.type == "datetime"»
«ELSE»
        <a-col :md="8" :sm="24">
          <a-form-item
            label="«sf.label»"
            fieldDecoratorId="«sf.name»_LIKE"
		  :fieldDecoratorOptions="{rules: [
		  ]}"
          >
            <a-input/>
          </a-form-item>
        </a-col>
«ENDIF»
«ENDFOR»

        </template>
        <a-col :md="!advanced && 8 || 24" :sm="24">
          <span
            class="table-page-search-submitButtons"
            :style="advanced && { float: 'right', overflow: 'hidden' } || {} "
          >
            <a-button type="primary" htmlType="submit">搜索</a-button>
            <a-button style="margin-left: 8px" htmlType="reset" @click="handleReset">重置</a-button>
            <a @click="toggleAdvanced" style="margin-left: 8px">
              {{ advanced ? '收起' : '展开' }}
              <a-icon :type="advanced ? 'up' : 'down'"/>
            </a>
          </span>
        </a-col>
      </a-row>
    </a-form>
  </div>
</template>
<script>
export default {
  name: "«record.name.toFirstUpper»Search",
  components: {},
  props:[«FOR f:fields»«IF f.keyType=="M21"|| f.keyType =="121"»"«f.name»s",«ENDIF»«ENDFOR»],
  data() {
    return {
      // 高级搜索 展开/关闭
      advanced: false,
      // 查询参数
      queryParam: {},
      form: {}
    };
  },
  methods: {
    toggleAdvanced() {
      this.advanced = !this.advanced;
    },
    handleSubmit(e) {
      console.log("submit");
      e.preventDefault();
      this.form.validateFieldsAndScroll((err, values) => {
        if (!err) {
          console.log("Received values of form: ", values);
          this.$emit('«record.name»SearchForm',values);
        }
      });
    },
    handleReset() {
      console.log("reset");
      this.form.resetFields();
    }
  }
};
</script>
		
		'''
	}

	def static recordlist(Project project, Record record, List<Field> fields) {
		'''
<template>
  <a-card title="«record.label»列表" :bordered="false">
    <«record.name.toFirstUpper»Search «FOR f:fields»«IF f.keyType=="M21"|| f.keyType =="121"»:«f.name»s="«f.name»s" «ENDIF»«ENDFOR» @«record.name»SearchForm="handleSearchForm" />

    <div class="table-operator">
      <a-button type="primary" icon="plus" @click="handleCreate">新建</a-button>
      <a-dropdown v-if="selectedRowKeys.length > 0">
        <a-menu slot="overlay">
          <a-menu-item key="1" @click="handleBatchDelete">
            <a-icon type="delete"/>删除
          </a-menu-item>
        </a-menu>
        <a-button style="margin-left: 8px">批量操作
          <a-icon type="down"/>
        </a-button>
      </a-dropdown>
    </div>

    <s-table
      ref="table"
      size="default"
      :columns="columns"
      :data="loadData"
      :showAlertInfo="true"
      @onSelect="onChange"
    >
      <span slot="action" slot-scope="text, record">
        <a @click="handleEdit(record)">修改</a>
        <a-divider type="vertical"/>
        <a @click="handleDelete(record)">删除</a>
      </span>
    </s-table>

    <a-modal title="操作" :width="800" :footer="null" v-model="visible" >
      <a-form @submit="handleSubmit" :autoFormCreate="(form)=>{this.form = form}">

«FOR f : fields»
«IF f.keyType == "P"»
<a-form-item label="ID" v-show="false" :labelCol="labelCol" :wrapperCol="wrapperCol" fieldDecoratorId="id">
  <a-input/>
</a-form-item>
«ELSEIF f.keyType == "M21"|| f.keyType =="121"»
		<a-form-item
		  :labelCol="labelCol"
		  :wrapperCol="wrapperCol"
		  label="«f.label»"
		  fieldDecoratorId="«f.name».id"
		  :fieldDecoratorOptions="{rules: [
		  «IF f.required=="required"»
		  { required: true, message: '请输入«f.label»!' }
		  «ENDIF»
		  ]}"
		>
			<a-select placeholder="请选择" :defaultActiveFirstOption="false">
			  <a-select-option v-for="d in «f.name»s" :key="d.id">{{d.name}}</a-select-option>
			</a-select>
		</a-form-item>
«ELSEIF f.keyType == "12M"»

«ELSE»
		<a-form-item
		  :labelCol="labelCol"
		  :wrapperCol="wrapperCol"
		  label="«f.label»"
		  fieldDecoratorId="«f.name»"
		  :fieldDecoratorOptions="{rules: [
		  «IF f.required=="required"»
		  { required: true, message: '请输入«f.label»!' }
		  «ENDIF»
		  ]}"
		>
			<a-input/>
		</a-form-item>
«ENDIF»

«ENDFOR»
		<a-form-item
		  :labelCol="labelCol"
		  :wrapperCol="wrapperCol"
				>
              <a-button-group>
                <a-button type="primary" htmlType="submit">保存</a-button>
                <a-button type="default" htmlType="reset" @click="handleReset">重置</a-button>
              </a-button-group>
            </a-form-item>
      </a-form>
    </a-modal>
  </a-card>
</template>

<script>
import STable from "@/components/table/";
import ATextarea from "ant-design-vue/es/input/TextArea";
import AInput from "ant-design-vue/es/input/Input";

import «record.name.toFirstUpper»Search from "@/views/device/«record.name.toFirstUpper»Search";

var moment = require("moment");

export default {
  name: "«record.name.toFirstUpper»List",
  components: {
    AInput,
    ATextarea,
    STable,
    «record.name.toFirstUpper»Search
  },
  data() {
    return {
      visible: false,
      labelCol: {
        xs: { span: 24 },
        sm: { span: 5 }
      },
      wrapperCol: {
        xs: { span: 24 },
        sm: { span: 12 }
      },
      form: null,
      mdl: {},

      // 高级搜索 展开/关闭
      advanced: true,
      // 查询参数
      queryParam: {},
      
    «FOR f : fields»
      «IF f.keyType == "M21"|| f.keyType =="121"»
      «f.name»s: [],
      «ENDIF»
    «ENDFOR»
      // 表头
      columns: [
      «FOR f : fields»
      	«IF f.keyType == "P"»
        «ELSEIF f.keyType == "12M"»
        «ELSEIF f.keyType == "M21"|| f.keyType =="121"»
        {
        	title: "«f.label»",
        	dataIndex: "«f.name»",
        	key: "«f.name»",       	
        	customRender: text => {
        		if (_.has(text,"name")){
        			return text.name
        		}else{
        		}	return ""
        	}
        },
        «ELSEIF f.type == "datetime"»
        {
          title: "«f.label»",
          dataIndex: "«f.name»",
          key: "«f.name»",       	
          width: "120px",
		  customRender: text => {
		    if (text) {
		      return moment(text).format("YYYY-MM-DD HH:mm:ss");
		    } else {
		      return "";
		    }
		  }
        },
        «ELSEIF f.type == "date"»
        {
          title: "«f.label»",
          dataIndex: "«f.name»",
          key: "«f.name»",       	
          width: "120px",
		  customRender: text => {
		    if (text) {
		      return moment(text).format("YYYY-MM-DD");
		    } else {
		      return "";
		    }
		  }
        },
         «ELSE»
        {
        	title: "«f.label»",
        	dataIndex: "«f.name»",
        	customRender: text => text
        },
        «ENDIF»
      «ENDFOR»
        {
          title: "操作",
          dataIndex: "action",
          width: "120px",
          scopedSlots: { customRender: "action" }
        }
      ],
      // 加载数据方法 必须为 Promise 对象
      loadData: parameter => {
        console.log("---", parameter);
        var body = Object.assign(parameter, this.queryParam);
        return this.$http
          .post(
            this.$store.state.app.approot + "/controller/v1/«record.name»/page",
            body,
            { params: parameter }
          )
          .then(res => {
            console.log("-------------", res);
            return res.data;
          });
      },

      selectedRowKeys: [],
      selectedRows: []
    };
  },
  mounted() {
«FOR f : fields»
  «IF f.keyType == "M21"|| f.keyType =="121"»
    this.$http
          .get(this.$store.state.app.approot + "/controller/v1/«f.name»/", {})
          .then(res => {
            console.log("-------------«f.name»s", res.data);
            this.«f.name»s = res.data;
          });
  «ENDIF»
«ENDFOR»
  },
  methods: {
    handleCreate(e) {
      this.visible = true;
      setTimeout(() => {
          this.form.resetFields();
      }, 50);
      
    },
    handleEdit(record) {
      this.mdl = Object.assign({}, record);
      «FOR f : fields»
      «IF f.keyType == "12M"»
      delete this.mdl.«f.name»
      «ENDIF»
      «ENDFOR»
      console.log("modal",this.mdl);
      this.visible = true;
      setTimeout(() => {
          this.form.setFieldsValue(this.mdl);
      }, 50);
    },
    handleDelete(record) {
      console.log(record);
      var that = this;
      const deleteModal = this.$confirm({
        title: "确认",
        content: `确认删除选中的 ${record.name}？`,
        okText: "确认",
        okType: "danger",
        cancelText: "取消",
        onOk() {
          console.log("开始删除");
          that.$http
            .delete(
              that.$store.state.app.approot + "/controller/v1/«record.name»/" + record.id
            )
            .then(res => {
              console.log(`已删除id为${record.id}的设备`);
              that.$refs.table.refresh();
              deleteModal.destroy();
            });
          
        },
        onCancel() {
          console.log("取消删除");
        }
      });
    },
    handleSubmit(e) {
      e.preventDefault();
      console.log("selected", this.form.values);
      this.form.validateFieldsAndScroll((err, values) => {
        if (!err) {
          console.log("Received values of form: ", values);
          this.$http
            .post(this.$store.state.app.approot + "/controller/v1/«record.name»/", values)
            .then(res => {
              console.log(`已添加设备${values.name}`);
              this.$refs.table.refresh();
              this.visible = false;
            });
        }
      });
    },
    handleReset() {
      console.log("reset");
      this.form.resetFields();
    },
    handleSearchForm(data){
      var keys = _.map(_.keys(data),key=>key.replace("_id_", ".id_"))
      var values = _.values(data)
      this.queryParam = _.zipObject(keys, values);
      console.log(this.queryParam);
      this.$refs.table.refresh();
    },
    handleBatchDelete(e) {
      console.log(this.selectedRowKeys);
      var that = this;
      const deleteModal = this.$confirm({
        title: "确认",
        content: `确认删除选中的${this.selectedRowKeys.length}个«record.label»？`,
        okText: "确认",
        okType: "danger",
        cancelText: "取消",
        onOk() {
          console.log("开始删除");
          that.$http
            .post(
              this.$store.state.app.approot + "/controller/v1/«record.name»/deletes",
              that.selectedRowKeys
            )
            .then(res => {
              console.log(`已删除选中的${that.selectedRowKeys.length}个«record.label»`);
              that.$refs.table.refresh();
              deleteModal.destroy();
            });
          
        },
        onCancel() {
          console.log("取消删除");
        }
      });
    },
    onChange(row) {
      this.selectedRowKeys = row.selectedRowKeys;
      this.selectedRows = row.selectedRows;
      console.log(this.selectedRowKeys);
      console.log(this.selectedRows);
      console.log(this.$refs.table);
    },
    toggleAdvanced() {
      this.advanced = !this.advanced;
    }
  },
  watch: {
    /*
      'selectedRows': function (selectedRows) {
        this.needTotalList = this.needTotalList.map(item => {
          return {
            ...item,
            total: selectedRows.reduce( (sum, val) => {
              return sum + val[item.dataIndex]
            }, 0)
          }
        })
      }
      */
  }
};
</script>
<style>
.table-operator button{
  margin: 10px 10px 10px 0px;
}
</style>
	    '''
	}

}
