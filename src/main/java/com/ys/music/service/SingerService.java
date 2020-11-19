package com.ys.music.service;

import com.ys.music.model.Singer.Singer;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SingerService {
    /**
     * 新增歌手
     */
    public boolean addSinger(Singer singer);

    /**
     * 修改歌手信息
     */
    public boolean updateSinger(Singer singer);

    /**
     * 删除歌手信息
     */
    public boolean delSinger(Integer id);

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
