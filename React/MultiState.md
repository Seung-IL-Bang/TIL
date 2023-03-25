```javascript
  // const [enteredTitle, setEnteredTitle] = useState("");
  // const [enteredAmount, setEnteredAmount] = useState("");
  // const [enteredDate, setEnteredDate] = useState("");
  const [userInput, setUserInput] = useState({
    enteredTitle: "",
    enteredAmount: "",
    enteredDate: "",
  });
```

<br>

하나의 컴포넌트 안에 여러 개의 스테이트가 필요한 경우 각각 useState를 사용하기보단 객체 한 곳에 모은 다음 하나의 useState로 관리하는 방법도 있다(단일 상태 관리). 개별적인 상태를 각각 관리해도 좋다(다중 상태 관리). 개인 취향에 따라 코딩하자. 단일 상태 관리로 코딩할 경우 상태 업데이트 함수를 사용할 때 동시성 문제에 유의하자! 그럴 경우엔 prevState를 꼭 사용하자.

보통 이전 상태(스냅샷)에 의존하는 경우 단일 상태 관리로 사용한다.