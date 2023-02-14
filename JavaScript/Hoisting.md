# 호이스팅 (Hoisting)

**함수 선언부가 유효범위 최상단으로 끌어올려지는 현상을 말한다.** 보통 코드를 작성할 때 호이스팅을 이용하여 함수 선언부들을 코드의 맨 끝부분에 몰아서 작성한다. **기명 함수로 '함수를 선언'해야지만 호이스팅이 일어나고, 익명 함수로 '함수를 표현'하는 경우에는 호이스팅 현상이 일어나지 않는다.**

<br>

```javascript
// double() 호출 가능, 호이스팅 현상
const a = 7

double() // 14

function double() { // 함수 선언
  console.log(a*2)
}
```


```javascript
// double() 호출 불가능
const a = 7

double() // error

const double = function () { // 함수 표현
  console.log(a*2)
}
```