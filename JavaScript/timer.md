# 타이머 함수

`setTimeout(함수, 시간)`

일정 시간 후 함수 실행한다. setTimeout을 실행하면 특정한 Timer 가 반환된다. 해당 Timer를 clearTimeout의 인수로 전달하여 호출하면 정지를 시킬 수 있다. (시간 단위 ms)

<br>

`setInterval(함수, 시간)` : 시간 간격마다 함수 실행

<br>

`clearTimeout()` : 설정된 Timeout 함수를 종료

<br>

`clearInterval()` : 설정된 Interval 함수를 종료

<br>


```javascript
const timer = setTimeout(function () {}, 3000)

clearTimeout(timer)
```

```javascript
const timer = setInterval(() => {}, 3000)

clearInterval(timer)
```