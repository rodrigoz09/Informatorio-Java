package com.informatorio.blog_info.repository;


import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.informatorio.blog_info.entity.Comment;
import com.informatorio.blog_info.entity.Post;


@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

	List<Post> findPostByPublished(Boolean published);
	
	List<Post> findByTitleLike(String title);
	
	List<Comment> findById(Long limit, Long id, Pageable pageable);
}