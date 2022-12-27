# Kotlin Runtime

코틀린 컴파일 시 런타임을 포함 시키지 않을 경우 `java.lang.NoClassDefFoundError`예외를 만난다.

```bash
$ kotlinc HelloWorld.kt -d HelloWorld.jar
$ java -jar HelloWorld.jar
Exception in thread "main" java.lang.NoClassDefFoundError:  kotlin/jvm/internal/Intrinsics
at HelloWorldKt.main(HelloWorld.kt)
Caused by: java.lang.ClassNotFoundException:  kotlin.jvm.internal.Intrinsics
```

Kotlin comes with its own standard class library (Kotlin runtime), which is different from the Java library. As a result, you need to merge it into the resulting JAR, or provide it in the classpath:

```bash
$ java -cp $KOTLIN_HOME/lib/kotlin-runtime.jar:HelloWorld.jar  HelloWorldKt
```

매번 KOTLIN_HOME 경로를 설정해주기 번거로우니 `-include-runtime` 플래그를 사용하여 컴파일하는 것이 편하다.
```bash
$kotlinc -include-runtime HelloWorld.kt -d HelloWorld
```