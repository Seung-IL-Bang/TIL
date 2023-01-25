# Kotlin.Collections.sortedWith

fun \<T> Iterable\<T>.sortedWith(
    comparator: Comparator\<in T>
): List\<T>

```kotlin
  val arr = arrayOf((3, 4), (1, 1), (1, -1), (2, 2), (3, 3))
  val sortedWith = list.sortedWith(compareBy<Pair<Int, Int>> { it.first }.thenBy { it.second })
  // [(1, -1), (1, 1), (2, 2), (3, 3), (3, 4)]
```

`sortedBy`와의 차이점은 `sortedBy`는 반복자의 key 또는 value 한 개의 기준으로 collection을 정렬하지만, `sortedWith`는 `comparator` 함수를 인수로 전달하여 하나 이상의 기준으로 정렬 가능하다.

위 예제 코드를 보면, 첫 번째 기준 `{ it.first }`로 정렬을 한 다음 `thenBy{ }`를 사용하면, 첫 번째 정렬 기준에서 compare 반환 값이 0인(=값이 같음) 그룹 내에서 상대적인 순서를 두 번째 기준인 `{ it.second }`로 정렬을 한다.