package com.real.logicserver.social.friend;

import com.real.logicserver.dto.Result;
import com.real.logicserver.social.friend.form.InviteFriendForm;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

/**
 * @author asuis
 */
@RestController
@Api("好友添加相关Api")
@RequestMapping("/v1/fri")
public class FriendController {
    /**
     * 添加好友
     * */
    @PostMapping("/add/{type}/{uid}")
    public Result addFriend(@PathVariable("type") String type,@PathVariable("uid") String uid) {
        return null;
    }
    /**
     * 删除好友
     * */
    @DeleteMapping("/del/{type}/{uid}")
    public Result removerFriend(@PathVariable("type") String type,@PathVariable("uid") String uid) {
        return null;
    }
    /**
     * 添加好友备注
     * */
    @PutMapping("/tag/add/{type}/{uid}")
    public Result addFriendTag(@PathVariable("type") String type,@PathVariable("uid") String uid) {
        return null;
    }
    /**
     * 邀请参加会议
     * */
    @PostMapping("/invite")
    public Result inviteToMeeting(@RequestBody InviteFriendForm inviteFriendForm){
        return null;
    }
    /**
     * 获取朋友列表
     * */
    @GetMapping("/list")
    public Result getFriendList(){
        return null;
    }
    /**
     * 查询朋友
     * */
    @GetMapping("/search/{query}")
    public Result searchFriend(@PathVariable String query){
        return null;
    }
}