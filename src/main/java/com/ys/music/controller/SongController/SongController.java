package com.ys.music.controller.SongController;

import com.ys.music.common.ResponseBean;
import com.ys.music.model.Singer.Singer;
import com.ys.music.model.Song.Song;
import com.ys.music.service.SongService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(value = "歌曲", tags = "歌曲")
@RestController
@CrossOrigin
@RequestMapping(value = "song")
public class SongController {
    @Autowired
    private SongService songService;
    int code = 200;
    /***
     * 练习从配置文件中ftp的属性值
     */
    @Value("${ftp.show}")
    private String ftpshow;
    @Value("${ftp.unit}")
    private String ftpunit;

    @ApiOperation(value = "新增", notes = "新增")
    @PostMapping("/add")
    public ResponseBean addSong(@RequestBody Song song) {
        System.out.println(song);
        boolean b = songService.addSong(song);
        return ResponseBean.ofSuccess(code, b);
    }

    @ApiOperation(value = "修改", notes = "修改")
    @PutMapping("/update")
    public ResponseBean updateSong(@RequestBody Song song) {
        System.out.println(song);
        boolean b = songService.updateSong(song);
        return ResponseBean.ofSuccess(code, b);
    }

    @ApiOperation(value = "删除", notes = "删除")
    @DeleteMapping("/delSong")
    public ResponseBean delSong(Integer id) {
        System.out.println(id);
        boolean b = songService.delSong(id);
        return ResponseBean.ofSuccess(code, b);
    }

    @GetMapping(value = {"/select"})
    @ApiOperation(value = "获取", notes = "获取")
    public ResponseBean SingerSelect() {
        List<Song> songs = songService.allSong();
        System.out.println("ftp.show ====>"+ftpshow);
        System.out.println("ftp.unit ====>"+ftpunit);
        return ResponseBean.ofSuccess(code, songs);
    }
    @GetMapping(value = {"/SingerSelectByName"})
    @ApiOperation(value = "获取Name", notes = "获取Name")
    public ResponseBean SingerSelectByName(String name) {
        List<Song> songs = songService.selectSongByName(name);
        return ResponseBean.ofSuccess(code, songs);
    }
}
