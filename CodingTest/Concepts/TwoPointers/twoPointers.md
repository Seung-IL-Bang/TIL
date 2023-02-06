# 투 포인터(Two Pointers)

### Concept

→ 투 포인터 알고리즘은 리스트에 순차적으로 접근해야 할 때, 2개의 점의 위치를 기록하면서 처리하는 알고리즘을 의미한다. 즉, 리스트에 담긴 데이터에 순차적으로 접근해야 할 때 ‘시작점’과 ‘끝점’ 2개의 점으로 접근할 데이터의 범위를 표현할 수도 있다.

<br>

### 특징

→ 투 포인터 알고리즘의 특징은 2개의 변수를 이용해 리스트 상의 위치를 기록한다는 점이다. 그리고 구현 가능한 방식이 매우 많다.

<br>

### 투 포인터 예시

1. Specific Sum 
    
    : 정수 배열이 주어지면 특정 합을 가지는 부분 연속 수열을 찾는다.
    
2. Remove Duplicates from Sorted Array
    
    : 정렬된 배열에서 중복을 제거할 수 있다.
    
3. Longest Substring Without Repeating Characters
    
    : 문자열이 주어졌을 때 반복되는 문자가 없는 가장 긴 하위 문자열의 길이를 찾을 수 있다.
    
4. union of two sorted lists → (Merge Sort 에서 사용됨)
    
    : 두 개의 정렬된 배열에 각 포인터를 두어 서로 크기를 비교해 가며 정렬된 합집합을 구한다.
    

<br>

**ex. 특정 합을 가지는 부분 연속 수열 찾기**    

```python
n = 5 # 데이터 개수
m = 5 # 찾고자 하는 부분 합 
data = [1, 2, 3, 4, 5] # 전체 수열

count = 0
interval_sum = 0
end = 0

# start를 차례대로 증가시키며 반복
for start in range(n):
	# end를 가능한 만큼 이동시키기
  while interval_sum < m and end < n:
    interval_sum += data[end]
    end += 1
	# 부분합이 m일 때 카운팅
  if interval_sum == m :
    count += 1
  interval_sum -= data[start]

print(count) # 3
```

💡 위 문제를 `투 포인터` 알고리즘으로 해결 가능한 이유는 시작점을 오른쪽으로 이동시키면 항상 합이 감소하고, 끝점을 오른쪽으로 이동시키면 항상 합이 증가하기 때문이다. 즉, 리스트 내 원소에 음수 데이터가 포함되어 있지 않기 때문에 투 포인터 알고리즘으로 해결 가능한 것이다.

<br>

**ex. 정렬되어 있는 두 리스트의 합집합 구하기**

```python
# 사전에 정렬된 리스트 A와 B 선언
n, m = 3, 4
a = [1, 3, 5]
b = [2, 4, 6, 8]

# 리스트 A와 B의 모든 원소를 담을 수 있는 크기의 결과 리스트 초기화
result = [0] * (n + m)
i = 0
j = 0
k = 0

# 모든 원소가 결과 리스트에 담길 때까지 반복
while i < n or j < m:
	# 리스트 B의 모든 원소가 처리되었거나, 리스트 A의 원소가 더 작을 때
	if j >= m or (i < n and a[i] <= b[j]):
		# 리스트 A의 원소를 결과 리스트로 옮기기
		result[k] = a[i]
		i += 1
	# 리스트 A의 모든 원소가 처리되었거나, 리스트 B의 원소가 더 작을 때
	else:
		# 리스트 B의 원소를 결과 리스트로 옮기기
		result[k] = b[j]
		j += 1
	k += 1

# 결과 리스트 출력
for i in result:
	print(i, end=' ') # 1 2 3 4 5 6 8
```