# Storage

### localStorage

로컬 저장소의 데이터는 만료되지 않고, 사용자가 직접 지우지 않는 한 브라우저 로컬 저장소에 반영구적이다. 서버가 닫혔다 다시 켜져도 존재한다.

<br>

### sessionStorage

세션 저장소의 데이터는 페이지 세션이 끝날 때, 즉 페이지를 닫을 때 사라진다.

> 스토리지에 저장할 땐 키-밸류 모두 문자열 데이터로 저장하는 것을 '권장'한다. 즉 JSON.stringify(obj) 사용하여 저장하길 권장한다.

```Javascript
// 스토리지에 데이터 저장
localStorage.setItem('myCat', 'Tom');

// 스토리지에서 데이터 읽기
const cat = localStorage.getItem('myCat');

// 스토리지에서 데이터 삭제
localStorage.removeItem('user')

// 스토리지에서 데이터 수정
// 저장소에서 데이터 가져오기 -> 객체로 변경 -> 수정 -> JSON로 변경 -> 저장소에 덮어쓰기
const str = localStorage.getItem('user')
const obj = JSON.parse(str)
obj.age = 22
console.log(obj)
localStorage.setItem('user', JSON.stringify(obj))
```


[local storage mdn](https://developer.mozilla.org/ko/docs/Web/API/Window/localStorage)