# 제목

### 문제 
`난이도: 🟢🟢⚫️⚫️⚫️`

아래와 같이 정의된 피보나치 수열 중 n번째 항의 수를 리턴해야 합니다.

- 0번째 피보나치 수는 0이고, 1번째 피보나치 수는 1입니다. 그 다음 2번째 피보나치 수부터는 바로 직전의 두 피보나치 수의 합으로 정의합니다.
- 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, ...



<br>

### 입력

인자 1 : n

`int` 타입의 n (n은 0 이상의 정수)

<br>

### 출력

`int` 타입을 리턴해야합니다.

<br>

### 주의 사항

- 재귀함수를 이용해 구현해야 합니다.
- 반복문(for, while) 사용은 금지됩니다.
- 함수 fibonacci가 반드시 재귀함수일 필요는 없습니다.

<br>

### 입출력 예시

```Java
int output = fibonacci(0);
System.out.println(output); // --> 0

output = fibonacci(1);
System.out.println(output); // --> 1

output = fibonacci(5);
System.out.println(output); // --> 5

output = fibonacci(9);
System.out.println(output); // --> 34
```

<br>

### Advanced

피보나치 수열을 구하는 `효율적인 알고리즘(O(N))`이 존재합니다. 재귀함수의 호출을 직접 관찰하여 비효율이 있는지 확인해 보시기 바랍니다.

---

<br>

### Test

- [ ] 1 회 Clear
- [ ] 2 

```java
import java.util.*;

public class Test {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int test = sol.fibonacci(15);
        System.out.println("fibonacci(15) -> 610 == " + test);
        test = sol.fibonacci(10);
        System.out.println("fibonacci(10) -> 55 == " + test);
        test = sol.fibonacci(3);
        System.out.println("fibonacci(3) -> 2 == " + test);
        test = sol.fibonacci(1);
        System.out.println("fibonacci(1) -> 1 == " + test);
        test = sol.fibonacci(0);
        System.out.println("fibonacci(0) -> 0 == " + test);
    }

}

class Solution {
    public int fibonacci(int num) {
        // TODO:

    }
}


```

<br>

Test 통과시 출력문
```java
fibonacci(15) -> 610 == 610
fibonacci(10) -> 55 == 55
fibonacci(3) -> 2 == 2
fibonacci(1) -> 1 == 1
fibonacci(0) -> 0 == 0
```

<br>

<details>
    <summary>ToDo ⭕️</summary>

- [x] Test Clear!
- [x] CheckPoint 작성! 
- [ ] 효율적인 알고리즘 이해(memorization)
</details>

<br>

<details>
    <summary>Solution</summary>

```java
class Solution {
    public int fibonacci(int num) {
        // TODO:
        if(num == 0 ) return 0;
        int[] cache = new int[num + 1];
        cache[1] = 1;
        if(num >= 2) {
            cache[2] = 1;
        }

        return fibo_memorization(num, cache);
    }

    int temp;
    public int fibo_memorization(int num, int[] cache) {
        if(cache[num] > 0) {
            return cache[num];
        }
        else {
            temp = fibo_memorization(num-1, cache) + fibo_memorization(num-2, cache);
            cache[num] = temp;
            return temp;
        }
    }
}   
```
</details>

<br>

<details>
    <summary>Reference</summary>

```java
class Solution { 
  // naive solution: O(2^N)
  // public int fibonacci(int num) {
	// 	if (num <= 1) return num;
	// 	return fibonacci(num - 1) + fibonacci(num - 2);
	// }

  // dynamic with meoization: O(N)
  // 이미 해결한 문제의 정답을 따로 기록해두고,
  // 다시 해결하지 않는 기법
  // fibo(10)
  // = fibo(9) + fibo(8)
  // = fibo(8) + fibo(7) + fibo(7) + fibo(6)
  public int fibonacci(int num) {
    ArrayList<Integer> memo = new ArrayList<>();
    memo.add(0);
    memo.add(1);

    return aux(memo, num);
  }
	
  public int aux(ArrayList<Integer> memo, int num) {
    if (memo.size() <= num) {
      memo.add(aux(memo, num - 1) + aux(memo, num - 2));
    }
    return memo.get(num);
  }
}

```
</details>

<br>

---

### CheckPoint ✅

- [x] 피보나치 구하는 방법
- [x] 효율적인 알고리즘 O(N)의 원리
- [x] 기존 fibonacci 재귀함수 호출의 비효율성  
 