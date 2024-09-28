package org.fastcompus.post.domain.comment;

import org.fastcompus.common.domain.PositiveIntegerCounter;
import org.fastcompus.post.domain.Post;
import org.fastcompus.post.domain.content.Content;
import org.fastcompus.user.domain.User;
// 이게 뭐하는 객체고?
public class Comment {
    private final Long id;
    private final Post post;
    private final User author;
    private final Content content;
    private final PositiveIntegerCounter likeCount;

    public Comment(Long id, Post post, User author, Content content) {
        if (author == null) {
            throw new IllegalArgumentException("Author cannot be null");
        }
        if (content == null) {
            throw new IllegalArgumentException("Content cannot be null");
        }
        if (post == null){
            throw new IllegalArgumentException("Post cannot be null");
        }
        this.id = id;
        this.post = post;
        this.author = author;
        this.content = content;
        this.likeCount = new PositiveIntegerCounter();
    }

    // 댓글 좋아요 기능 추가
    public void commentLike(User user){
        if (this.author.equals(user)){
            throw new IllegalArgumentException("Cannot like a comment");
        }
        likeCount.increase();
    }
    public void commentUnlike(){
        // 좋아요가 눌러있는지 상태에 대한 값은 어디서 저장함?
        likeCount.decrease();
    }

    public void updateComment(User user, String updateComment){
        if (!this.author.equals(user)){
            throw new IllegalArgumentException("Cannot update a comment");
        }
        this.content.updateContent(updateComment);
    }
}
