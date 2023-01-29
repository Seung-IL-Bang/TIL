# 5. 그래프 탐색 BFS(Breadth First Search)

### Concepts

→ BFS 알고리즘은 ‘너비 우선 탐색’ 이다. 즉, 가까운 노드부터 탐색하는 알고리즘이다. DFS는 최대한 멀리 있는 노드를 우선으로 탐색하는 방식이지만, BFS는 정반대이다. BFS 구현은 선입선출(FIFO) 방식인 큐(Queue) 자료구조를 이용하는 것이 정석이다.

<br>

### Algorithm

1. 탐색 시작 노드를 쿠에 삽입하고 방문 처리를 한다.
2. 큐에서 노드를 꺼내 해당 노드의 인접 노드 중에서 방문하지 않은 노드를 **모두** 큐에 삽입하고 방문 처리를 한다.
3. 2번의 과정을 더 이상 수행할 수 없을 때까지 반복한다.

<br>

### 시간 복잡도

→ 탐색을 수행하는 데 있어 데이터의 개수가 N일 때, $O(N)$ 의 시간이 소요된다. **일반적인 경우 BFS가 DFS보다 조금 더 빠르게 동작한다.**

<br>

### 구현

→ BFS는 큐 자료구조에 기초하여 구현이 간단하다. 실제로 구현함에 있어 deque 라이브러리를 사용하는 것이 좋다.

```kotlin
class BFS {
    fun bfs(root: Node) {
        val queue = LinkedList<Node>()
        root.visited = true
        queue.add(root)
        
        while (!queue.isEmpty()) {
            val currentNode = queue.remove()
            print(currentNode.data + " ")

            for (node in currentNode.adjacentNodes) {
                if (!node.visited) {
                    node.visited = true
                    queue.add(node)
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
    
    BFS().bfs(node1)
}
```