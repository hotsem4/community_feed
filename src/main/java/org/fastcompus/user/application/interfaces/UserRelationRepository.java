package org.fastcompus.user.application.interfaces;

import org.fastcompus.user.domain.User;

public interface UserRelationRepository {
    /**
     * 어떤 메소드가 필요?
     * 유저의 존재 유무 파악
     * 유저들이 이미 팔로우 관계인지 파악
     */
    // 왜 id가 아닌 user 객체를 직접 넘겼을까?
    // id를 넘길 경우 의존해야할 Repository가 늘어나기 때문이다.
    // 객체 간에는 응집도는 높이고 결합도는 낮추려는 방법?

    // 변경이 있는 도메인 객체를 넘기는 것을 선호한다.
    // 유저의 Count도 같이 업데이트 되어야 하기 때문이다.
    // 이렇게 할 경우 User만 변경하면 interface에는 별 다른 변화가 없을 것이다.
    boolean isAlreadyFollow(User user, User targetUser);
    void save(User user, User targetUser);
    void delete(User user, User targetUser);

}
