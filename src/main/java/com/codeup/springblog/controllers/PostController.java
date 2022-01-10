package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.User;
import com.codeup.springblog.services.EmailService;
import com.codeup.springblog.Repositories.UserRepository;
import com.codeup.springblog.Repositories.postRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private final postRepository postDao;
    private final UserRepository userDao;
    private final EmailService emailService;

    public PostController(postRepository postDao, UserRepository userDao, EmailService emailService) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailService = emailService;
    }

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

    @GetMapping("/posts/create")
    public String ViewCreatePost(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post) {

        User postCreator = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        post.setUser(postCreator);

        emailService.prepareAndSend(post, "Your post has been created", "Congratulations on creating your post!");

        postDao.save(post);

        return "redirect:/posts";
    }

    @GetMapping("/posts/show")
    public String userPost(Model model, @PathVariable Long postId){
        Post userPost = postDao.getById(postId);
        model.addAttribute("post", userPost);
        model.addAttribute("user", userPost.getUser());
        return "posts/show";
    }
}
