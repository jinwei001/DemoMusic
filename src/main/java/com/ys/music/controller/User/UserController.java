package com.ys.music.controller.User;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "歌曲", tags = "歌曲")
@RestController
@CrossOrigin
@RequestMapping(value = "song")
public class UserController {
}
