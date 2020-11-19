package com.ys.music.service;

import com.ys.music.model.Song.Song;
import com.ys.music.model.Song.Song;

import java.util.List;

public interface SongService {
    /**
     * 新增歌曲
     * @param song
     */
    public boolean addSong(Song song);
    /**
     * 修改歌曲信息
     */
    public boolean updateSong(Song song);

    /**
     * 删除歌曲信息
     */
    public boolean delSong(Integer id);

    /**
     * 查询所有歌曲信息
     */
    public List<Song> allSong();

    /**
     * 根据id查询
     */
    public Song selectSongByID(Integer id);

    /**
     * 根据名字模糊查询歌曲
     */
    public List<Song> selectSongByName(String name);

}
