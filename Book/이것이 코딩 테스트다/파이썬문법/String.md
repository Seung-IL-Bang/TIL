# 코딩 테스트를 위한 파이썬 문법

## 문자열 자료형(String)

- [문자열 초기화](#문자열-초기화) 
- [이스케이프 문자](#이스케이프-문자)
- [문자열 연산](#문자열-연산)

---

### 문자열 초기화

문자열 변수를 초기화할 때는 `큰따옴표(")`나 `작은따옴표(')`를 사용한다.

```python
data = "Hello World"
print(data) # Hello World

data = 'Hello World'
print(data) # Hello World
```

### 이스케이프 문자

코드를 작성할 때 문자열 안에 큰따옴표나 작은따옴표가 포함되어야 하는 경우가 있다. 이럴 때 `백슬래시(\)`를 사용하면, 큰따옴표나 작은따옴표를 문자열에 포함시킬 수 있다. 참고로 문자열을 큰따옴표로 구성하는 경우, 내부적으로 작음따옴표를 구성할 수 있다. 반대로 문자열을 작은따옴표로 구성하는 경우, 내부적으로 큰따옴표를 구성할 수 있다.

```python
data = "'Hello World'"
print(data) # 'Hello World

data = '"Hello World"'
print(data) # "Hello World"

data = "\"Hello World\""
print(data) # "Hello World"
```

### 문자열 연산

파이썬은 문자열에 대한 연산도 지원한다.

1. `덧셈(+)`을 이용하면 문자열들이 더해져서 *단순히 연결된다.*

```python
# 덧셈(+)을 이용한 문자열 더하기
a = "Hello"
b = "World"

print(a + " " + b) # Hello World
```

2. `쉼표(,)`을 이용하면 문자열 사이에 *공백이 추가되어 더해진다.*

```python
# 쉼표(,)를 이용한 문자열 더하기
a = "Hello"
b = "World"

print(a, b) # Hello World
```

3. `양의 정수와 곱`하는 경우, 문자열이 *양수 값만큼 여러 번 덧셈 된다.*

```python
a = "String"

print(a) # StringStringString
```

4. 파이썬의 `문자열`은 내부적으로 리스트와 같이 처리된다. 문자열은 여러 개의 문자가 합쳐진 리스트로 볼 수 있다. 따라서 문자열 데이터에 대해서도 마찬가지로 `인덱싱`과 `슬라이싱`이 가능하다.

```python
a = "ABCDEF"

print(a[2:4]) # CD
```