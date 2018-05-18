package com.real.logicserver.meeting;
import com.google.zxing.WriterException;
import com.real.logicserver.meeting.service.GenerateIdService;
import com.real.logicserver.meeting.utils.ZxingUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * @author asuis
 */
@Controller
@RequestMapping(value = "/v1/m/")
@Api("会议二维码生成")
public class QrcodeController {

    private final GenerateIdService generateIdService;

    @Autowired
    public QrcodeController(GenerateIdService generateIdService) {
        this.generateIdService = generateIdService;
    }

    @RequestMapping(value = "invite/get/{mid}", method = RequestMethod.GET)
    @ApiOperation("生成二维码用作邀请会议")
    public void readZxing(HttpServletResponse response, Integer size, Integer margin, String level,
                          String format, String content, @PathVariable("mid") Integer mid) throws WriterException, IOException {
        Integer width,height;
        if(size == null){
            width = 200;
            height = 200;
        }else{
            width = size;
            height = size;
        }
        if(margin == null) {
            margin = 0;
        }
        if(level == null) {
            level = "L";
        }
        if(format == null) {
            format = "gif";
        }
        if(content == null) {
            content = mid.toString();
        }
        ZxingUtil.createZxing(response, width, height, margin, level, format, content);
    }
    @RequestMapping(value = "signup/get/{mid}", method = RequestMethod.GET)
    @ApiOperation("生成二维码用作会议签到")
    public void getSignupCode(HttpServletResponse response, Integer size, Integer margin, String level,
                          String format, String content, @PathVariable("mid") Integer mid) throws WriterException, IOException {
        Integer width,height;
        if(size == null){
            width = 200;
            height = 200;
        }else{
            width = size;
            height = size;
        }
        if(margin == null) {
            margin = 0;
        }
        if(level == null) {
            level = "L";
        }
        if(format == null) {
            format = "gif";
        }
        if(content == null) {
            content = "https://asuis.mengxiangjing.com/signup/"+mid;
        }
        ZxingUtil.createZxing(response, width, height, margin, level, format, content);
    }
}