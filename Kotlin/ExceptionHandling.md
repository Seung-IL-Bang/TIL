# Kotlin Exception Handling

예외 처리는 Java가 예외를 처리하는 방식과 거의 동일하지만 Kotlin의 한 가지 주요 차이점은 모든 예외가 `Unchecked Exception`이라는 점이다.

대표 예
- `Checked Exception` ➡️ `IOException`
- `Unchecked Exception` ➡️ `NullPointerException`

<br>

> 참고
>
> 확인된 예외(Checked exception)는 메서드 시그니처의 일부로 선언되거나 메서드 내에서 처리되어야 하는 예외이다. 그리고 확인되지 않은 예외(Unchecked exception)는 메서드 시그니처에 추가할 필요가 없는 예외이다. 

<br>

`try`-`catch`-`finally` 구문은 Java와 동일한 방식을 따른다.

- `try` : 예외가 발생하면 catch구문으로 넘어간다.
- `catch` : 예외가 발생해야지만 해당 구문을 실행한다.
- `finally` : 예외가 발생하든 안 하든 상관없이 마지막에 항상 실행된다. finally 구문은 나머지 구문과 달리 **선택 사항**이다.

<br>

```kotlin
    fun readFile(path: Path): Unit { 
      val input = Files.newInputStream(path) 
      try { 
        var byte = input.read() 
        while (byte != -1) { 
          println(byte) 
          byte = input.read() 
        } 
      } catch (e: IOException) { 
        println("Error reading from file. Error was ${e.message}") 
      } finally { 
        input.close() 
      } 
    } 
```

