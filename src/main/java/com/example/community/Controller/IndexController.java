package com.example.community.Controller;

import com.example.community.Dto.QuestionDTO;
import com.example.community.Mapper.QuestionMapper;
import com.example.community.Mapper.UserMapper;
import com.example.community.Model.Question;
import com.example.community.Model.User;
import com.example.community.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author create by Jaw
 * @2019/11/24 14:24
 */
@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(HttpServletRequest request,
                        Model model){

        Cookie [] cookies =request.getCookies();
        if(cookies!=null &&cookies.length!=0)
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

        List<QuestionDTO> questionList=questionService.list();
        model.addAttribute("questionList",questionList);
        return "index";
    }
}
