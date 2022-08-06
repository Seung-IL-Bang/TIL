# reverseArr

### 문제 
`난이도: 🟢🟢⚫️⚫️⚫️`

배열을 입력받아 순서가 뒤집힌 배열을 리턴해야 합니다.

<br>

### 입력
인자 1 : arr
- `int` 타입의 요소를 갖는 배열

<br>

### 출력
- 순서가 뒤집힌 배열을 리턴해야 합니다.
- `[arr[n-1], arr[n-2], ... , arr[0]]`
- `arr.length`는 `n`

<br>

### 주의 사항
- 함수 reverseArr는 재귀함수의 형태로 작성합니다.
- 반복문(for, while) 사용은 금지됩니다.
- 입력받은 배열은 함수의 호출 뒤에도 처음 상태를 유지해야 합니다(immutability).
- 빈 배열은 빈 배열 그대로를 리턴해야 합니다.

<br>

### 입출력 예시

```Java
int[] output = reverseArr(new int[]{1, 2, 3});
System.out.println(Arrays.toString(output)); // --> [3, 2, 1]
```

---

### Test

```java
import java.util.*;

public class Test {
    public static void main(String[] args){
        Solution solution = new Solution();
        int[] test = solution.reverseArr(new int[]{1,2,3,4});
        System.out.println("[test01] {1,2,3,4} -> " + Arrays.toString(test));
        test = solution.reverseArr(new int[]{-2,-1,0,1,2});
        System.out.println("[test02] {-2,-1,0,1,2} -> " + Arrays.toString(test));
        test = solution.reverseArr(new int[]{});
        System.out.println("[test02] {} -> " + Arrays.toString(test));

    }
}
class Solution {
    public int[] reverseArr(int[] arr){
        // TODO:

    }
}
```

<br>

Test 통과시 출력문
```java
[test01] {1,2,3,4} -> [4, 3, 2, 1]
[test02] {-2,-1,0,1,2} -> [2, 1, 0, -1, -2]
[test03] {} -> []
```

<br>

<details>
    <summary>ToDo ⭕️</summary>

- [x] Test Clear!
- [x] CheckPoint 작성! 
</details>

<br>

<details>
    <summary>Solution</summary>

```java
class Solution {
    public int[] reverseArr(int[] arr){
        // TODO:
        if(arr.length == 0) return arr;
        int[] head = Arrays.copyOfRange(arr, arr.length - 1, arr.length);
        int[] tail = reverseArr(Arrays.copyOfRange(arr, 0, arr.length - 1));
        int[] dest = new int[head.length + tail.length];

        System.arraycopy(head, 0, dest, 0, head.length);
        System.arraycopy(tail, 0, dest, head.length, tail.length);

        return dest;
    }
}
```
</details>

<br>

---

### CheckPoint ✅

- [x] `Arrays.toString()` vs `Obeject.toString()`
- [x] `Arrays.copyOfRange(array, int from, int to)` -> return `array`
- [x] `System.arraycopy(Object src, int srcPos, Object dest, int destPost, int length)` 