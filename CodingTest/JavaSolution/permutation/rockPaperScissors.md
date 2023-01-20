# reverseArr

### 문제 
`난이도: 🟢🟢🟢⚫️⚫️`

가위바위보 게임은 2인 이상의 사람이 동시에 '가위, 바위, 보'를 외치고 동시에 가위, 바위 또는 보 중에서 한 가지를 의미하는 손 모양을 내밀어 승부를 결정짓는 게임입니다. 세 판의 가위바위보 게임을 할 경우, 한 사람은 세 번의 선택(예. 가위, 가위, 보)을 할 수 있습니다. 입력받은 rounds만큼의 선택으로 가능한 모든 경우의 수를 구하는 함수를 작성합니다.

<br>

### 입력

`int`타입의 게임 횟수 rounds

<br>

### 출력
- ArrayList<String[]>타입을 리턴해야 합니다.
- ArrayList가 담고있는 배열은 전체 경우의 수 중 한 가지 경우(총 세 번의 선택)를 의미하는 배열입니다.
- String[]은 'rock', 'paper', 'scissors' 중 한 가지 이상을 요소로 갖는 배열입니다.

<br>

### 주의 사항
- 최종적으로 리턴되는 배열의 순서는 가중치 적용 정렬(Weighted Sort)을 따릅니다.
- 중요도는 'rock', 'paper', 'scissors' 순으로 높습니다.
- 쉽게 생각해 올림픽 순위 결정 방식을 참고하면 됩니다.
- 금메달('rock')이 은메달('paper')보다 우선하고, 은메달('paper')이 동메달('scissors')보다 우선합니다.

<br>

### 입출력 예시

```Java
ArrayList<String[]> output = rockPaperScissors(5);

System.out.println(output);
/*
    [
      ["rock", "rock", "rock", "rock", "rock"],
      ["rock", "rock", , "rock", "rock", "paper"],
      ["rock", "rock", , "rock", "rock", "scissors"],
      ["rock", "rock", "rock", "paper", "rock"],
      ["rock", "rock", "rock", "paper", "paper"],
      ["rock", "rock", "rock", "paper", "scissors"],
      ["rock", "rock", "rock", "scissors", "rock"],
      // ...etc ...
    ]
  */
```

---

### Test
- [x] 1회 clear! 
- [ ] 2회 

```java
import java.util.*;

public class Test {
    public static void main(String[] args) {
        Solution sol = new Solution();
        ArrayList<String[]> test = sol.rockPaperScissors(2);
        System.out.println(Arrays.deepToString(test.toArray()));
        System.out.println(test.size());
    }
}



class Solution {
    public ArrayList<String[]> rockPaperScissors(int rounds) {
        // TODO:

    }
}

```

<br>

Test 통과시 출력문
```java
[[rock, rock], [rock, paper], [rock, scissors], [paper, rock], [paper, paper], [paper, scissors], [scissors, rock], [scissors, paper], [scissors, scissors]]
9

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
    public ArrayList<String[]> rockPaperScissors(int rounds) {
        // TODO:
        ArrayList<String[]> result = new ArrayList<>();
        int temp = rounds;
        return permutation(temp, rounds, new String[rounds], result);

    }

    String[] rps = new String[]{"rock", "paper", "scissors"};

    public ArrayList<String[]> permutation(int temp, int rounds, String[] arr, ArrayList<String[]> list){
        // base case
        if(rounds == 0){
            list.add(arr);
            return list;
        }
        // arr에 rounds 횟수만큼 선택한 경우 List에 추가
        // recursive case
        else{
            for(int i =0; i < rps.length; i++){
                arr[temp - rounds] = rps[i];
                if(rounds == 1) {
                    list = permutation(temp, 0, arr.clone(), list);
                }
                else{
                    list = permutation(temp,rounds - 1, arr.clone(), list);

                }
            }
        }
        // arr에 rounds 횟수만큼 선택되지 않은 경우 arr에 계속 rps 중에서 계속 추가;
        return list;
    }
}
```
</details>

<br>

---

### CheckPoint ✅

- [x] Array 클래스 메서드 `arr.clone()`
- [x] 재귀 호출 시 전달 매개변수 -> `deep copy`
- [x] `Arrays.deepToString(Object[])`  -> 모든 요소들을 문자열로 출력 ! 주소값 출력 ❌ 
- [x] `ArrayList` 클래스 메서드 `arrlist.toArray()` 