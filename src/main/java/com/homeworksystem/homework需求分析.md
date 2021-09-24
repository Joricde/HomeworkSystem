## 需求分析

### 学生端

+ 登录（账号、密码
  1. 显示登录后信息（账号、姓名、学号）
  2. 登录成功后 课程显示（拉取课程信息 -（课程名、班级，任课老师）
  3. 进入具体课程，拉取课程内信息。显示作业条例，n次作业，状态（未交、待审阅、超时、已批改）
  4. 点击作业某一条例，进入具体内容
     1. 显示内容有  题目、内容、时间、 提交按钮（若未超时且未批改，可编辑or输入内容提交作业）
     2. 提交内容 
     3. （统一文件形式保存。若在文本框编写，则使用字符串形式存储，若为上传文件形式，存储其url，方便提供用户下载，ury样例{/100班/xxx/文件.file}（为了不使路径中文件冲突，应该改写文件名存储。同时使用数据库存储其原来文件名，

### 教师端 

+ 登录 （账号密码）
  1. 显示登录后信息





### 接口文档 

默认api为前缀

| 参数名 | 必选  | 类型   | 说明  |
| ------ | ----- | ------ | ----- |
| 请求头 | token | string | token |

 /Stulogin

请求参数

| 参数名   | 必选 | 类型   | 说明 |
| -------- | ---- | ------ | ---- |
| account  | true | int    | 账号 |
| password | true | string | 密码 |

```json

{
    "account": "123456",
    "password": "password"
}

```

返回数据包

```json
{
	{
	"msg":"登录成功",
	"result":{
		"name":"name",
		"student_no":"1234"
		"token":"asfdaklfhalkfhbaagfka",
		},
	"code":1
	}	
}
```

说明

| 参数   | 说明                 |
| ------ | -------------------- |
| msg    | 请求结果信息         |
| result | 学生个人信息         |
| code   | 登录状态 1成功 0失败 |



/course

请求参数

| 参数名  | 必选 | 类型 | 说明 |
| ------- | ---- | ---- | ---- |
| account | true | int  | 账号 |

返回数据包

```json
{
    "course_no": "123",
    "class_no": "10"
    "name":"C语言",
    "teacher_name":"老师",
    
}
```



/homework

请求参数

```json
{
	"course_no": "`123",
	"student_no": "601918000",
}
```

返回数据

```json
{
 {
    "homework_no": "123123"
 	"title": "第二次作业",
    "content":"作业具体题目",
    "start":"开始时间",
    "end":"截止时间",
    "status":"待批改",
    "score":-1
},
 {
    "homework_no": "123456",
 	"title": "第一次作业",
    "content":"作业具体题目",
    "start":"开始时间",
    "end":"截止时间",
    "status":"已批改",   
    "score": 90
}
}
```

/submit_homework

请求参数

```json
 {
    "homework_no": "123456"
}
```

返回数据

```json
 	{
	"msg":"提交成功",
	"result":{
        
	"code":1
	}	
```









/TeacherLogin

| 参数名   | 必选 | 类型   | 说明 |
| -------- | ---- | ------ | ---- |
| account  | true | int    | 账号 |
| password | true | string | 密码 |

```json
{
    "account": "123456",
    "password": "password"
}
```



