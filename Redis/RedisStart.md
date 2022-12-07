# Redis 설치 및 간단 명령어


### Redis

- key: value로 값을 저장하는 NoSQL 데이터베이스다.
- 인-메모리(In-Memory) 데이터베이스로 메모리에 데이터가 저장된다. 
- 주로 캐싱, 세션 관리, pub/sub 및 순위표에 사용된다.

<br>

### 설치
```
$ brew install redis
```

### 시작, 중지, 재시작
```bash
$ brew services start redis # 시작

$ brew services stop redis # 중지

$ brew services restart redis # 재시작
```

### CLI 연결
```
$ redis-cli
```