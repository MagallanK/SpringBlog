package com.codeup.springblog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    @RequestMapping(path = "/posts", method = RequestMethod.GET)
    @ResponseBody
    public String mainPage(){
        return "This is the index page";
    }

    @RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String userPage(@PathVariable int id){
        return "This is user " + id + "'s profile page";
    }

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

    @GetMapping("/posts/index")
    public String showAllPosts(){
        return "Placeholder: Index for posts";
    }
}
