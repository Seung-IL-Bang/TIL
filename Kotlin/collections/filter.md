# Kotlin.Collections.filter

inline fun \<T> Iterable\<T>.filter(
    predicate: (T) -> Boolean
): List\<T>

```kotlin
val numbers: List<Int> = listOf(1, 2, 3, 4, 5, 6, 7)
val evenNumbers = numbers.filter { it % 2 == 0 }
val notMultiplesOf3 = numbers.filterNot { number -> number % 3 == 0 }

println(evenNumbers) // [2, 4, 6]
println(notMultiplesOf3) // [1, 2, 4, 5, 7]
```

Returns a list containing only elements matching the given predicate.