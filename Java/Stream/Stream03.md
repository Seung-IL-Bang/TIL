# 스트림(Stream) 03

### 스트림 만들기

1. [컬렉션 스트림](#1-컬렉션-스트림) 
2. [배열 스트림](#2-배열-스트림)
3. [임의의 수 스트림](#3-임의의-수-스트림)
4. [특정 범위의 정수 스트림](#4-특정-범위의-정수-스트림)
5. [iterate(), generate() 스트림](#5-iterate-generate-스트림)
6. [파일과 빈 스트림](#6-파일과-빈-스트림)

---

<br>

#### 1. 컬렉션 스트림

Collection 인터페이스에는 `stream()`이 정의되어 있다. 따라서 자손 클래스, `List`, `Set`은 모두 `stream()` 메서드로 스트림을 생성할 수 있다. **`stream()`은 해당 컬렉션을 소스(source)로 하는 스트림을 반환한다.**

```java
List<Integer> list = Arrays.asList(1,2,3,4,5); // 가변 인자
Stream<Integer> intStream = list.stream(); // list를 소스로 하는 스트림 생성
```

<br>

#### 2. 배열 스트림

배열을 소스의 스트림을 생성하는 메서드는 `Stream`과 `Arrays`에 static 메서드로 정의되어 있다.

```java
Stream<T> Stream.of(T... values) // 가변 인자
Stream<T> Strema.of(T[])
Stream<T> Arrays.stream(T[])
Stream<T> Arrays.stream(T[] array, int startInclusive, int endExclusive)
```

<br>

물론, 기본형 배열을 소스로 하는 스트림 생성 메서드도 존재한다.

```java
// Stream<T>가 아니라 IntStream 반환
IntStream IntStream.of(int... values)
IntStream IntStream.of(int[])
IntStream Arrays.stream(int[])
IntStream Arrays.stream(int[] array, int startInclusive, int endExclusive)
```

long, double 타입도 마찬가지로 존재한다.

<br>

Ex.1 배열 소스의 문자열 스트림 생성

```java
Stream<String> strStream = Stream.of("a", "b", "c"); // 가변 인자
Stream<String> strStream = Stream.of(new String[]{"a", "b", "c"});
Stream<String> strStream = Arrays.stream(new String[]{"a", "b", "c"});
Stream<String> strStream = Arrays.stream(new String[]{"a", "b", "c"}, 0, 3);
```

<br>

#### 3. 임의의 수 스트림

난수를 생성하는데 사용하는 `Random` 클래스에는 아래와 같은 인스턴스 메서드들이 포함되어 있다. 이 메서드들은 해당 타입의 난수들로 이루어진 `무한 스트림`을 반환한다.

```java
IntStream ints()
LongStream longs()
DoubleStream doubles()
```

<br>

크기가 정해지지 않은 스트림을 `무한 스트림`이라 부른다. 스트림의 개수를 유한하게 만들어주는 메서드 `limit()`을 사용하여 무한 스트림을 `유한 스트림`으로 만들어 준다.

```java
IntStream intStream = new Random().ints(); // 무한 스트림
intStream.limit(5).forEach(System.out::println); // 5개의 요소만 출력한다.
```

<br>

또는, 유한 스트림을 생성해주는 오버로딩 메서드가 존재한다.

```java
IntStream ints(long streamSize)
LongStream longs(long streamSize)
DoubleStream doubles(long streamSize)

IntStream intStream = new Random().ints(5) // 크기가 5인 난수 스트림을 반환
```

<br>

**스트림 난수의 범위**


```java
Integer.MIN_VALUE <= ints() <= Integer.MAX_VALUE
Long.MIN_VALUE <= longs() <= Long.MAX_VALUE
0.0 <= doubles() < 1
```

<br>

지정된 범위(begin ~ end)의 난수를 발생시키는 스트림 오버로딩 메서드도 존재한다.

```java
// 무한
IntStream ints(int begin, int end)
LongStream longs(int begin, int end)
DoubleStream doubles(int begin, int end)

// 유한
IntStream ints(long streamSize, int begin, int end)
LongStream longs(long streamSize, int begin, int end)
DoubleStream doubles(long streamSize, int begin, int end)
```

<br>

#### 4. 특정 범위의 정수 스트림

`IntStream`과 `LongStream`은 지정된 범위의 **<u>연속된</u> 정수**를 스트림으로 생성해서 반환하는 `range()`와 `rangeClosed()`를 가지고 있다.

```java
IntStream intStream = IntStream.range(1,5) // 1,2,3,4
IntStream intStream = IntStream.rangeClosed(1,5) // 1,2,3,4,5
```

<br>

#### 5. iterate(), generate() 스트림

Stream 클래스의 `iterate()`와 `generate()`는 람다식을 매개변수로 받아서, 이 람다식에 의해 계산되는 값들을 요소로 하는 **무한 스트림**을 생성한다.

```java
static <T> Stream<T> iterate(T seed, UnaryOperator<T> f)
static <T> Stream<T> generate(Supplier<T> s)
```

- `iterate()`는 seed로 지정된 값부터 시작하여, 람다식 f에 의해 계산된 결과를 다시 seed 값으로 반복 계산한다.
- `generate()`는 람다식에 의해 계산되는 값을 요소로 하는 무한 스트림을 생성하지만, iterate()와 달리, 이전 결과를 이용하여 다음 요소를 계산하지 않는다.

<br>

Ex iterate(), generate() 생성 예시
```java
Stream<Integer> evenStream = Stream.iterate(0, n -> n+2); // 0, 2, 4, 6, ...
Stream<Double> randomStream = Stream.generate(Math::random);
```

❗️ 주의할 점

- iterate()와 generate()에 의해 생성된 스트림은 기본형 스트림 타입의 참조변수로 다룰 수 없다.

굳이 필요하다면, `mapToInt()`와 같은 메서드로 변환을 해야한다.

<br>

#### 6. 파일과 빈 스트림

**파일 스트림**

`java.nio.file.Files` 클래스 안에는 `list()` 메서드가 존재하는데, 이 메서드는 디렉토리(dir)에 있는 파일의 목록을 소스로 하는 스트림을 생성해서 반환한다.

```java
Stream<Path> Files.list(Path dir)
```

<br>

**빈 스트림**

요소가 하나도 없는 비어있는 스트림을 생성할 수 있다. 스트림에 연산을 수행한 결과가 하나도 없을 때, null 보다 빈 스트림을 반환하는 것이 좋다.

```java
Strema emptyStrema = Stream.empty(); // empty()는 빈 스트림을 생성해서 반환한다.
long count = emptyStream.count(); // count의 값은 0
```

💡 `count()`는 스트림 요소의 개수를 반환한다.

<br>

[02_스트림의 특징](Stream02.md) [Prev ◀︎] [▶︎ Next] [03_스트림의 연산](Stream04.md)