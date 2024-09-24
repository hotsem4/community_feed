package org.fastcompus.post.domain.content;

public class CommentContent extends Content{
    private final int MAX_COMMENT_LENGTH =100;

    public CommentContent(String content){
        super(content);
    }

    @Override
    protected void checkText(String contentText) {
        if (contentText == null || contentText.trim().isEmpty()) {
            throw new IllegalArgumentException("Comment content must not be null or empty");
        }
        if (contentText.length() > MAX_COMMENT_LENGTH) {
            throw new IllegalArgumentException("Comment content too long");
        }
    }
}
