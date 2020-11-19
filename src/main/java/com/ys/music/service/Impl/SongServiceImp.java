package com.ys.music.service.Impl;

import com.ys.music.mapper.SongMapper;
import com.ys.music.model.Song.Song;
import com.ys.music.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImp implements SongService {
    @Autowired
    private SongMapper songMapper;
    /**
     * 新增歌曲
     *
     * @param song
     */
    @Override
    public boolean addSong(Song song) {
        return songMapper.addSong(song)>0;
    }

    /**
     * 修改歌曲信息
     *
     * @param song
     */
    @Override
    public boolean updateSong(Song song) {
        return songMapper.updateSinger(song)>0;
    }

    /**
     * 删除歌曲信息
     *
     * @param id
     */
    @Override
    public boolean delSong(Integer id) {
        return songMapper.delSong(id)>0;
    }

    /**
     * 查询所有歌曲信息
     */
    @Override
    public List<Song> allSong() {
        return songMapper.allSong();
    }

    /**
     * 根据id查询
     *
     * @param id
     */
    @Override
    public Song selectSongByID(Integer id) {
        return songMapper.selectSongByID(id);
    }

    /**
     * 根据名字模糊查询歌曲
     *
     * @param name
     */
    @Override
    public List<Song> selectSongByName(String name) {
        return songMapper.selectSongByName("%"+name+"%");
    }
}
