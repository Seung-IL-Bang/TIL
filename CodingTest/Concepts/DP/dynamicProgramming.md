# DP(Dynamic Programming)

### Concept

→ DP란 동적 계획법(프로그래밍)이라고도 불린다. 큰 문제를 작은 문제로 나누어 푸는 문제를 일컫는 말이다. 이때 작은 문제에 대하여 똑같은 문제의 중복이 일어나고 그 답이 항상 같다. 분할정복(Divide and Conquer)과 비슷하지만 분할정복은 작은 문제의 중복이 일어나지 않으며, 단지 작은 문제로 나누어 푸는 것만 DP와 닮아 있다.

<br>

### DP 사용 조건

: 아래 두 조건을 만족시켜야지만 DP를 사용할 수 있다.

1. 똑같은 작은 문제가 반복해서 일어나야 한다.
2. 같은 문제에 대해서 정답이 항상 같다.

<br>

### DP 방법

→ 모든 작은 문제들은  한 번만 풀어야 한다. 따라서 해결이 된 작은 문제의 정답은 어딘가에 **메모(Memorization)** 해야 한다. 이후 큰 문제를 풀어나갈 때 똑같은 작은 문제가 나타나면 앞서 메모한 정답을 이용한다.

<br>

### Memorization

→ 똑같은 작은 문제들이 반복해서 일어나므로, 한번 계산한 정답은 저장해놓고 재사용한다. 이것을 `메모라이제이션(Memorization)`이라고 한다.

<br>

### 예제. 피보나치 재귀와 동적 프로그래밍 비교

```kotlin
fun fibonacciDP(n: Int): Int {
    if (n <= 1) return n
    var f0 = 0
    var f1 = 1
    for (i in 2..n) {
        val f = f0 + f1
        f0 = f1
        f1 = f
    }
    return f1
}
```

```kotlin
fun fibonacciRecursive(n: Int): Int {
    return when (n) {
        0, 1 -> n
        else -> fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2)
    }
}
```