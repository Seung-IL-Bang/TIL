# 스트림(Stream) 02 

### 스트림의 특징

1. 스트림은 데이터 소스를 변경하지 않는다.
2. 스트림은 일회용이다.
3. 스트림은 작업을 내부 반복으로 처리한다.
4. 지연된 연산
5. 오토박싱 & 언박싱으로 인한 비효율 해소 
6. 병렬 스트림 제공

---

<br> 

1. 스트림은 데이터 소스를 변경하지 않는다.

스트림은 데이터 소스로 부터 데이터를 읽기만할 뿐, 데이터 소스를 변경하지 않는다. 필요하다면 결과를 컬렉션이나 배열에 담아서 반환할 수 있다.

```java
// 정렬된 결과를 새로운 List에 담아서 반환한다.
List<String> sortedList = strStream.sorted().collect(Collectors.toList());
```

<br>

2. 스트림은 일회용이다.

스트림은 Iterator 처럼 한번 사용하면 닫혀서 다시 사용할 수 없다.

```java
str.Stream.sorted().forEach(System.out::println);
int numOfStr = strStream.count(); // Error : 스트림이 이미 닫혔음(스트림의 요소를 모두 소모함).
```

<br>

3. 스트림은 작업을 내부 반복으로 처리한다.

**내부 반복**이란 반복문을 메서드 내부에 숨겼다는 것을 의미한다. 예를 들어, 스트림 메서드 중 하나인 `forEach()`는 매개변수에 대입된 람다식을 데이터 소스의 모든 요소에 적용한다.

```java
// forEach() 정의

void forEach(Consumer<? super T> action) {
    Objects.requireNonNull(action); // 매개변수의 Null 체크

    for(T t : source) { // 내부 반복
        action.accept(t);
    }
}
```

<br>

4. 지연된 연산

최종 연산이 수행되기 전까지는 중간 연산이 수행되지 않는다. 다시 말해, 최종 연산이 수행되어야 비로소 스트림의 요소들이 중간 연산을 거쳐 최종 연산에서 소모된다.

<br>

5. 오토박싱 & 언박싱으로 인한 비효율 해소 

요소의 타입이 제네릭 T인 스트림은 기본적으로 Stream<T>이다. 하지만 **오토박싱 & 언박싱**으로 인한 비효율을 줄이기 위해 데이터 소스의 요소를 기본 타입으로 다루는 스트림 `IntStream`, `LongStream`, `DoubleStream`이 제공된다. 일반적으로 Stream<Integer> 대신 IntStream을 사용하는 것이 더 효율적이고, `IntStream`에는 int 타입의 값을 작업하는데 유용한 메서드들이 포함되어 있다.

> 오토박싱 & 언박싱 
>
> 오토박싱: 기본 타입 데이터를 대응하는 Wrapper 클래스로 만드는 동작 (int -> Integer)
> 
> 언박싱 : Wrapper 클래스에서 기본 타입으로 변환 (Integer -> int)
>
> 편의성을 위해 오토 박싱과 언박싱이 사용되지만, 내부적으로 추가 연산 작업을 거치면서 성능 면에서는 좋지 않다.

<br>

6. 병렬 스트림

스트림은 병렬 처리가 쉽다. 스트림에 parallel() 메서드를 호출만 하면 병렬로 연산 처리를 진행한다. 병렬로 처리하지 않을 때는 sequential()을 호출하면 된다. 기본값으로 sequential()이다.

<br>

[01_스트림이란?](Stream01.md) [Prev ◀︎] [▶︎ Next] [03_스트림 만들기](Stream03.md)