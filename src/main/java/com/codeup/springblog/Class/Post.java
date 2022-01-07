package com.codeup.springblog.Class;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post {

    @Column(nullable = false, length = 10000)
    private String body;

    @Column(nullable = false, length = 50)
    private String title;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Post() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post(String body){
        this.body = body;
    }

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public Post(String body, String title, long id) {
        this.body = body;
        this.title = title;
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
