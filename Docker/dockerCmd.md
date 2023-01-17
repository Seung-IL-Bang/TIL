# docker 명령어 모음

1. 실행중인 컨테이너 리스트
```bash
docker ps
```

2. 도커 이미지 리스트 
```bash
docker image ls
```

3. 도커 이미지 ➡️ 컨테이너 구동
```bash
docker run -p <localPort>:<containerPort> <Image ID or Name>
```

4. 컨테이너 구동 & 컨테이너 터미널 진입
```Bash
docker run -it <container ID or Name>
```

5. 컨테이너 및 이미지 삭제
```bash
docker image rm <ID or Name>

docker container rm <ID or Name>
```