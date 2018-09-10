# 基础模型元数据

可以参考ddlutils和mysql的数据表，完全能够涵盖mongo这种弱数据类型的模型
用于生成模型，curd逻辑，接口，页面
页面分解：
1. 控件：文本，下拉，复选，查找，带回选择框，自增，时间，日期，日期区间，图标（自定义），图片（自定义），上传，文本编辑
2. 组件：查询，工具栏（可自定义操作？），表单，表格，树表
3. 模板：单表curd，主子表curd，树表，树关联表

## 项目元数据 project
- id
- name 项目名称
- label 中文名
- path 开发路径，统一定下来，方便工具使用
- language 后端语言，前端铁定是vue
- config 补充config，以json表示
- doc 详细描述

项目和模型是多对多关系，借鉴maker项目搞定多对多预设
## 模型元数据 model
- id
- name 名称，一般是英文
- label 中文名，出现在模块名
- db_type 数据库类型 mysql，mongo，hbase，redis之类
- db_name 数据库名
- table_name 表名
- pk_name 主键名
- view_name 视图名，只有sql才有，且和table_name互斥
- filter 默认过滤
- sort 默认排序
- config 补充config，以json表示
- doc 详细描述

模型和字段是一对多关系
## 字段元数据 field
基础字段，循环节点？
- id
- name 名称，一般是英文
- label 作为中文名出现在表头，表单字段名等地
- unique 唯一
- pk 0:非主键,1:自增,2:UUID
- type 数据类型
- length 数据长度
- model_name 模型名
- td_cell 表格格式化，默认用预加载的code表转义，可以自编写h函数或者jsx
- form_field_set 表单字段集
- form_item 表单控件，默认用预制控件，可以新增控件
- form_item_data 表单控件的值，默认string等直接用value,下拉框可以用cache,查找框可以用通用path+sql直接暴力解决
- faker_func 用于产出demo数据
- config 补充config，以json表示
- doc 详细描述，暂时考虑出现在placeholder和tip中
<!-- - obejct_detail language+company.project.domain.Model -->

type类型：
string
int
float
object 如果是object尽量做map处理？
enum
code

## 字典元数据 dict
基础字段，循环节点？
- id
- name 名称，一般是英文
- label 作为中文名出现在表头，表单字段名等地
- type 数据类型
- config 补充config，以json表示
- doc 详细描述，暂时考虑出现在placeholder和tip中

## 编码元数据 code
id
name
value
model_name
field_name
label 同field.label
type 同field.type
doc 详细描述


## 验证元数据 valid
参考
- [async-validator](https://github.com/yiminghe/async-validator)搭建验证体系
- [jquery-plugin-validate](http://www.runoob.com/jquery/jquery-plugin-validate.html)
实际上就是用object在valid中做验证看是否通过
在模板中内置这两个对象{{object.xxx}}{{valid.xxx}}


字段说明

元数据定义验证规则，一个数据可能有多条验证规则数据
required: true, #是否必需
type: 'array',  #数据类别 string array date email等
min: 1,			#最小
max: 1,			#最大
enum: ['admin', 'user', 'guest']
message: '请选择兴趣', #错误信息
trigger: 'change'      #触发条件 change blur

类型说明

* `string`: 必需是类型 `string`. `This is the default type.`
* `number`: 必需是类型 `number`.
* `boolean`: 必需是类型 `boolean`.
* `method`: 必需是类型 `function`.
* `regexp`: 必需是类型 `RegExp`.正则表达式.
* `integer`: 必需是类型 `number` 且是整数.
* `float`: 必需是类型 `number` 且是浮点数.
* `array`: 必需是数组，能通过`Array.isArray`.相关字段`min`or`max`.
* `range`: 必需是数字范围.相关字段`min`and`max`.
* `object`: 必需是对象 `object` 不能通过`Array.isArray`.
* `enum`: 必需以枚举形式存在 `enum`.相关字段 `enum`
* `date`: 必需以日期形式存在 `Date`
* `remote`: 必需通过远程API确认. 相关字段`url`. 返回值`false`or`true`
* `url`: 必需是类型 `url`.
* `hex`: 必需是类型 `hex`.
* `email`: 必需是类型 `email`.

## 搜索元数据
元数据，数据，实现
查询元数据用于生成组件，一个对象字段对应多条查询元数据

动态搜索实现流程:
1. 通过 字段 关系 值 三元组传至后端，
三元组表现形式可以是
"name__like":"aaa"
也可以是
"name":[{"relation":"like",value:"aaa"}]

2. 后端解析合成sql 或者jpa Specification，mongo Specification
sql用于 spring jdbctemplate or mybatis （通用）
jpa用于 spring data jpa
mongo用于 mongodb

3. 查询，返回合适值
合成list对象，以合理格式返回


字段：
- type：类型
- min: 下限，依赖于range
- max: 上限，依赖于range
- enum：[], 依赖于枚举，内部对象有label，name，id三个字段，可能依赖于编码表

类型：
- like:  简单input框
- compare: 比较框- 自己找或者自己写
- enum：枚举，选择框
- int_range: 整数范围，自增框？区间框？
- float_range: 浮点范围，区间框
- date_range：时间范围，时间区间框

## 控件元数据
只需要定义控件？数据应该是动态传的
h或者jsx
又想了想，直接写vue也是可以的，前端使用热加载就好，就是要控制好插入点，是slot么？

## 权限三张表
用户 拥有一个角色
角色 拥有多个权限，多对多
角色权限表 多对多
权限 包含菜单和目录

## 日志一张表 log

共计 12主表 两张关联表，共14张表
考虑前端用vue，后端用express django jfinal--spring gni ，用开发平台开发开发平台
接口统一》？
