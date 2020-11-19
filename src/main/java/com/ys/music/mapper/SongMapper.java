package com.ys.music.mapper;


import com.ys.music.model.Song.Song;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 歌曲Mapper
 */
@Mapper
public interface SongMapper {
    /**
     * 新增歌曲
     */
    public int addSong(Song song);

    /**
     * 修改歌曲信息
     */
    public int updateSinger(Song song);

    /**
     * 删除歌曲信息
     */
    public int delSong(Integer id);

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
    /**
     * 根据歌手id查询歌曲
     */
    public List<Song> selectSongBySingerID(Integer id);
}
