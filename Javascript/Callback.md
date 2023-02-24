# 콜백(Callback)

함수의 인수로 사용되는 함수를 의미한다. **특정한 실행 위치를 보장해주는 방식으로 많이 활용된다. 매개변수의 이름은 아무렇게나 가능하지만 보통 callback 또는 cb라고 한다.**

<br>

ex) 

`setTimeout(함수, 시간)`: setTimeout에 인수로 전달된 함수를 '콜백'이라 한다.

<br>

```javascript
function timeout(callback) {
  setTimeout( () => {
  console.log('Heropy')
  callback()
}, 3000)}

timeout(() => {
  console.log('Done')
})

// Heropy
// Done
```