 # 스프링부트 동작원리


<details>
    <summary>ToDo⭕️</summary>

- [ ] 본문 리팩터링
- [ ] 내용 보강
</details>

1. 내장 톰캣을 가진다.

톰캣을 따로 설치할 필요 없이 바로 실행 가능하다. 

> 톰캣이란?
> 
> 톰캣은 웹 서버와 연동하여 실행할 수 있는 자바 환경을 제공하여 자바서버 페이지(JSP)와 자바 서블릿이 실행할 수 있는 환경을 제공하고 있다. 톰캣은 관리툴을 통해 설정을 변경할 수 있지만, XML 파일을 편집하여 설정할 수도 있다.

톰캣을 알기 전에 소켓을 알아야 한다.

socket : 운영체제가 가지고 있는 것!

> 소켓이란?
>
> 네트워크상에서 동작하는 프로그램 간 통신의 종착점(Endpoint)입니다. 즉, 프로그램이 네트워크에서 데이터를 통신할 수 있도록 연결해주는 연결부라고 할 수 있습니다

소켓 통신 : main Thread 요청을 확인하고 연결까지만 해준 다음 스스로 연결을 끓음. 연결을 이어받은 메인 스레드가 아닌 Thread_1, Thread_2 ... 는 데이터를 주고 받으며 연결이 항상 유지된다.

소켓 통신 단점 : 연결이 계속 유지되므로 부하가 심하다. 연결이 많아질 수록 엄청난 부하.

<br>

개선 -> http

http 통신 : 연결을 유지하지 않는 stateless 방식. 스레드를 만들 필요 없이 소켓에서 데이터를 주고 받은 다음 연결을 끊는다. 연결을 유지할 필요가 없어 부하가 적다.

단점 : 같은 대상으로부터 같은 연결을 재시도 하더라도 소켓에서 항상 새로운 대상으로 인식한다.

<br>

개선 -> web server

solid 프로젝트 : 모든 데이터가 중앙집중화 되어 있는 것을 개인이 데이터를 통제할 수 있는 새로운 웹을 만드는 프로젝트

--- 

### 톰켓

http(소켓 기반)는 운영체제가 가지고 있는 소켓을 이용(system call)해서 만들어졌다.

톰캣과 웹 서버의 차이를 알아야 한다.

> 웹 서버란?
> 
> http 통신은 클라이언트가 웹 서버한테 요청(request)을 한다. 클라이언트는 웹 서버의 IP 주소를 알아야하고 어떤 데이터를 얻어야 하는지 명시해야 한다. 어떤 데이터(자원)에 대한 자원요청 주소를 URL(URI)이라 생각하면 된다. 웹 서버는 클라이언트의 요청에 대해 응답(response)를 한다. 요청을 받은 IP 주소(클라이언트 주소)로 그대로 응답한다. 웹 서버는 굳이 클라이언트 IP 주소를 알 필요가 없다. 따라서 웹 서버는 요청에 대해 응답만 해주면 되고, 이 응답은 정적인 자원이다. (static resource) 

- static resource : 요청 받은 후 서버에 이미 존재하는 데이터
- dynamic resource : 요청 받은 후 서버에서 가공이 필요한 데이터

<br>

흔히 사용하는 웹서버 : 아파치

만약 웹서버(아파치)가 요청(req)으로 `.jsp(자바코드)`를 주문 받으면 웹서버(아파치)는 자바코드를 이해하지 못한다. 이때 아파치에 톰캣을 달아준다. 아파치는 본인이 이해 못하는 파일(.jsp)을 요청 받으면 제어권을 톰캣에 넘겨준다. 톰캣은 `.jsp`에 있는 모든 파일을 컴파일하고 컴파일한 모든 데이터를 `.html`로 만듭니다. 해당 .html 파일을 아파치에 전달해주고 아파치는 전달 받은 html 파일을 응답(res)에 실어 전달해준다.

웹 브라우저는 `.jsp`를 이해 못해서 사이트의 화면이 깨질 것이다. `.html` 파일은 이해 가능하다. 웹 브라우저는 html, css, javaScript를 읽어주는 프로그램이다. 따라서 웹 브라우저가 이해 못하는 확장자의 파일이 들어오면 제 기능을 하지 못한다.

