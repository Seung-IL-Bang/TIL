# toLocaleString()

날짜 포맷을 변경할 수 있게 도와주는 함수이다.

[Reference](https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Global_Objects/Array/toLocaleString)

```javascript
  const month = props.date.toLocaleString("en-US", { month: "long" });
  const year = props.date.getFullYear(); // 연도를 네 자리로 표현
  const day = props.date.toLocaleString("en-US", { day: "2-digit" }); // 날짜를 두 자리로 표현
```

<br>

### getFullYear()

Date 객체의 연도를 네 자리 숫자로 추출하는 내장함수이다.