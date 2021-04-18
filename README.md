# vue
## 1、vue引言

<<<<<<< HEAD
![image-20210417124205955](..\vue-first\typora-user-images\image-20210417124205955.png)
=======
<img src="https://github.com/21seu/vue/blob/master/typora-user-images/image-20210417124205955.png"/>
>>>>>>> f1cb595cdd5e0a68debe7cae15c9b9b51b10b76a

> `渐进式` JavaScript 框架   --摘自官网

```markdown
# 渐进式
   1. 易用  html css javascript
   2. 高效  开发前端页面 非常高效 
   3. 灵活  开发灵活 多样性

# 总结
		Vue 是一个javascript 框架 js 简化页面js操作
		bootstrap 是一个css框架  封装css

# 后端服务端开发人员: 
		页面标签  dom  jquery js document.getElementById("xxx")
		Vue 渐进式javascript框架: 让我们通过操作很少的DOM,甚至不需要操作页面中任何DOM元素,就很容易的完成数据和视图绑定 ====> 双向绑定 MVVM  
		
		注意: 日后在使用Vue过程中页面中不要在引入Jquery框架
		
		html css--->javascript(document.getElementById()...) -----> jquery($("#xx")) 
		        ----> angularjs -----> Vue(前后端分离架构核心)
 		Vue 前端系统     <---JSON---->  后台系统springcloud
 		19年  full stack  全栈式开发工程师

# Vue 作者
 	尤雨溪   国内的 
```



## 2、vue入门
### 2.1  下载vue.js

你可以创建一个`.html`文件，然后通过如下方式引入它。

```javascript
<!-- 开发环境版本，包含了有帮助的命令行警告 -->
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>

<!-- 生产环境版本，优化了尺寸和速度 -->
<script src="https://cdn.jsdelivr.net/npm/vue"></script>
```

### 2.2 第一个vue入门程序

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>使用v-text和v-html</title>
</head>
<body>
<div id="app">
    <h2>{{msg}}</h2>
</div>
</body>
</html>
<!--引入vue.js文件-->
<script src="../vue.js"></script>
<script>
    new Vue({
        el:'#app', //指定vue作用范围
        data:{  //用来个vue实例绑定一系列数据
            msg:"hello vue",
        }
    })
</script>
```

```markdown
# 总结:
	1.vue实例(对象)中el属性: 	代表Vue的作用范围  日后在Vue的作用范围内都可以使用Vue的语法
	2.vue实例(对象)中data属性: 用来给Vue实例绑定一些相关数据, 绑定的数据可以通过{{变量名}}在Vue作用范围内取出
	3.在使用{{}}进行获取data中数据时,可以在{{}}中书写表达式,运算符,调用相关方法,以及逻辑运算等
	4.el属性中可以书写任意的CSS选择器[jquery选择器],但是在使用Vue开发是推荐使用 id选择器  注意: el属性值不能指定body或html标签
```



## 3、v-text和v-html

### 3.1 v-text

> `v-text` 用来获取data中的数据，将数据以文本形式渲染到指定标签内部，类似于js中的innerText

```html
<div id="app" class="aa">
    <span >{{ message }}</span>
    <span v-text="message"></span>
</div>

<!--引入vue.js-->
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script>
    const app = new Vue({
        el:"#app",
        data:{
            message:"vue欢迎您"
        }
    })
</script>
```

```markdown
# 总结
    1.{{}}(插值表达式)和v-text获取数据的区别在于 
 	a.使用v-text取值会将标签中原有的数据覆盖 使用插值表达式的形式不会覆盖标签原有的数据
	b.使用v-text可以避免在网络环境较差的情况下出现插值闪烁
```



### 3.2 v-html

> `v-html` 用来获取data中的数据，将含有的html标签先解析再渲染到指定标签内部，类似于js中的innerHTML

```html
<div id="app" class="aa">
        <span>{{message}}</span>
        <br>
        <span v-text="message"></span>

        <br>
        <span v-html="message">xxxxxx</span>
</div>

<!--引入vue.js-->
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script>
    const app = new Vue({
        el:"#app",
        data:{
            message:"<a href=''>vue欢迎您</a>"
        }
    })
</script>
```