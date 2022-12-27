# Kotlin Basic (2)

### Packages

코틀린의 어떤 파일이든 `package` 선언으로 시작할 수 있다.

패키지 선언을 통해 다음 문장에 포함된 것들을 제공받을 수 있다.

**fully qualified name (FQN) for a class, object, interface, or function**

<br>

### Imports

선언된 패키지 이외의 클래스, 객체, 인터페이스, 함수를 사용하려면 외부 패키지를 `import` 해와야 한다.

```kotlin
    import com.packt.myproject.Foo 
```

한번에 전체 패키지를 가져오는 `Wildcard imports` 기능을 제공한다. `*`을 사용하면 된다. 불필요한 반복적 선언을 제거해준다.
```kotlin
    import com.packt.myproject.* 
```

`as` 키워드를 사용하여 패키지에 별칭을 지정해 줄 수 있다.
```kotlin
    import com.packt.myproject.Foo 
    import com.packt.otherproject.Foo as Foo2 
 
    fun doubleFoo() {
      val foo1 = Foo()
      val foo2 = Foo2() 
    } 
```

<br>

### String templates

문자열 템플릿은 패턴 교체나 문자열 연결 없이 문자열 내부에 값, 변수 또는 식을 포함하는 간단하고 효과적인 방법이다. 문자열 템플릿은 문자열을 짧고 읽기 쉽게 유지하므로 단일 리터럴에서 여러 변수를 사용할 때 Java 환경을 개선한다.

```Kotlin
    val name = "Sam" 
    val str = "hello $name" 
```

임의의 표현식은 달러($)를 접두사로 사용하고 중괄호 {}로 감싸서 삽입할 수 있다.

```kotlin
    val name = "Sam" 
    val str = "hello $name. Your name has ${name.length} characters" 
```

<br>

### Ranges

`Ranges`는 시작 값과 끝 값이 포함된 간격으로 정의된다. 비교할 수 있는 유형을 간격으로 지정하고 `..` 연산자를 사용하여  범위를 만들 수 있다. `for` 루프에서도 사용 가능하다. 

```kotlin
    val aToZ = "a".."z" 
    val oneToNine = 1..9 
    // .. 연산자를 사용할 땐 왼쪽이 항상 작아야 한다. 그렇지 않으면 empty range가 생성된다.
    val 100To2 = 100..2 // empty range
```

`in` 연산자를 사용하여 주어진 값이 해당 `ranges`에 들어가는지 `Boolean` 값을 반환한다.

```kotlin
    val aToZ = "a".."z" 
    val isTrue = "c" in aToZ
    val oneToNine = 1..9 
    val isFalse = 11 in oneToNine 
```

`..`연산자 이외 ranges 생성하는 라이브러리
- `downTo()`
- `rangeTo()`

```kotlin
    val countingDown = 100.downTo(0) // 100 .. 0 (step: -1)
    val rangeTo = 10.rangeTo(20) // 10 .. 20 (step: 1)
```

`step(x: only positive int)`을 사용하여 범위가 바뀌는 간격의 정도를 수정할 수도 있다.
```
    val oneToFifty = 1..50 
    val oddNumbers = oneToFifty.step(2) // 1, 3, 5, 7 ... , 49
```

`reversed()`을 사용하여 범위를 뒤집을 수도 있다.

```kotlin
val countingDownEvenNumbers = (2..100).step(2).reversed() // 100 downTo 2 step 2 
```