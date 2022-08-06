# [Java_Error] java.lang.StackOverflowError


### 오류 메시지
---

java.lang.StackOverflowError

<br>

### 원인

---
스택 오버 플로우의 일반적인 원인은 잘못된 재귀 호출에 의해 발생한다.

<br>

### 해결 방법

재귀를 올바르게 구현해야한다. 

- base case: 재귀 탈출을 제대로 하는지 확인.
- recursive case: 올바른 위치에서 적절하게 재귀를 하는지 확인.

Ref 👉 [참고자료](http://daplus.net/memory-leaks-stackoverflowerror%EB%8A%94-%EB%AC%B4%EC%97%87%EC%9E%85%EB%8B%88%EA%B9%8C/)