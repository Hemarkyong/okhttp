package com.http.controller;

import com.http.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HttpController {

    @RequestMapping("/login")
    public boolean login(@RequestParam String username,@RequestParam String password){
        System.out.println("login请求:"+username+","+password);
        return validata(username,password);
    }
    @RequestMapping(value="/getLogin",method = RequestMethod.GET)
    public boolean getLogin(@RequestParam String username,@RequestParam String password){
        System.out.println("get请求:"+username+","+password);

        return validata(username,password);
    }

    @RequestMapping(value="/postLogin",method = RequestMethod.POST)
    public boolean postLogin(@RequestParam String username, @RequestParam String password){
        System.out.println("POST请求:"+username+","+password);

        return validata(username,password);
    }

    private boolean validata(String username,String password){
        if(username.equals("okhttp")&&password.equals("123456"))
        {
            return true;
        }
        return false;
    }
}
