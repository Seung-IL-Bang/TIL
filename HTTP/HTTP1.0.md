# HTTP/1.0

## 오늘 배운 사실

> HTTP는 애플리케이션 계층(OSI Layer 7)으로 웹 서비스 통신에 사용된다.

> HTTP/1.0은 한 연결당 하나의 요청을 처리하도록 설계되었다. 따라서 [RTT](https://en.wikipedia.org/wiki/Round-trip_delay)가 증가하는 단점이 존재한다.

> RTT 증가에 대한 해결책
> - 이미지 스플리팅
> 
>      : 많은 이미지를 합쳐서 하나의 이미지로 다운로드.
> - 코드 압축
> 
>      : 개행 문자, 띄어쓰시 등을 삭제하여 코드 길이 압축.
> - 이미지 Base64 인코딩
> 
>      : 이미지 파일을 64진법으로 이루어진 문자열로 인코딩.



  