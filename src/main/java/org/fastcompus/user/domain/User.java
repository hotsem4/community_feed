package org.fastcompus.user.domain;

import java.util.Objects;
import org.fastcompus.common.domain.PositiveIntegerCounter;

public class User {
    private final Long id;
    private final UserInfo info;  // VO
    private final PositiveIntegerCounter followingCount; // VO -> 내가 팔로우하고 있는 수
    private final PositiveIntegerCounter followerCount;  // VO -> 남이 나를 팔로우하고 있는 수

    public User(Long id, UserInfo userInfo) {
        if (userInfo == null){
            throw new IllegalArgumentException("userInfo is null");
        }
        this.id = id;
        this.info = userInfo;
        // 이렇게 할 경우 User를 만들 때 항상 0인 값을 불필요하게 User 객체에서 생성하고 넣어야한다.
        // 하지만 followingCount와 followerCount는 생성시 항상 0이여야하기 때문에 생성자에서 관리하는 것이 올바르다.
//        this.followingCount = followingCount;
//        this.followerCount = followerCount;
        this.followingCount = new PositiveIntegerCounter();
        this.followerCount = new PositiveIntegerCounter();

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

    public int followerCount() {
        return followerCount.getCount();
    }
    public int followingCount() {
        return followingCount.getCount();
    }
}
