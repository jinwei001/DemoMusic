package com.ys.music.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileuploadService {
    public Object upload(MultipartFile file);
}
