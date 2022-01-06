package com.codeup.springblog.Repositories;
import com.codeup.springblog.Class.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface postRepository extends JpaRepository<Post, Long>{

     Post findAllById(long id);
}
