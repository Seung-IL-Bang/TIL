# Kotlin.Collections.first

fun \<T> Iterable\<T>.first(): T

▶️ Returns the first element.

<br>

```kotlin
val map = mapOf("a" to 1, "b" to 2, "c" to 3)
val firstElement = map.entries.first()
println(firstElement) // Output: a=1
```


<br>

### Exceptions
NoSuchElementException - if the collection is empty.