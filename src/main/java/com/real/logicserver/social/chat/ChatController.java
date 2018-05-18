package com.real.logicserver.social.chat;

import com.real.logicserver.dto.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author asuis
 */
@RestController
@RequestMapping("/chat")
@Api("会议中发送、分享消息api")
public class ChatController {
    /**
     * 发送信息
     * */
    public Result sendChatMessage(){
        return null;
    }
    /**
     * 获取人员信息
     * */
    @GetMapping("/members")
    @ApiOperation("获取在线人信息")
    public Result getMembers(){
        return null;
    }
    /**
     * 获取图片
     * */
    @GetMapping("/img/get")
    @ApiOperation("获取图片")
    public Result getImage(){
        return null;
    }
    /**
     * 获取文件列表
     * */
    @GetMapping("/file/list/{mid}")
    @ApiOperation("获取房间文件列表")
    public Result getFileList() {
        return null;
    }


}