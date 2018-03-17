package com.real.logicserver.vote;

import com.real.logicserver.dto.Result;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author asuis
 * 投票模块
 */
@RestController
@Api("投票模块api")
public class VoteController {
    /**
     * 为会议创建一个投票
     * */
    public Result addVote(){
        return null;
    }
    /**
     * 删除投票
     * */
    public Result removeVote(){
        return null;
    }
    /**
     * 处理投票信息
     * */
    public Result dealVoteMessage(){
        return null;
    }
    /**
     * 查看当前投票结果
     * */
    public Result getVoteResult() {
        return null;
    }
}