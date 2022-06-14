# STUN & TURN Servers

## STUN(Session Traversal Utilities for NAT)

**Peer에게 Public IP 주소를 보내는 역할을 한다.**

STUN은 상호 연결 확립(ICE), 세션 개시 프로토콜(SIP), WebRTC 등의 기타 프로토콜들에 의해 사용되는 도구이다. 호스트가 네트워크 주소 변환기의 존재를 찾아내고 NAT의 원격 호스트에 대한 애플리케이션의 사용자 데이터그램 프로토콜(UDP) 플로를 위해 할당된 매핑된 (보통은 퍼블릭) 인터넷 프로토콜(IP) 주소와 포트 번호를 발견하기 위한 도구를 제공한다.

하지만, STUN은 항상 효과적이지 않다. 두 단말이 같은 NAT 환경에 있을 경우, 또는 NAT의 보안 정책이 엄격할 경우 STUN이 완벽한 해결책이 되지 않는다. 이런 경우 보완책으로 `TURN`을 이용한다.


## TURN(Traversal Using Relays around NAT)
**TURN은 릴레리로부터 IP 주소와 포트를 클라이언트가 취득할 수 있는 릴레이 주소를 할당한다.**

NAT 보안 정책이 너무 엄격하거나 NAT 순회를 하기 위해 필요한 NAT 바인딩을 성공적으로 생성할 수 없는 경우에 `TURN`을 사용한다.

TURN 서버는 인터넷망에 위치하고 각 Peer들이 Private IP안에서 통신한다. 각 Peer들이 직접 통신하는 것이 아니라 릴레이 역할을 하는 TURN 서버를 사용하여 경유한다.

하지만, 이런 TURN 서버는 장점만 있는 것은 아니다.

클라이언트와의 연결을 거의 항상 제공하지만 STUN 서버에 비해 리소스 낭비가 심하다. 그렇기 때문에, ICE Candidate 과정에서 local IP로 연결할 수 있는지, Public IP로 연결할 수 있는지를(모든 후보군을 찾은 후) 알아낸 후 최후의 수단으로 사용해야 한다.