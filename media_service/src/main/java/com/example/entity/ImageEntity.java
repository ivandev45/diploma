package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by ivan on 09.06.18.
 */
@Entity(name = "image")
public class ImageEntity {

    @Id
    @Column(name = "image_id")
    private String imageId;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "image_file_name")
    private String imageFileName;

    public ImageEntity(String imageId, String userId, String imageFileName) {
        this.imageId = imageId;
        this.userId = userId;
        this.imageFileName = imageFileName;
    }

    public ImageEntity() {
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }

    @Override
    public String toString() {
        return "ImageEntity{" +
                "imageId='" + imageId + '\'' +
                ", userId='" + userId + '\'' +
                ", imageFileName='" + imageFileName + '\'' +
                '}';
    }
}
