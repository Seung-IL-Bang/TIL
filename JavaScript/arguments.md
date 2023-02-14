# 함수 내부의 arguments 객체

함수 내부에서 `arguments` 객체를 사용하게 되면, **함수 매개변수에 전달된 인수 값들이 arguments 객체에 배열 형태로 저장되게 된다. 이때 함수 정의에 매개변수를 생략한다.**


```javascript
// 전달된 a, b 두 개를 더하기
function sum( ) {
  console.log(arguments) // [a, b]
  return arguments[0] + arguments[1] // a + b
}
```