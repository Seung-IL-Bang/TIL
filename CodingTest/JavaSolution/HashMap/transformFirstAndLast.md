# transformFirstAndLast

### 문제 
`난이도: 🟢⚫️⚫️⚫️⚫️`

배열을 입력받아 차례대로 배열의 첫 요소와 마지막 요소를 각각 키와 값으로 하는 HashMap을 리턴해야 합니다.

<br>

### 입력

인자 1 : array

- `String` 타입을 요소로 갖는 배열

<br>

### 출력

- `HashMap<String, String>` 타입의 값을 리턴해야 합니다.

<br>

### 주의 사항

- 빈 배열을 입력받은 경우, `null`을 리턴해야 합니다.

<br>

### 입출력 예시

```Java
String[] arr = new String[]{'Queen', 'Elizabeth', 'Of Hearts', 'Beyonce'};
HashMap<String, String> output = transformFirstAndLast(arr);
System.out.println(output); // --> { Queen : 'Beyonce' }

String[] arr = new String[]{'Kevin', 'Bacon', 'Love', 'Hart', 'Costner', 'Spacey'};
HashMap<String, String> output = transformFirstAndLast(arr);
System.out.println(output); // --> { Kevin : 'Spacey' }
```

---

### Test

- [x] 1 회 Clear
- [ ] 2 

```java
import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        String[] arr1 = new String[]{"Queen", "Elizabeth", "Of Hearts", "Beyonce"};
        String[] arr2 = new String[]{"Kevin", "Bacon", "Love", "Hart", " Costner", "Spacey"};
        String[] arr3 = new String[]{};

        Solution solution = new Solution();

        System.out.println("arr1 output : " + solution.transformFirstAndLast(arr1));
        System.out.println("arr2 output : " + solution.transformFirstAndLast(arr2));
        System.out.println("arr3 output : " + solution.transformFirstAndLast(arr3));
    }
}

class Solution {
    public HashMap<String, String> transformFirstAndLast(String[] arr) {
        // ToDo...
    }
}
```

<br>

Test 통과시 출력문
```java
arr1 output : {Queen=Beyonce}
arr2 output : {Kevin=Spacey}
arr3 output : null
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
    public HashMap<String, String> transformFirstAndLast(String[] arr) {
        if(arr.length == 0) return null;
        HashMap<String, String> result = new HashMap<>();
        result.put(arr[0], arr[arr.length - 1]);
        return result;
    }
}
```
</details>

<br>

---

### CheckPoint ✅

- [x] HashMap 선언과 정의
- [x] Map 인터페이스 메서드 `put(Object key, Object value)`

