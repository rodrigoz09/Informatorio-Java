package com.informatorio.blog_info.repository;





import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.informatorio.blog_info.entity.Comment;






@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
