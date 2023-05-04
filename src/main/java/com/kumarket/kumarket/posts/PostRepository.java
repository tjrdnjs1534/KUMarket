package com.kumarket.kumarket.posts;

import com.kumarket.kumarket.posts.entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostEntity, Long> {
}
