# vue
## ![image.png](https://cdn.nlark.com/yuque/0/2021/png/12759906/1622687658442-afbbac9f-1dba-4f58-8069-5de761a256fb.png?x-oss-process=image%2Fresize%2Cw_2000)

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
    尤雨溪   国内的I 
```



## 2、vue入门

### 2.1 下载vue

```javascript
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



### 4.2 vue事件的简化语法

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>vue中的事件绑定v-on简化写法@</title>
</head>
<body>
<div id="app">
    <h2>{{age}}</h2>
    <!--
        vue中绑定事件  v-on：事件名 ===> @
    -->
    <input type="button" value="点我改变年龄" @click="changeAge"/>
</div>
</body>
</html>
<!--引入vue.js文件-->
<script src="../vue.js"></script>
<script>
    new Vue({
        el: '#app', //指定vue作用范围
        data: {  //用来个vue实例绑定一系列数据
            msg: "hello vue",
            age: 23
        },
        methods: {
            changeAge: function () {  //定义事件  简化写法,见changeAge2
                this.age++;
            },
        }
    })
</script>
```

```markdown
# 总结:
1.日后在vue中绑定事件时可以通过@符号形式 简化  v-on 的事件绑定
```



### 4.3 vue事件函数两种写法

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>vue中的事件绑定v-on简化写法@</title>
</head>
<body>
<div id="app">
    <h2>{{age}}</h2>
    <!--
        vue中绑定事件  v-on：事件名 ===> @
    -->
    <input type="button" value="点我改变年龄" @click="changeAge"/>
</div>
</body>
</html>
<!--引入vue.js文件-->
<script src="../vue.js"></script>
<script>
    new Vue({
        el: '#app', //指定vue作用范围
        data: {  //用来个vue实例绑定一系列数据
            msg: "hello vue",
            age: 23
        },
        methods: {
            changeAge: function () {  //定义事件  简化写法,见changeAge2
                this.age++;
            },
            changeAge2() { //es6语法

            }
        }
    })
</script>
```

```markdown
# 总结:
1.在Vue中事件定义存在两种写法  一种是 函数名:function(){}  推荐    一种是  函数名(){} 推荐
```



### 4.4 vue事件参数传递

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>04.vue中的事件绑定v-on简化写法@（二）</title>
</head>
<body>
<div id="app">
    <h2>{{age}}</h2>
    <!--
        vue中绑定事件  v-on：事件名 ===> @事件名="事件函数名(参数......)"
    -->
    <input type="button" value="点我改变年龄" @click="changeAge(10)"/>
</div>
</body>
</html>
<!--引入vue.js文件-->
<script src="../vue.js"></script>
<script>
    new Vue({
        el: '#app', //指定vue作用范围
        data: {  //用来个vue实例绑定一系列数据
            msg: "hello vue",
            age: 23
        },
        methods: {
            changeAge(number) { //定义事件
                this.age += number;
            }
        }
    })
</script>

```

```markdown
# 总结:
1.在使用事件时,可以直接在事件调用出给事件进行参数传递,在事件定义出通过定义对应变量接收传递的参数
```



## 5、v-if、v-show、v-bind的使用

### 5.1 v-show

> `v-show`用来控制页面中某个标签元素是否展示，底层使用display属性；使用场景：数据量比较大，控制显示极其频繁

```html
<div id="app">
    <!--
        v-show: 用来控制标签展示还是隐藏的
    -->
    <h2 v-show="false">vue之v-show!!!</h2>
    <h2 v-show="show">vue之v-show!!!属性为true展示！！！</h2>
    <input type="button" value="展示隐藏标签" @click="showmsg">

</div>
<!--引入vue.js-->
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script>
    const app = new Vue({
        el:"#app",
        data:{
            show:false,
        },
        methods:{
            //定义事件
            showmsg(){
               this.show =  !this.show;
            }
        }
    })
</script>
```

```markdown
# 总结
1.在使用v-show时可以直接书写boolean值控制元素展示,也可以通过变量控制标签展示和隐藏
2.在v-show中可以通过boolean表达式控制标签的展示和隐藏
```

### 5.2 v-if

> `v-if`用来控制页面元素是否展示，底层是DOM元素，操作DOM

```html
<div id="app">
    <h2 v-if="false">vue1</h2>
    <h2 v-if="show">vue2</h2>
