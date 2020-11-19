package com.ys.music.mapper;


import com.ys.music.model.Singer.Singer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 歌手Mapper
 */
@Mapper
public interface SingerMapper {
    /**
     * 新增歌手
     */
    public int addSinger(Singer singer);

    /**
     * 修改歌手信息
     */
    public int updateSinger(Singer singer);

    /**
     * 删除歌手信息
     */
    public int delSinger(Integer id);

    /**
     * 查询所有歌手信息
     */
    public List<Singer> allSinger();

    /**
     * 根据id查询
     */
    public Singer selectSingerByID(Integer id);

    /**
     * 根据名字模糊查询歌手
     */
    public List<Singer> selectSingerByName(String name);
}
