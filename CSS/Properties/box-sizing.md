# CSS box-sizing

요소의 크기 계산 기준을 지정

- `content-box` : 기본값, 요소의 내용(content)으로 크기 계산. **즉, 내용(콘텐트)의 크기에만 명시한 w,h 적용 -> padding , border 크기는 따로 증가됨**
- `border-box` : **요소의 내용 + padding + border로 크기 계산.** 즉, 명시한 w, h 값대로 요소의 크기를 제어하고 싶다면 해당 속성값을 사용하면 된다. 쉽게 말해 padding을 포함한 border까지의 크기를 명시한 w,h 값으로 지정한다.

<br>

**💡 Tip**

> **box-sizing: border-box;** 은 매우 편리하다. 왜냐하면 실제 가로/세로 너비를 간단하게 명시한 w,h 의 값으로 설정해주기 때문이다.