# reverseArr

### 문제 
`난이도: 🟢⚫️⚫️⚫️⚫️`

수를 입력받아 제곱근 값을 소수점 두 자리까지 리턴해야 합니다.

<br>

### 입력

인자 1 : num

`int `타입의 정수 (num >= 2)

<br>

### 출력
- `String` 타입을 리턴해야 합니다.
- 최대 소수점 둘째 짜리까지 구한 수를 문자열로 변환하여 출력합니다. (소수점 셋째 자리에서 반올림)

<br>

### 주의 사항
`Math.sqrt` 사용은 금지됩니다.

<br>

### 입출력 예시

```Java
String output = computeSquareRoot(9);
System.out.println(output); // --> "3.00"

output = computeSquareRoot(6);
System.out.println(output); // --> "2.45"
```

<br>

### 힌트

- 소수점 처리는 java 표준 내장 객체인 String를 검색해 봅니다. (`java decimal places limit` 또는 자바 소수점 자리수)
- 각 자리수(1, 0.1, 0.01, 0.001)마다 (목표값을 넘지 않는) 근사값을 구하는 방식이 있습니다.
- 제곱근을 구하는 방법 중 바빌로니아 법이 있습니다. `바빌로니아 법의 점화식(recurrence formula)`을 이해할 수 있다면, 해당 식을 이용해 문제를 풀어도 좋습니다.
---

### Test
- [x] 1회 clear! 
- [ ] 2회 

```java
import java.util.*;

public class Test {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String result = sol.computeSquareRoot(6);
        System.out.println("6 입력시 \"2.45\" -> " + result);
        result = sol.computeSquareRoot(9);
        System.out.println("9 입력시 \"3.00\" -> " + result);
    }

}

class Solution {
        public String computeSquareRoot(int num) {
            // TODO:

        }
}

```

<br>

Test 통과시 출력문
```java
6 입력시 "2.45" -> 2.45
9 입력시 "3.00" -> 3.00
```

<br>

<details>
    <summary>ToDo ❌</summary>

- [x] Test Clear!
- [x] CheckPoint 작성! 
</details>

<br>

<details>
    <summary>Solution</summary>

```java
class Solution {
        public String computeSquareRoot(int num) {
            // TODO:
            double result;
            double sqrt = num / 2;
            do {
                result = sqrt;
                sqrt = (result + (num / result)) / 2;
            } while((result - sqrt) != 0);

            return String.format("%.2f", sqrt);
        }
}
```
</details>

<br>

---

### CheckPoint ✅

- [x] `Math.sqrt` 사용 없이 제곱근 구하는 방법
- [x] `String.format(specifier, value)` 