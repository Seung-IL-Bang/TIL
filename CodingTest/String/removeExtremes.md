# removeExtremes

### 문제 
`난이도: 🟢🟢⚫️⚫️⚫️`

문자열을 요소로 갖는 배열을 입력받아 가장 짧은 문자열과 가장 긴 문자열을 제거한 배열을 리턴해야 합니다.

<br>

### 입력
인자 1 : arr
- `String` 타입을 요소로 갖는 배열
- `arr[i].length()`는 20 이하

<br>

### 출력
배열을 리턴해야 합니다.

<br>

### 주의 사항
- 가장 짧은 문자열의 길이와 가장 긴 문자열의 길이가 같은 경우는 없습니다.
- 가장 짧은 문자열 또는 가장 긴 문자열이 다수일 경우, 나중에 위치한 문자열을 제거합니다.
- 빈 배열을 입력받을 경우, null을 반환합니다.

<br>

### 입출력 예시

```Java
String[] output = removeExtremes(new String[]{"a", "b", "c", "def"});
System.out.println(output); // --> ["a"', "b"]

output = removeExtremes(new String[]{"where", "is", "the", "longest", "word"});
System.out.println(output); // --> ["where", "the", "word"]
```

---

### Test

```java
import java.util.*;

public class Test {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] result = sol.removeExtremes(new String[]{"where", "is", "the", "longest", "word"});
        System.out.println("['where', 'is', 'the', 'longest', 'word']를 입력받은 경우, ['where', 'the', 'word']를 리턴해야 합니다 -> " + Arrays.deepToString(result));
        result = sol.removeExtremes(new String[]{"iAmLongest", "iAmNotShortest", "iAmLongest", "long"});
        System.out.println("['iAmLongest', 'iAmNotShortest', 'iAmLongest', 'long']를 입력받은 경우, ['iAmLongest', 'iAmLongest']를 리턴해야 합니다 -> " + Arrays.deepToString(result));
        result = sol.removeExtremes(new String[]{"a", "c", "def"});
        System.out.println("['a', 'c', 'def']를 입력받은 경우, ['a']를 리턴해야 합니다 -> " + Arrays.deepToString(result));
        result = sol.removeExtremes(new String[]{});
        System.out.println("빈 배열을 입력받은 경우, null을 리턴해야 합니다 -> " + Arrays.deepToString(result));
    }

}


class Solution {
    public String[] removeExtremes(String[] arr) {
        // TODO:

    }
}
```

<br>

Test 통과시 출력문
```java
['where', 'is', 'the', 'longest', 'word']를 입력받은 경우, ['where', 'the', 'word']를 리턴해야 합니다 -> [where, the, word]
['iAmLongest', 'iAmNotShortest', 'iAmLongest', 'long']를 입력받은 경우, ['iAmLongest', 'iAmLongest']를 리턴해야 합니다 -> [iAmLongest, iAmLongest]
['a', 'c', 'def']를 입력받은 경우, ['a']를 리턴해야 합니다 -> [a]
빈 배열을 입력받은 경우, null을 리턴해야 합니다 -> null
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
    public String[] removeExtremes(String[] arr) {
        // TODO:
        // 1. 문자열 배열을 입력받아, 각 요소들의 문자열 길이를 구한다.
        // 2. 문자열 길이를 저장할 리스트를 선언한다.
        // 3. 가장 짧은 길이의 문자열과 가장 긴 길이의 문자열의 인덱스를 구한다.
        // 4. 해당 인덱스에 요소를 지운 문자열 배열을 리턴한다.
        if(arr.length == 0) return null;
        int[] lengthArr = new int[arr.length];
        int maxIndex = arr.length - 1;
        int minIndex = arr.length - 1;
        for(int i = arr.length - 1; i >= 0 ; i--){
            lengthArr[i] = arr[i].length();
            maxIndex = lengthArr[i] > lengthArr[maxIndex] ? i : maxIndex;
            minIndex = lengthArr[i] < lengthArr[minIndex] ? i : minIndex;
        }
        ArrayList<String> result = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            if(i != maxIndex && i != minIndex){
                result.add(arr[i]);
            }
        }
        return result.toArray(new String[0]);
    }
}
```
</details>

<br>

---

### CheckPoint ✅

- [x] `ArrayList` 클래스 메서드 `toArray()` 리턴 타입 ->  `Object[] `
- [x] `toArray(new String[0])` 리턴 타입 -> `String[] `
- [x] if 조건문을 `삼항 연산자(ternary operator)`로 표기하는 방법
- [x] 제거해야 할 요소가 중복이 발생할 경우 뒷 인덱스 요소를 지우는 방법 -> `for문`의 반복자를 배열의 끝부터 시작하여 나중 요소를 제거하게끔 코딩하면 해결 가능하다. 

