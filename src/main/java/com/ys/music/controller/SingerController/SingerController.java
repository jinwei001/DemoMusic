package com.ys.music.controller.SingerController;

import com.ys.music.common.ResponseBean;
import com.ys.music.model.Singer.Singer;
import com.ys.music.service.SingerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/Singer")
@CrossOrigin
@Api(value = "歌手", tags = {"歌手"})
public class SingerController {
    @Autowired
    private SingerService singerService;
    int code = 200;

    @PostMapping("add")
    @ApiOperation(value = "新增歌手", notes = "新增歌手 HttpServletRequest request ")
    public ResponseBean addSinger(@RequestBody Singer singer) {
//        JSONObject jsonObject = new JSONObject();
//        String name = request.getParameter("name").trim();
//        String sex = request.getParameter("sex").trim();
//        String pic = request.getParameter("pic").trim();
//        String birth = request.getParameter("birth").trim();
//        String location = request.getParameter("location").trim();
//        String introduction = request.getParameter("introduction").trim();
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Date birthDate = new Date();
//        try {
//            birthDate = dateFormat.parse(birth);
//        }catch (ParseException e){
//            e.printStackTrace();
//        }
//        Singer singer = new Singer();
//        singer.setName(name);
//        singer.setSex(new Byte(sex));
//        singer.setLocation(location);
//        singer.setBirth(birthDate);
//        singer.setPic(pic);
//        singer.setIntroduction(introduction);

        boolean b = singerService.addSinger(singer);
        return ResponseBean.ofSuccess(code, b);
    }

    @PutMapping(value = "updateSinger")
    @ApiOperation(value = "更新歌手", notes = "更新歌手")
    public ResponseBean updateSinger(@RequestBody Singer singer) {
        boolean b = singerService.updateSinger(singer);
        return ResponseBean.ofSuccess(code, b);
    }

    @DeleteMapping(value = "deleteSinger")
    @ApiOperation(value = "删除歌手", notes = "删除歌手")
    public ResponseBean deleteSinger(Integer id) {
        boolean b = singerService.delSinger(id);
        return ResponseBean.ofSuccess(code, b);
    }

    @GetMapping(value = {"/selectById/{id}"})
    @ApiOperation(value = "获取id歌手", notes = "获取id歌手")
    public ResponseBean SingerSelectById(@PathVariable(value = "id", required = false) Integer id) {
        Singer singer = singerService.selectSingerByID(id);
        return ResponseBean.ofSuccess(code, singer);
    }

    @GetMapping(value = {"/selectByName"})
    @ApiOperation(value = "获取模糊查询", notes = "获取name歌手")
    public ResponseBean SingerSelectByName(String name) {
        List<Singer> singers;
        if (name == null) {
            singers = singerService.allSinger();
        } else {
            singers = singerService.selectSingerByName("%" + name + "%");
        }
        return ResponseBean.ofSuccess(code, singers);
    }

    @GetMapping(value = {"/select"})
    @ApiOperation(value = "获取歌手", notes = "获取歌手")
    public ResponseBean SingerSelect() {
        List<Singer> singers = singerService.allSinger();
        return ResponseBean.ofSuccess(code, singers);
    }
}
