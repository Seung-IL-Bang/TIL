# JS DOM API

Document Object Model, Application Programming Interface의 약어이다. 이때 DOM은 HTML의 div, span, input 같은 요소들을 가리킨다. 쉽게 말해서 JS로 HTML를 제어할 때 사용하는 명령어들을 DOM API 라 한다. 이러한 기능들은 브라우저의 JS 엔진에 이미 정의되어 지원되는 것들이다.

웹 앱에 'UI'를 핸들링 할 수 있는 유일한 방법이다. 웹 앱을 만드는데 거의 모든 기능을 제공해주지만 다루기가 까다롭고, 웹 애플리케이션 제작에 최적화 되어 있지 않다. 따라서 react나 redux를 사용해서 이러한 불편함들을 해결할 수 있다.

<br>

### script defer 속성

'defer' 속성은 html의 head 영역에 script 태그를 사용하여 HTML과 JS 파일을 연동할 때 필요한 속성이다. 만약 defer을 적용하지 않는다면, 연동되는 시점에 JS 파일이 html의 body 영역은 해석하지 못하는 문제가 발생한다. 이런 문제가 발생하면 body의 요소들을 JS에서 인식하지 못 하기 때문에 DOM API들을 사용하지 못하게 된다. 따라서 defer을 적용하게 되면 head 에서 연동되는 시점에 body 영역을 해석하는 것이 아니라 html 구조가 전부 해석된 다음 body 영역을 해석하게 된다

요약: JS 파일을 HTML 문서 분석 이후에 실행하도록 지시하는 속성

<br>

### `document.querySelector()`

HTML 요소(Element) 1개 검색/찾기

```javascript
const 변수명 = document.querySelector('선택자명');
```

만약 같은 클래스명의 요소가 여러 개 존재하는 경우, html 구조 상 가장 위에 있는 요소가 선택된다.

<br>

### `document.querySelectorAll()`

HTML 요소(Element) 모두 검색/찾기

```javascript
const boxEls = document.querySelectorAll('.box');
console.log(boxEls);

// <콘솔 출력>
// NodeList(3)
// 0: div.box
// 1 div.box
// 2: div.box
// length: 3
// [[Prototype]]: NodeList
```

데이터 유형: 배열같이 생겼지만 **'유사 배열(Array-like)'** 타입이다

<br>

### `forEach()`

`querySelectorAll()`로 찾은 요소들에 대해 반복해서 함수를 실행한다. 익명 함수를 인수로 추가한다.

```javascript
boxEls.forEach( function( boxEl, index) {
  boxEl.classList.add(`order-${index + 1}`);
  console.log(index, boxEl);
});

// 첫 번째 매개변수(boxEl): 반복 중인 요소
// 두 번째 매개변수(index): 반복 중인 번호
```

각 매개변수 이름은 개발자가 자유롭게 정할 수 있다. 두 번재 매개변수는 통상적으로 index로 적는다. 두 번째 매개변수(index)는 생략 가능하다.

<br>

### `addEventListener()`

HTML 요소에 이벤트를 생성/적용할 수 있는 메소드이다.


```javascript
// HTML 요소 1개 검색 및 할당
const boxEl = document.querySelector('.box');

// 첫 번째 인수 - 이벤트(이벤트의 정보)
// 두 번째 인수 - 핸들러(실행할 익명 함수)
boxEl.addEventListener('click', function () {
  console.log('Click~!');
});
```

<br>

### `classList`

요소의 클래스 정보 객체를 활용하는 속성이다.

- elem.classList.add()
- elem.classList.contains()
- elem.classList.remove()

위 에서 'elem'은 `querySelector`를 통해 얻은 HTML의 요소를 저장한 변수이다.

```javascript
const boxEl = document.querySelector('.box');

// boxEl에 해당하는 요소의 클래스명에 '띄어쓰기 + 문자열'이 추가된다.
boxEl.classList.add('active'); // -> class="box active"

// 클래스명에 해당 문자열이 포함되어 있는지.
let isContains = boxEl.classList.contains('active');
console.log(isContains); // true

// boxEl에 해당하는 요소의 클래스명에 '띄어쓰기 + 문자열'이 삭제된다. 
boxEl.classList.remove('active'); // -> class="box"
isContains = boxEl.classList.contains('active');
console.log(isContains); // false
```

<br>

### `textContent`

`querySelector()`로 찾은 요소의 내용(Content)에 대해 `Getter` or `Setter` 로 활용된다.

```javascript
const boxEl = document.querySelector('.box');

// Getter
console.log(boxEl.textContent); // box

// Setter
boxEl.textContent = 'new box'
console.log(boxEl.textContent); // new box
```

<br>

### 메소드 체이닝(Method Chaining)

조건을 부합하는 메소드들을 이어서 사용하는 것을 **메소드 체이닝**이라 한다.

```Javascript
const a = 'Hello';
const b = a.split('').reverse().join(); // 메소드 체이닝

console.log(a); // Hello
console.log(b); // olleH
```

<메소드 설명>
1. split : 문자를 인수(구분자, separator) 기준으로 쪼개서 배열 반환
2. reverse : 배열을 뒤집기
3. join : 배열을 인수 기준으로 문자열로 병합 반환 (default: '')

> 주의❗️ split 바로 뒤에 join 은 사용 못한다.