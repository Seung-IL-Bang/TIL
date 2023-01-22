# Kotlin.Collections.mapValues

inline fun <K, V, R> Map<out K, V>.mapValues(
    transform: (Entry<K, V>) -> R
): Map<K, R>

```kotlin
val map1 = mapOf("beverage" to 2.7, "meal" to 12.4)
val map2 = map1.mapValues { it.value.toString() + "$" }
val map2 = map1.mapValues { (key, value) -> "$value$" }

println(map2) // {beverage=2.7$, meal=12.4$}
```

기존 map의 value 값을 transform 함수를 적용하여 새로운 value를 가진 map 반환한다.

iterator를 사용하여 Map의 Entry 자체에 접근도 가능하지만, 람다식을 사용하여 Entry의 키, 쌍 두 개를 인수로 받을 수도 있다.