package com.ys.music.service.Impl;

import com.ys.music.mapper.SingerMapper;
import com.ys.music.model.Singer.Singer;
import com.ys.music.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SingerServiceImp implements SingerService {
    @Autowired
    private SingerMapper singerMapper;


    /**
     * 新增歌手
     *
     * @param singer
     */
    @Override
    public boolean addSinger(Singer singer) {
        return singerMapper.addSinger(singer)>0;
    }

    /**
     * 修改歌手信息
     *
     * @param singer
     */
    @Override
    public boolean updateSinger(Singer singer) {
        return singerMapper.updateSinger(singer)>0;
    }

    /**
     * 删除歌手信息
     *
     * @param id
     */
    @Override
    public boolean delSinger(Integer id) {
        return singerMapper.delSinger(id)>0;
    }

    /**
     * 查询所有歌手信息
     */
    @Override
    public List<Singer> allSinger() {
        return singerMapper.allSinger();
    }

    /**
     * 根据id查询
     *
     * @param id
     */
    @Override
    public Singer selectSingerByID(Integer id) {
        return singerMapper.selectSingerByID(id);
    }

    /**
     * 根据名字模糊查询歌手
     *
     * @param name
     */
    @Override
    public List<Singer> selectSingerByName(String name) {
        return singerMapper.selectSingerByName(name);
    }
}
