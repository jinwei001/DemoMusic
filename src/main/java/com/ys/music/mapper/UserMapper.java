package com.ys.music.mapper;

import com.ys.music.model.UserModel.UserRool;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserMapper {

    /**
     * 根据用户查询角色对应的权限表
     */
    public List<UserRool> selectUserRool(Integer code);
}
