package com.ys.music.service;

import com.ys.music.model.UserModel.UserModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HomeService {
    /**
     * 用户登录
     *
     * @param name
     * @param password
     * @return
     */
    UserModel getuser(String name, String password);

    /**
     * 删除用户
     *
     * @param id
     */
    void deleteUser(int id);

    /**
     * 根据名字查询用户
     *
     * @param name
     * @return
     */
    UserModel getUserByName(String name);


    /**
     * 更新用户信息
     * @param userModel
     */
    void updateUser(UserModel userModel);

    /**
     * 查询所有用户
     * @return
     */
    List<UserModel> AllUser();

    /**
     * 新增用户
     * @param userModel
     */
    void saveUser(UserModel userModel);
}
