# ES6 Classes

javascript는 prototype의 기반 언어인데, 다른 신뢰도가 높고 안정적인 언어들의 객체지향 설계의 영향을 받아서 클래스라는 개념을 흉내내서 나타난 것이 `ES6 Classes` 개념이다. 파스칼케이스로 작성한 생성자 함수의 객체 방식과 유사하며 메소드를 추가하기에 좀 더 편리해졌다.

<br>

### <사용법>
```javascript
class User {
  constructor(first, last) {
    this.firstName = first
    this.lastName = last
}

  getFullName() {
    return `${this.firstName} ${this.lastName}`
  }
}

const bang = new User('seungil', 'bang')
console.log(bang.getFullName()) // seungil bang
```