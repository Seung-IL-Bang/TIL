# JS 메소드(Method)
JS 객체 데이터 내부에서 한 속성을 구성하는데 이때 Value 값이 익명 함수일 경우, 이 속성을 `메소드`라고 부르기로 한다.

```javascript
// 객체 데이터
const obj = {
  name: 'Heropy',
  getName: function () {
    return this.name;
  }
};

const hisName = heropy.getName();
console.log(hisName); // Heropy
```
위 코드에서 obj 객체 내부의 `getName` 속성을 메소드라고 한다.
