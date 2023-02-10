# `BellmanFord`

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