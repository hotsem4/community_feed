package org.fastcampus.user.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.fastcompus.user.domain.UserInfo;
import org.junit.jupiter.api.Test;

public class UserInfoTest {

    @Test
    void givenNameAndProfileImage_whenCreated_thenThrowNothing() throws Exception {
        // given
        String name = "test";
        String profileImage = "testURL";
        // when
        // then
        assertDoesNotThrow(()->new UserInfo(name, profileImage));
    }

    @Test
    void givenNameNullAndProfileImage_whenCreated_thenThrowNothing() throws Exception {
        // given
        String name = null;
        String profileImage = "testUrl";
        // when
        // then
        assertThrows(IllegalArgumentException.class, ()->new UserInfo(name, profileImage));
    }
}
