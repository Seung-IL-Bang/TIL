# 4. 그래프 탐색  DFS(Depth First Search)

### Concepts

→ DFS는 깊이 우선 탐색이라고 부르며, 그래프에서 깊은 부분을 우선적으로 탐색하는 알고리즘이다. 특정한 경로로 탐색하다가 특정한 상황에서 최대한 깊숙이 들어가서 노드를 방문한 후, 다시 돌아가 다른 경로로 탐색하는 알고리즘이다. **DFS는 스택 자료구조를 이용한다.**

<br>

### Algorithm

1. 탐색 시작 노드를 스택에 삽입하고 방문 처리를 한다.
2. 스택의 최상단 노드에 방문하지 않은 인접 노드가 있으면 그 인접 노드를 스택에 넣고 방문 처리를 한다. 방문하지 않은 인접 노드가 없으면 스택에서 최상단 노드를 꺼낸다.
3. 2번의 과정을 더 이상 수행할 수 없을 때까지 반복한다.

<br>

### 시간 복잡도

→ DFS 탐색을 수행함에 있어서 데이터의 개수가 N개인 경우 $O(N)$ 의 시간이 소요된다.

<br>

### 구현

→ DFS는 스택 자료구조에 기초하기 때문에 구현이 간단하다. DFS는 스택을 이용하는 알고리즘이기 때문에 실제 구현은 재귀 함수를 이용했을 때 매우 간결하게 구현할 수 있다.

```kotlin
class DFS {
    fun dfs(root: Node) {
        root.visited = true
        print(root.data + " ")
        for (node in root.adjacentNodes) {
            if (!node.visited) {
                dfs(node)
            }
        }
    }
}

class Node(var data: Int, var visited: Boolean = false, var adjacentNodes: MutableList<Node>)

fun main() {
    val node1 = Node(1)
    val node2 = Node(2)
    val node3 = Node(3)
    val node4 = Node(4)
    val node5 = Node(5)
    
    node1.adjacentNodes.add(node2)
    node1.adjacentNodes.add(node3)
    node2.adjacentNodes.add(node4)
    node4.adjacentNodes.add(node5)
    
    DFS().dfs(node1)
}
```

```kotlin
class DFS { // Stack 라이브러리를 사용한 버전
    fun dfs(root: Node) {
        val stack = Stack<Node>()
        root.visited = true
        stack.push(root)

        while (!stack.isEmpty()) {
            val currentNode = stack.pop()
            print(currentNode.data + " ")

            for (node in currentNode.adjacentNodes) {
                if (!node.visited) {
                    node.visited = true
                    stack.push(node)
                }
            }
        }
    }
}

class Node(var data: Int, var visited: Boolean = false, var adjacentNodes: MutableList<Node>)

fun main() {
    val node1 = Node(1)
    val node2 = Node(2)
    val node3 = Node(3)
    val node4 = Node(4)
    val node5 = Node(5)
    
    node1.adjacentNodes.add(node2)
    node1.adjacentNodes.add(node3)
    node2.adjacentNodes.add(node4)
    node4.adjacentNodes.add(node5)
    
    DFS().dfs(node1)
}
```