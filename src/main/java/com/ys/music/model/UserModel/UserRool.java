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
public class UserRool {
    @ApiModelProperty(value = "id")
    private String id;
    @ApiModelProperty(value = "name")
    private String name;
    @ApiModelProperty(value = "path")
    private String path;
    @ApiModelProperty(value = "hidden")
    private boolean hidden;
    @ApiModelProperty(value = "redirect")
    private String redirect;
    @ApiModelProperty(value = "component")
    private String component;
    @ApiModelProperty(value = "alwaysShow")
    private boolean alwaysShow;
    @ApiModelProperty(value = "meta")
    private UserMeta meta;
}