웹 브라우저로부터 .jsp를 요청 받아도 웹 서버는 웹 브라우저가 .jsp를 이해 못 할 것으로 판단하여 톰캣에게 .jsp 파일을 .html 파일로 변환해달라 부탁할 것이다.

즉, 아파치는 요청 받은 파일에 대한 응답을 해주는 서버이고, 톰캣은 아파치 내부에 존재하며 아파치가 요청 받은 파일 중 자바 코드에 해당하는 파일을 컴파일 하여 html 파일로 번역하고 아파치에게 돌려주는 프로그램이다.

---

서블릿 컨테이너(=톰캣)란?

URL : 자원 접근 (스프링은 URL로 접근을 막아놨다. 즉, 스프링은 URI 접근만 가능하다.)

URI : 식별자 접근 (URI 접근을 하면 톰캣으로 제어권이 넘어갈 수 밖에 없다. 이유는 추후에..)

즉 스프링은 특정 파일을 요청 시에 무조건 자바를 거친다. (= 아파치는 무조건 톰캣에게 제어권을 넘기게 되어있다.)

서블릿 컨테이너(톰캣)은 `request(java)`을 받으면 스레드를 생성한다. 생성된 스레드가 서블릿 객체를 만든다. 서블릿 객체에서 다양한 작업(DB 커넥션, 데이터 쿼리, html 변환 등)이 이뤄진다. 이때 요청은 엄청나게 많이 들어올 수 있다. 요청마다 스레드를 생성하고 스레드는 서블릿 객체를 만든다. 이렇게 요청마다 스레드, 서블릿 객체를 만드는 이유는 딜레이를 없애기 위함이다(서블릿 객체가 하나라면 뒤에 들어온 요청은 앞의 요청이 해결될 때까지 기다려야 한다). 만약 서블릿 객체의 개수 제한이 20개이고 21번 째 요청이 들어온다면 대기해야 한다. 그렇다고해서 스레드를 많이 늘리게 되면 각 서블릿 객체들이 수행하게 되는 성능이 느려지게 된다.
만약 대기하는 요청이 있다면 응답을 완료한 서블릿 객체를 재사용한다(∴성능 빠름). 최종적으로 톰캣이 httpServletRequest 객체와 httpServletResponse 객체를 만든다.

--- 

web.xml

web.xml은 톰캣을 들어가기 위한 관문이다.

- ServletContext의 초기 파라미터 (자원 접근에 대한 암구호)
- Session의 유효시간 설정(접근 인증 유효기간)
- Servlet/JSP에 대한 정의 (web.xml에 적혀있는 자원 )
- Servlet/JSP 매핑(요청한 자원의 주소를 알려주고 자원까지 이동하게 해주는 것)
- Mime Type 매핑 (요청req가 들고있는 데이터 타입, 해당 데이터 타입에 알맞은 가공할 장소로 이동하게 해주는 것)
- Welcome File list(공백의 web.xml을 들고온 요청을 모아두는 장소, 다른 일 시키려고?)
- Error Pages 처리(요청에 해당하는 장소가 없는 경우의 요청들을 모아두는 장소)
- 리스너/필터 설정(필터:적절한 요청만 접근하게 해주는 것, 리스너:문지기 보조인, 관리자가 필요로 하는 특정 .xml설정의 요청을 데리고 감)
- 보안(투옥 또는 쫓아냄)


---

### FrontController 패턴

web.xml에서 전부 servlet/JSP 정의, 매핑하기 어렵기 때문에 FrontController 에게 분담

 최초 앞단에서 특정 request 요청을 받아서 필요한 클래스에 넘겨준다. why? web.xml에 다 정의하기가 힘들기 때문.

 이때 새로운 요청이 생기기 때문에 request와 response가 새롭게 new 될 수 있다. 그래서 RequestDispatcher가 필요하다.

톰캣이 request 객체와 response 객체를 자동으로 만들어준다.

이때 특정 요청을 낚아채는 FrontController는 해당 요청에 대한 자원으로 재요청하게 되는데, 이때 새로운 req 정보(∵기존 req 정보와 달라지는 문제점 발생)를 생성하지 않고 기존의 요청req에 대한 정보를 끌어와서 재요청하는 기능을 RequestDispatcher가 담당한다. res도 마찬가지로 기존의 res로 사용가능하게끔 해준다.
 

### RequestDispatcher

필요한 클래스 요청이 도달했을 때 FrontController에 도착한 reqeust와 response를 그대로 유지시켜준다.

