package com.board.bulldogs.model;

import java.util.List;

public class Dog {
    private Long id;
    private String name;
    private String bio;
    private List<String> imagePaths;

    public Dog(Long id, String name, String bio, List<String> imagePaths) {
        this.id = id;
        this.name = name;
        this.bio = bio;
        this.imagePaths = imagePaths;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBio() {
        return bio;
    }

    public List<String> getImagePaths() {
        return imagePaths;
    }
}
