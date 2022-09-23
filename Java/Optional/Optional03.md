# Optional\<T> 03

### Optional\<T> 메서드

<br>

1. 조회 메서드

- `get()`
- `orElse()`
- `orElseGet()`
- `orElseThrow()`

2. 판별 메서드

- `isPresent()`
- `ifPresent()`

---

<br>

📌 `get()` & `orElse()`

```java
Optional<String> optVal = Optional.of("abc");
String str1 = optVal.get(); // optVal에 저장된 값을 반환. null이면 예외발생
String str2 = optVal.orElse(""); // optVal에 저장된 값이 null일 때는, ""를 반환
```

기본적으로 Optional 객체에 저장된 값을 가져올 때는 `get()`을 사용한다. 하지만 값이 null일 때는 <u>NoSuchElementException</u>이 발생하며, 이를 대비해서 `orElse()`로 대체할 값을 지정할 수 있다.

<br>

📌 `orElseGet()` & `orElseThrow()`

```java
// 선언 부분
T orElseGet(Supplier<? extends T> other)
T orElseThrow(Supplier<? extends X> exceptionSupplier)

// 사용 예시
String str = optVal.orElseGet(String::new); // () -> new String() 와 동일
String str = optal.orElseThrow(NullPointerException::new); // 널이면 매개변수에 해당하는 예외 발생
```

`orElse()`의 변형으로 null을 대체할 값을 반환하는 람다식을 지정할 수 있는 `orElseGet()`과 null일 때 지정된 예외를 발생시키는 `orElseThrow()`가 있다.

<br>

📌 `isPresent()` & `ifPresent()`

- `isPresent()`: Optional 객체의 값이 null이면 false를, 값이 존재하면 true를 반환한다.
- `ifPresent(Consumer<T> c)`: 객체의 값이 존재하면 주어진 람다식을 실행하고, 없으면 아무 일도 하지 않는다. 

<br>

[02_Optional\<T> 객체 생성하기](Optional02.md) [Prev ◀︎]