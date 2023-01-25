# 선택 정렬(Selection Sort)

→ 데이터가 무작위로 여러 개 있을 때, 이 중에서 **가장 작은 데이터를 선택해 맨 앞에 있는 데이터와 바꾸고, 그 다음 작은 데이터를 선택해 앞에서 두 번째 데이터와 바꾼다**. 이렇게 단계적으로 데이터를 정렬하는 방법이다. 가장 원시적인 방법으로 매번 **‘가장 작은 것을 선택’** 한다는 의미에서 선택 정렬이다.

$$
시간 복잡도: O(N^2)
$$

```kotlin
fun selectionSort(arr: IntArray) {
    for (i in 0 until arr.size - 1) {
        var minIndex = i
        for (j in i + 1 until arr.size) {
            if (arr[j] < arr[minIndex]) {
                minIndex = j
            }
        }
        if (minIndex != i) {
            val temp = arr[i]
            arr[i] = arr[minIndex]
            arr[minIndex] = temp
        }
    }
}
```