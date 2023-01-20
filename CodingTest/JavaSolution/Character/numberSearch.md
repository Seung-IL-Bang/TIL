# numberSearch

### 문제 
`난이도: 🟢⚫️⚫️⚫️⚫️`

문자열을 입력받아 문자열에서 숫자를 모두 찾아 더한 뒤에 해당 값을 (숫자와 공백을 제외한 나머지) 문자열의 길이로 나눈 값을 정수로 반올림하여 리턴해야 합니다.

<br>

### 입력

인자 1 : str

`String` 타입의 문자열

<br>

### 출력

`int` 타입을 리턴해야 합니다 (0 이상의 정수)

<br>

### 주의 사항

- 빈 문자열을 입력받은 경우, 0을 리턴해야 합니다.
- 숫자(digit)는 연속해서 등장하지 않습니다.

<br>

### 입출력 예시

```Java
int output = numberSearch("Hello6 ");
System.out.println(output); // --> 1

output = numberSearch("Hello6 9World 2,");
System.out.println(output); // --> 2

output = numberSearch("Hello6 9World 2, Nic8e D7ay!");
System.out.println(output); // --> 2
```

<br>

### 힌트 

- 주어진 문자(길이 1의 문자열)이 숫자(digit)인지 판단하는 방법은 여러 가지 입니다.
- 그 중 하나는 해당 문자가 숫자들의 집합(문자열 또는 배열)에 속하는 지를 판단하는 것입니다.
- 이와 관련해서 `Java String contains, Java String indexOf`를 검색해 봅니다.

---

### Test

- [x] 1 회 Clear
- [ ] 2 

```java
import java.util.*;

public class Test {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int result = sol.numberSearch("YlQO uT9");
        System.out.println("\"YlQO uT9\"" + " is 2 == " + result);
        result = sol.numberSearch("8ad");
        System.out.println("\"8ad\"" + " is 4 == " + result);
        result = sol.numberSearch("Hello6 9World 2, Nic8e D7ay!");
        System.out.println("\"Hello6 9World 2, Nic8e D7ay!\"" + " is 2 == " + result);
    }

}


class Solution {
    public int numberSearch(String str) {
        // TODO:

    }
}



```

<br>

Test 통과시 출력문
```java
"YlQO uT9" is 2 == 2
"8ad" is 4 == 4
"Hello6 9World 2, Nic8e D7ay!" is 2 == 2
```

<br>

<details>
    <summary>ToDo ❌</summary>

- [ ] Test Clear!
- [ ] CheckPoint 작성! 
</details>

<br>

<details>
    <summary>Solution</summary>

```java
class Solution {
    public int numberSearch(String str) {
        // TODO:
        if (str.length() == 0) return 0;
        int sum = 0;
        int length = str.length();
        ArrayList<Integer> list = new ArrayList<>();
        // 문자열의 각 문자마다 숫자인지 판별
        for(int i=0; i < str.length(); i++){
            if(Character.isDigit(str.charAt(i))){
                list.add(str.charAt(i) - '0');
                length -= 1;
                // 숫자인 경우 숫자 리스트에 추가
            }
            else if(str.charAt(i) == ' '){
                length -= 1;
            }
        }
        // 숫자 리스트의 있는 모든 숫자를 더한다
        for(int elem : list) {
            sum += elem;
        }
        // 합을 문자열의 길이로 나눈다.
        // 나눈 값을 정수로 반올림 한다.
        return (int)Math.round((double)sum / length);
    }
}    
```
</details>

<br>

---

### CheckPoint ✅

- [x] `Character.isDigit(char)` 문자 wrapper 클래스 메서드 : 해당 문자(char)가 숫자 리터럴인지 판별(boolean)
- [x] `int / int` -> `int` & `int / float` -> `float`
- [x] `char` to `int` : `char - '0'`
- [x] `Math.round(float) : 반올림` Cf. `floor : 내림`, `ceil : 올림`
 