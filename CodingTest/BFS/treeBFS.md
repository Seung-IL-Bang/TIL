# 제목

### 문제 
`난이도: 🟢🟢⚫️⚫️⚫️`

임의의 tree를 구성하는 노드 중 하나의 Node 객체를 입력받아, 해당 노드를 시작으로 너비 우선 탐색(BFS, Breadth First Search)을 합니다. 이 때, 탐색되는 순서대로 노드의 값이 저장된 배열을 리턴해야 합니다.



<br>

### 입력

인자 1 : node

'value', 'children' 속성을 갖는 객체 (Solution.tree)
'node.value'는 String 타입
'node.children'은 Solution.tree을 요소로 갖는 ArrayList

<br>

### 출력

ArrayList<String> 타입을 리턴해야 합니다.

<br>

### 주의 사항

생성자 함수(Node)와 메소드(addChild)는 변경하지 않아야 합니다.

<br>

### 입출력 예시

```Java
Solution.tree root = new Solution.tree("1");
Solution.tree rootChild1 = test.addChildNode(new Solution.tree("2"));
Solution.tree rootChild2 = test.addChildNode(new Solution.tree("3"));
Solution.tree leaf1 = rootChild1.addChildNode(new Solution.tree("4"));
Solution.tree leaf2 = rootChild1.addChildNode(new Solution.tree("5"));
ArrayList<String> output = bfs(root);
System.out.println(output); // --> ["1", "2", "3", "4", "5"]

leaf1.addChildNode(new Solution.tree("6"));
rootChild2.addChildNode(new Solution.tree("7"));
output = bfs(root);
System.out.println(output); // --> ["1", "2", "3", "4", "5", "7", "6"]
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

        Solution.tree root = new Solution.tree("1");
        Solution.tree rootChild1 = root.addChildNode(new Solution.tree("2"));
        Solution.tree rootChild2 = root.addChildNode(new Solution.tree("3"));
        Solution.tree leaf1 = rootChild1.addChildNode(new Solution.tree("4"));
        Solution.tree leaf2 = rootChild1.addChildNode(new Solution.tree("5"));

        System.out.println(solution.bfs(root).toString());

        leaf1.addChildNode(new Solution.tree("6"));
        leaf2.addChildNode(new Solution.tree("7"));
        leaf2.addChildNode(new Solution.tree("8"));
        rootChild2.addChildNode(new Solution.tree("9"));


        System.out.println(solution.bfs(root).toString());
    }
}

class Solution {
    public ArrayList<String> bfs(tree node) {
        // TODO:

    }

    //아래 클래스의 내용은 수정하지 말아야 합니다.
    public static class tree {
        private String value;
        private ArrayList<tree> children;

        public tree(String data) {
            this.value = data;
            this.children = null;
        }

        public tree addChildNode(tree node) {
            if(children == null) children = new ArrayList<>();
            children.add(node);
            return children.get(children.size() - 1);
        }

        public String getValue() {      //현재 노드의 데이터를 반환
            return value;
        }

        public ArrayList<tree> getChildrenNode() {
            return children;
        }
    }
}

```

<br>

Test 통과시 출력문
```java
[1, 2, 3, 4, 5]
[1, 2, 3, 4, 5, 9, 6, 7, 8]
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
public class Solution { 
	public ArrayList<String> bfs(tree node) {
    // TODO:
    Queue<tree> queue = new LinkedList<>();
    ArrayList<String> result = new ArrayList<>();
    queue.add(node);
    while(queue.size() > 0) {
      tree curNode = queue.poll();

      result.add(curNode.getValue());

      if(curNode.getChildrenNode() != null) {
        queue.addAll(curNode.getChildrenNode());
      }
    }

    return result;
	} 

	//아래 클래스의 내용은 수정하지 말아야 합니다.
	public static class tree {
    private String value;
    private ArrayList<tree> children;

    public tree(String data) {
      this.value = data;
      this.children = null;
    }

    public tree addChildNode(tree node) {
      if(children == null) children = new ArrayList<>();
      children.add(node);
      return children.get(children.size() - 1);
    }

    public String getValue() {      //현재 노드의 데이터를 반환
      return value;
    }

    public ArrayList<tree> getChildrenNode() {
      return children;
    }
  }
}
```
</details>

<br>

---

### CheckPoint ✅

- [x] BFS 개념
- [x] Queue 선언 방법 
- [x] Queue 메서드 `poll`, `add`, `offer`
- [x] ArrayList 메서드 `addAll`  
 