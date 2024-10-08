package org.fastcampus.user.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.fastcompus.user.domain.User;
import org.fastcompus.user.domain.UserInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserTest {
    private final UserInfo userInfo = new UserInfo("test1", "test@test.com");
    private User user1;
    private User user2;

    @BeforeEach
    void init() {
        user1 = new User(1L, userInfo);
        user2 = new User(2L, userInfo);
    }

    @Test
    public void givenTwoUser_whenEqual_thenReturnFalse() throws Exception {
        // when
        boolean result = user1.equals(user2);
        // then
        assertFalse(result);
    }
    @Test
    public void givenSameTwoUser_whenEqual_thenReturnTrue() throws Exception {

        // given
        User sameUser = new User(1L, userInfo);
        // when
        boolean result = user1.equals(sameUser);
        // then
        assertTrue(result);
    }
    
    // 현재 equals과 hashcode가 재정의 되어 있음으로 둘을 검증하여 일관성을 입증하라.
    @Test
    public void givenTwoUser_whenHashCode_thenReturnFalse() throws Exception {
        // given

        // when
        int hashCode = user1.hashCode();
        int hashCode2 = user2.hashCode();
        // then
        assertNotEquals(hashCode, hashCode2);
    }
    @Test
    public void givenwoSameIdUser_whenHashCode_thenEqual() throws Exception {
        // given
        User sameUser = new User(1L, userInfo);
        // when
        int hashCode1 = user1.hashCode();
        int sameUserHashCode = sameUser.hashCode();
        // then
        assertEquals(hashCode1, sameUserHashCode);
    }
    @Test
    public void givenTwoUser_whenUser1FollowUser2_thenIncreaseUserCount() throws Exception {
        // when
        user1.follow(user2);
        // then
        assertEquals(1, user1.followingCount());
        assertEquals(0, user1.followerCount());
        assertEquals(0, user2.followingCount());
        assertEquals(1, user2.followerCount());
    }
    @Test
    public void givenTwoUserUser1FollowUser2_whenUnfollow_thenDecreaseUserCount() throws Exception {
        // given
        user1.follow(user2);
        // when
        user1.unfollow(user2);
        // then
        assertEquals(0, user1.followingCount());
        assertEquals(0, user1.followerCount());
        assertEquals(0, user2.followingCount());
        assertEquals(0, user2.followerCount());
    }

    @Test
    void givenTwoUser_whenUnfollow_thenNotDecreaseUserCount() {
        // when
        user1.unfollow(user2);
        // then
        assertEquals(0, user1.followingCount());
        assertEquals(0, user1.followerCount());
        assertEquals(0, user2.followingCount());
        assertEquals(0, user2.followerCount());
    }
}
