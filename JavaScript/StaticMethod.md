# JS 데이터 - Object 정적 메소드

프로토타입으로 추가된 메소드들은 리터럴 방식으로 생성된 데이터에도 직접 사용이 가능했는데, **정적 메소드는 리터럴 방식 또는 생성자 함수로 생성된 '데이터에 직접' 메소드를 적용할 수 없다.**

```javascript
{ }.method() // x 
myData.method() // x
```

<br>

대신 Object 정적 메소드는 클래스명으로 메소드 접근이 가능하다.

```javascript
Object.method() // o 가능
```

<br>

`Object.assign(target, source1, source2...)`

`assing` 메소드는 열거할 수 있는 하나 이상의 출처 객체로부터 대상 객체로 속성을 복사하여 붙여 넣을 때 사용한다. 그 후 대상 객체를 반환한다.

만약 복사해올 때 여러 source들의 데이터 중 같은 이름의 속성이 존재한다면, 뒤에 입력되는 source의 속성값으로 덮어쓰여진다.

```javascript
const target = { a: 1, b: 2 };
const source = { b: 4, c: 5 };

const returnedTarget = Object.assign(target, source);

console.log(target);
// Expected output: Object { a: 1, b: 4, c: 5 }

console.log(returnedTarget === target);
// Expected output: true -> 같은 메모리의 주소를 참조한다.
```

<br>


`Object.keys(obj)`

인수로 주어진 object의 키값들만 모아서 새로운 배열을 반환한다.

```Javascript
const object1 = {
  a: 'somestring',
  b: 42,
  c: false
};

console.log(Object.keys(object1));
// Expected output: Array ["a", "b", "c"]
```

<br>

### 객체 인덱싱 -> 키 배열 & 값 배열

객체의 해당 데이터를 접근할 때 대괄호 안에 키값을 입력해야 한다.

```javascript
const user = { ... }
const keys = Object.keys(user)
const values = keys.map(key => user[key])
```