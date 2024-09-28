package org.fastcompus.post.domain.content;

import org.fastcompus.post.domain.common.DateTimeInfo;

public abstract class Content {
    String contentText;
    final DateTimeInfo dateTimeInfo;// 이렇게 참조타입에 final이 붙게 되면
    // 필드 자체에 값 변경을 막는 것이 아니라 다른 DateTimeInfo로 대체되는 것을 막을 수 있다.

    protected Content(String contentText) {
        checkText(contentText);
        this.contentText = contentText;
        this.dateTimeInfo = new DateTimeInfo();
    }

    public void updateContent(String updateContent){
        checkText(updateContent); // 글자수 유효성 검사
        this.contentText = updateContent;
        this.dateTimeInfo.updateEditDatetime();
    }

    protected abstract void checkText(String contentText);

    public String getContentText() {
        return contentText;
    }
}
