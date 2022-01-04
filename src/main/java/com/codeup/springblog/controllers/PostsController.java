package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PostsController {

    private final PostRepository postDao;

    public PostsController(PostRepository postDao){
        this.postDao = postDao;
    }

    @PostMapping("/posts")
    public String postsIndex(Model model){
        model.addAttribute("save", postDao.save());
        model.addAttribute("delete", postDao.delete());

        return "posts";

    }
}
