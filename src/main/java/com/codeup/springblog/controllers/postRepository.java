package com.codeup.springblog.controllers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface postRepository extends JpaRepository<Post, String>{

    Object findAllBy();

//    Object saveAll();
//
//    Object delete();
}
