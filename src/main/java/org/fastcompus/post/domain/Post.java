package org.fastcompus.post.domain;

import org.fastcompus.user.domain.User;

public class Post {
    private final Long id;
    private final User author;
    private final PostContent content;

    public Post(Long id, User author, PostContent content) {
        if (author == null) {
            throw new IllegalArgumentException("Author cannot be null");
        }
        this.id = id;
        this.author = author;
        this.content = content;
    }
}

/**
 * 코드 리뷰
 * 1. author의 아이디를 가져가는 경우 || 2. User 객체로 author를 가져가는 경우.
 * 1번의 경우 id를 가져가는 경우 사용할 수 있는 범위가 늘어날 것 같다. 그리고 이름이 직접적으로 노출되지 않기 때문에 보안성 향상도 가능할 것으로 보임.
 * 하지만 게시글에 작성자를 표시하게 될 경우 repository를 통해 name을 가져와야하는 번거로움이 있을 것 같음.
 *
 * 반면 2번으로 진행할 경우
 * 앞서 말한 것 처럼 게시글의 이름을 직접 작성할 때 transaction이 덜 들어가기 때문에 효율의 향상이 가능
 * 하지만 이름이 직접적으로 노출되어 보안 취약점이 발생할 수 있을 것 같다.
 *
 * 강사님 생각
 * User객체 전체를 참조하고 있다면 객체 자체 메소드가 생겼을 때 사용하기 편하고 객체를 참조하고 있다는 가독성이 좋다.
 * 단점
 * test 세팅할 때 번거로움이 있을 수 있음-> 객체를 넣을 경우 객체 생성을 해야하함.
 * 2.
 * Long이나 int를 받는다면 테스트 코드를 넣기가 쉬워짐.
 * 하지만 객체지향과 거리가 멀어짐
 *
 */

