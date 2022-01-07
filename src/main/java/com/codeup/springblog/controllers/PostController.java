package com.codeup.springblog.controllers;


import com.codeup.springblog.Class.Post;
import com.codeup.springblog.Repositories.UserRepository;
import com.codeup.springblog.Repositories.postRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class PostController {

    //    JPA exercise
    private final postRepository postDao;
    private final UserRepository userDao;

    public PostController(postRepository postDao, UserRepository userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
    }

//        @GetMapping("/posts")
//        public String postsIndex(){
//            return "posts";
//        }

//        @PostMapping("/posts")
//        public String postsIndex(Model model){
//            model.addAttribute("posts", postDao.findAllById());
////            model.addAttribute("update", postDao.saveAll());
////            model.addAttribute("delete", postDao.delete());
//            return "posts";
//        }
//JPA exercise end

//    JPA exercise review

    @GetMapping("/posts")
    public String indexPosts(Model model) {
        model.addAttribute("allPosts", postDao.findAll());
        return "posts/index";
    }

    @PostMapping("/posts/delete/{id}")
    public String deletePost(@PathVariable Long id) {

        long deletePostId = id;

        postDao.deleteById(deletePostId);

        return "redirect:/posts/index";
    }

    @GetMapping("/posts/edit/{id}")
    public String editPost(@PathVariable Long id, Model model) {
        Post editPost = postDao.getById(id);

        model.addAttribute("postToEdit", editPost);
        return "/posts/index";
    }

    @PostMapping("/posts/edit")
    public String savePost(@RequestParam(name = "postTitle") String postTitle, @RequestParam(name = "postBody") String postBody, @RequestParam(name = "postId") Long id) {

        Post postToEdit = postDao.getById(id);
        postToEdit.setBody(postBody);
        postToEdit.setTitle(postTitle);

        postDao.save(postToEdit);

        return "redirect:/posts/index";
    }

// JPA exercise review end

//    @RequestMapping(path = "/posts/create", method = RequestMethod.GET)
//    @ResponseBody
//    public String createPost() {
//        return "View the form for creating a post!";
//    }
//
//    @RequestMapping(path = "/posts/create", method = RequestMethod.POST)
//    @ResponseBody
//    public String addPost() {
//        return "Create a new post!";
//    }


    //    Views exercise
//    @GetMapping("/posts/show")
//    public String showSinglePost(Model singlePost) {
//        Post showSingle = new Post("This is the title", "This is the body for the single post.");
//        singlePost.addAttribute("post", showSingle);
//        return "/posts/show";
//    }

//    @GetMapping("/posts")
//    public String showAllPosts(Model viewAll) {
//        Post newPost1 = new Post("First title", "body for first title");
//        Post newPost2 = new Post("Second title", "body for second title");
//        ArrayList<Post> allPosts = new ArrayList<>();
//        allPosts.add(newPost1);
//        allPosts.add(newPost2);
//        viewAll.addAttribute("posts", allPosts);
//        return "posts/index";
//    }
//    Views exercise end


//    Relationships Exercise
    @GetMapping("/posts/show")
    public String userPost(Model model, @PathVariable Long postId){
        Post userPost = postDao.getById(postId);
        model.addAttribute("post", userPost);
        model.addAttribute("user", userPost.getUser());
        return "posts/show";
    }
}
