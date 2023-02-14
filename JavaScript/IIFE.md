# IIFE 즉시실행함수

Immediately-Invoked Function Expression의 약어이다. 익명 함수를 소괄호로 감싸고, 그 뒤에서 소괄호를 내부 또는 외부에 붙여줘서 바로 실행할 수 있다. IIFE 사용 직전 명령어에는 세미콜론 붙이는 것을 권장한다. 뒤에 붙는 소괄호는 내부에 작성할 것을 권장한다.

<br>

### <사용법>
1. 외부 소괄호

```javascript
... ;

( function ( ) {
console.log('IIFE')
}) ( ); 
```

2. 내부 소괄호
```javascript
... ;

( function ( ) {
console.log('IIFE')
} ( ) ); 
```

> 주의 ⭐️
> 
> 에러 방지를 위해 IIFE 를 사용하기 직전 명령어와 IIFE 끝난 위치에 세미콜론 ; 을 붙여주는 것이 좋다.