```java
// 참조변수의 다형성 예시

class Friend {
    public void friendInfo() {
        System.out.println("나는 당신의 친구입니다.");
    }
}

class BoyFriend extends Friend {

    public void friendInfo() {
        System.out.println("나는 당신의 남자친구입니다.");
    }
}

class GirlFriend extends Friend {

    public void friendInfo() {
        System.out.println("나는 당신의 여자친구입니다.");
    }
}

public class FriendTest {

    public static void main(String[] args) {
        Friend friend = new Friend(); // 객체 타입과 참조변수 타입의 일치
        BoyFriend boyfriend = new BoyFriend();
        Friend girlfriend = new GirlFriend(); // 객체 타입과 참조변수 타입의 불일치
        // 상위 클래스를 참조변수의 타입으로 지정했기 때문에 자연스럽게 참조변수가 사용할 수 있는 멤버의 개수는 상위 클래스의 멤버의 수가 됩니다.

        friend.friendInfo();
        boyfriend.friendInfo();
        girlfriend.friendInfo();
    }
}

// 출력값
나는 당신의 친구입니다.
나는 당신의 남자친구입니다.
나는 당신의 여자친구입니다.

```