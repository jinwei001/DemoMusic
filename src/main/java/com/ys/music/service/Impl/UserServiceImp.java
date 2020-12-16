package com.ys.music.service.Impl;


import com.ys.music.mapper.UserMapper;
import com.ys.music.model.UserModel.UserRool;
import com.ys.music.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserMapper usermapper;


    /**
     * 根据用户查询角色对应的权限表
     *
     * @param code
     */

    @Override
    public List<UserRool> UserRool(Integer code) {
        return usermapper.selectUserRool(code);
    }
}
