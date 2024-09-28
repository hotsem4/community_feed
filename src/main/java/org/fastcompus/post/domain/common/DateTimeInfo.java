package org.fastcompus.post.domain.common;

import java.time.LocalDateTime;

public class DateTimeInfo {
    private boolean isEdited; // 수정 여부 확인 필드
    private LocalDateTime dateTime;

    public DateTimeInfo() {
        this.isEdited = false;
        this.dateTime = LocalDateTime.now();
    }

    public void updateEditDatetime(){
        this.isEdited = true;
        this.dateTime = LocalDateTime.now();
    }

    public boolean isEdited() {
        return isEdited;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
