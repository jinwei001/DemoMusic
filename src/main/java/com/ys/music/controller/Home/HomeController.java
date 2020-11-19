package com.ys.music.controller.Home;

import com.ys.music.common.ResponseBean;
import com.ys.music.model.UserModel.UserModel;
import com.ys.music.service.HomeService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/user")
@RestController
@CrossOrigin
@Api(value = "用户", tags = {"用户"})
public class HomeController {
    @Autowired
    private HomeService homeService;
    int code = 200;

    /**
     * 用户登录
     *
     * @param name
     * @param password
     * @return
     */
    @PostMapping("/")
    @ApiOperation(value = "用户登录操作", notes = "用户登录操作")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "用户名称", dataType = "String", defaultValue = "admin"),
            @ApiImplicitParam(name = "password", value = "用户账号", dataType = "String", defaultValue = "123"),
    })
    public ResponseBean login(String name, String password) {
        UserModel admin = homeService.getuser(name, password);
        if (null == name || null == password) {
            return ResponseBean.ofSuccess(code, "没有账号或者，没有密码！！");
        } else if (null == admin) {
            return ResponseBean.ofSuccess(code, "账号或密码不正确！！");
        } else {
            return ResponseBean.ofSuccess(code, "登录成功！！！");
        }
    }

    /**
     * 查询所有用户
     *
     * @return
     */
    @GetMapping("/getAlluser")
    @ApiOperation(value = "查询所有用户", notes = "查询所有用户")
    public ResponseBean getAlluser() {
        List<UserModel> userModels = homeService.AllUser();
        return ResponseBean.ofSuccess(code, userModels);
    }

    /**
     * 根据名字查询用户
     *
     * @param name
     * @return
     */
    @PostMapping("/getuser")
    @ApiOperation(value = "根据名字查询用户", notes = "根据名字查询用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "用户名称", dataType = "String", defaultValue = "admin"),
    })
    public ResponseBean getuser(String name) {
        UserModel admin = homeService.getUserByName(name);
        if (null == name) {
            return ResponseBean.ofSuccess(code, "没有账号");
        } else if (null == admin) {
            return ResponseBean.ofSuccess(code, "账号不存在！！");
        } else {
            return ResponseBean.ofSuccess(code, admin);
        }
    }

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    @DeleteMapping("/delete")
    @ApiOperation(value = "删除用户", notes = "删除用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "")
    })
    public ResponseBean deluser(Integer id) {
        homeService.deleteUser(id);
        return ResponseBean.ofSuccess(code, "删除成功");
    }

    /**
     * 更新用户
     *
     * @param userModel
     * @return
     */
    @PutMapping("updateuser")
    @ApiOperation(value = "更新用户", notes = "更新用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = true),
            @ApiImplicitParam(name = "username", value = "用户名称", dataType = "String"),
            @ApiImplicitParam(name = "password", value = "用户密码", dataType = "String"),
    })
    public ResponseBean updateuser(UserModel userModel) {
        homeService.updateUser(userModel);
        System.out.println(userModel);
        return ResponseBean.ofSuccess(code, "更新成功");
    }


    /**
     * 新增用户
     *
     * @param userModel
     * @return
     */
    @PostMapping("adduser")
    @ApiOperation(value = "新增用户", notes = "新增用户")

    public ResponseBean adduser(@RequestBody UserModel userModel) {
        homeService.saveUser(userModel);
        System.out.println(userModel);
        return ResponseBean.ofSuccess(code, "新增成功");
    }
}
