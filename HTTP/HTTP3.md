# HTTP/3

## 오늘 배운 사실

> **HTTP3**
> 
> * 이전 버전들 특징
> 
>   - TCP 기반
> 
> * HTTP/3 특징
>
>   - UDP 기반
>   - QUIC 계층 위에서 돌아간다.

> **장점**
>
> - HTTP/2의 장점을 그대로 가지고 옴.
> - 초기 연결 설정 시 지연 시간 감소
> 
>      : 3-way HandShake 생략, QUIC 첫 연결 설정에 1-RTT만 소요되고 바로 본 통신 시작.

> [**순방향 오류 수정 메커니즘(FEC, Forword Error Correction)**](http://www.ktword.co.kr/test/view/view.php?m_temp1=693)
> 
> : QUIC은 FEC을 적용하여 전송한 패킷이 손실되었다면 수신 측에서 에러를 검출하고 수정하는 방식을 통해 열악한 네트워크 환경에서도 낮은 패킷 손실률을 자랑한다.