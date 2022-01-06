package com.codeup.springblog.controllers.Repositories;
import com.codeup.springblog.controllers.Class.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface postRepository extends JpaRepository<Post, Long>{

     Post findAllById(long id);
}
