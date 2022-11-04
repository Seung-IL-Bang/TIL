# 500 Internal Server Error

팀 프로젝트 진행 도중 `500` 에러를 두 번이나 마주했다...

<br>

**문제 상황**

1. DB 스키마가 달라진 상태에서 `application.yml` 설정 중에서 `jpa.hibernate.aal-auto` 를 `update`로 해놨기 때문.

```yaml
jpa:
    database: mysql
    database-platform: org.hibernate.dialect.MySQL5InnoDBDialect
    show-sql: true
    hibernate:
      ddl-auto: update
```

2. 컨트롤러 핸들러 메서드 중 API `엔드포인트 중복`이 발생했기 때문.

<br>

**문제 원인과 대책**

1. `update` 설정은 이미 정해진 DB 스키마의 데이터 정보만 새로 갱신해주는 것이지, DB 스키마, 즉 변경된 테이블마저 갱신해주지 않는다. 따라서 테이블이 변경된 부분이 있으면 `update` 설정하고 애플리케이션 구동시 `500`에러를 만날 수 있다. `ddl-auto`를 `create`로 한번 실행해주면 새로운 DB 스키마가 적용되어 그 이후로 `update`를 사용해도 에러를 피할 수 있다.
2. 당연히 중복된 API가 있다면, 어떤 엔드포인트로 메서드를 지정해줘야 될지 모른다. <u>따라서 API 경로가 겹치지 않도록 잘 설계하자.</u>

<br>
