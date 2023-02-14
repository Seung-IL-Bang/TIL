# 참조형 데이터(Reference Type Data)

참조형 데이터는 특정 메모리 위치의 주소를 참조하는 데이터들을 의미한다. 참조형 타입의 데이터 종류는 아래와 같다.

- 객체
- 배열
- 함수

<br>

```javascript
const a = { k: 123 }
const b = { k: 123 }
console.log(a === b) // false
```
객체의 내부 데이터가 똑같더라도 참조하고 있는 메모리 주소가 다르기 때문에 false가 나온다.