# Decimal Number <-> Binary Number

```kotlin
val x = 5

// 십진수를 이진수로 표현하기
val binaryString = x.toString(2) // 101

// 이진수를 십진수로 바꾸기
val decimalNumber = binaryString.toInt(2) // 5

```

`toString(2)`, `toInt(2)` 타입 변환에서 인수로 2를 전달하면 `Decimal Number <-> Binary Number` 과정이 성사된다.

<br>

### 주의 점

`binaryString` 은 해당 정수를 표현하는데 최소한의 비트 수만을 사용하고 문자열이다. `decimalNumber` 는 이진수의 해당하는 정수 값이다. 

