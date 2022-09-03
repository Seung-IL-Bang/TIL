# 람다(Lambda) 02

### 람다식 작성하기

<br>

메서드를 **람다식**으로 바꾸는 방법

1. 메서드에서 **이름**과 **반환타입**을 제거한다.
2. 매개변수 선언부와 몸통`{}` 사이에 화살표`->`를 추가해준다.

<br>

람다식 작성 예시
```java
// 메서드
int max(int a, int b) {
    return a > b ? a : b;
}

// 람다식
(int a, int b) -> {return a > b ? a : b;}
```

<br>

**람다식에서 생략이 더 가능한 경우**

1. 반환값이 있는 메서드의 경우, `몸통{}` 안의 `return 문` 만 존재하는 경우 문장 대신 `식(expression)`으로 대신할 수 있다.
   
    `식(expression)`의 연산결과가 자동으로 반환값이 되고, `문장(statememnt)`이 아닌 `식(expression)`이므로 끝에 `몸통{}`, `return`, `세미콜론(;)`을 붙이지 않는다. <u>몸통{}과 세미콜론만 생략하고 return만 남길 수 없다.`</u>

    ```java
    // 기존 람다식
    (int a, int b) -> {return a > b ? a : b;}
    
    // {}, return, ;을 생략한 람다식 
    (int a, int b) -> a > b ? a : b // OK

    // Error
    (int a, int b) -> return a > b ? a : b
    ```

<br>

2. 람다식에 선언된 매개변수의 타입은 추론이 가능한 경우 생략 가능하다.

    대부분의 경우 생략 가능하다. 람다식에 반환타입이 없는 이유도 항상 추론이 가능하기 때문이다.

    ```java
    // 기존 람다식
    (int a, int b) -> a > b ? a : b

    // 매개변수 타입을 생략한 람다식
    (a, b) -> a > b ? a : b
    ```
    
<br>

3. 선언된 매개변수가 하나뿐인 경우 괄호`()`를 생략할 수 있다. <u>단, 매개변수의 타입을 생략 안하면 괄호`()`를 생략할 수 없다.</u>

    ```java
    // 기존 람다식
    (a) -> a * a
    (int a) -> a * a

    // 괄호 생략 람다식
    a -> a * a // OK

    // Error
    int a -> a * a 
    ```
    
<br>

4. `몸통{}` 안의 문장이 하나일 때는 `몸통{}`를 생략할 수 있다. 이때 문장의 끝에 `세미콜론(;)`도 생략해야 한다.

    ```java
    // 기존 람다식
    (String firstName, String lastName) -> {
        System.out.println(firstName + lastName);
    }

    // 몸통과 세미콜론 생략한 람다식
    (String firstName, String lastName) 
        -> System.out.println(firstName + lastName) 
    ```

<br>

[01_람다식이란?](Lambda01.md) [Prev ◀︎] [▶︎ Next] [03_람다식의 예](Lambda03.md)