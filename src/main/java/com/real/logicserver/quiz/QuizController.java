package com.real.logicserver.quiz;

import com.real.logicserver.dto.Result;
import com.real.logicserver.quiz.model.mongo.Questions;
import com.real.logicserver.quiz.service.QuestionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author asuis
 * 调查问卷模块
 * 管理员 编辑会议 可以添加调查问卷|报名表
 */
@RestController
@Api("报名表|调查问卷相关接口")
@RequestMapping("/v1/quiz")
public class QuizController {

    private final QuestionService questionService;

    @Autowired
    public QuizController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/create")
    @ApiOperation("创建调查问卷")
    public Result createQuiz(HttpServletRequest request, @RequestBody Questions questions){

        return null;
    }
    /**
     * 调查问卷添加
     * */
    @PutMapping("/put/{qid}")
    @ApiOperation("为调查问卷添加单个项目")
    public Result addQuizItem(@PathVariable("qid")String qid){
        return null;
    }
    @DeleteMapping("/delete/{qid}")
    @ApiOperation("删除问卷")
    public Result removeQuiz(@PathVariable("qid") String qid){
        return null;
    }
    @GetMapping("/result/get/{qid}")
    @ApiOperation("获取问卷统计结果")
    public Result getResultByQuiz(@PathVariable("qid")String qid){
        return null;
    }
    @PostMapping("/ans/submit")
    @ApiOperation("提交问卷答案")
    public Result submitAnswer(){
        return null;
    }
}