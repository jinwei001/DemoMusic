package com.ys.music.service.Impl;

import com.ys.music.mapper.HomeMapper;
import com.ys.music.model.UserModel.UserModel;
import com.ys.music.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeServiceImp implements HomeService {
    @Autowired
    private HomeMapper homeMapper;

    /**
     * 用户登录
     *
     * @param name
     * @param password
     * @return
     */
    @Override
    public UserModel getuser(String name, String password) {
        return homeMapper.getUser(name, password);
    }

    /**
     * 删除用户
     *
     * @param id
     */
    @Override
    public void deleteUser(int id) {
        homeMapper.deleteUser(id);
    }

    /**
     * 根据名字查询用户
     *
     * @param name
     * @return
     */
    @Override
    public UserModel getUserByName(String name) {
        return homeMapper.getUserByName(name);
    }

    /**
     * 更新用户信息
     *
     * @param userModel
     */
    @Override
    public void updateUser(UserModel userModel) {
        homeMapper.updateUser(userModel);
    }

    /**
     * 查询所有用户
     *
     * @return
     */
    @Override
    public List<UserModel> AllUser() {
        return homeMapper.AllUser();
    }

    /**
     * 新增用户
     *
     * @param userModel
     */
    @Override
    public void saveUser(UserModel userModel) {
        homeMapper.saveUser(userModel);
    }
}
