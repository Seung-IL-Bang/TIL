Ex. Enum 사용 안하는 경우 ❌
```java
class Seasons {
    public static final Seasons SPRING = new Seasons();
    public static final Seasons SUMMER = new Seasons();
    public static final Seasons FALL   = new Seasons();
    public static final Seasons WINTER = new Seasons();
}

public class Main {
    public static void main(String[] args) {
        Seasons seasons = Seasons.SPRING;
        switch (seasons) {
            case Seasons.SPRING:
                System.out.println("봄");
                break;
            case Seasons.SUMMER:
                System.out.println("여름");
                break;
            case Seasons.FALL:
                System.out.println("가을");
                break;
            case Seasons.WINTER:
                System.out.println("겨울");
                break;
        }
    }
}

/*
출력값 

java: incompatible types: Seasons cannot be converted to int
*/
```
`switch`문의 조건은 `char, byte, short, int, Character, Byte, Short, Integer, String, enum` 타입만 가능하지만, 위의 seasons 는 사용자 정의 타입이기 때문이다. 따라서 코드를 실행하면 호환되지 않는 타입이라는 에러가 발생한다.

<br>

Ex. Enum 사용 하는 경우 ⭕️
```java
enum Seasons {SPRING, SUMMER, FALL, WINTER}

public class Main {
    public static void main(String[] args) {
        Seasons seasons = Seasons.SPRING;
        switch (seasons) {
            case SPRING:
                System.out.println("봄");
                break;
            case SUMMER:
                System.out.println("여름");
                break;
            case FALL:
                System.out.println("가을");
                break;
            case WINTER:
                System.out.println("겨울");
                break;
        }
    }
}

//출력값 
봄
```
`Seasons` 라는 이름의 열거형은 `SPRING, SUMMER, FALL, WINTER` 는 총 네 개의 열거 객체를 포함하고 있다고 말할 수 있다.



<br>

Ex. Enum 메서드 사용 예제 ✨

```java
enum Level {
  LOW, // 0
  MEDIUM, // 1
  HIGH // 2
}

public class EnumTest {
    public static void main(String[] args) {
        Level level = Level.MEDIUM;

        Level[] allLevels = Level.values();
        for(Level x : allLevels) {
            System.out.printf("%s=%d%n", x.name(), x.ordinal());
        }

        Level findLevel = Level.valueOf("LOW");
        System.out.println(findLevel);
        System.out.println(Level.LOW == Level.valueOf("LOW"));

        switch(level) {
            case LOW:
                System.out.println("낮은 레벨");
                break;
            case MEDIUM:
                System.out.println("중간 레벨");
                break;
            case HIGH:
                System.out.println("높은 레벨");
                break;
        }
    }
}

//출력값
LOW=0
MEDIUM=1
HIGH=2
LOW
true
중간 레벨
```

1. `values()` 메서드는 컴파일러가 자동적으로 모든 열거형에 추가해주는 메서드로 Level 에 정의된 모든 상수를 배열로 반환한다.
2. `name()` 과 `ordinal()` 을 사용하여 각각 이름과 순서를 출력값으로 반환하고 있다.
3. `valueOf()` 메서드를 활용하여 지정된 열거형에서 이름과 일치하는 열거형 상수를 반환하고, 반환된 상수가 의도했던 상수와 일치하는 지 여부를 불리언 값으로 확인한다.

