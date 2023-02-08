# 최단 경로(Shortest Path)

## 그래프 이론에서 최단 경로 알고리즘

그래프 이론은 연결된 노드 사이의 거리를 찾기 위해 여러 종류의 최단 거리 알고리즘을 사용합니다. 이러한 알고리즘의 일반적인 유형으로는 다익스트라 알고리즘, 벨만-포드 알고리즘, 플로이드-와샬 알고리즘 등이 있습니다. 다익스트라 알고리즘은 모든 노드로부터 출발하여 가장 짧은 거리를 찾는 방법입니다. 벨만-포드 알고리즘은 하나의 노드에서 다른 노드로 가는 최단 거리를 찾는 방법입니다. 플로이드-와샬 알고리즘은 모든 노드 사이의 최단 거리를 찾는 방법입니다.

💡 [Reference](https://ko.wikipedia.org/wiki/%EC%B5%9C%EB%8B%A8_%EA%B2%BD%EB%A1%9C_%EB%AC%B8%EC%A0%9C)

<br>

### `Dijkstra`

→ 다익스트라(데이크스트라) 알고리즘은 그래프 내의 **모든 다른 노드로부터의 최단 거리를 찾기 위한 그래프 이론 알고리즘**이다. 다른 방법들과 비교하여 그 **효율성 면에서 뛰어나다.** 단일-출발 최단 경로 문제이며, 단일 노드에서 출발하여 그래프 내의 모든 다른 노드들에 도착하는 가장 짧은 경로들을 찾는 문제이다. 단, 가중치에 음수가 존재하는 경우 다익스트라 알고리즘을 사용할 수 없다.

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

<br>

### `BellmanFord`

벨만-포드 알고리즘은 가중 유향 그래프에 하나의 노드에서 다른 노드로 가는 최단 거리를 찾는 그래프 이론 알고리즘이다. 이때, 거리의 **가중치가 음수일 수도 있다.** 벨만-포드 알고리즘은 다익스트라 알고리즘과 동일한 작업을 수행하지만 **다익스트라 알고리즘보다 실행 속도가 더 빠르다**. 그리고 다익스트라 알고리즘은 가중치가 음수인 경우는 처리 할 수 없으므로, 이런 경우에는 벨만-포드 알고리즘을 사용한다. 벨만-포드 알고리즘도 단일-출발 최단 경로 문제이다.

```kotlin
class BellmanFord {
    private val nodes: MutableList<Node> = mutableListOf()
    private val edges: MutableList<Edge> = mutableListOf()

    data class Node(val name: String, var distance: Int = Int.MAX_VALUE)

    data class Edge(val source: Node, val destination: Node, val weight: Int)

    fun addNode(name: String) = nodes.add(Node(name))

    fun addEdge(sourceName: String, destinationName: String, weight: Int) {
        val source = nodes.find { it.name == sourceName }!!
        val destination = nodes.find { it.name == destinationName }!!
        edges.add(Edge(source, destination, weight))
    }

    fun findShortestPath(startNodeName: String): Boolean {
        nodes.find { it.name == startNodeName }!!.apply { distance = 0 }
        for (i in 0 until nodes.size - 1) {
            for (edge in edges) {
                val newDistance = edge.source.distance + edge.weight
                if (newDistance < edge.destination.distance) {
                    edge.destination.distance = newDistance
                }
            }
        }
        for (edge in edges) {
            if (edge.source.distance + edge.weight < edge.destination.distance) {
                return false
            }
        }
        return true
    }

    fun getNodes(): MutableList<Node> {
        return this.nodes
    }
}

fun main() {
    val bellmanFord = BellmanFord()
    bellmanFord.addNode("A")
    bellmanFord.addNode("B")
    bellmanFord.addNode("C")
    bellmanFord.addEdge("A", "B", 20)
    bellmanFord.addEdge("A", "C", 30)
    bellmanFord.addEdge("B", "C", -5)
    val hasNegativeCycle = !bellmanFord.findShortestPath("A")
    if (hasNegativeCycle) {
        println("The graph contains a negative cycle.")
    } else {
        val nodes = bellmanFord.getNodes()
        for (node in nodes) {
            println("Node ${node.name} has distance ${node.distance}")
        }
    }
}

// Node A has distance 0
// Node B has distance 20
// Node C has distance 15
```

<br>

### `FloydWarshall`

플로이드-와셜 알고리즘은 모든 노드 사이의 최단 거리를 찾는 방법이다. 이 알고리즘은 노드가 여러 방향으로 연결되어 있거나 무한거리가 있을 때 특히 효과적이다. 전체-쌍 최단 경로 문제이며, 해당 알고리즘을 한 번 수행하면 **그래프 내의 모든 노드 쌍들 사이의 최단 경로를 찾을 수 있는 문제이다.** 수치적으로 의미있는 결과를 얻기 위해서, 플로이드-워셜 알고리즘은 입력에 음수 사이클이 없다고 가정한다. 반면, 음수 사이클이 존재할 경우에는 플로이드-워셜 알고리즘으로 감지할 수 있다.

```kotlin
class FloydWarshall {
    private val distances: Array<IntArray>

    init {
        val size = 5
        distances = Array(size) { IntArray(size) { Int.MAX_VALUE / 2 } }
        for (i in 0 until size) distances[i][i] = 0
    }

    fun addEdge(from: Int, to: Int, weight: Int) {
        distances[from][to] = weight
    }

    fun findShortestPaths() {
        val size = distances.size
        for (k in 0 until size) {
            for (i in 0 until size) {
                for (j in 0 until size) {
                    distances[i][j] = minOf(distances[i][j], distances[i][k] + distances[k][j])
                }
            }
        }
    }

    fun getShortestPath(from: Int, to: Int): Int {
        return distances[from][to]
    }
}

fun main() {
    val floydWarshall = FloydWarshall()
    floydWarshall.addEdge(0, 1, 3)
    floydWarshall.addEdge(0, 2, 8)
    floydWarshall.addEdge(1, 2, -2)
    floydWarshall.addEdge(2, 4, 1)
    floydWarshall.addEdge(4, 3, -4)
    floydWarshall.findShortestPaths()
    println("The shortest path from node 0 to node 3 is: ${floydWarshall.getShortestPath(0, 3)}")
}

// The shortest path from node 0 to node 3 is: -2
// The shortest path from node 0 to node 2 is: 1
```