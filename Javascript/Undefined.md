# JS Undefined
값이 할당되지 않은 상태를 나타낸다. 또는 존재하지 않는 속성의 값을 출력하려 할 때 나타난다.

<br>

값이 할당되어 있지 않은 상태 = 초기화가 안된 상태.

```javascript
let undef;
let obj = { abc: 123};

console.log(undef); // undefined
console.log(obj.abc); // 123
console.log(obj.xyz); // undefined
```