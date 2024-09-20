package org.fastcompus.user.domain;

import java.util.Objects;

public class User {
    private final Long id;
    private final UserInfo info;  // VO
    private final UserRelationCounter followingCount; // VO -> 내가 팔로우하고 있는 수
    private final UserRelationCounter followerCount;  // VO -> 남이 나를 팔로우하고 있는 수

    public User(Long id, UserInfo userInfo, UserRelationCounter followingCount,
        UserRelationCounter followerCount) {
        this.id = id;
        this.info = userInfo;
        this.followingCount = followingCount;
        this.followerCount = followerCount;
    }
    // 내가 -> 상대
    public void follow(User targetUser){
        if (this.equals(targetUser)) { // 객체랑 목표상대랑 같은지?
            throw new IllegalArgumentException("Cannot follow self");
        }
        followingCount.increase();
        targetUser.increaseFollowerCount();
    }
    // 상대
    public void unfollow(User targetUser){
        // 선행조건인 팔로우는 스스로 할 수 없기 때문에 필요 없음.
        if (this.equals(targetUser)){
            throw new IllegalArgumentException("Cannot unfollow self");
        }
        followingCount.decrease();
        targetUser.decreaseFollowerCount(); // 객체지향 생활체조에서 보면 .이 너무 많으면 캡슐화가 깨짐
    }
    // .을 줄이기 위한 메소드
    private void increaseFollowerCount(){
        followerCount.increase();
    }
    private void decreaseFollowerCount(){
        followerCount.decrease();
    }



    // 객체의 == 비교를 할 경우 주소값으로 비교를 하게 된다. 그러니 값이 같던 다르던 주소값이 다르기 때문에
    // 무조건 false가 나올 수 밖에 없다. 그러니 equal, hashcode를 override해서 사용한다.
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public Long getId() {
        return id;
    }
}
