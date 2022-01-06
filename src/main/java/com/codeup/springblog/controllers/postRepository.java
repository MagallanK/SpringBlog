package com.codeup.springblog.controllers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface postRepository extends JpaRepository<Post, Long>{

     Post findAllById(long id);
}
