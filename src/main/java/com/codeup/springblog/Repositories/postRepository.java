package com.codeup.springblog.Repositories;
import com.codeup.springblog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface postRepository extends JpaRepository<Post, Long>{

}
