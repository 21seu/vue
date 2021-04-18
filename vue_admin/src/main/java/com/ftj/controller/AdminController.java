package com.ftj.controller;

import com.ftj.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin //允许所有请求 所有域访问 解决：跨域问题
public class AdminController {

    //定义post方式接口
    @PostMapping("/user")
    public Map<String, Object> save(@RequestBody User user) {
        System.out.println(user);
        Map<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("msg", "添加成功");
        return result;
    }

    //user接口（rest接口）
    @GetMapping("user/{id}")
    public User findUserById(@PathVariable("id") Integer id) {
        return new User(id, "小冯", 23, new Date());
    }

    //user接口
    @GetMapping("/user")
    public User user(@RequestParam("id") Integer id) {
        System.out.println("id:" + id);
        System.out.println("user ...");
        return new User(id, "小刘", 23, new Date());
    }

    @GetMapping("/demo")
    public String demo() {
        System.out.println("demo...");
        return "demo ok...";
    }
}
