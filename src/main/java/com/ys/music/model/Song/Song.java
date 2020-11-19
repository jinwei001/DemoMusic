package com.ys.music.model.Song;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Song {
    @ApiModelProperty(value = "id")
    private Integer id;
    @ApiModelProperty(value = "歌手id")
    private Integer singerID;
    @ApiModelProperty(value = "歌曲名")
    private String name;
    @ApiModelProperty(value = "歌曲简介")
    private String introduction;
    @ApiModelProperty(value = "歌曲创建时间")
    private Date createTime;
    @ApiModelProperty(value = "歌曲更新时间")
    private Date updateTime;
    @ApiModelProperty(value = "歌曲图片")
    private String pic;
    @ApiModelProperty(value = "歌词")
    private String lyric;
    @ApiModelProperty(value = "地址")
    private String url;
}
