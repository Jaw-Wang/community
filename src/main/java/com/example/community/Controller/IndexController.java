package com.example.community.Controller;

import com.example.community.Mapper.UserMapper;
import com.example.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author create by Jaw
 * @2019/11/24 14:24
 */
@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/")
    public String index(HttpServletRequest request){

        Cookie [] cookies =request.getCookies();
        for(Cookie cookie:cookies){
            if(cookie.getName().equals("token")){
                String token =cookie.getValue();
                User user =userMapper.findByToken(token);
                if(user!=null){
                    request.getSession().setAttribute("user", user);
                }
                break;
            }
        }
        return "index";
    }
}
