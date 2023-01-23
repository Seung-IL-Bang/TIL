# Kotlin.Collections.MaxByOrNull

inline fun <T, R : Comparable\<R>> Collections\<out T>.maxByOrNull(
    selector: (T) -> R
): T?

```kotlin
val nameToAge = listOf("Alice" to 42, "Bob" to 28, "Carol" to 51)
val oldestPerson = nameToAge.maxByOrNull { it.second }
println(oldestPerson) // (Carol, 51)

val emptyList = emptyList<Pair<String, Int>>()
val emptyMax = emptyList.maxByOrNull { it.second }
println(emptyMax) // null
```

selector 함수에 의해 산출된 크기가 제일 큰 값들 중 순서가 가장 앞인 요소를 반환한다.

위에서 쓰인 `it.second`는 `to` 문법에 의해 생긴 `Pair` 객체의 두 번째 위치의 property 값이다.

<br>

### `Pair<A, B>`

Creates a tuple of type Pair from this and that.
This can be useful for creating Map literals with less noise

A -> first <br>
B -> second