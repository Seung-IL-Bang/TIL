# `FloydWarshall`

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