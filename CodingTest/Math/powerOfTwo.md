# reverseArr

### 문제 
`난이도: 🟢⚫️⚫️⚫️⚫️`
수를 입력받아 2의 거듭제곱인지 여부를 리턴해야 합니다.

<br>

### 입력
인자 1 : num
- `long` 타입의 정수 (num >= 1)
<br>

### 출력
`boolean` 타입을 리턴해야 합니다.

<br>

### 주의 사항
- 반복문(while)문을 사용해야 합니다.
- 2의 0승은 1입니다.
- `Math.log` 사용은 금지됩니다.

<br>

### 입출력 예시

```Java
boolean output1 = powerOfTwo(16);
System.out.println(output1); // true
boolean output2 = powerOfTwo(22);
System.out.println(output2); // false
```

---

### Test

```java
import java.util.*;

public class Test {
    public static void main(String[] args){
        Solution solution = new Solution();

        System.out.printf("1을 입력 받은 경우 true를 리턴해야 합니다. Test -> %b\n",solution.powerOfTwo(1));
        System.out.printf("32을 입력 받은 경우 true를 리턴해야 합니다. Test -> %b\n",solution.powerOfTwo(32));
        System.out.printf("100을 입력 받은 경우 false를 리턴해야 합니다. Test -> %b\n",solution.powerOfTwo(100));
        System.out.printf("997을 입력 받은 경우 false를 리턴해야 합니다. Test -> %b\n",solution.powerOfTwo(997));
    }
}

class Solution{
    public boolean powerOfTwo(long num) {
        // ToDo...
    }
}
```

<br>

Test 통과시 출력문
```java
1을 입력 받은 경우 true를 리턴해야 합니다. Test -> true
32을 입력 받은 경우 true를 리턴해야 합니다. Test -> true
100을 입력 받은 경우 false를 리턴해야 합니다. Test -> false
997을 입력 받은 경우 false를 리턴해야 합니다. Test -> false
```

<br>

<details>
    <summary>ToDo ⭕️</summary>

- [x] Test Clear!
- [x] CheckPoint 작성!
- [ ] 다시 풀어보기!

</details>

<br>

<details>
    <summary>Solution</summary>

```java
public class Solution { 
	public boolean powerOfTwo(long num) {
    // TODO:
    int i = 0;
    while(num >= Math.pow(2,i)){
      if(num == Math.pow(2,i)){
        return true;
      }
      i++;
    }
    return false;
	} 
}
```
</details>

<br>

---

### CheckPoint ✅

- [x] Math.pow() 사용법
- [x] 2의 거듭제곱 개념 

