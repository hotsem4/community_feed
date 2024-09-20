package org.fastcompus.post.domain;

public class PostContent {
    private final String content;

    public PostContent(String content){
        if (content == null || content.length() < 5 || content.length() > 100) {
            throw new IllegalArgumentException("Content length must be between 5 and 100 characters");
        }
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
