package com.nowcoder.community.controller;

import com.nowcoder.community.service.AlphaService;
import com.sun.javafx.collections.MappingChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.PushBuilder;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.*;
@Controller
@RequestMapping("/alpha")
public class AlphaController {
    @Autowired
    private AlphaService alphaService;
    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello(){
        return "Hello Spring Boot.";
    }

    @RequestMapping("/data")
    @ResponseBody
    public  String getService(){
        return alphaService.find();
    }

    @RequestMapping("/http")
    public  void http(HttpServletRequest request, HttpServletResponse response) throws IOException {
     //获取请求数据
        System.out.println(request.getMethod()); //获取请求方式
        System.out.println(request.getServletPath()); //获取请求路径
        Enumeration<String> enumeration = request.getHeaderNames();//得到请求行所有的key
        while(enumeration.hasMoreElements()){
            String name = enumeration.nextElement();
            String value = request.getHeader(name);
            System.out.println(name+":"+value);
        }
        System.out.println(request.getParameter("code"));
        //返回响应数据
        response.setContentType("text/html;charset =utf-8");   //设置返回类型
        PrintWriter writer = response.getWriter();   //获取输出流
        writer.write("<h1>牛客网</h1>");
    }

    //GET请求
    //  /students?current=1&limit=20
    @RequestMapping(value = "/students",method = RequestMethod.GET)    //强制只能用GET方法获得请求
    @ResponseBody
    public String getStudents(
            @RequestParam(name ="current",required = false,defaultValue = "1") int current ,
            @RequestParam(name ="limit",required = false,defaultValue = "20") int limit){
        System.out.println(current);
        System.out.println(limit);
        return "some students";
    }
    //  /students/123
    @RequestMapping(path = "/students/{id}",method = RequestMethod.GET)
    @ResponseBody
    public String getStudent(@PathVariable("id")int id){
        System.out.println(id);
        return"a student";
    }
//post请求
    //   /html/student.html
    @RequestMapping(path = "/student",method = RequestMethod.POST)
    @ResponseBody
    public String saveStudent(String name,int age){
        System.out.println(name);
        System.out.println(age);
        return  "success";
    }
    //响应动态的html
    @RequestMapping(path = "/teacher",method = RequestMethod.GET)
    public ModelAndView getTearch(){
        ModelAndView  mav =new ModelAndView();
        mav.addObject("name","张三");
        mav.addObject("age",30);
        mav.setViewName("/demo/view");
        return mav;

    }


    @RequestMapping(path = "/school",method = RequestMethod.GET)
    public  String getSchool(Model model){
        model.addAttribute("name","北京大学");
        model.addAttribute("age",80);
        return "/demo/view";
    }

    //单员工
    @RequestMapping(path = "/emp",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getmap(){
        Map<String , Object> emp = new HashMap<>();
        emp.put("name","张三");
        emp.put("age",20);
        emp.put("salary",8000.00);
        return  emp;
    }

    //响应多员工
    @RequestMapping(path = "/emps",method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String,Object>> getmaps(){
        List<Map<String,Object>> list = new ArrayList<>();
        Map<String , Object> emp = new HashMap<>();
        emp.put("name","张三");
        emp.put("age",20);
        emp.put("salary",8000.00);
        list.add(emp);

        emp.put("name","李四");
        emp.put("age",30);
        emp.put("salary",9000.00);
        list.add(emp);

        emp.put("name","王五");
        emp.put("age",25);
        emp.put("salary",6000.00);
        list.add(emp);

        return  list;
    }





}
