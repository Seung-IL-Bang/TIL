# Optional\<T> 02

### Optional\<T> 객체 생성하기

<br>

Optional 객체를 생성할 때는 `of()` 또는 `ofNullable()`을 사용한다.

```java
String str = "abc";
Optional<String> optVal = Optional.of(str);
Optional<String> optVal = Optional.of("abc");
Optional<String> optVal = Optional.of(new String("abc"));
```

❗️ 만약 참조변수의 값이 null일 가능성이 있다면, `of()`대신 `ofNullable()`을 사용해야한다. `of()`는 매개변수의 값이 null이면 `NullPointerException`이 발생하기 때문이다.

<br>

```java
Optional<String> optVal = Optional.of(null); // NullPointerException
Optional<String> optVal = Optional.ofNullable(null) // ok
```

<br>

Optionl\<T> 타입의 참조변수를 기본값으로 초기화할 때는 `empty()`를 사용한다. null로 초기화하는 것이 가능하지만, `empty()`로 초기화 하는 것이 바람직하다.

```java
Optional<String> optVal = null; // null 로 초기화. 바람직하지 않음
Optional<String> optVal = Optional.<String>empty(); // 빈 객체로 초기화
```

💡 empty()는 제네릭 메서드라서 앞에\<T>를 붙였다. 타입 추론이 가능하므로 생략할 수 있다.

<br>

✅ CheckPoint

- [x] `of()` 
- [x]  `ofNullable()`
- [x]  `empty()`

<br>

[01_Optional\<T>의 이해](Optional01.md) [Prev ◀︎] [▶︎ Next] [03_Optional\<T> 메서드](Optional03.md)