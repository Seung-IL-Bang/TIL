# kotlin.colletions.groupBy

fun <T, K> Collections\<out T>.groupBy(
    keySelector: (T) -> K
): Map<K, List<T>>

```kotlin
  val list = listOf(1,2,3,5,5,4,4,6)
  val groupBy = list.groupBy(keySelector = { it })
  val groupBy = list.groupBy{it}

  println(groupBy) // {1=[1], 2=[2], 3=[3], 5=[5, 5], 4=[4, 4], 6=[6]}
```


keySelector 람다식에 맞는 값을 key로 하고 list의 같은 키값을 갖는 요소들끼리 그룹화 하여 배열 타입의 value를 갖는 map을 반환한다.

( )와 keySelector를 생략하여, { } 안에 iterator 활용하여 사용가능하다.

`keySelector`는 Map(키-쌍)의 Entry(요소)에서 Key를 추출하는 데 사용되는 함수를 지정하는 데 사용된다.