</div>
<!--引入vue.js-->
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script>
    const app = new Vue({
        el:"#app",
        data:{
            show:false
        },
        methods:{

        }
    });
</script>
```

### 5.3 v-bind

> `v-bind`: 用来绑定标签的属性从而通过vue动态修改标签的属性

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>v-bind指令</title>
</head>
<style>
    .aa {
        border: 5px red solid;
    }

    .bb {
        border: 5px darkorange solid;
    }
</style>
<body>
<div id="app">
    <h2>{{msg}}</h2>

    <!--
        v-bind:绑定   作用：用来将html标签中相关属性绑定到vue实例中，日后通过vue实例中数据的改变，影响到对应标签中属性值变化
                     语法：v-bind:属性  ====>  简化写法：:属性名
    -->

    <img :class="isClass ? 'aa' : 'bb'" v-bind:src="imageSrc" :width="width" height="300px" v-bind:alt="tip"/>
</div>
</body>
</html>
<script src="../vue.js"></script>
<script>
    new Vue({
        el: '#app',
        data: {
            msg: "hello vue",
            imageSrc: "../img1.jpg",
            width: 200,
            tip: "这是一张图片...",
            //isClass:"aa"
            isClass: false //true 红色边框 false 橙色边框
        },
        methods: {}
    })
</script>
```



## 6、v-for的使用

> `v-for`: 作用就是用来对对象进行遍历的(数组也是对象的一种)

```html
<div id="app">

    <span>{{ user.name }} {{ user.age }}</span>
    <br>
    <!--
       通过v-for遍历对象
    -->
    <span v-for="(value,key,index) in user">
        {{index}} : {{key}} : {{value}}
    </span>

    <!--
        通过v-for遍历数组
    -->
    <ul>
        <li v-for="a,index in arr" >
            {{index}} {{a}}
        </li>
    </ul>

    <!--
        通过v-for遍历数组中对象
        :key 便于vue内部做重用和排序
    -->
    <ul>
        <li v-for="user,index in users" :key="user.id">
            {{index+1}} {{ user.name }}  === {{ user.age }} ==== {{ user.content }}
        </li>
    </ul>

</div>
<!--引入vue-->
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script>
    const app = new Vue({
        el: "#app",
        data: {
            user:{name:"小陈",age:23},
            arr:["北京校区", "天津校区", "河南校区"],
            users:[
                {id:"1",name:"xiaochen",age:23,content:"我曾经也是一个单纯的少年!"},
                {id:"2",name:"小白",age:23,content:"我曾经是一个邪恶的少年!"},
            ]
        },
        methods: {}
    });
</script>
```

```markdown
# 总结
1.在使用v-for的时候一定要注意加入:key 用来给vue内部提供重用和排序的唯一key
```



## 7、v-model双向绑定

> `v-model`: 作用用来绑定标签元素的值与vue实例对象中data数据保持一致,从而实现双向的数据绑定机制

```html
<div id="app">
    <input type="text" v-model="message">
    <span>{{message}}</span>
    <hr>
    <input type="button" value="改变Data中值" @click="changeValue">
</div>
<!--引入vue-->
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script>
    const app = new Vue({
        el: "#app",
        data: {
            message:""
        },
        methods: {
            changeValue(){
                this.message='双向绑定!';
            }
        }
    });
</script>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<div id="app">
    <h2>{{msg}}</h2>

    <!--
        v-model：用来绑定form表单标签中的value属性交给vue实例进行管理 input select checkbox button
        v-bind：用来绑定html标签中属性交给vue实例管理
    -->
    <input type="text" v-model="msg"/>
</div>
</body>
</html>
<script src="../vue.js"></script>
<script>
    new Vue({
        el: '#app',
        data: {
            msg: "hello vue",
            user: {name: "小王", age: 23, birthday: "2021-4-14"},
            schools: ["北京大学", "天津大学", "浙江大学", "南京大学"],
            users: [
                {id: "1", name: "小王", age: 21, bir: "2021-4-4"},
                {id: "2", name: "小朱", age: 24, bir: "2021-4-12"},
                {id: "3", name: "小红", age: 18, bir: "2021-4-8"},
            ]
        },
        methods: {}
    })
</script>
```

