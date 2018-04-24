package com.real.logicserver.luck;

import com.real.logicserver.dto.Result;
import com.real.logicserver.dto.ResultCode;
import com.real.logicserver.luck.form.LuckForm;
import com.real.logicserver.luck.service.LuckService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author asuis
 */
@RestController
@Api("抽奖相关接口")
@RequestMapping("/v1/luck")
public class LuckController {

    private final LuckService luckService;

    @Autowired
    public LuckController(LuckService luckService) {
        this.luckService = luckService;
    }

    @PostMapping("/create")
    public Result create(@RequestBody LuckForm luckForm) {
        return luckService.create();
    }
}
