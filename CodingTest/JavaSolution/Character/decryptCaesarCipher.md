# 제목

### 문제 
`난이도: 🟢⚫️⚫️⚫️⚫️`

암호화된 문자열과 암호화 키를 입력받아 복호화된 문자열을 리턴해야 합니다.
카이사르 암호(Caesar cipher)는 평문(plaintext)을 암호키 secret개만큼 (오른쪽으로) 평행이동시켜 암호화 합니다. 복호화는 암호화된 문자열을 원래의 평문으로 복원하는 것을 말합니다.

<br>

### 입력

인자 1 : str

`String` 타입의 알파벳 소문자 문자열

인자 2 : secret

`int` 타입의 암호화 키

<br>

### 출력

`String` 타입을 리턴해야 합니다.

<br>

### 주의 사항

- 빈 문자열을 입력받은 경우, 빈 문자열을 리턴해야 합니다.
- 공백은 그대로 두어야 합니다.
- 입력된 문자열은 모두 소문자만 입력됩니다.

<br>

### 입출력 예시

```Java
String output = decryptCaesarCipher("khoor", 3);
System.out.println(output); // --> hello

output = decryptCaesarCipher("zruog", 3);
System.out.println(output); // --> world
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
        String test = sol.decryptCaesarCipher("khoor zruog", 3);
        System.out.println("\"khoor zruog\", 3 -> hello world : " + test);
        test = sol.decryptCaesarCipher("nzop delepd dfaazced jzf", 11);
        System.out.println("\"nzop delepd dfaazced jzf\", 11 -> code states supports you : " + test);
    }

}


class Solution {
    public String decryptCaesarCipher(String str, int secret) {
        // TODO:

    }
}
```

<br>

Test 통과시 출력문
```java
"khoor zruog", 3 -> hello world : hello world
"nzop delepd dfaazced jzf", 11 -> code states supports you : code states supports you
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
    public String decryptCaesarCipher(String str, int secret) {
        // TODO:
        // 빈 문자열 - > 리턴 빈 문자열
        // 아스키 코드 'a' = 97, 'z' = 122 이다.
        // 복호화 해야하므로 아스키 코드값에 secret 값만큼 (왼쪽으로) 평행이동 시킨다.(뺄셈)
        // 이때 경계값 'a', 'z'를 넘어가는 경우 순환하도록 만들어야한다.
        String result = "";
        int dec;

        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == ' ') {
                result += " ";
                continue;
            }
            dec = str.charAt(i);
            if(dec - secret < 97) {
                dec = 123 - (97 - (dec - secret));
                result += (char)dec;
            }
            else {
                dec = dec - secret;
                result += (char)dec;
            }
        }
        return result;
    }
}    
```
</details>

<br>

---

### CheckPoint ✅

- [x] 아스키 코드에 의한 `char` - `int` 매핑
- [x] `String` + `char` -> `String`자동 형변환
- [x] `int` <-> `char` 자동 형변환
- [x] [아스키 코드 테이블](https://stepbystep1.tistory.com/10)
 