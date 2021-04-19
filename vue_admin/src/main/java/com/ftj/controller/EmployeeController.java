package com.ftj.controller;

import com.ftj.entity.Employee;
import com.ftj.entity.User;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin
public class EmployeeController {

    private static Collection<Employee> collection = new ArrayList<>();

    //模拟数据库
    static {
        collection.add(new Employee(1, "zhangsan", 2000.0, 25, "我是张三"));
        collection.add(new Employee(2, "lisi", 3000.0, 44, "我是李四"));
        collection.add(new Employee(3, "wangwu", 4444.0, 24, "我是王五"));
        collection.add(new Employee(4, "zhaoliu", 5000.0, 19, "我是赵六"));
    }

    @GetMapping("/emp")
    public Collection<Employee> getEmp() {
        return collection;
    }

    @PostMapping("/saveOrUpdate")
    public void saveOrUpdate(@RequestBody Employee employee) {
        if (employee.getId() == 0) {
            employee.setId(5);
            collection.add(employee);
        } else {
            for (Employee e : collection) {
                if (e.getId() == employee.getId()) {
                    e.setAge(employee.getAge());
                    e.setDesc(employee.getDesc());
                    e.setName(employee.getName());
                    e.setSalary(employee.getSalary());
                }
            }
        }
    }

    @PostMapping("/del/{id}")
    public void deleteEmp(@PathVariable long id) {
        //这里的遍历删除元素是有问题的 详细解释可见：https://blog.csdn.net/qq_35056292/article/details/79751233
        /*for (Employee e : collection) {
            if (e.getId() == id) {
                collection.remove(e);
            }
        }*/
        Iterator<Employee> it = collection.iterator();
        while (it.hasNext()) {
            if (it.next().getId() == id) {
                it.remove();
            }
        }
    }
}
