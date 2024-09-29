package org.fastcompus.user.application.interfaces;

import java.util.Optional;
import org.fastcompus.user.domain.User;

public interface UserRepository {
    User save(User user);
    Optional<User> findById(Long id);
}
/**
 * follow기능을 담당하는 Repository와 UserRepsitory를 나누는 것은 어떤 장단점이 있을까?
 * 장점
 * 1. 각자 관리할 수 있어서 안정성에 도움이 되다.
 * 2. follow 기능을 수정하는데 문제가 생겨 User 기능까지 동작하면 안되기 때문에 기능별 나누는 것이 좋아보임
 * 3. follow 기능에 변경이 있을 경우 해당 코드마 변경하기 때문에 안전성이 높아진다?
 *
 * 강사님 생각
 * 나중에 follow 관련 데이터만 다른 DB로 움긴다고 생각하면 UserRepository를 건드려야하기 때문에
 * 자연스럽게 인터페이스가 불리되어 버린다.
 * 테스트를 만드는데도 용의할 것으로 판단함.
 */
