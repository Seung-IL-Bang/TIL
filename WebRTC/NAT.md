# NAT(Network Address Translation)

개인 Host는  LAN에서 Private IP를 사용한다. 이 때 다른 네트워크를 접속하고 데이터를 주고 받기 위해서는 Public IP 가 필요하다.

### 기능
`NAT`는 Private IP를 Public IP로 1대 1 대응시켜 변환하는 장치를 말한다.

### 문제
WebRTC은 P2P 방식으로 Peer의 Public IP를 알고 있어야 한다. 그런데 NAT 장치는 WebRTC 통신에서 많은 문제를 야기한다.

### 해결책
NAT가 일으킨 문제는 STUN, TURN 서버를  통해 문제를 해결할 수 있다.