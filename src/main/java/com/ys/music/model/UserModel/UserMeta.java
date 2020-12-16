package com.ys.music.model.UserModel;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserMeta {
    @ApiModelProperty(value = "title")
    private String title;
    @ApiModelProperty(value = "icon")
    private String icon;
}
