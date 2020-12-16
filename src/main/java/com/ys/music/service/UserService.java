package com.ys.music.service;


import com.ys.music.model.UserModel.UserRool;

import java.util.List;

public interface UserService {
    /**
     * 根据用户查询角色对应的权限表
     */
    public List<UserRool> UserRool(Integer code);
}
