package com.example.repository;

import com.example.entity.ImageEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by ivan on 09.06.18.
 */
public interface MediaRepository extends CrudRepository<ImageEntity, String> {
    ImageEntity findImageEntityByUserIdAndImageFileName(String userId, String imageFileName);
}
