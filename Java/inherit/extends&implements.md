# extends와 implements 차이점

### `extends`
Java에서 `extends`와 `implements`는 모두 클래스 간의 상속 관계를 정의하는 데 사용된다.

`extends`는 클래스가 다른 클래스를 상속받을 때 사용된다. 상속을 받은 클래스는 상위 클래스의 모든 멤버를 포함하여 사용할 수 있다. <u>**상속을 받은 클래스는 하나의 클래스만 상속받을 수 있다.**</u>

```java
public class Animal {
    public void move() {
        System.out.println("The animal moves.");
    }
}

public class Dog extends Animal {
    public void bark() {
        System.out.println("The dog barks.");
    }
}
```
위 코드에서 `Dog` 클래스는 `Animal` 클래스를 상속받아 `move()` 메소드를 사용할 수 있다.

<br>

### `implements`

반면에 implements는 인터페이스를 구현할 때 사용된다. 인터페이스는 클래스에서 구현해야 할 메소드의 시그니처를 정의하는데 사용된다. 클래스에서 인터페이스를 구현할 때는 인터페이스에서 정의한 모든 메소드를 구현해야 한다.

예를 들어, 다음과 같이 `Runnable` 인터페이스를 구현하는 `MyThread` 클래스를 정의할 수 있다.

```Java
public class MyThread implements Runnable {
    public void run() {
        System.out.println("The thread is running.");
    }
}
```

위 코드에서 `MyThread` 클래스는 `Runnable` 인터페이스를 구현하여 `run()` 메소드를 구현한다.

<br>

<aside style="display: flex; border-radius: 3px; color: rgb(55,53,47); background: rgb(241, 241, 239); padding: 16px 16px 16px 12px;">
💡 따라서 extends는 클래스 간의 상속 관계를 정의하는 데 사용되고, implements는 클래스에서 구현해야 할 인터페이스를 정의하는 데 사용된다.

</aside>
