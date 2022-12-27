# Kotlin Basic

### Var vs Val

**mutable variable 선언** -> `var`
```kotlin
var name = "kotlin"
```

`var` 변수는 초기화를 나중에 해도 된다.
```kotlin
var name: String
name = "kotlin"
```

`var`변수는 mutable 하므로 값을 재할당 해줄 수 있다.
```kotlin
var name = "kotlin"
name = "new Kotlin"
```

<br>

**immutable variable 선언** -> `val`

`val`변수는 immutable 하므로 값을 재할당 해줄 수 없다.
```kotlin
val name = "kotlin"
```

<br>

### Type inference

자바는 변수의 선어 시 타입을 항상 수반되어야 하지만, 코틀린은 타입 생략이 가능하다. 즉 코틀린은 `타입 추론(Type inference)` 기능이 제공된다. **변수**뿐만 아니라 함수 시그니처 위치에 있는 **매개변수**의 타입 또한 추론이 가능하다.

> 타입 추론 장점
> 
> This reduces boilerplate whilst keeping the type safety we expect of a modern language.

<br>

타입 명시
```kotlin
val explicitType: Number = 12.3
```

<br>

### Basic Types

java의 원시 타입(primitive type)은 제네릭 타입으로 사용 불가하며, 메서드/함수 콜 그리고 null 할당이 불가능했다. 이러한 문제점을 해결하기 위해 `wrapper object`를 도입됐다. `boolean` -> `Boolean`

**코틀린에서는 원시 타입 전체를 객체로 승격하여 래퍼 클래스로 감쌀 필요성이 사라졌다.** 하지만 성능 상의 이유로 코틀린 컴파일러가 코틀린 기본 타입을 JVM primitives로 되돌리는 경우도 있다.

> 용어 사전: boxing
>
> Boxing is the conversion from a primitive type to a wrapper type that types place whenever an object is required but a primitive is presented.

<br>

### Numbers

| **Type** | **Width(bit)** |
| -------- | --------- |
| Long     | 64        |
| Int      | 32        |
| Short    | 16        |
| Byte     | 8         |
| Double   | 64        |
| Float    | 32        |

<br>

```
    val int = 123 
    val long = 123456L 
    val double = 12.34 
    val float = 12.34F 
    val hexadecimal = 0xAB 
    val binary = 0b01010101 
```

- `long` 값에는 접미사 L과 `float` 값에는 접미사 F가 필요하다.
- double은 부동 소수점 숫자의 기본값(Default)으로 사용된다.
- 16진수(`hexadecimal`)와 2진수(`binary`)는 접두사 0x와 0b를 각각 사용한다.
- 정수는 `int`를 사용한다.

<br>

**Kotlin은 숫자의 자동 확장을 지원하지 않으므로 명시적으로 변환을 호출해야 한다.** 다행히, 각 숫자에는 값을 다른 숫자 유형 중 하나로 변환하는 기능이 제공된다.
```kotlin
val int = 123
val long = int.toLong()
```

<br>

set of functions for conversions between types
- toByte()
- toShort()
- toInt()
- toLong()
- toFloat()
- toDouble()
- toChar()

<br>

### bitwise operators

java는 비트 연산에 대한 연산자가 내장되어 있다. 하지만 코틀린은 비트 연산에 대해 이름이 지정된 함수로 제공되며 연산자처럼 호출할 수 있다.

```kotlin
    val leftShift = 1 shl 2  // left shift
    val rightShift = 1 shr 2 // right shift
    val unsignedRightShift = 1 ushr 2 // unsigned right shift
 
    val and = 1 and 0x00001111 // logical and
    val or = 1 or0x00001111 // logical or
    val xor = 1 xor0x00001111 // exclusive logical or
    val inv = 1.inv() // the multiplicative inverse of a number.
```

> inv()는 이진 연산자가 아니라 단항 연산자이므로 숫자에 점 구문을 사용하여 호출된다.

<br>

### Boolean

```kotlin
    val x = 1 
    val y = 2 
    val z = 2 
 
    val isTrue = x < y && x < z 
    val alsoTrue = x == y || y == z 
```
`&&`, `||` 연산시 왼쪽 평가로 인해 오른쪽 평가는 생략될 수 있다.

<br>

### Chars

`Chars`은 단일 문자이다. 작은 따옴표를 사용하여 나타낸다. 

`'A'`, `'B'`

Chars는 이스케이핑도 지원한다.

`\t`, `\b`, `\n`, `\r`, `'`, `"`, `\\`, `\$`

모든 유니코드 문자는 `\u1234` 처럼 유니코드 숫자를 이용하여 표현할 수 있다.

> 주의
>
> char 유형은 Java에서 사용되는 것처럼 숫자로 취급되지 않는다.

<br>

### Strings

자바처럼 코틀린의 문자열 또한 값의 변경이 불가능하다(immutable). 코틀린에서 문자열은 큰따옴표 또는 삼중따옴표를 통해 만들 수 있다.

큰따옴표 문자열은 이스케이핑 문자를 포함시킬 수 있다.
```kotlin
val string = "string with \n new line"
```

삼중따옴표는 원시(raw) 문자열을 생성하는데, 이스케이핑 문자를 포함시킬 필요가 없으며 모든 문자들을 그대로 저장한다.
```kotlin
val rawString = """ 
    raw string is super useful for strings that span many lines """ 
``` 

> for 루프에서 String
>
> 문자열은 for 루프에서 사용할 수 있는 반복자 함수도 제공된다.

<br>

### Arrays

코틀린에서 배열은 `arrayOf()`를 사용해서 만들 수 있다. 코틀린의 배열은 Java와 달리 언어에서 특수한 것으로 취급되지 않으며 일반 컬렉션 클래스로 취급된다.

```kotlin
val array = arrayOf(1, 2, 3)
```

또한, 초기 크기와 각 요소를 생성하는 데 사용되는 함수를 지정하여 배열을 생성할 수도 있다.

```kotlin
 val perfectSquares = Array(10, { k -> k * k }) 
```

iterator 함수, size 함수, get 함수, set 함수들도 제공된다.
```kotlin
    val element1 = array[0]
    val element2 = array[1] 
    array[2] = 5 
```

코틀린은 성능 상의 이유로 JVM 원시 타입으로 되돌리 때가 있다. 코틀린은 원시 타입에 특화된 대체 배열 클래스를 제공한다. 이를 통해 성능이 중요한 곳에 Java에서와 마찬가지로 효율적으로 배열을 사용할 수 있다.
- `ByteArray`
- `CharArray`
- `ShortArray`
- `IntArray`
- `LongArray`
- `BooleanArray`
- `FloatArray`
- `DoubleArray`


<br>

### Comments

주석은 Java와 동일하다.
```kotlin
    // line comment 
 
    /* 
     A block comment 
     can span many 
     lines 
    */ 
```


