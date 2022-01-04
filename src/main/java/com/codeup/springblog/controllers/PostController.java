package com.codeup.springblog.controllers;


import org.springframework.stereotype.Controller;
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
    public String showPosts(){
        return "/posts/show";
    }

    @GetMapping("/posts/index")
    public String showAllPosts(){
        return "/posts/index";
    }
}