```markdown
# 总结
1.使用v-model指令可以实现数据的双向绑定 
2.所谓双向绑定 表单中数据变化导致vue实例data数据变化   vue实例中data数据的变化导致表单中数据变化 称之为双向绑定

# MVVM架构  双向绑定机制
Model: 数据  Vue实例中绑定数据
    
VM:   ViewModel  监听器

View:  页面  页面展示的数据
```



## 8、vue阶段案例（结合上面知识点）

### 8.1 备忘录案例

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>备忘录案例</title>
</head>
<body>
<div id="app">
    输入备忘录内容：<input type="text" placeholder="输入内容" v-model="info"/>
    <input type="button" value="添加" @click="addContent"><br>

    <ul v-show="contents.length != 0">
        <li v-for="(item,index) in contents">{{index+1}}、{{item}} <a href="javascript:;"
                                                                     @click="deleteContent(index)">删除</a></li>
    </ul>
    <h5 v-show="contents.length == 0" style="color: red">当前备忘录中还没有任何内容，请添加</h5>

    <h3>当前备忘录中共：{{contents.length}} 条</h3>
    <input type="button" value="清空备忘录" @click="deleteAll"/>
</div>
</body>
</html>
<script src="../vue.js"></script>
<script>
    new Vue({
        el: "#app", //代表vue实例的作用范围
        data: {
            msg: "备忘录功能实现",
            contents: [
                "今天要好好学习", "今天要去市场买菜"
            ],
            info: ""
        },
        methods: {  //在vue实例中定义相关函数
            addContent() { //添加备忘信息
                //没有内容的时候不能添加数据
                if (this.info === "") {
                    alert("请输入备忘内容");
                    return;
                }
                this.contents.push(this.info);
                //清空一下info属性
                this.info = "";
            },
            deleteContent(index) { //删除指定元素
                this.contents.splice(index, 1);
            },
            deleteAll() { //清空备忘录
                this.contents = [];
            }
        }
    })
</script>
```

### 8.2 购物车案例

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>购物车案例</title>
</head>
<body>
<div id="app">
    <h1>{{msg}}</h1>
    <table border="1">
        <tr>
            <th>id</th>
            <th>名称</th>
            <th>价格</th>
            <th>数量</th>
            <th>小计</th>
        </tr>
        <!--v-for遍历vue实例中的数据--> <!--:key作用：https://www.zhihu.com/question/61064119-->
        <tr v-for="(item,index) in items" :key="items.id">
            <td>{{item.id}}</td>
            <td>{{item.name}}</td>
            <td>{{item.price}}</td>
            <td><input type="button" value="-" @click="decrCount(index)"/>{{item.count}}<input type="button" value="+"
                                                                                               @click="incrCount(index)"/>
            </td>
            <td>{{(item.price * item.count).toFixed(2)}}</td>
        </tr>

    </table>
    <h3>总价格：{{getTotalPrice()}}</h3>
</div>
</body>
</html>
<script src="../vue.js"></script>
<script>
    new Vue({
        el: "#app", //代表vue实例的作用范围
        data: {
            msg: "购物车功能实现",
            items: [
                {id: 1, name: "iphone12", count: 1, price: 6999.0},
                {id: 2, name: "HUAWEI Pro", count: 1, price: 4999.0}
            ]
        },
        methods: {
            incrCount(index) {
                this.items[index].count++;
            },
            decrCount(index) {
                if (this.items[index].count < 1) {
                    alert("所买的商品不能再少了！！！");
                    return;
                }
                this.items[index].count--;
            },
            getTotalPrice() {
                var totalPrice = 0;
                for (let val of this.items) {
                    console.log("debug=====>", val);
                    totalPrice += val.count * val.price;
                }
                return totalPrice.toFixed(2);
            }
        }
    })
</script>
```

