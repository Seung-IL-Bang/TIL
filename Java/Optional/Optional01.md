# Optional\<T> 01

### Optional\<T> 이란 무엇인가?

> Optional\<T>
> 
> 'T 타입의 객체'를 감싸는 래퍼 클래스이다. 그래서 Optional 타입의 객체에는 모든 타입의 객체를 담을 수 있다.

<br>

```java
public final class Optional<T> {
    private final T value; // T 타입의 참조변수
    ...
}
```

<br>

**💡 Optional<T>를 사용 시 장점**

최종 연산의 결과를 그냥 반환하는게 아니라 `Optional` 객체에 담아서 반환을 하면 장점이 존재한다.

- 반환된 결과가 null 인지 매번 if 문으로 체크하는 대신 Optional에 정의된 메서드를 통해서 간단히 처리 가능하다.
- null 체크를 위한 if문 없이도 NullPointerException이 발생하지 않는 보다 간결하고 안전한 코드를 작성하는 것이 가능하다.

<br>

[▶︎ Next] [02_Optional<T> 객체 생성하기](Optional02.md)