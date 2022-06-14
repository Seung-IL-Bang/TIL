# WebRTC Outline

> ## WebRTC?
> -> Web Real Time Communication<br />

### WebRTC Characteristic
- 개방형 표준 외에 작동하는 실시간 통신 기능을 애플리케이션에 추가 가능.
- 동영상, 음성, 일반 데이터를 동종 앱 간에 전송 가능하여 강력한 음성 및 영상 통신 솔루션 구축.
- WebRTC는 개방형 웹 표준으로 구현되며 브라우저에서 자바스크립트 API로 제공됨
- Android & iOS 같은 네이티브 클라이언트의 경우 동일한 기능을 제공하는 라이브러리 사용 가능.
- 오픈 소스입니다.

### WebRTC 장점
- Latency가 짧다
- 별도의 설치 없이 Web에서 실시간 소통이 가능하다.
- 개발의 진입장벽이 낮다.
- 오픈 소스이다.

### WebRTC 단점
- 크로스 브라우징 문제<br />
  : 인기가 없는 브라우저나 최신 버전을 사용하지 않는 유저들은 사용이 불가능 하다.<br>
  *ex) Internet Explorer는 지원되지 않음.*
- STUN/TURN 서버 필요<br>
  : P2P 통신을 위해서는 사용자의 IP 주소를 알아야 한다. 하지만 대부분의 사용자들은 방화벽 등을 사용하기 때문에 다른 네트워크 상에서 연결이 이루어지려면 STUN/TURN 서버가 꼭 필요하다.

### WebRTC 통신 원리
- Peer to Peer Communication(P2P)
: 동등한 계층 간 통신 방식으로 클라이언트, 서버의 개념없이 동등한 노드들로 구성되어 데이터를 주고 받는 형식이다.

### 알아야 할 용어
- data stream
- [NAT(Network Address Translation)](./NAT.md)
- Signaling
- SDP
- JSEP
- UDP/TCP
- [ICE(Interactive Connectivity Establishment)](./ICE.md)
- [STUN(Session Traversal Utilities for NAT)](./STUN%26TURN.md)
- [TURN(Traversal Using Relays around NAT)](./STUN%26TURN.md)