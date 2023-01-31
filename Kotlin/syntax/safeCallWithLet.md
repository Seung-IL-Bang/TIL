# Safe Call Operator with 'let' function

세이프 콜은 `let` 함수와 함께 사용될 수 있다.

```kotlin
receiver?.let {
    // code block to be executed if receiver is not null
}
```

safe call 앞에 `receiver` 가 `null`이 아니면 `let` 함수의 코드 블록 `{ }` 내부가 실행된다.

만약 `receiver`가 null이라면 코드 블록 내부는 무시된다.

ex)

```kotlin
val name: String? = "John"
name?.let {
    println("Length of name is ${it.length}")
}
// Length of name is 4
```