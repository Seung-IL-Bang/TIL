# 17. 세그먼트 트리(Segment Tree)

### Concept

→ 통계 트리(statistic tree)라고도 불린다. 어떤 배열의 일정 구간의 합을 구하는 것과 특정 원소의 값을 변경하는 연산들이 빈번하게 일어날 때 사용하면 유용한 자료구조이다. 원소 값의 수정이 자주 일어나기 때문에 누적합 알고리즘을 적용할 경우 매번 누적합을 다시 구해줘야 하는 비효율성이 발생한다. 따라서 세그먼트 트리 자료구조를 활용하여 구간 합 연산과 원소 값의 변경 둘 다 $O(logN)$ 의 시간 복잡도로 효율적으로 처리할 수 있게 된다.

<br>

### Structure

→ 세그먼트 트리의 리프 노드와 리프 노드가 아닌 다른 노드(=내부 노드)들은 다음과 같은 의미를 가진다.

- 리프 노드(leaf node): 배열의 수 그 자체
- 내부 노드(interval node): 왼쪽 자식과 오른쪽 자식의 합

<br>

### 구현

→ 세그먼트 트리는 `Full Binary Tree` 형태를 가진다. 따라서 리프 노드를 제외한 모든 노드는 항상 2개의 자식을 가진다. **만약 $N$ 이 2의 제곱꼴인 경우**에는 `Perfect Binary Tree`가 된다.

- 리프 노드가 $N$ 개인 ~~Full Binary~~ Tree에는 내부 노드가 $N - 1$ 개 있다. 따라서 필요한 노드의 총 개수는 $2N - 1$ 개 이다.
- $N$ 이 2의 제곱꼴이 아닌 경우에(= Full Binary Tree) 높이는 $H = logN$
- 배열을 이용하더라도 공간을 크게 낭비하지 않기 때문에 정보를 저장할 세그먼트 트리를 배열로 구현한다.
- 깊이가 가장 깊은 리프 노드와 가장 깊지 않은 리프 노드의 깊이 차이는 1 이하 이다.
- Perfect Binary Tree의 경우 높이가 $H$ 일 때, 노드의 개수는 배열의 크기가 되고,
    
    이 값은 $2^{H+1} - 1$ 와 같다.
    

```java
// a: 배열 A
// tree: 세그먼트 트리
// node: 노드 번호
// node에 저장되어 있는 합의 범위가 start - end
void init(long[] a, long[] tree, int node, int start, int end) {
    if (start == end) {
        tree[node] = a[start];
    } else {
        init(a, tree, node*2, start, (start+end)/2);
        init(a, tree, node*2+1, (start+end)/2+1, end);
        tree[node] = tree[node*2] + tree[node*2+1];
    }
}
```

- `start == end` 는 리프 노드인 경우이다. 리프 노드는 배열의 본래의 값을 저장해야 하기 때문에 `tree[node] = a[start]` 가 된다.
- 내부 노드의 왼쪽 자식은 $node * 2$ 이고, 오른쪽 자식은 $node * 2 + 1$ 이다.
- 노드의 저장된 구간이 [start, end] 라면, 왼쪽 자식은 [start, (start + end) / 2], 오른쪽 자식은 [(start + end) / 2 + 1, end] 가 저장된 구간이다.
- `tree[node]` 에 저장된 값을 구하려면 왼쪽 자식에 저장된 값 `tree[node * 2]` , 오른쪽 자식에 저장된 값 `tree[node * 2 + 1]` 을 먼저 구해야 한다. 따라서 재귀를 통해 각각의 값을 먼저 구한다.

<br>

### 구간 합 구하기

→ 구간 `left, right` 가 주어졌을 때, 구간 합을 구하려면 트리를 루트부터 순회하면서 각 노드에 저장된 구간의 정보와 `left, right` 와의 관계를 살펴봐야 한다.  트리의 높이가 $logN$ 이기 때문에 구간 합을 구하는 시간 복잡도는 $logN$ 이다.

노드에 저장된 구간이 `[start, end]` 이고, 합을 구해야하는 구간이 `[left, right]` 라면 다음과 같이 4가지 경우로 나누어질 수 있다.

