# LIS(Longest Increasing Subsequence)

### Concept

→ LIS는 최장 증가 부분 수열이라 불리며, 원소가 n개인 배열의 일부 원소를 골라내서 만든 부분 수열 중, 각 원소가 이전 원소보다 크다는 조건을 만족하고, 그 길이가 최대인 부분 수열을 최장 증가 부분 수열(LIS)이라고 한다. 쉽게 말해서, 어떠한 수열이 주어질 때, 그 수열에서 일부 원소들을 뽑아내어 새로 만든 수열을 **‘부분 수열’** 이라고 하며, 이 수열이 오름차순을 유지하면 **‘증가하는 부분 수열’** 이 되는 것이다. 따라서 주어진 수열에서 만들 수 있는 부분 수열 중 가장 길면서 오름차순을 유지하는 수열이 LIS이다. 주의할 점은 LIS는 한 개 이상 존재할 수도 있다.

<br>

### 문제

→ 이 알고리즘은 DP(Dynamic Programming) 문제로 자주 나오는 유형이며, $O(N^2)$ 의 시간복잡도를 갖는 알고리즘과 $O(NlogN)$의 시간 복잡도를 갖는 알고리즘이 있다. 어려운 문제로는 $O(NlogN)$ 을 요구하는 문제가 출제된다. 일반적으로 LIS의 길이가 얼마인지 간편하게 구하는 방법은 DP(Dynamic Programming)을 이용하는 것이다. 또한 이분 탐색을 이용하여 LIS의 길이를 구할 수도 있습니다.

→ 하지만, 단순히 최장 증가 부분 수열의 **길이만** 구해내는 것은 부족하다. 이 때에는 **최장 증가 부분 수열을 생성하는 알고리즘**을 사용해야 한다. 이 알고리즘은 주어진 배열에 대해 가능한 모든 최장 증가 부분 수열들을 찾는 것이다. 이를 위해 이중 반복문을 사용하여 구현할 수 있다. 또한, 이는 다른 부분 문제들로 나누어 다른 최적해를 구하는 동적 계획법 알고리즘을 기본 뼈대로 사용될 수 있습니다.

<br>

### LIS 생성 알고리즘

```kotlin
fun lis(arr: IntArray): List<Int> {
    // 각 인덱스에 대한 LIS 값을 저장할 배열
    val lis = IntArray(arr.size) { 1 }

    // 각 인덱스에 대한 이전 인덱스 저장
    val preIndex = IntArray(arr.size) { -1 }

    // arr[i]보다 작은 수로 끝나는 LIS를 계산
    for (i in 1 until arr.size) {
        for (j in 0 until i) {
            if (arr[j] < arr[i] && lis[i] < lis[j] + 1) {
                lis[i] = lis[j] + 1
                preIndex[i] = j
            }
        }
    }

    // 최대값을 갖는 인덱스를 찾기
    var maxIndex = 0
    for (i in 1 until arr.size) {
        if (lis[i] > lis[maxIndex])
            maxIndex = i
    }

    // 찾은 인덱스부터 역추적하여 최장 증가 부분 수열을 생성합니다.
    val result = mutableListOf(arr[maxIndex])
    var currentIndex = preIndex[maxIndex]
    while (currentIndex != -1) {
        result.add(arr[currentIndex])
        currentIndex = preIndex[currentIndex]
    }

    return result.reversed()
}

fun main() {
    val arr = arrayOf(5,1,3,4,2,8,7,9,6).toIntArray()

    print(lis(arr).toString()) // [1, 3, 4, 8, 9]
}
```

<br>

### LIS 길이 이분 탐색으로 구하기

```kotlin
fun lisBinarySearch(arr: IntArray): Int {
    val tails = IntArray(arr.size)
    var size = 0
    for (x in arr) {
        var left = 0
        var right = size
        while (left < right) {
            val mid = (left + right) / 2
            if (tails[mid] < x) {
                left = mid + 1
            } else {
                right = mid
            }
        }
        tails[left] = x
        if (left == size) size++
    }
    return size
}
```