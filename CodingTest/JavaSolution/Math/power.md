# 제목

### 문제 
`난이도: 🟢⚫️⚫️⚫️⚫️`

두 수를 입력받아 거듭제곱을 리턴해야 합니다.



<br>

### 입력

인자 1 : base

`int` 타입의 자연수 (base >= 2)

인자 2 : exponent

`int` 타입의 정수 (exponent >= 0)

<br>

### 출력

`long` 타입을 리턴해야 합니다.
실제 계산 결과를 94,906,249로 나눈 나머지를 리턴해야 합니다.

<br>

### 주의 사항

- Math.pow, 거듭제곱 연산자 사용은 금지됩니다.
- 시간복잡도 O(logN)을 만족해야 합니다.
- 나머지를 구하는 이유는 계산 결과가 컴퓨터로 나타낼 수 있는 수의 범위를 넘을 수 있기 때문입니다. 하지만 모든 연산이 끝난 뒤에 그 결과를 94,906,249로 나누려고 해서는 안 됩니다. 연산 중간에도 이 범위를 넘을 수 있기 때문에, 연산을 할 때마다 나머지를 구하고 그 결과에 연산을 이어가시기 바랍니다.

<br>

### 입출력 예시

```Java
long output = power(3, 40);
System.out.println(output); // --> 19334827
```

---

### Test

- [x] 1 회 Clear
- [ ] 2 

```java
import java.util.*;

public class Test {
    public static void main(String[] args) {
        Solution sol = new Solution();
        long test = sol.power(2, 10);
        System.out.println("power(2,10) -> 1024 == " + test);
        test = sol.power(5, 22);
        System.out.println("power(5,22) -> 70168358 == " + test);
        test = sol.power(4, 15);
        System.out.println("power(4,15) -> 29773085 == " + test);
    }

}

class Solution {
    public long power(int base, int exponent) {
        // TODO:

}


```

<br>

Test 통과시 출력문
```java
power(2,10) -> 1024 == 1024
power(5,22) -> 70168358 == 70168358
power(4,15) -> 29773085 == 29773085
```

<br>

<details>
    <summary>ToDo ⭕️</summary>

- [x] Test Clear!
- [x] CheckPoint 작성! 
- [ ] 효율적인 알고리즘 원리 이해
</details>

<br>

<details>
    <summary>Solution</summary>

```java
class Solution {
    public long power(int base, int exponent) {
        // TODO:
        long result = base;
        for(int i =1; i < exponent; i++) {
            result *= base;
            result %= 94906249; // 효율적인 알고리즘 구현?
        }
        return result;
    }
}    
```
</details>

<br>

---

### CheckPoint ✅

- [x] `Math.pow` 사용하지 않고 거듭제곱 연산하는 방법
- [x] 시간복잡도 `O(logN)`을 만족시키는 알고리즘
 