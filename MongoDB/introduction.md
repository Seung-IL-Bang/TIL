# MongoDB 개요

<aside>
💡 MongoDB는 유연하고 확장성 높은 Opensource Document 지향 Database 이다.

</aside>

<br>

### 왜 MongoDB 를 사용하는지

- Schema 가 자유롭다.
- HA와 Scale-out Solution을 자체적으로 지원해서 확장이 쉽다.
- Secondary Index 를 지원하는 NoSQL이다.
- 다양한 종류의 Index를 제공한다.
- 응답 속도가 빠르다.
- 배우기 쉽고 간편하게 개발이 가능하다.

<br>

### Document 장단점

**장점**

- **데이터 접근성과 가시성이 좋다.**
- Join 없이 조회가 가능해서 응답 속도가 일반적으로 빠르다.
- 스키마 변경에 공수가 적다.
- 스키마가 유연해서 데이터 모델을 App의 요구사항에 맞게 데이터를 수용할 수 있다.

**단점**

- 데이터의 중복이 발생한다.
- 스키마가 자유롭지만, 스키마 설계를 잘해야 성능 저하를 피할 수 있다.

**Scaling 측면 장점**

- HA와 Sharding에 대한 솔루션을 자체적으로 지원하고 있어 Scale-Out 이 간편하다.
- 확장 시, Application의 변경사항이 없다. (DB단에서 알아서 처리해줌)