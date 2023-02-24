# JS Array(배열 데이터)
여러 데이터를 순차적으로 저장한다. **[ ] 대괄호로 정의한다.**

<br>

### <사용법>

```javascript
let fruits = ['Apple', 'Banana', 'Cherry'];

console.log(fruits[0]); // 'Apple'
console.log(fruits[1]); // 'Banana'
console.log(fruits[2]); // 'Cherry'
```
`Zero-Based Numbering` 으로 배열의 인덱스가 0부터 시작한다. `arr[index]` 인덱싱을 통해 배열의 원소에 접근이 가능하다.

<br>

### 쓸만한 메소드

`Array.prototype.find(predicate)`

callback 함수는 array의 item 개수만큼 반복 실행하게 된다. find()는 주어진 판별 함수(predicate)를 만족하는 첫 번째 요소의 값을 반환한다. 그런 요소가 없다면 undefined를 반환한다.

```javascript
const array1 = [5, 12, 8, 130, 44];

const found = array1.find(element => element > 10);

console.log(found);
// Expected output: 12
```

사용 가능 매개변수
1. element
2. index (optional)

<br>

`Array.prototype.concat(array)`

호출한 배열(앞)과 인수로 전달된 배열(뒤)을 앞 뒤로 합친 새로운 배열을 반환한다. 이때 원본 배열들은 변하지 않는다.

```javascript
const array1 = ['a', 'b', 'c'];
const array2 = ['d', 'e', 'f'];
const array3 = array1.concat(array2);

console.log(array3);
// Expected output: Array ["a", "b", "c", "d", "e", "f"]
```

<br>

`Array.prototype.forEach(function)`

forEach() 메서드는 주어진 함수를 배열 요소 각각에 대해 실행한다. **반환값이 없다**

```javascript
const array1 = ['a', 'b', 'c'];

array1.forEach(element => console.log(element));

// Expected output: "a"
// Expected output: "b"
// Expected output: "c"
```

사용 가능 매개변수
1. element
2. index (optional)

<br>


`Array.prototype.map(function)`
: forEach와 동일하게 주어진 함수가 모든 배열 요소에 대해 반복 실행된다. 차이점은 **map은 반환값이 존재하는데, 함수가 각각 요소에 적용되어 반환된 결과물들의 새로운 배열을 반환한다. 원본 배열은 변화 없다.**

```javascript
const array1 = [1, 4, 9, 16];

// Pass a function to map
const map1 = array1.map(x => x * 2);

console.log(map1);
// Expected output: Array [2, 8, 18, 32]
```
사용 가능 매개변수
1. element
2. index (optional)

<br>

`Array.prototype.filter(predicate)`

predicate로 들어온 주어진 판별 함수의 조건을 만족시키는 요소들만 모아놓은 새로운 배열을 반환한다. 원본 배열은 변화 없다.

```javascript
const words = ['spray', 'limit', 'elite', 'exuberant', 'destruction', 'present'];

const result = words.filter(word => word.length > 6);

console.log(result);
// Expected output: Array ["exuberant", "destruction", "present"]
```

<br>

`Array.prototype.findIndex(predicate)`

배열 요소의 개수만큼 주어진 함수가 실행된다. 이때 조건을 만족시키는 첫 번째 요소가 생기면 그 요소의 인덱스를 반환하고, 반복이 끝난다.

<br>

`Array.prototype.includes(arg)`

전달된 인수가 배열에 포함되어 있는지 판별한다. 포함되어 있으면 true, 없으면 false를 반환한다.

<br>


**⭐️ ▼ 아래 메소드들은 원본 배열이 수정되니 주의해야 한다.**

`Array.prototype.push(elem)`

배열에 새로운 요소를 추가함, 맨 뒤에 추가된다.

<br>

`Array.prototype.unshift(elem)`

배열에 새로운 요소를 추가함, 맨 앞에 추가된다.

<br>

`Array.prototype.reverse()`

원본 배열의 순서를 거꾸로 뒤집는다. 반환 x

<br>

`Array.prototype.splice(index, n)`

index번째를 포함하여 해당 인덱스부터 n개를 지운다.

<br>

`Array.prototype.splice(index, 0, elem)`

index번 째 자리에 새로운 elem 삽입, 해당 인덱스 뒤의 요소들은 뒤로 밀린다.

<br>

`Array.prototype.splice(index, 1, elem)`

index번 째 요소와 elem 교체

**index와 n은 정수여야 한다.**


<br>

### 쓸만한 속성

`array.length` : 배열의 elements 개수 반환