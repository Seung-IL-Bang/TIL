# this

**익명 함수는 "호출 위치"에 따라 `this`를 정의한다. 화살표 함수는 자신이 선언된 "함수 범위"에서 `this`를 정의한다.** 두 개의 차이점을 제대로 알고 있어야지, JS 클래스를 사용할 때 일반 함수를 만들지 화살표 함수를 만들지 제대로 정할 수 있다. 그리고 객체 데이터 내부에서 메소드를 할당할 때 익명 함수를 할당할 땐 `: function` 부분이 생략 가능하다.

<br>

### 사용법

```javascript
const heropy = {
  name: 'Heropy',
  normal: function () {
    console.log(this.name)
  },
  arrow: () => {
    console.log(this.name)
  }
}

heropy.normal() // Heropy
heropy.arrow() // undefined

const amy = {
  name: 'Amy',
  normal: heropy.normal,
  arrow: heropy.arrow
}

amy.normal() // Amy
amy.arrow() // undefined
```

<br>

`prototype` 을 통해 메소드 주입

```javascript
// 생성자 함수
function User(name) {
  this.name = name
}

User.prototype.normal = function () {
  console.log(this.name)
}

User.prototype.arrow = () => {
  console.log(this.name)
}

const heropy = new User('Heropy')

heropy.normal() // Heropy
heropy.arrow() // undefined
```

<br>

callback 으로 활용될 경우 비교
```javascript
// arrow 활용
const timer = {
  name: 'Heropy',
  timeout: function() {
    setTimeout(() => {
      console.log(this.name)
    }, 2000)
  }
}

timer.timeout() // Heropy
```
위의 경우 객체의 메소드 내의 setTimeout의 callback 인수로 화살표 함수가 정의되어 있는데, 이 화살표 함수가 정의된 부분을 감싸고 있는 추가적인 (익명)함수 범위 내에서 this가 정의되기 때문에, this는 timeout 메소드가 정의된 timer 객체를 가리키게 된다.

```javascript
// 익명 함수 활용
const timer = {
  name: 'Heropy',
  timeout: function() {
    setTimeout(function() {
      console.log(this.name)
    }, 2000)
  }
}

timer.timeout() // undefiend
```
위의 경우 객체의 메소드 내의 setTimeout의 callback 인수로 익명 함수가 정의되어 있는데, 이 익명 함수는 setTimeout 함수의 로직 어딘가에서 실행이 될 것이기 때문에, this는 setTimeout 로직의 어딘가에서 호출 위치가 잡히게 된다.

> Tip ⭐️
>
> setTimeout() 또는 setInterval() 함수의 콜백 인자로 Arrow 함수를 작성하는 것이 활용도가 좋다.