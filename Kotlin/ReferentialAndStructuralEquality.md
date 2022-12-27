# Kotlin: Referential equality and structural equality


### Referential Equality(참조적 동등성)

두 개의 개별 참조가 메모리에서 정확히 동일한 인스턴스를 가리키는 경우이다. 두 참조가 동일한 인스턴스를 가리키는지 여부를 테스트하기 위해 `===(삼중 등호)` 또는 `!==`를 사용한다.

```kotlin
    val a = File("/mobydick.doc") 
    val b = File("/mobydick.doc") 
    val sameRef = a === b // false
```

같은 File(데이터)을 참조하고 있을지라도, 두 개의 개별 객체이기 때문에 `a === b` 의 결과는 `false` 이다.

<br>

### Structural Equality

두 개체가 메모리에서 별도의 인스턴스이지만 동일한 값을 갖는 경우이다. 두 개체의 값이 같은지 테스트하려면 `==` 또는 `!=`를 사용한다. 이와 같은 호출은 `equals` 함수의 사용으로 변환된다.

```Kotlin
    val a = File("/mobydick.doc") 
    val b = File("/mobydick.doc") 
    val structural = a == b // true; 동일한 값을 갖는다.
```

> Java '=='
>
> Java의 '=='는 참조 동등성을 위한 연산자이다.

<br>

> '==': Null save
> == 연산자는 null로부터 안전하다. 즉, 컴파일러가 null 검사를 추가하므로 null 인스턴스를 테스트하는 경우 걱정할 필요가 없다.

<br>

```kotlin
    val a = null
    val b = null
    val isTrue = a == b // true
```