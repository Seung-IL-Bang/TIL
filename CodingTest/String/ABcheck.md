# ABcheck

### 문제 
`난이도: 🟢⚫️⚫️⚫️⚫️`

문자열을 입력받아 문자열 내에 아래 중 하나가 존재하는지 여부를 리턴해야 합니다.

- `'a'`로 시작해서 `'b'`로 끝나는 길이 5의 문자열
- `'b'`로 시작해서 `'a'`로 끝나는 길이 5의 문자열

<br>

### 입력
인자 1 : str
- `String` 타입의 알파벳 문자열

<br>

### 출력
`boolean` 타입을 리턴해야 합니다.

<br>

### 주의 사항
- 대소문자를 구분하지 않습니다.
- 공백도 한 글자로 취급합니다.
- 'a'와 'b'는 중복해서 등장할 수 있습니다.

<br>

### 입출력 예시

```Java
boolean output = ABCheck("lane Borrowed");
System.out.println(output); // --> true
```

---

### Test

```java
import java.util.*;

public class Test {
    public static void main(String[] args) {
        Solution sol = new Solution();
        boolean test = sol.ABCheck("");
        System.out.println("[test1] : 빈 문자열 -> false == " + test);
        test = sol.ABCheck("TgDrnjAz6kAbdEaxFkrKIsa");
        System.out.println("[test2] : TgDrnjAz6kAbdEaxFkrKIsa -> false == " + test);
        test = sol.ABCheck("HK9J6YjrAcMbq8qKrbS3EaPRT");
        System.out.println("[test3] : HK9J6YjrAcMbq8qKrbS3EaPRT -> ture == " + test);
        test = sol.ABCheck("lane borrowed");
        System.out.println("[test4] : lane borrowed -> true == " + test);
        test = sol.ABCheck("aMAJ7sBrO4CyysuoHFrgGTX");
        System.out.println("[test5] : aMAJ7sBrO4CyysuoHFrgGTX -> true == " + test);
        test = sol.ABCheck("vsZYkn LOfgbAabbHYw4tO1O");
        System.out.println("[test6] : vsZYkn LOfgbAabbHYw4tO1O -> false == " + test);
        test = sol.ABCheck("c");
        System.out.println("[test7] : c -> false == " + test);
        test = sol.ABCheck("aaaaaccccbbbbb");
        System.out.println("[test8] : aaaaaccccbbbbb -> false == " + test);

    }

}


class Solution {
    public boolean ABCheck(String str) {
        // TODO:

    }
}



```

<br>

Test 통과시 출력문
```java
[test1] : 빈 문자열 -> false == false
[test2] : TgDrnjAz6kAbdEaxFkrKIsa -> false == false
[test3] : HK9J6YjrAcMbq8qKrbS3EaPRT -> ture == true
[test4] : lane borrowed -> true == true
[test5] : aMAJ7sBrO4CyysuoHFrgGTX -> true == true
[test6] : vsZYkn LOfgbAabbHYw4tO1O -> false == false
[test7] : c -> false == false
[test8] : aaaaaccccbbbbb -> false == false
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
    public boolean ABCheck(String str) {
        // TODO:
        // 대소문자 구분을 하지 않기 위해 문자열 전부를 소문자로 치환
        str = str.toLowerCase();
        // 1. 문자열 0 번째 인덱스의 요소와 마지막 요소의 값들이 각각 조건에 부합하는지 확인한다.
        String[] arr = str.split("");
        for(int i=0; i < arr.length - 4; i++){
            if(arr[i].equals("a")  && arr[i+4].equals("b")){ // arr[i] == "a" && arr[i+4] == "b" 금지!
                return true;
            }
            else if(arr[i].equals("b") && arr[i+4].equals("a")){ // arr[i] == "b" && arr[i+4] == "a" 금지!
                return true;
            }
        }
        return false;
        // 2. 문자열 길이가 5인 경우에 return true;
    }
}
```
</details>

<br>

---

### CheckPoint ✅

- [x] 문자열 비교 시 `==` & `equals()` 차이점 👉 [레퍼런스](https://go-coding.tistory.com/35) 
- [x] String 클래스 메서드 `split()` -> `sep : default 공백(" ")`
- [x] 대소문자 구분 안할 경우 -> 대문자 또는 소문자로 전부 치환하여 문제 풀기 🍯 
- [x] 반복문안에서 배열 요소에 접근 시 `ArrayIndexOutOfBoundsException` 발생하지 않도록 범위 유의하기 ☠️

