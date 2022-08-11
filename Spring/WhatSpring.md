# 스프링이란?

<details>
    <summary>ToDo⭕️</summary>

- [ ] 본문 리팩터링
- [ ] 내용 보강
</details>

<br>

- 스프링은 프레임워크이다.
- 스프링은 오픈소스이다.
- 스프링은 IoC 컨테이너를 가진다.
- 스프링은 DI를 지원한다.
- 스프링은 엄청나게 많은 필터를 가지고 있다.
- 스프링은 엄청나게 많은 애너테이션을 가지고 있다.
- 스프링은 MessageConverter를 가지고 있다. 기본값은 현재 Json이다.
- 스프링은 BufferedReader와 BufferedWriter를 쉽게 사용할 수 있다.
- 스프링은 계속 발전중이다.

---

`프레임워크`는 정해진 틀을 벗어나지 않고 개발할 수 있게 제공되는 도구(수정 불가)

<br>

`오픈소스`는 공개된 소스코드, 누구나 개선하고 기여할 수 있다.

<br>

`IoC(Inversion of Controll)` 직역하면 제어의 역전, 개발의 흐름(주도권)이 스프링한테 넘어간 것. 스프링이 스캔을 통해 Object 전부를 heap 메모리에 올린다. 개발자는 `new` 키워드를 통해 객체를 인스턴스화할 때 마다 heap 메모리에 새로운 객체가 생성된다. 개발자가 직접 `new` 를 통해 객체를 인스턴스화 하지 않아도 Spring이 객체들을 한 번에 전부 스캔하여 객체를 언제 어디서나 `싱글톤`으로 공유하여 접근가능하다. 즉 `new` 로 객체를 생성하지 않고 Spring이 스캔한 객체를 인스턴스화 하는 것을 `IoC`라 한다.

- class ➡️ 설계도(거푸집, 틀)
Ex : 가구

- Object ➡️ 실체화가 가능한 것!
Ex : 의자, 침대 등

- Instance ➡️ 실체화가 이뤄진 것!
Ex : 실제로 제작된 의자, 침대 등

<br>

`DI(Dependency Injection)`는 스캔되어 heap 메모리에 한번 올라갔을 때 `싱글톤`으로 공유하여 객체를 가져다 쓰는 것을 DI라 한다.

<br>

검열의 기능을 담당하는 것을 `필터`라고 한다. 클라이언트 요청에 대해 서버의 접근 권한을 확인하는 문지기라고 생각할 수 있다. 스프링 자체가 기본적으로 on 되어 있는 필터 기능뿐만 아니라 기능이 off 된 필터를 on 시킬 수도 있다. 그리고 직접 필터를 만들어서 사용할 수도 있다.

이때, 톰캣(서버)을 문지기가 지키고 있는 요새라고 생각할 수 있다. 그리고 스프링 컨테이너는 요새 안에 있는 성(castle)으로 생각할 수 있다.

- 톰캣이 들고 있는 첫 번째 문 = `filter` = `web.xml`

- 톰캣 내부에 있는 스프링 컨테이너의 두 번째 문 = `인터셉트(AOP 개념)` -> 필터라고 생각해도 무방.

<br>

애너테이션 -> 컴파일 체킹시 애너테이션을 통해 에러 체크

- 애너테이션 : 컴파일러가 무시 ❌ Ex. @Override 
- 주석 : 컴파일러가 무시 ⭕️

스프링에서는 애너테이션을 통해 객체를 생성할 수도 있다.

- @Component ➡️ 해당 클래스를 heap 메모리에 할당(스캔, IoC)
- @Autowired ➡️ @Component로 인해 로딩된 객체를 해당 변수에 할당, 메모리에 없다면 null 할당(DI)
- @Bean 
- @Controller

스프링이 어떤 클래스 안에 어떤 메서드, 필드 애너테이션이 있는지 **런타임 시 분석**하는 것을 `리플렉션`이라고 한다.

<br>

what is MessagConverter? 

Java Object와 Python Object 서로 다른 언어끼리 서로 다른 객체를 주고 받으면 통신에 어려움이 있다.

중간 언어 -> Json! (어떤 언어에서든 이해하기 쉬운 데이터 표현 방법)

Java -> Python 데이터 보낼 경우

`Java Object` -> `Json` -> `Python Object`

Python -> Java 데이터 보낼 경우

`Python Object` -> `Json` -> `Java Object`

위 동작처럼 `Json`으로 변환 또는 `Json`을 전달 받는 언어에 맞는 `Object`로 변환 해주는 역할을 `MessageConverter`가 맡는다. 스프링 프레임워크에서 `Jackson` 라이브러리로 존재한다.

<br>

BufferReader, BufferWriter

1 바이트(8비트) : 통신 단위(영어권, 한 문자씩 끊어서 리딩 가능)

각 나라별 언어권마다 표현해야되는 비트수가 다르다 보니, 통신에 제약이 생김 -> 통일성을 위해 유니코드 등장

유니코드는 3byte로 인코딩되어 있다. 그래서 요즘은 전부 문자를 3byte로 인코딩하여 통신한다.

BufferedReader로 가변길이의 문자열을 받을 수 있다.(byte 낭비 없이)

BufferedWriter는 byte Stream 통신을 할 때 가변길이의 문자열을 전송해주는 기능이다. 그리고 BufferedWriter는 자바에서 내려쓰기의 제약이 있어 같은 기능을 하면서 내려쓰기까지 가능한 printWriter을 많이 사용한다.

- @ResponseBody -> BufferedWriter
- @RequestBody -> BufferedReader

<br>

스프링 부트가 나오면서 스프링 프레임워크를 사용하기 많이 편해졌다.