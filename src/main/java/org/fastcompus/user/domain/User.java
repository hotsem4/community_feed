package org.fastcompus.user.domain;

import java.util.Objects;

public class User {
    private final Long id;
    private final UserInfo info;

    public User(Long id, UserInfo userInfo) {
        this.id = id;
        this.info = userInfo;
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
}
