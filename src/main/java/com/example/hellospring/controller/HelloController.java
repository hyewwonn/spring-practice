package com.example.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String Hello(Model model){
        model.addAttribute("data", "spring!!");
        return "hello";
    }
    
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template"; // return으로 넘겨준 (html)파일 엶
    }
    
    @GetMapping("hello-string")
    @ResponseBody // http의 body부에 데이터를 직접 넣음
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name; // "hello spring" 요청한 클라이언트에 그대로
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello; // JSON("키":"값") JSON은 XML방식보다 가벼움
    }
    static class Hello {
        private String name; //private이기 때문에 외부에서 직접 접근 x, getter setter를 통해 얻음(프로퍼티 접근 방식)

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
