# gRPC 서비스와 HTTP API 비교

## gRPC 장점

### 성능
- 효율적인 이진 메시지 형식 사용: [Protobuf](https://developers.google.com/protocol-buffers/docs/overview)
- Protobuf는 서버와 클라이언트에서 매우 빠르게 직렬화(Serialization)
- 직렬화는 매우 작은 메시지 페이로드를 발생시키며, 제한된 대역폭에서 중요

### 코드 생성
- gRPC 개발의 핵심 파일은 gRPC 서비스 및 메시지의 계약을 정의하는 [.proto 파일](https://developers.google.com/protocol-buffers/docs/proto3) 입니다.
- 서버와 클라이언트 간에 `.proto` 파일을 공유하여 메시지와 클라이언트 코드를 종단 간에 생성할 수 있다.
- client의 코드 생성은 클라이언트와 서버에서 메시지의 중복을 제거하면서 이뤄짐.
- 클라이언트를 직접 작성하지 않아도 되므로 개발 시간이 상당히 절감됨.

### 엄격한 사양
- JSON을 사용하는 HTTP API는 공식 사양이 없는 반면 gRPC 사양은 서비스가 따라야 하는 형식에 대한 엄격한 지침이 있습니다.
- 이는 gRPC 개발 과정 중 논쟁의 여지가 없으므로 개발 시간을 절약합니다.

### 스트리밍
- gRPC 서비스는 모든 스트리밍 조합을 지원
  
  - 단항(스트리밍 없음)
  - 서버-클라이언트 스트리밍
  - 클라이언트-서버 스트리밍
  - 양방향 스트리밍

### 최종 기한/시간 초과 및 취소
- 클라이언트의 [RPC](https://ko.wikipedia.org/wiki/%EC%9B%90%EA%B2%A9_%ED%94%84%EB%A1%9C%EC%8B%9C%EC%A0%80_%ED%98%B8%EC%B6%9C)가 완료될 때까지 대기하는 기간을 지정할 수 있음.
- `최종 기한`이 서버에 전송되고 서버에서 최종 기한을 초과하는 경우 수행할 작업을 결정할 수 있다.

## gRPC 권장 시나리오

### 마이크로 서비스
: gRPC는 대기 시간이 짧고 처리량이 높은 통신을 위해 설계되었다. 효율성이 중요한 경량 마이크로 서비스에 적합하다.

### 지점 간 실시간 통신
: 양방향 스트리밍을 위한 뛰어나 지원 기능을 제공한다. gRPC 서비스는 [폴링(polling](https://ko.wikipedia.org/wiki/%ED%8F%B4%EB%A7%81_(%EC%BB%B4%ED%93%A8%ED%84%B0_%EA%B3%BC%ED%95%99)))을 사용하지 않고 실시간으로 메시지를 푸시할 수 있다.

### Polyglot 환경
: 널리 사용되는 모든 개발 언어를 지원한다. 따라서 다중 언어 환경에 적합하다.

### 네트워크 제한 환경
: gRPC 메시지는 경량 메시지 형식인 `Protobuf`를 사용하여 직렬화된다. gRPC 메시지는 항상 해당 JSON 보다 가볍기 때문에 제한된 네트워크 환경에서 유리합니다.

### IPC(프로세스 간 통신)
: IPC 전송은 gRPC에서 동일한 머신에 있는 앱 간에 통신에 사용될 수 있습니다.

---

## gRPC 약점

### 제한된 브라우저 지원
: 현재 브라우저에서 gRPC 서비스를 직접 호출하는 것은 불가능 합니다.
- gRPC-Web
- RESTful JSON Web API

위 두 가지 일반적인 방법으로 gRPC를 브라우저 앱으로 가져올 수 있습니다.

### 사람이 읽을 수 없음
: HTTP API 요청은 `text`로 전송되어 사람이 읽고 만들 수 있습니다. 반면에 gRPC 메시지는 기본적으로 Protobuf로 인코딩됩니다. Protobuf는 송신 및 수신에 효율적이지만, 이진 형식은 사람이 읽을 수 없습니다.

### 대체 프레임워크 시나리오
다음과 같은 시나리오에서는 gRPC보다 다른 프레임워크가 권장됩니다.
- 브라우저에서 액세스 가능한 API: gRPC는 브라우저에서 완전히 지원되지는 않습니다. gRPC-Web은 브라우저 지원을 제공할 수 있지만 제한 사항이 있으며 서버 프록시를 도입합니다.
- 브로드캐스트 실시간 통신: gRPC는 스트리밍을 통해 실시간 통신을 지원하지만 등록된 연결에 메시지를 브로드캐스트하는 개념이 없습니다.

---

## 개괄적인 비교

다음 표에서는 gRPC와 JSON을 사용하는 HTTP API 간의 고급 기능 비교를 제공합니다.

| 기능                 | gRPC                                                         | JSON을 사용하는 HTTP API        |
| :------------------- | :----------------------------------------------------------- | :------------------------------ |
| 계약                 | 필수(`.proto`)                                               | 선택 사항(OpenAPI)              |
| 프로토콜             | HTTP/2                                                       | HTTP                            |
| Payload              | [Protobuf](https://docs.microsoft.com/ko-kr/aspnet/core/grpc/comparison?view=aspnetcore-6.0#performance)(소형, 이진) | JSON(대형, 사람이 읽을 수 있음) |
| 규범                 | [엄격한 사양](https://docs.microsoft.com/ko-kr/aspnet/core/grpc/comparison?view=aspnetcore-6.0#strict-specification) | 느슨함. 모든 HTTP가 유효합니다. |
| 스트리밍             | [클라이언트, 서버, 양방향](https://docs.microsoft.com/ko-kr/aspnet/core/grpc/comparison?view=aspnetcore-6.0#streaming) | 클라이언트, 서버                |
| 브라우저 지원        | [아니요(gRPC-웹 필요)](https://docs.microsoft.com/ko-kr/aspnet/core/grpc/comparison?view=aspnetcore-6.0#limited-browser-support) | 예                              |
| 보안                 | 전송(TLS)                                                    | 전송(TLS)                       |
| 클라이언트 코드 생성 | [예](https://docs.microsoft.com/ko-kr/aspnet/core/grpc/comparison?view=aspnetcore-6.0#code-generation) | OpenAPI + 타사 도구             |