### 8.3 购物车案例之总价格methods实现

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>购物车案例之总价格methods实现</title>
</head>
<body>
<div id="app">
    <h1>{{msg}}</h1>
    <table border="1">
        <tr>
            <th>id</th>
            <th>名称</th>
            <th>价格</th>
            <th>数量</th>
            <th>小计</th>
        </tr>
        <!--v-for遍历vue实例中的数据--> <!--:key作用：https://www.zhihu.com/question/61064119-->
        <tr v-for="(item,index) in items" :key="items.id">
            <td>{{item.id}}</td>
            <td>{{item.name}}</td>
            <td>{{item.price}}</td>
            <td><input type="button" value="-" @click="decrCount(index)"/>{{item.count}}<input type="button" value="+"
                                                                                               @click="incrCount(index)"/>
            </td>
            <td>{{(item.price * item.count).toFixed(2)}}</td>
        </tr>

    </table>
    <!--
        使用methods方法完成计算业务：
        缺点：
            1、只要调用了一次计算方法，整个计算方法就会执行一次，如果在一个页面中多次使用到计算结果，可能会造成重复计算，导致页面
               加载性能变慢。
    -->
    <h3>总价格：{{getTotalPrice()}}</h3>
</div>
</body>
</html>
<script src="../vue.js"></script>
<script>
    new Vue({
        el: "#app", //代表vue实例的作用范围
        data: {
            msg: "购物车功能实现",
            items: [
                {id: 1, name: "iphone12", count: 1, price: 6999.0},
                {id: 2, name: "HUAWEI Pro", count: 1, price: 4999.0}
            ]
        },
        methods: {
            incrCount(index) {
                this.items[index].count++;
            },
            decrCount(index) {
                if (this.items[index].count < 1) {
                    alert("所买的商品不能再少了！！！");
                    return;
                }
                this.items[index].count--;
            },
            getTotalPrice() {
                var totalPrice = 0;
                for (let val of this.items) {
                    console.log("debug=====>", val);
                    totalPrice += val.count * val.price;
                }
                return totalPrice.toFixed(2);
            }
        }
    })
</script>
```

### 8.4 购物车案例之总价格computed实现

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>购物车案例之总价格computed实现</title>
</head>
<body>
<div id="app">
    <h1>{{msg}}</h1>
    <table border="1">
        <tr>
            <th>id</th>
            <th>名称</th>
            <th>价格</th>
            <th>数量</th>
            <th>小计</th>
        </tr>
        <!--v-for遍历vue实例中的数据--> <!--:key作用：https://www.zhihu.com/question/61064119-->
        <tr v-for="(item,index) in items" :key="items.id">
            <td>{{item.id}}</td>
            <td>{{item.name}}</td>
            <td>{{item.price}}</td>
            <td><input type="button" value="-" @click="decrCount(index)"/>{{item.count}}<input type="button" value="+"
                                                                                               @click="incrCount(index)"/>
            </td>
            <td>{{(item.price * item.count).toFixed(2)}}</td>
        </tr>

    </table>
    <!--
        使用computed方法完成计算业务：
        computed：vue官方提供的一个计算属性   ！！！记住：是一个属性
            作用：在完成某种业务时，往往页面结果需要经过多次计算才能获取，computed属性就是用来完成业务结果多次计算
            好处：在完成计算的同时也会将本次计算结果进行缓存，如果数据没有发生变化，在页面中多次使用，计算方法仅仅计算一次
    -->
    <h3>总价格：{{totalPrice}}</h3>
</div>
</body>
</html>
<script src="../vue.js"></script>
<script>
    new Vue({
        el: "#app", //代表vue实例的作用范围
        data: {
            msg: "购物车功能实现",
            items: [
                {id: 1, name: "iphone12", count: 1, price: 6999.0},
                {id: 2, name: "HUAWEI Pro", count: 1, price: 4999.0}
            ]
        },
        methods: {
            incrCount(index) {
                this.items[index].count++;
            },
            decrCount(index) {
                if (this.items[index].count < 1) {
                    alert("所买的商品不能再少了！！！");
                    return;
                }
                this.items[index].count--;
            }
        },
        computed: { //计算属性：用来书写计算相关方法(好处：只进行一次计算，后面使用直接使用它的缓存)
            totalPrice() {
                var totalPrice = 0;
                for (let val of this.items) {
                    console.log("debug=====>", val);
                    totalPrice += val.count * val.price;
                }
                return totalPrice.toFixed(2);
            }
        }
    })
</script>
```
