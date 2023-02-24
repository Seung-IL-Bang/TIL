# 화살표 함수(Arrow Function)

1. 익명 함수
```javascript
const double = function (x) {
  return x * 2
}

double(2) // 4
```

2. 화살표 함수
```javascript
const doubleArrow = (x) => {
  return x * 2
}

doubleArrow(2) // 4
```

3. 축약형
```javascript
const doubleArrow = x => x * 2

doubleArrow(2) // 4
```

> 주의❗️
>
> 객체와 함수의 블록 표현이 중복되므로 축약형 사용 시 { } 객체 데이터를 리턴하고 싶으면 소괄호 ( ) 로 감싸서 반환해야 한다.

```javascript
// 축약형: 객체 반환시 소괄호로 감싸줘야 한다.
const doubleArrow = x => ( { name:'he' } )
```