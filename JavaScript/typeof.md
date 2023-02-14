# typeof 데이터

데이터의 타입을 반환한다. 해당 명령어를 통해 특정 데이터의 타입을 확인하는데 유용하게 사용할 수 있다.

> 주의 ❗️
> 
> Null, 객체 { }, 배열[ ] 데이터의 타입은 모두 'object' 으로 반환된다.

<br>

따라서 null, 객첵, 배열의 타입을 각각 구분하기 위해선 개별적인 타입 구분을 해주는 아래 함수를 선언하여 사용해야 한다.


```javascript
function getType(data) {
  return Object.prototype.toString.call(data).slice(8, -1)
}
```
