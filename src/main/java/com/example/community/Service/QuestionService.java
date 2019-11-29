package com.example.community.Service;

import com.example.community.Dto.QuestionDTO;
import com.example.community.Mapper.QuestionMapper;
import com.example.community.Mapper.UserMapper;
import com.example.community.Model.Question;
import com.example.community.Model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private UserMapper userMapper;

    //查询问题列表
    public List<QuestionDTO> list() {
        List<Question> questions=questionMapper.list();
        List<QuestionDTO> questionDTOList=new ArrayList<>();
        for (Question question:questions){
            User user= userMapper.findById(question.getCreator());
            QuestionDTO questionDTO=new QuestionDTO();
            //把question对象放到questionDTO对象
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
            //老版本
            /*questionDTO.setId(question.getId());*/
        }
        return questionDTOList;
    }
}
