# 스트림(Stream) 01

### 스트림(Stream)에 대해 알아보자.

<br>

많은 수의 데이터를 다룰 때, `Collection` 또는 `Array`에 데이터를 저장했다. 저장한 데이터 소스를 이용하여 원하는 결과를 얻기 위해선 `for문` 또는 `Iterator` 인터페이스를 이용하여 원하는 결과를 도출했다.

<br>

**💀 하지만 위와 같은 방식에 <u>단점</u>이 존재한다.**
  
1. 컬렉션과 배열 클래스에는 같은 기능의 메서드들이 <u>중복 정의</u>되어 있다.

    - `Collection.sort()`
    - `Arrays.sort()`

2. 코드의 가독성이 떨어진다.
3. 코드를 재사용하기 어렵다.

<br>

**✨ 위와 같은 문제점들을 해결하기 위해 만든 것이 `스트림(Stream)`이다.**

<br>

스트림을 간단히 설명하자면

- 데이터를 **추상화**하여 다룬다.
- 추상화된 데이터를 다루는 **스트림 메서드**가 정의되어 있다.

데이터를 **추상화**한다는 것은 데이터 소스가 무엇이던 간에 같은 방식으로 다룰 수 있게 되었다는 것이다.

<br>

1. 같은 내용의 데이터들이 각각 배열과 리스트에 저장되어 있다.
```java
String[] strArr = {"c", "a", "b"};
List<String> strList = Arrays.asList(strArr);
```

<br>

2. 배열과 리스트를 기반으로 하는 스트림은 아래와 같이 생성한다.

```java
Stream<String> strStream1 = strList.stream();
Stream<String> strStream2 = Arrays.stream(strArr);
```

<br>

3. 두 스트림의 데이터 소스는 다르지만, 정렬하고 출력하는 방법은 완전히 동일하다.
```java
strStream1.sorted().forEach(System.ou::print); // abc
strStream2.sorted().forEach(System.ou::print); // abc
```

<br>

**⭐️ 요약**

스트림을 이용하면 각기 다른 데이터 소스(ex.배열, 컬렉션)들을 <u>모두 같은 방식으로 다룰 수 있게 된다.</u>

- 메서드 중복 정의 해소
- 가독성 향상
- 재사용성 향상

<br>

[▶︎ Next] [02_스트림의 특징](Stream02.md)



