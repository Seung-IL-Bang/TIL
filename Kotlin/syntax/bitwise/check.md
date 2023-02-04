# bitwise operators to check if an element is present in a set

`contains()` 메소드를 사용하여 집합에 요소가 포함되어 있는지 확인할 수 있다.

```kotlin
val set = setOf(1, 2, 3)
println(set.contains(1)) // outputs "true"
println(set.contains(4)) // outputs "false"
```

<br>

집합에 요소가 있는지 확인하기 위해 비트 연산자를 사용하려면 `AND 연산자(and)`를 사용하여 특정 비트가 설정되어 있는지 확인해야 합니다.

```kotlin
val set = setOf(1, 2, 4)
val x = 5
for (num in set) {
    if (x and (1 shl num) != 0) {
        println("$x contains $num")
    }
}
/*
5 contains 1
5 contains 4
*/
```