package com.informatorio.blog_info.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.informatorio.blog_info.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}