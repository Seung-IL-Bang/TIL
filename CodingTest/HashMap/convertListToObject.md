# convertListToObject

### 문제 
`난이도: 🟢🟢⚫️⚫️⚫️`

2차원 배열(배열을 요소로 갖는 배열)을 입력받아 각 배열을 이용해 만든 HashMap을 리턴해야 합니다.



<br>

### 입력

인자 1 : array

- 배열을 요소로 갖는 배열
- arr[i]는 String 타입을 요소로 갖는 배열
- arr[i].length는 0 또는 2
- String[][] arr;

<br>

### 출력

`arr[i]`의 첫 번째 요소를 키, 두 번째 요소를 값으로 하는 `HashMap<String, String>`을 리턴해야 합니다.

<br>

### 주의 사항

- 중복되는 키의 경우, 초기의 값을 사용합니다.
- 빈 배열을 입력받은 경우, 빈 HashMap을 리턴해야 합니다.
- arr[i]의 길이가 0인 경우, 무시합니다.

<br>

### 입출력 예시

```Java
String[][] arr = new String[]{
  {'make', 'Ford'},
  {'model', 'Mustang'},
  {'year', '1964'},
  {'make', 'Bill'},
};

HashMap<String, String> output = convertListToObject(arr);

System.out.println(output) // -->
{
  "make" = "Ford"
  "model" = "Mustang",
  "year" = "1964"
}
```

---

### Test

- [x] 1 회 Clear
- [ ] 2 

```java
import java.util.*;

public class Test {
    public static void main(String[] args){
        Solution solution = new Solution();

        String[][] arr = new String[][]{
                {"make", "Ford"},
                {"model", "Mustang"},
                {"year", "1964"},
                {"make", "Bill"}
        };
        String[][] emptyArr = new String[][]{};
        System.out.println("arr : " + solution.convertListToHashMap(arr).toString());
        System.out.println("emptyArr : " + solution.convertListToHashMap(emptyArr).toString());


    }
}

class Solution {
    public HashMap<String, String> convertListToHashMap(String[][] arr) {
        // TODO:

    }
}
```

<br>

Test 통과시 출력문
```java
arr : {year=1964, model=Mustang, make=Ford}
emptyArr : {}
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
public HashMap<String, String> convertListToHashMap(String[][] arr) {
        // TODO:
        // 빈 hashmap 선언
        HashMap<String, String> result = new HashMap<>();
        // if(빈 배열) return 빈 hashmap;
        if(arr.length == 0) return result;
        // for: arr 바깥 배열을 입력받고 반복문을 통해 안쪽 배열 순회
        for(int i=0; i < arr.length; i++){
            // 안쪽 배열 arr[i]의 길이가 0인 경우 무시,
            // 안쪽 배열 arr[i]의 길이가 2인 경우 0번째 요소 key, 1번째 요소 value로 hashmap에 put
            if(arr[i].length == 2){
                // 키가 중복되는 경우 무시
                if(!result.containsKey(arr[i][0])){
                    result.put(arr[i][0], arr[i][1]);
                }
            }
        }
        return result;
    }
```
</details>

<br>

---

### CheckPoint ✅

- [x] HashMap 메서드 `put(key, value)`, `containsKey(key)`

