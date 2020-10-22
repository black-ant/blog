# AntBlog 文档



## 一 . Blog 项目简介

```
> 该项目致力于提供Blog的 Server 服务

> 描述切割 : DocInfoService
```



## 二 . 项目结构记录

### 2.1 Blog 拉取方式

```javascript
var form = new FormData();
form.append("projectPath", "https://github.com/black-ant/blogDoc.git");
form.append("type", "git");

var settings = {
  "url": "127.0.0.1:8086/pull/bypath",
  "method": "POST",
  "timeout": 0,
  "headers": {
    "Content-Type": "multipart/form-data",
    "Cookie": "Cookie_6=value; LtpaToken=AQIDBDVGODk1QzkyNjc0MkU2OTJzeXNhZG1pbpTBpJ2LS8k8RExKtI3NPGM6YPsc"
  },
  "processData": false,
  "mimeType": "multipart/form-data",
  "contentType": false,
  "data": form
};

$.ajax(settings).done(function (response) {
  console.log(response);
});



```

### 2.2 创建 Doc

```javascript
// 作用 : 生成 BLOG.md

var settings = {
  "url": "127.0.0.1:8086/docbuild",
  "method": "GET",
  "timeout": 0,
  "headers": {
    "Content-Type": "application/json",
    "Cookie": "Cookie_6=value; LtpaToken=AQIDBDVGODk1QzkyNjc0MkU2OTJzeXNhZG1pbpTBpJ2LS8k8RExKtI3NPGM6YPsc"
  },
  "data": JSON.stringify({"filePath":"D:\\java\\workspace\\doc\\blogDoc","findChild":true}),
};

$.ajax(settings).done(function (response) {
  console.log(response);
});

// Class 
C- DocJsonController 

C- DocInfoService
	|- buildFlow
```



## 三 . 项目操作记录
### 3.1 Template 模板访问
```

```

## 附录 

### 待完善

https://www.jq22.com/jquery-info3674
