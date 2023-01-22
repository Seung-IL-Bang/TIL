# 퀵 정렬(Quick Sorting)

→ ‘퀵 정렬’과 ‘병합 정렬’은 대부분의 프로그래밍 언어에서 정렬 라이브러리의 근간이 될 만큼 효율적인 알고리즘이다. **퀵 정렬은 기준 데이터(=피벗)을 설정하고 그 기준보다 큰 데이터와 작은 데이터의 위치를 교환한 후 리스트를 반으로 나누는 방식으로 동작한다.** 대표적인 분할 방식인 **호어 분할(Hoare Partition)**은 피벗을 리스트의 첫번 째 데이터로 설정하여 정렬 하는 방식이다. 퀵 정렬은 특정한 리스트에서 피벗을 설정하여 정렬을 수행한 이후에, 피벗을 기준으로 분할된 각각의 리스트에서 다시 정렬을 수행한다. 이는 **재귀 함수 동작 원리와 같다. 실제로 퀵 정렬은 재귀 함수 형태로 작성하면 구현이 매우 간결해진다.** 재귀가 끝나는 조건은 리스트의 데이터 개수가 1개인 경우이다. 데이터가 무작위로 존재하는 경우 퀵 정렬은 매우 빠르게 동작하지만, 호어 분할로 퀵 정렬을 할 경우, ‘이미 데이터가 정렬되어 있는 경우’ 에는 매우 느리게 동작하여 삽입 정렬과 선택 정렬의 시간복잡도($O(N^2)$)와 비슷해질 수도 있다. 실제로 퀵 정렬 기반으로 라이브러리를 제공하는 프로그래밍 언어는 최악의 경우에도 아래 시간 복잡도를 보장할 수 있도록 피벗값을 설정하는 추가 로직이 더해진다.

$$
시간 복잡도: O(NlogN)
$$

```kotlin
fun quickSort(arr: IntArray, low: Int, high: Int) {
    if (low < high) {
        val pivotIndex = partition(arr, low, high)
        quickSort(arr, low, pivotIndex)
        quickSort(arr, pivotIndex + 1, high)
    }
}

fun partition(arr: IntArray, low: Int, high: Int): Int {
    val pivot = arr[low]
    var i = low
    var j = high

    while (i < j) {
        do {
            i++
        } while (arr[i] < pivot)
        do {
            j--
        } while (arr[j] > pivot)
        if (i < j) {
            val temp = arr[i]
            arr[i] = arr[j]
            arr[j] = temp
        }
    }
    val temp = arr[low]
    arr[low] = arr[j]
    arr[j] = temp

    return j
}
```