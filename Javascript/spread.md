# 전개 연산자(spread) ...

`배열`에 전개 연산자를 사용하면 포함하고 있는 **모든 요소의 데이터를 전개하여 쉼표로 구분된 문자열들을 반환한다**. 또 다른 사용처는 `매개변수` 에 사용 가능하다. 전개 연산자를 적용한 매개변수를 나머지 매개변수(rest parameter) 라고 한다.

<br>

### 배열 - 전개 연산자

```javascript
const fruits = ['apple', 'banana', 'cherry']

const str = ...fruits 

console.log(str) // 'apple', 'banana', 'cherry'
```

즉 fruits[0], fruits[1], fruits[2], ... 을 쉽게 전개하도록 도와주는 연산자이다.

<br>

### rest parameter (나머지 매개변수)
함수의 매개변수를 정의할 때, 맨 끝 매개변수에 전개 연산자를 사용하면, 이 매개변수를 Rest parameter라고 부른다. 주어지는 인수에 대해 앞쪽 매개변수 개수만큼 매핑해주고 나머지 인수들은 배열의 행태로 rest parameter에게 배열로 할당해준다.

```javascript
function toObject(a, ...b) {
  return {
    a: a,
    b: b,
  }
}

const obj = toObject('apple', 'banana', 'cherry')
// a <- 'apple'
// b <- ['banana', 'cherry']
```

<br>

### 함수 매개변수 축약하기

속성과 매개변수의 이름이 같으면 `:(콜론)` 생략이 가능하다.

```javascript
// 화살표 함수와 축약형 매개변수
const toObject. = (a, ...b) => ( { a, b } )
```