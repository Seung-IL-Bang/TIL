# 이분 탐색(Binary Search)

### Concept

→ 이분 탐색(이진 탐색, Binary Search) 알고리즘은 정렬되어 있는 리스트에서 탐색 범위를 절반씩 좁혀가며 데이터를 탐색하는 방법이다. **이분 탐색은 리스트 내부의 데이터가 반드시 정렬되어 있어야만 사용할 수 있는 알고리즘이다.**

<br>

### 탐색 방법

→ 변수 3개(Start, end, mid)를 사용하여 탐색한다. 찾으려는 데이터와 중간점 위치(mid)에 있는 데이터를 비교한다. 만약 중간점 위치의 값이 찾고자 하는 값보다 크면 end 를 (mid - 1) 위치로 옮기고, 작으면 start 를 (min + 1) 로 옮겨서 다시 중간점 위치를 구한다. 그리고 start가 end 보다 커질 때 까지 탐색과정을 반복한다.

<br>

### 구현

```kotlin
fun binarySearch(arr: Array<Int>, target: Int): Int {
    var left = 0
    var right = arr.size - 1
    while (left <= right) {
        val mid = (left + right) / 2
        when {
            arr[mid] == target -> return mid
            arr[mid] < target -> left = mid + 1
            else -> right = mid - 1
        }
    }
    return -1
}
```

<br>

### 시간 복잡도

$$
O(logN)
$$

탐색 과정을 거칠 때 마다 범위가 절반씩 줄어들기 때문에 위와 같은 시간 복잡도를 갖게 된다.
