# vue
## 1、vue引言



![image.png](https://cdn.nlark.com/yuque/0/2021/png/12759906/1619234936540-fc516a0b-e296-4980-a010-ab2923a2b7a7.png)

> `渐进式` JavaScript框架



```markdown
# 渐进式
1、易用    html css js
2、高效  开发前端页面 非常高效
3、灵活  开发灵活 多样性

# 总结
Vue 是一个javascript 框架 js 简化页面js操作
bootstrap 是一个css框架  封装css

# 后端服务端开发人员: 
页面标签  dom  jquery js document.getElementById("xxx")
    
Vue 渐进式javascript框架: 让我们通过操作很少的DOM,甚至不需要操作页面中任何DOM元素,就很容易的完成数据和视图绑定 ====> 双向绑定 MVVM 
    
注意: 日后在使用Vue过程中页面中不要在引入Jquery框架
        
html css--->javascript(document.getElementById()...) -----> jquery($("#xx")) ----> angularjs -----> Vue(前后端分离架构核心)

Vue 前端系统     <---JSON---->  后台系统springcloud

19年  full stack  全栈式开发工程师

# Vue 作者
    尤雨溪   国内的
```



## 2、vue入门

### 2.1 下载vue

```html
//开发版本:
<!-- 开发环境版本，包含了有帮助的命令行警告 -->
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>

//生产版本:
<!-- 生产环境版本，优化了尺寸和速度 -->
<script src="https://cdn.jsdelivr.net/npm/vue"></script>
```

### 2.2 vue的第一个入门应用

```html
<div id="app">
    {{ msg }} {{username}} {{pwd}}

    <br>
    <span>
            {{ username }}
            <h1>{{ msg }}</h1>
        </span>

</div>
<!--引入vue.js-->
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script>
    const app = new Vue({
        el: "#app",  //element 用来给Vue实例定义一个作用范围
        data: {      //用来给Vue实例定义一些相关数据
            msg: "vue入门应用",
            username: "hello Vue!",
            pwd: "12345",
        },
    });
</script>
```

```markdown
# 总结:
1.vue实例(对象)中el属性:   代表Vue的作用范围  日后在Vue的作用范围内都可以使用Vue的语法

2.vue实例(对象)中data属性: 用来给Vue实例绑定一些相关数据, 绑定的数据可以通过{{变量名}}在Vue作用范围内取出

3.在使用{{}}进行获取data中数据时,可以在{{}}中书写表达式,运算符,调用相关方法,以及逻辑运算等

4.el属性中可以书写任意的CSS选择器[jquery选择器],但是在使用Vue开发是推荐使用 id选择器  注意: el属性值不能指定body或html标签
```



## 3、v-text和v-html



> `v-text` 用来获取data中的数据将数据以文本形式渲染到指定标签内部，类似与javascrpit中的innerText。
>
> `v-html` 用来获取data中的数据，将数据中含有的html标签先解析，再渲染到指定标签内部，类似于javascript的innterHTML。

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
    <!--vue提供两个指令：v-text v-html 都可以直接根据属性名获取data中数据渲染到指定标签内-->

    <!--v-text-->
    <h2><span v-text="msg"></span> 您好</h2>

    <!--
    v-text：{{}}取值区别
    1、使用{{}}取值不会将标签原始数据覆盖  v-text获取数据会将标签中原始内容覆盖
    2、v-text获取数据时不会出现插值闪烁  {{属性名}} ===> 插值表达式：容易出现插值闪烁（当网络条件不好的情况下使用
       这种方式会出现闪烁） 可以使用chrome浏览器network中修改网络来测试
    -->

    <h2 v-html="content"></h2>
    <h2 v-text="content"></h2>

    <!--
        v-text：将获取数据直接以文本形式渲染到标签内部  innerText(js)
        v-html：将获取数据中含有html标签解析之后渲染到对应标签内部  innerHtml(js)
    -->
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
            content:"<a href='www.github.com'>欢迎来到github</a>"
        }
    })
</script>
```



## 4、vue中的事件绑定v-on

### 4.1 绑定事件基本语法

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>vue中的事件绑定v-on</title>
</head>
<body>
<div id="app">
    <!--
        js事件三要素：
            1、事件源：发生事件的源头称为事件，一般指html标签
            2、事件： 发生特定的动作，onclick单击  dbclick双击  onkeyup...
            3、监听器：事件处理程序，事件处理函数  function{}

        vue事件：v-on:
            1、vue给对应的标签绑定事件：v-on进行事件的绑定  v-on:事件名
            2、vue中事件处理函数统一声明再vue实例中的methods属性
    -->
    <input type="button" value="点我" v-on:click="clickMe" v-on:mouseover="overMe"/>
</div>
</body>
</html>
<!--引入vue.js文件-->
<script src="../vue.js"></script>
<script>
    new Vue({
        el: '#app', //指定vue作用范围
        data: {  //用来个vue实例绑定一系列数据
            msg: "hello vue"
        },
        methods: {  //用来给当前vue实例对象，声明一些列函数
            clickMe: function () {
                alert("点我！！！");
            },
            overMe:function () {
                alert("鼠标移入了！！！");
            }
        }
    })
</script>
```

```markdown
# 总结:
事件  事件源:发生事件dom元素  事件: 发生特定的动作  click....  监听器  发生特定动作之后的事件处理程序 通常是js中函数

1.在vue中绑定事件是通过v-on指令来完成的 v-on:事件名 如  v-on:click
2.在v-on:事件名的赋值语句中是当前事件触发调用的函数名
3.在vue中事件的函数统一定义在Vue实例的methods属性中
4.在vue定义的事件中this指的就是当前的Vue实例,日后可以在事件中通过使用this获取Vue实例中相关数据
```