# JS 개요

### 주석

```Javascript
// 한 줄 주석

/* 한 줄 주석 */

/**
* 여러 줄 주석
* 메모 1
* 메모 2
*/
```

<br>

### 데이터 종류(자료형)

1. String
2. Number
3. Boolean
4. Undefined
5. Null
6. Object
7. Array

JS로 개발할 땐 데이터를 중심으로 사고해야한다. JS는 모든게 데이터로 이루어져 있다.

<br>

### 변수 선언

```javascript
let 변수 = 값;
```

변수는 재사용, 재할당 가능하다.

<br>

### 상수 선언

```javascript
const 상수 = 값;
```

상수는 재사용은 가능하지만, 재할당은 불가능하다.

<br>

### 예약어(Reserved Word)

특별한 의미와 용도가 있어서 변수나 함수 이름 등으로 사용할 수 없는 단어이다.

- this
- if
- break
- etc

<br>

### 조건문

조건의 결과(true, false)에 따라 코드를 분기 실행하는 구문이다. 키워드는 if 와 else가 있다.

```javascript
if (isShow) {
  console.log('show!');
} else {
  console.log('hide!');
}
```

<br>

### 일치 연산자 vs 동등 연산자

1. 일치 연산자 '==='
: 두 변수의 메모리 주소 값이 같은지 참/거짓, 형변환 없이 실제 값 비교

1. 동등 연산자 '==' (사용 미권장)
: 형 변환(Type Conversion) 이 일어나서 값을 비교한다.

```javascript
1 === '1' // false
1 == '1' // true
```

<br>

### 불리언 형 변환(Type Conversion)

1. Truthy(참과 같은 값)
   - true
   - {} (객체, 빈객체)
   - [] (배열, 빈배열)
   - 양수, 음수
   - 문자열

<br>

2. Falsy(거짓과 같은 값)
   - false
   - '', "" (빈 문자열 또는 빈 문자)
   - null
   - undefined
   - 0
   - NaN (Not a Number) <- 1 + undefined

<br>

### 리터럴 생성 방식

특정 기호로 어떤 데이터를 바로 만들어내는 방식을 리터럴 방식이라 한다.

```javascript
const obj = {}

const str = "a"

const arr = []
```