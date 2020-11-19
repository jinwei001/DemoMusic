package com.ys.music.mapper;

import com.ys.music.model.UserModel.UserModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HomeMapper {
    /**
     * 用户登录
     *
     * @param name
     * @param password
     * @return
     */
    UserModel getUser(String name, String password);

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