RequestDispatcher를 이용해야지 page 간 데이터 이동이 가능하다.

### DispatchServlet

하는 역할 : 주소 분배, 컴포넌트 스캔

FrontController 패턴을 직접 짜거나 ReqeustDispatcher를 직접 구현할 필요가 없다. 왜냐하면 스프링에는 DispatchServlet이 있기 때문이다. DispatchServlet은 FrontController 패턴 + ReqeustDispatcher 이다.

DispatchServlet이 자동생성되어 질 때 수 많은 객체가 생성(IoC)된다. 보통 필터들이다. 해당 필터들은 내가 직접 등록할 수도 있고 기본적으로 필요한 필터들은 자동 등록 되어진다. 

예를 들어 com.cos.blog 이하의 패키지 안에 작업 파일이 있다면, 스프링 부트는 패키지 안에 있는 모든 파일을 All Scan 한다.

DispatchServlet은 필요한 파일을 메모리에 올린다. 필요한 파일들은 정해져 있다. 필요한 것들을 찾기 위해 정해진 애너테이션 자바 파일을 찾는다.

- @Controller
- @RestController
- @Configuration
- @Repository
- @Service

---

### 스프링 컨테이너

DispatchServlet에 의해 생성되어지는 수 많은 객체들은 어디에서 관리될까?

첫 째. ApplicationContext

수 많은 객체들이 ApplicationContext에 등록된다. 이것을 IoC라고 한다. IoC란 제어의 역전을 의미한다. 개발자가 직접 new를 통해 객체를 생성하게 된다면 해당 객체를 생성하게 된다면 해당 객체를 가르키는 레퍼런스 변수를 관리하기 어렵다. 그래서 스프링이 직접 해당 객체를 관리한다. 이때 우리는 주소를 몰라도 된다. 왜냐하면 필요할 때 DI하면 되기 때문이다. DI를 의존성 주입이라고 한다. 필요한 곳에서 ApplicationContext에 접근하여 필요한 객체를 가져올 수 있다. ApplicationContext의 종류에는 두 가지가 있는데 (root-applicationContext와 servlet-applicationContext)이다.

servlet-applicationContext는 ViewResolver, Interceptor, MultipartResolver 객체를 생성하고 웹과 관련된 애너테이션 Controller, RestController 등을 스캔한다.

=> 해당 파일은 DispatchServlet에 의해 실행된다.

root-applicationContext는 해당 애너테이션을 제외한 애너테이션 Service, Repository 등을 스캔하고 DB 관련 객체를 생성한다. (스캔이란: 메모리에 로딩한다는 뜻) 

=> 해당 파일은 ContextLoaderListener에 의해 실행된다. ContextLoaderListener를 실행해주는 녀석은 web.xml이기 때문에 root-applicationContext는 servlet-applicationContext 보다 먼저 로드된다. 당연히 servlet-applicationContext에서는 root-applicationContext가 로드한 객체를 참조할 수 있지만 그 반대는 불가능하다. 생성 시점이 다르기 때문이다.



### ContextLoaderListener

공통적으로 써야하는 것들(root-ApplicationContext 파일)을 메모리에 띄워준다.


둘 째. Bean Factory

필요한 객체를 Bean Factory에 등록할 수도 있다. 여기에 등록하면 초기에 메모리에 로드되지 않고 필요할 때 getBean()이라는 메소드를 통해 호출하여 메모리에 로드할 수 있다. 이것 또한 IoC이다. 그리고 피룡할 때 DI 하여 사용할 수 있다. ApplicationContext와 다른 점은 Bean Factory에 로드되는 객체들은 미리 로드되지 않고 필요할 때 호출하여 로드하기 때문에 lazy-loading 된다는 점이다.

---

### 요청 주소에 따른 적절한 컨트롤러 요청(Handler Mapping)

GET 요청 => http://localhost:8080/post/1

해당 주소 요청이 오면 적절한 컨트롤러의 함수를 찾아서 실행한다.

### 응답

html 파일을 응답할지 Data을 응답할지 결정해야 하는데 html 파일을 응답하게 되면 ViewResolver(prefix, suffix를 붙여줌)가 관여하게 된다. 하지만 Data를 응답하게 되면 MessageConverter가 작동하게 되는데 메시지를 컨버팅할 때 기본전략은 Json이다.