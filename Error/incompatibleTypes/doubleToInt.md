# [Java_Error] possible lossy conversion from double to int


### 오류 메시지
---

incompatible types: possible lossy conversion from double to int

<br>

### 원인

---
int는 정수를 저장할 때 사용되기 때문에 소수점이 있는 값(실수형)을 int로 변환하면 소수점 아래의 수를 잃게 된다. 
따라서 double을 int로 저장하는 것은 `lossy` 할 수 있기 때문에 자바는 허용하지 않는다.

<br>

### 해결 방법

- **강제 형변환**을 사용한다.

```Java
//아래와 같이 강제형변환을 진행함
double d  = 1.9;
int n = (int) d;
```
- 참조 타입을 `int`가 아닌 `double`로 바꾼다.