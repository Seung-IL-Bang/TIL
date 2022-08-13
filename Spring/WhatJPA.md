# JPA란?

<details>
    <summary>ToDo⭕️</summary>

- [ ] 본문 리팩터링
- [ ] 내용 보강
</details>

<br>

- JPA는 Java Persistence API 이다.
- JPA는 ORM(Object Relational Mapping) 기술이다.
- JPA는 반복적인 CRUD 작업을 생략하게 해준다.
- JPA는 영속성 컨텍스트를 가지고 있다.
- JPA는 DB와 OOP의 불일치성을 해결하기 위한 방법론을 제공한다. (DB는 객체저장 불가능)
- JPA는 OOP의 관점에서 모델링을 할 수 있게 해준다. (상속, 컴포지션, 연관관계)
- 방언 처리가 용이하여 Migration하기 좋음. 유지보수에도 좋음.
- JPA는 쉽지만 어렵다.

---

`영속성(persistence)`는 데이터를 생성한 프로그램의 실행이 종료되더라도 사라지지 않는 데이터의 특성을 말한다. 영속성은 파일 시스템, 관계형 데이터베이스 혹은 객체 데이터베이스 등을 활용하여 구현한다.

<br>

`JPA`는 자바에 있는 데이터를 영구히 저장할 수 있는 환경(DB)에 데이터를 옮기는 API이다.

자바 프로그래밍을 할 때 영구적으로 데이터를 저장하기 위해 필요한 인터페이스가 `JPA`이다.

<br>

`API`란? 

`인터페이스` ➡️ `프로그래밍` ➡️ `애플리케이션(프로그램)`
-  애플리케이션(프로그램)
-  프로그래밍
-  인터페이스(상하관계가 존재하는 약속, 규약) cf. 프로토콜(동등한 관계의 약속, 규약)
   - 인터넷, WWW -> 프로토콜로 이루어진 생태계
   - ex. email로 서로 연락하자.

---

`ORM`이란? 

Object Relational Mapping

객체를 데이터베이스에 연결하는 방법론

DB의 data type과 java의 data type은 같지 않기 때문에 DB에 있는 데이터(테이블)을 자바 클래스로 모델링 해줘야 한다.

| TABLE |         |
| ----- | ------- |
| ID    | int     |
| Name  | varchar |
| Year  | archer  |

```Java
class TABLE {
    int id;
    String name;
    String year;
}
```
`클래스` ➡️ `테이블` : JPA의 인터페이스를 지키며 클래스를 만들고 실행하면 DB에 자동적으로 TABLE이 생성되게 하는 기법이 `ORM`

---
1. 단계 연결 요청

`Java` ➡️ `Connection 요청` ➡️ `권한 확인` ➡️ `세션 오픈` ➡️ `java connection 획득`

2. 커넥션 획득 이후 쿼리

`Java query` ➡️ `DB response data` 이때 DB에서 보내온 데이터 타입과 자바의 데이터 타입이 다르므로 자바 Object로 바꿔줘야 한다.

위와 같은 CRUD 반복 작업을 일일이 코드 작성할 필요없이 단순한 반복 로직을 JPA가 대신 해결해줌, 함수 제공

`ORM`은 나의 하인이다.

---

`context` 대상에 관한 모든 정보

`Java` ∼ `Persistence Context` ∼ `DB`

자바는 항상 `영속성 컨텍스트`를 통해서 DB에 데이터를 저장하고, DB도 항상 영속성 컨텍스트를 통해서 자바쪽으로 전달된다. 그리고 영속성 컨텍스트에서 일어나는 모든 작업(타입 변환, 동기화, CRUD 등)은 자동으로 일어난다. 자바가 DB에 데이터를 어떻게 저장해야 되는지에 관한 메타 정보를 모두 가지고 있다. 반대도 마찬가지이다.

---

DB의 TABLE들의 column(특성)들은 기본 자료형만 가질 수 있고, Object는 가질 수 없다. 하지만 Java의 class는 Object를 가질 수 있다. 따라서 Java의 class에서 객체를 저장하고 이것을 DB에 저장할 때는 JPA가 자동적으로(ORM) FK를 넣어줄 것이다.

| Table Team |      |      |
| ---------- | ---- | ---- |
| ID         | Name | Year |
| 1          | 롯데 | 1990 |
| 2          | NC   | 2005 |



| Table Player |        |            |
| ------------ | ------ | ---------- |
| ID           | Name   | TeamId(FK) |
| 1            | 이대호 | 1          |
| 2            | 공필성 | 1          |
| 3            | 홍길동 | 2          |

```java
class Team {
    int id;
    String name;
    String year;
}
```

```java
class Player {
    int id;
    String name;
    // int teamId; int타입으론 어떤 팀인지 모름
    Team team; // java class에선 객체 저장 가능
}
```
객체지향으로 인해 `Player` table과 class의 괴리가 생김. JPA가 자동적으로 매핑하여 team에 teamId에 해당하는 team을 넣어줄 것이다.

---


JPA는 클래스를 먼저 만들고 클래스를 토대로 자동적으로 DB 테이블을 만든다. 

```java
class Car {
    String naem;
    String color;
    Engine engine;
}

class Engine {
    int id;
    int power;
}
```

위 자바 클래스를 JPA를 이용하여 아래와 같은 테이블이 자동적으로 만들어진다.

| Car TABLE |        |       |          |
| --------- | ------ | ----- | -------- |
| id        | name   | color | engineId |
| 1         | Bmw    | white | 2        |
| 2         | Sonata | Black | 1        |

| Engine TABLE |       |
| ------------ | ----- |
| id           | Power |
| 1            | 2000  |
| 2            | 4000  |

위 같은 상황에서 `class Engine`에 생성 시간(timeStamp)을 새로 넣게되면 어떻게 될까? 

```java
class Car extends EntityDate{
    String naem;
    String color;
    Engine engine;
    // TimeStamp createDate; // 새로 추가 
    // TimeStamp updateDate; // 새로 추가

}
class Engine extends EntityDate {
    int id;
    int power;
    // TimeStamp createDate; // 새로 추가
    // TimeStamp updateDate; // 새로 추가
}

class EntityDate {
    TimeStamp createDate;
    TimeStamp updateDate;
}
```

JPA를 사용하면 TimeStamp를 일일이 추가 대신 TimeStamp를 가진 EntityDate 클래스를 만들고 TimeStampe가 필요한 클래스에 EntityDate 클래스를 상속시켜주면 DB에 자동적으로 연동된다.

| Car TABLE |        |       |          |            |            |
| --------- | ------ | ----- | -------- | ---------- | ---------- |
| id        | name   | color | engineId | createDate | updateDate |
| 1         | Bmw    | White | 2        | YYYY-MM-DD | ...        |
| 2         | Sonata | Black | 1        | ...        | ...        |

---

`Spring` ∼ `JPA(inner : abstract Object)` ∼ `DB`

이때 JPA가 쓸 수 있는 데이터베이스 프로그래밍 언어로 `MySQL` 같은 언어만 지원하는게 아니라 다양한 언어를 지원한다. 방언(dialect) Oracle, Maria, Postgre 등.

JPA는 `추상화 객체`가 존재하여 사용하고 싶은 데이터 프로그래밍 언어로 DB에 연결가능하다. 사용하고 싶은 언어로 객체를 바꿔가며 사용한다. 즉 방언처리(여러가지 언어 지원)를 통해 데이터베이스에 다양한 언어로 접근 가능하다.

---

JPA는 처음 접하면 개념이 헷갈린다. 적응을 하면 편하고 쉽다. 데이터가 방대해질수록 더 어려워질 수도 있다.

