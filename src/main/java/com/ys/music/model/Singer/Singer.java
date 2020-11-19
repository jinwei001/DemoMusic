package com.ys.music.model.Singer;

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
public class Singer {
    @ApiModelProperty(value = "主键id")
    private Integer id;
    @ApiModelProperty(value = "歌手名")
    private String name;
    @ApiModelProperty(value = "性别")
    private Byte sex;
    @ApiModelProperty(value = "歌手照片")
    private String pic;
    @ApiModelProperty(value = "歌手生日")
    private Date birth;
    @ApiModelProperty(value = "地址")
    private String location;
    @ApiModelProperty(value = "歌手简介")
    private String introduction;
}