1. `[left, right]` 와 `[start, end]` 가 겹치지 않는 경우
2. `[left, right]` 가 `[start, end]` 를 완전히 포함하는 경우
3. `[start, end]` 가 `[left, right]` 를 완전히 포함하는 경우
4. `[left, right]` 가 `[start, end]` 에 걸쳐져 있는 경우 (1, 2, 3 제외한 나머지 경우)

**① 경우**

→ 1번의 경우 `if (left > end || right < start)` 로 나타낼 수 있다. 이 경우 범위를 완전히 벗어나므로 탐색을 할 필요가 없다. 따라서 `0`을 리턴하고 탐색을 종료하면 된다.

**② 경우**

→ 2번의 경우 `if (left <= start && end <= right)` 로 나타낼 수 있다. 이 경우 모든 노드가 합의 범위에 모두 포함되기 때문에 탐색을 이어나가는 것은 비효율적이다. 따라서 `tree[node]` 를 리턴해 탐색을 종료한다.

**③, ④ 경우**

→ 3, 4번의 경우에는 왼쪽 자식과 오른쪽 자식을 루트로 하는 트리에서 재귀적으로 탐색을 시작해야 한다.

```java
long query(long[] tree, int node, int start, int end, int left, int right) {
    if (left > end || right < start) {
        return 0;
    }
    if (left <= start && end <= right) {
        return tree[node];
    }
    long lsum = query(tree, node*2, start, (start+end)/2, left, right);
    long rsum = query(tree, node*2+1, (start+end)/2+1, end, left, right);
    return lsum+rsum;
}
```

<br>

### 수 변경하기

→ `index` 번째 수를 변경하는 경우, index 번째 노드를 포함하는 구간 합만 변경해주면 된다. 원래 index 번째 수가 a[index] 였고, 바뀐 수가 `val` 이라면, 합은 `val - a[index]` 만큼 변하게 된다. 수 변경은 다음과 같이 2가지 경우가 있다. 수 변경하기의 시간 복잡도는 $logN$ 이다.

1. `[start, end]` 에 `index` 가 포함되는 경우
2. `[start, end]` 에 `index` 가 포함되지 않는 경우

1번 경우에만 재귀 호출을 진행하고, 2번 경우에는 그 노드의 모든 자식도 index 번째를 포함하지 않으니 재귀 호출을 중단하면 된다.

```java
void update_tree(long[] tree, int node, int start, int end, int index, long diff) {
    if (index < start || index > end) return;
    tree[node] = tree[node] + diff;
    if (start != end) {
        update_tree(tree,node*2, start, (start+end)/2, index, diff);
        update_tree(tree,node*2+1, (start+end)/2+1, end, index, diff);
    }
}
void update(long[] a, long[] tree, int n, int index, long val) {
    long long diff = val - a[index];
    a[index] = val;
    update_tree(tree, 1, 0, n-1, index, diff);
}
```

`update(a, tree, index, val)` 은 index 번째를 `val` 로 변경하는 코드이다. 이 함수는 index 번째를 포함하는 모든 노드의 합에 `diff` 를 더해서 트리를 갱신하는 `update_tree(tree, node, start, end, index, diff)` 를 호출하는 소스이다.

아래는 다른 방법으로 ‘수 변경하기’를 구현한 코드이다.

```java
void update(long[] a, long[] tree, int node, int start, int end, int index, long val) {
    if (index < start || index > end) {
        return;
    }
    if (start == end) {
        a[index] = val;
        tree[node] = val;
        return;
    }
    update(a, tree,node*2, start, (start+end)/2, index, val);
    update(a, tree,node*2+1, (start+end)/2+1, end, index, val);
    tree[node] = tree[node*2] + tree[node*2+1];
}
```

<br>

<details>
  <summary>Reference</summary>

- [세그먼트 트리 - 백준](https://book.acmicpc.net/ds/segment-tree)

- [[ 세그먼트 트리(Segment Tree) ] 개념과 구현방법 (C++)](https://yabmoons.tistory.com/431)
</details>