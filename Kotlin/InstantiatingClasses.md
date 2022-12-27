# Kotlin: Instantiating Classses

코틀린은 Java와 달리 `new` 키워드를 통해 클래스의 객체를 인스턴스화 하지 않는다. 코틀린은 `클래스 이름` 그 자체를 사용하여 생성자 함수를 호출한다.

```kotlin
    val file = File("/etc/nginx/nginx.conf") 
    val date = BigDecimal(100) 
```