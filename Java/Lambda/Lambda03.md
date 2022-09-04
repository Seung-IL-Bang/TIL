# 람다(Lambda) 03

### 람다식의 예

<br>

Ex.1
```java
// 메서드
int max(int a, int b) {
    return a > b ? a : b;
}

// 람다식
(int a, int b) -> {return a > b ? a : b;} // 기본

(int a, int b) -> a > b ? a : b // 몸통 내부 단일 리턴문 -> return, {}, ; 생략

(a, b) -> a > b ? a : b // 타입 추론
```

<br>

Ex.2
```java
// 메서드
void printVar(String name, int i) {
    System.out.println(name + "=" + i);
}

// 람다식
(String name, int i) -> {System.out.println(name + "=" + i);} // 기본

(String name, int i) -> System.out.println(name + "=" + i) // 몸통 내부 단일 문장 -> {}, ; 생략

(name, i) -> System.out.println(name + "=" + i) // 타입 추론
```

<br>

Ex.3
```java
// 메서드
int square(int x) {
    return x * x;
}

// 람다식
(int x) -> {return x * x;} // 기본

(int x) -> x * x // 몸통 내부 단일 리턴문 -> return, {}, ; 생략

(x) -> x * x // 타입 추론

x -> x * x // 단일 매개변수 -> 타입, 괄호() 생략
```

<br>

Ex.4
```java
// 메서드
int roll() {
    return (int)(Math.random() * 6);
}

// 람다식
() -> {return (int)(Math.random() * 6);} // 기본

() -> (int)(Math.random * 6) // 몸통 내부 단일 리턴문 -> return, {}, ; 생략
```

<br>

Ex.5
```java
// 메서드
int sumArr(int[] arr) {
    int sum = 0;
    for(int i : arr) 
        sum += i;
    return sum;
}

// 람다식
(int[] arr) -> {
    int sum =0;
    for(int i : arr)
        sum += i;
    return sum;
} // 기본

(arr) -> {
    int sum =0;
    for(int i : arr)
        sum += i;
    return sum;
} // 타입 추론

arr -> {
    int sum =0;
    for(int i : arr)
        sum += i;
    return sum;
} // 단일 매개변수 -> 타입, 괄호() 생략
```

<br>

[02_람다식 작성하기](Lambda02.md) [Prev ◀︎] [▶︎ Next] [04_람다식은 익명 객체](Lambda04.md)