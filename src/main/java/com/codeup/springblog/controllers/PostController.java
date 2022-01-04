package com.codeup.springblog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class PostController {

    @RequestMapping(path = "/posts/create", method = RequestMethod.GET)
    @ResponseBody
    public String createPost(){
        return "View the form for creating a post!";
    }

    @RequestMapping(path = "/posts/create", method = RequestMethod.POST)
    @ResponseBody
    public String addPost(){
        return "Create a new post!";
    }

    @GetMapping("/posts/show")
    public String showSinglePost(Model singlePost){
        Post showSingle = new Post("This is the title", "This is the body for the single post.");
        singlePost.addAttribute("post", showSingle);
        return "/posts/show";
    }

    @GetMapping("/posts")
    public String showAllPosts(Model viewAll){
        Post newPost1 = new Post("First title", "body for first title");
        Post newPost2 = new Post("Second title", "body for second title");
        ArrayList<Post> allPosts = new ArrayList<>();
        allPosts.add(newPost1);
        allPosts.add(newPost2);
        viewAll.addAttribute("posts", allPosts);
        return "posts/index";
    }
}
