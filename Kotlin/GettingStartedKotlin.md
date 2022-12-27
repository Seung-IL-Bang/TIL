- Kotlin is a JVM language, and so the compiler will emit Java bytecode. Because of this, of course, Kotlin code can call Java code, and vice versa!

- To write and execute code written in Kotlin, you will need its runtime and the compiler. 

- Kotlin can also be run as a script.


Kotlin Compiler installment Using Homebrew (macOS only):

```bash
$ brew update
$ brew install kotlin
```

코틀린 파일 `.kt` -> `.jar`  컴파일 명령

`-include-runtime `is a flag for the compiler to produce a self-contained and runnable JAR by including the Kotlin runtime into the resulting assembly
```
kotlinc HelloWorld.kt -include-runtime -d HelloWorld.jar
```

컴파일 된 코틀린 파일 실행
```bash
$ java -jar HelloWorld.jar
```

코틀린 파일 -> 바이트 코드인 `.class` 파일 변환
```kotlin
kotlinc HelloWorld.kt
// HelloWorldKt.class (접미사 Kt 붙음 주의)
```
<br>


<참고>

javap tool available with the JDK을 이용하면

`static main` entry point를 대신 만들어 주는 것을 확인 가능
```bash
$ javap -c HelloWorldKt.class
```

```
Compiled from "HelloWorld.kt"
public final class HelloWorldKt {
  public static final void main(java.lang.String[]);
    Code:
      0: aload_0
      1: ldc           #9                  // String args
      3: invokestatic  #15                 // Method  kotlin/jvm/internal/Intrinsics.checkParameterIsNotNull:(Ljava/lang/Ob ject;Ljava/lang/String;)V
      6: ldc           #17                 // String Hello, World!
      8: astore_1
      9: nop
      10: getstatic     #23                 // Field  java/lang/System.out:Ljava/io/PrintStream;
      13: aload_1
      14: invokevirtual #29                 // Method  java/io/PrintStream.println:(Ljava/lang/Object;)V
      17: return
}
```
