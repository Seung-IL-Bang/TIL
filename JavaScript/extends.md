# 상속 (extends)

키워드 `extends` 를 통해 부모 클래스를 상속 받고 `super`를 통해 부모 클래스의 생성자를 활용할 수 있다. 자식 클래스의 개별 적인 속성을 추가할 수 있어서 '확장'한다고 표현할 수도 있다

<br>

### <사용법>

```javascript
class Vehicle {
  constructor(name, wheel) {
    this.name = name
    this.wheel = wheel
  }
}

class Bicycle extends Vehicle { // 상속
  constructor(name, wheel) {
    super(name, wheel) 
  }
}

class Car extends Vehicle { 
  constructor(name, wheel) {
    super(name, wheel)
    this.license = license // 확장
  }
}
```