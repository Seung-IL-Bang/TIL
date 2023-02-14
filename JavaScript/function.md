# JS 함수(Function)
특정 동작(기능)을 수행하는 일부 코드의 집합, 키워드 `function` 을 명시하여 함수 선언을 한다. 또한 `return` 키워드를 사용하여 함수의 반환값을 정할 수 있다. 그리고 함수는 '재사용'이 가능하다(=여러 연산에 사용가능). 함수는 정의 끝에 ;을 붙일 필요가 없다.

<br>

```javascript
// 함수 선언
function hello() {
  // 실행 코드
  console.log(1234);
}

// 함수 호출
hello(); // 1234
```

<br>

```javascript
function returnFunc() {
  return 123;
}

let a = returnFunc();

console.log(a); // 123
```

<br>

```javascript
// 함수의 매개변수(a, b) 타입은 작성 안해도 된다.
function sum(a, b) {
  return a + b
}

let a = sum(1, 2); // 1과 2는 인수(Arguments)
let b = sum(7, 12);

console.log(a, b); // 3, 19
```

<br>

### 익명 함수(Anonymous Function)

이름이 없는 함수를 `익명 함수`라 한다. 반대로 이름이 이 있는 함수를 `기명 함수`라 한다. **익명 함수는 '데이터'로써 사용될 수도 있고, 어떤 변수에 할당되어 사용되기도 한다.**

<br>

```javascript
// 변수 익명 함수 할당
let world = function () {
  console.log('world~!');
}

world() = // world~!
```


> 참고 📌
> 
> 기명 함수를 작성하는 것은 <u>'함수를 선언한다'</u> 라고 말할 수 있고, 익명 함수를 어떤 변수에 할당하는 것을 <u>'함수를 표현한다'</u>라고 말할 수 있다. 해당 개념 구분은 <u>호이스팅(Hoisting)</u>을 배우는데 필요하다.

<br>

### 인수와 매개 변수

함수 호출에서 전달 받은 데이터를 **'인수'** 라 하고 인수를 함수 내부로 전달하기 위한 변수를 **'매개변수'** 라 한다.

쉽게 말해, 인수는 함수 호출 시 요구되어 전달되는 데이터를 뜻하고, 매개변수는 함수를 정의할 때 시그니처에 작성되는 변수를 의미한다.