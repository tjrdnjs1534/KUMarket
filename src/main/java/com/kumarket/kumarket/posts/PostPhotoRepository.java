package com.kumarket.kumarket.posts;

import com.kumarket.kumarket.posts.entities.PostPhotoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostPhotoRepository extends JpaRepository<PostPhotoEntity, Long> {
}
