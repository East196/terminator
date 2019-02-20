  
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