# JS String(문자열)

### 리터럴 정의 방법

1. 큰 따옴표
```javascript
let myname = "Heropy"
```

2. 작은 따옴표
```javascript
let email = 'test@gmail.com'
```

3. 백틱 with 보간법
```javascript
let hello = `Hello ${myName}'
```
<br>

### 전역 객체 정의

```javascript
new String()
```

<br>

### 보간법이란

`$`(달러사인)과 중괄호`{ }`를 사용하여 기존에 존재하는 변수값을 `${}` 안에 할당하여 사용하는 방식을 뜻한다.

> 주의❗️
>
> 보간법을 쓰려면 문자열을 반드시 백틱(`)을 사용하여 정의해야 한다.

<br>

### 쓸만한 메소드

`String.prototype.indexOf(str: String)`
 
호출한 String 객체에서 주어진 값(str)과 일치하는 첫 번째 인덱스를 반환합니다. 일치하는 값이 없으면 -1을 반환합니다.

<br>

`String.prototype.slice(start, end)`

문자열의 일부를 추출하면서 새로운 문자열을 추출한다. 시작점부터 끝점 '직전'까지만 추출된다.

<br>

`String.prototype.replace(old, new)`

문자열의 맨 처음에 탐색되는 old 단어를 new 단어로 대체한다.

<br>

`String.prototype.match(Regex)`

문자열을 정규표현식 조건에 따라 배열 형태로 분리한다. 배열 형태로 반환되어 [ ] 인덱스로 각각 접근이 가능해진다(=인덱싱).

<br>

`String.prototype.trim()`

문자열 앞뒤에 존재하는 모든 공백 문자들을 제거해준다. 중간에 존재하는 공백은 냅둔다.

<br>

### 쓸만한 속성

`String.length` : 문자열의 길이 반환

<br>

[String mdn](https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Global_Objects/String)