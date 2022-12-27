# Kotlin Loops

코틀린은 `while` 및 `for` 루프문 둘 다 지원한다.

```kotlin
    while (true) { 
      println("This will print out for a long time!") 
    } 
```

<br>

`for` 반복문은 반복자(시퀀셜, 컬렉션)의 이름을 가진 함수를 정의하는 어느 객체의 요소 대해 반복을 실행한다. `for`은 `in`과 항상 함께 사용되며, ranges에 대해서도 반복이 가능하다
```kotlin
    val list = listOf(1, 2, 3, 4) 
    for (k in list) { 
      println(k) 
    } 
 
    val set = setOf(1, 2, 3, 4) 
    for (k in set) { 
      println(k) 
    } 

    val oneToTen = 1..10 
    for (k in oneToTen) { 
      for (j in 1..5) { 
        println(k * j) 
       } 
    } 
```

> Tip 🍯
>
> Ranges 는 컴파일러에서 특별한 방식으로 처리되며 JVM에서 직접 지원되는 인덱스 기반 for 루프로 컴파일되므로 반복자 개체 생성으로 인한 성능 저하를 방지할 수 있다.

<br>

iterator라는 함수를 구현하여 이를 매우 유연한 구성으로 만드는 경우 모든 객체를 for 루프 내에서 사용할 수 있다.

```kotlin
operator fun hasNext(): Boolean
operator fun next(): T
```

위 예시로, `String` 클래스는 `iterator` extension function을 제공해주므로 문자열의 각 문자를 for 루프에 적용할 수 있다.

```kotlin
    val string = "print my characters" 
    for (char in string) { 
      println(char) 
    } 
```

배열에는 배열의 인덱스를 반복하는 데 사용할 수 있는 `indices`라는 확장 함수가 있다.

```Kotlin
    for (index in array.indices) { 
      println("Element $index is ${array[index]}") 
    } 
```

> Tip 🍯
>
> 코틀린 컴파일러는 배열에 대한 특별한 지원을 제공한다. 배열에 대한 루프를 일반 인덱스 기반 for 루프로 컴파일하여 범위 루프와 같은 성능 저하를 방지한다.