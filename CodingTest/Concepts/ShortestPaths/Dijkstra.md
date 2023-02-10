# `Dijkstra`

→ 다익스트라(데이크스트라) 알고리즘은 그래프 내의 **모든 다른 노드로부터의 최단 거리를 찾기 위한 그래프 이론 알고리즘**이다. 다른 방법들과 비교하여 그 **효율성 면에서 뛰어나다.** 단일-출발 최단 경로 문제이며, 단일 노드에서 출발하여 그래프 내의 모든 다른 노드들에 도착하는 가장 짧은 경로들을 찾는 문제이다. 단, 가중치에 음수가 존재하는 경우 다익스트라 알고리즘을 사용할 수 없다. 다익스트라 알고리즘은 그리디 알고리즘으로도 분류된다. 매번 **가장 가중치가 낮은 노드** 를 선택하기 때문이다.

```kotlin
class Dijkstra {
    private val nodes: MutableList<Node> = mutableListOf()
    private val edges: MutableList<Edge> = mutableListOf()
    private val unvisitedNodes: MutableList<Node> = mutableListOf()

    data class Node(val name: String, var distance: Int = Int.MAX_VALUE)

    data class Edge(val source: Node, val destination: Node, val weight: Int)

    fun addNode(name: String) = nodes.add(Node(name).also { unvisitedNodes.add(it) })

    fun addEdge(sourceName: String, destinationName: String, weight: Int) {
        val source = nodes.find { it.name == sourceName }!!
        val destination = nodes.find { it.name == destinationName }!!
        edges.add(Edge(source, destination, weight))
    }

    fun findShortestPath(startNodeName: String) {
        nodes.find { it.name == startNodeName }!!.apply { distance = 0 }
        while (unvisitedNodes.isNotEmpty()) {
            val node = unvisitedNodes.minByOrNull { it.distance }
            unvisitedNodes.remove(node)
            for (edge in edges) {
                if (edge.source == node) {
                    val newDistance = node.distance + edge.weight
                    if (newDistance < edge.destination.distance) {
                        edge.destination.distance = newDistance
                    }
                }
            }
        }
    }

    fun getNodes(): MutableList<Node> {
        return this.nodes
    }
}

fun main() {
    val dijkstra = Dijkstra()
    dijkstra.addNode("A")
    dijkstra.addNode("B")
    dijkstra.addNode("C")
    dijkstra.addNode("D")
    dijkstra.addEdge("A", "B", 10)
    dijkstra.addEdge("A", "C", 20)
    dijkstra.addEdge("B", "D", 25)
    dijkstra.addEdge("C", "D", 5)
    dijkstra.findShortestPath("A")
    val nodes = dijkstra.getNodes()
    for (node in nodes) {
        println("A to ${node.name} has distance ${node.distance}")
    }
}

// A to A has distance 0
// A to B has distance 10
// A to C has distance 20
// A to D has distance 25
```

위 코드에서 A to D 경로는 두 가지가 존재하는데, 그 중에서 알고리즘을 통해 최단 경로를 구하게 된다.

아래 코드는 [백준 1753번 문제](https://www.acmicpc.net/problem/1753) 풀이에 사용한 다익스트라 알고리즘을 나타낸 것이다.
```kotlin
import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {

    val bw = System.out.bufferedWriter()
    val st = StringTokenizer(readLine())
    val V = st.nextToken().toInt()
    val E = st.nextToken().toInt()
    val K = readLine().toInt()

    val graph = Array<MutableList<Pair<Int, Int>>>(V + 1) { mutableListOf() }
    val visited = BooleanArray(V + 1)
    val distances = IntArray(V + 1) { Int.MAX_VALUE / 2 } // overflow 방지

    repeat(E) {
        val token = StringTokenizer(readLine())
        val u = token.nextToken().toInt()
        val v = token.nextToken().toInt()
        val w = token.nextToken().toInt()

        graph[u].add(Pair(v, w))
    }

    // 방문하지 않은 노드 중에서, 가장 최단 거리가 짧은 노드의 번호 반환
    fun getShortestNode(): Int {
        var minValue = Int.MAX_VALUE / 2
        var index = 0
        for (i in 1..V) {
            if (distances[i] < minValue && !visited[i]) {
                minValue = distances[i]
                index = i
            }
        }
        return index
    }

    fun dijkstra(start: Int) {
        // 시작 노드에 대해서 초기화
        distances[start] = 0
        visited[start] = true
        for (i in graph[start]) {
            // first == to, second == weight
            val currentDistance = distances[i.first]
            if (currentDistance == Int.MAX_VALUE / 2 || currentDistance > i.second) {
                // 서로 다른 두 노드 사이에 여러 간선이 존재할 경우 가장 짧은 비용을 저장한다.
                distances[i.first] = i.second
            }
        }
        // 시작 노드를 제외한 전체 V - 1 개의 노드에 대해 반복
        repeat(V - 1) {
            // 현재 최단 거리가 가장 짧은 노드를 꺼내서, 방문 처리
            val now = getShortestNode()
            visited[now] = true
            // 현재 노드와 연결된 다른 노드를 확인
            for (i in graph[now]) {
                val cost = distances[now] + i.second
                // 현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우
                if (cost < distances[i.first]) {
                    distances[i.first] = cost
                }
            }
        }
    }

    dijkstra(K)

    for (i in 1..V) {
        if (distances[i] == Int.MAX_VALUE / 2) {
            bw.write("INF\n")
        } else {
            bw.write("${distances[i]}\n")
        }
    }
    bw.flush()
    bw.close()
}
```