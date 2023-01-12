package com.vad.ltale.entity;

import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;

public class ImageRequest extends FileRequest {
    private int isIcon;

    public int getIsIcon() {
        return isIcon;
    }

    public void setIsIcon(int isIcon) {
        this.isIcon = isIcon;
    }

    public ImageRequest(MultipartFile file, Date dateCreated, Date dateChanged, int isIcon) {
        super(file, dateCreated, dateChanged);
        this.isIcon = isIcon;
    }
}
