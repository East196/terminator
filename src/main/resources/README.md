  
  ```
  {
    path: '/ProjectList',
    name: 'ProjectList',
    component: () => import('@/views/crud/ProjectList'),
    meta: { title: 'ProjectList', icon: 'bank', permission: ['Home'] }
  },
  {
    path: '/FieldList',
    name: 'FieldList',
    component: () => import('@/views/crud/FieldList'),
    meta: { title: 'FieldList', icon: 'bank', permission: ['Home'] }
  },
  {
    path: '/RecordList',
    name: 'RecordList',
    component: () => import('@/views/crud/RecordList'),
    meta: { title: 'RecordList', icon: 'bank', permission: ['Home'] }
  },
  ```
  
  
 
安装 sdkman
安装 lazybones

## TODO 
- [ ] 自定义个人模板
- [x] 支持 Ant Design Vue
- [ ] 支持 LayUI
- [x] 支持 Dio for Dart/Flutter 
- [x] 支持 Retrofit for Java/Android 
- [x] 支持 Feign for Java 
- [x] 支持 Spring MVC 
- [x] 支持 Spring Data JPA 
- [x] 支持 Mybatis 
- [x] 支持 Jfinal 
- [ ] 支持 Django 
- [ ] 支持 Flask
- [ ] 支持 ThinkPHP
- [ ] 支持 CodeIgniter