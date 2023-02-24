# 생성자 함수(prototype)

**JS를 prototype 기반의 프로그래밍 언어라고도 불른다.** 그만큼 JS에서 `prototype을` 많이 쓴다. JS에서 prototype을 사용해서 **new 키워드와 함께 생성자 함수로 인스턴스를 만들어내는 것을 클래스 개념 이라고한다.**

<예시>
```javascript
function User(first, last) {
  this.firstName = first
  this.lastName = last
}

// 생성자 함수 new User(...)
const heropy = new User('Heropy', 'Park')
```

일반 함수와 구분하기 위해 new라는 키워드를 사용하는 함수를 `생성자 함수`라 하고, **특별히 생성자 함수는 카멜케이스가 아닌 파스칼 케이스로 작성한다.** 생성자 함수를 통해서 해당 객체를 전달 받은 변수를 `인스턴스`라고 한다.

<br>

```javascript
// prototype 속성을 통해 메소드 삽입 가능
User.prototype.getFullName = function() {
  return `${this.firstName} ${this.lastName}`
}

console.log(heropy.getFullName())
```

<br>

**✅ User 클래스 안에 메소드를 this를 통해 직접 구현하지 않는 이유?**

-> firstName, lastName은 각각의 인스턴스마다 개별의 값이 들어가야 하므로 메모리를 통일화 시키기 어렵지만, getFullName은 모든 인스턴스가 동일하게 사용할 수 있으므로 메모리 통일화가 가능하다.

**쉽게 말해서 `prototype`이란 속성을 통해서 메소드를 등록하게 되면, 인스턴스가 얼마나 많이 생성되던지 간에 해당 메소드는 딱 한번만 메모리에 등록된다. 즉, 메모리 관리 측면에서 효율적이다.** 반면에, this. 를 통해 등록된 속성들은 각 인스턴스마다 메모리에 생성되어야 하기 때문에 메모리 비용이 부담이 될 수 있다.