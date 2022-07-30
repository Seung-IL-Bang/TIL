# [Java_Error] incompatible types: inference variable T has incompatible bounds


### 오류 메시지
---

incompatible types: inference variable T has incompatible bounds

<br>

### 원인

---
```java
// 에러 발생 연출
int[] A = new int[]{1,2,3,4};

List<Integer> list = Arrays.asList(A);
```
위 코드에서 `베열A`는 int 타입을 요소로 가지고 있다. 하지만 `리스트(list)`는 `Integer`타입이 와야하므로 에러가 발생한다. 참고로 `Arrays.asList(A)`는 `List<int[]>`을 리턴한다.



<br>

### 해결 방법

1. `Int 스트림`을 이용하여 List로 만들기

`IntStream.of(A).boxed().collect(Collectors.toList());`

<br>

2. 반복문과 `ArrayList`를 사용하기

```java
int[] ints = {1, 2, 3};
List<Integer> intList = new ArrayList<Integer>();
for (int index = 0; index < ints.length; index++)
{
    intList.add(ints[index]);
}
```

<br>

- Ref 👉 [stackoverflow](https://stackoverflow.com/questions/27522741/incompatible-types-inference-variable-t-has-incompatible-bounds)
