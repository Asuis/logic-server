package com.real.logicserver.price;

import com.real.logicserver.dto.Result;
import com.real.logicserver.price.form.RedPaperForm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author asuis
 * 红包 金额 交易 模块
 */
@RestController
@RequestMapping("/v1/p")
@Api("金额交易相关系统")
public class PriceController {
    /**
     * 抢红包
     * 需进行身份校验
     * */
    @GetMapping("/get/{rid}")
    @ApiOperation("获取红包")
    public Result getRedPaper(HttpServletRequest request, HttpServletResponse response, @PathVariable("rid")String rid) {
        return null;
    }
    /**
     * 创建红包
     * */
    @PostMapping(value = "/create/")
    public Result createRedPaper(@RequestBody RedPaperForm redPaperForm) {
        return null;
    }
    /**
     * 发送定向红包
     * */
    @GetMapping(value = "")
    public Result sendRedPaper () {
        return null;
    }
    /**
     * 取消定时红包
     * */
    public Result cancelTimerRedPaper() {
        return null;
    }
    /**
     * 提现
     * */
    public Result getMoney () {
        return null;
    }
    /**
     * 查看抢红包排名 model siample userinfo
     * */
    public Result getRank() {
        return null;
    }
}