
Ex. 매개변수와 리턴 값이 없는 람다식
```java
@FunctionalInterface
public interface MyFunctionalInterface {
    public void accept();
}

public class MyFunctionalInterfaceExample {
	public static void main(String[] args) throws Exception {
		MyFunctionalInterface example;
		example = () -> {
			String str = "첫 번째 메서드 호출!";
			System.out.println(str);
		};
		example.accept();

		example = () -> System.out.println("두 번째 메서드 호출!");
		//실행문이 하나라면 중괄호 { }는 생략 가능
		example.accept();
	}
}

// 출력값
첫 번째 메서드 호출!
두 번째 메서드 호출!
```

<br>

Ex. 매개변수가 있는 람다식
```java
@FunctionalInterface
public interface MyFunctionalInterface {
    public void accept(int x);
}

public class MyFunctionalInterfaceExample {
    public static void main(String[] args) throws Exception {
        MyFunctionalInterface example;
        example = (x) -> {
            int result = x * 5;
            System.out.println(result);
        };
        example.accept(2);

        example = (x) -> System.out.println(x * 5);
        example.accept(2);
    }
}

// 출력값
10
10
```

<br>

Ex. 리턴 값이 있는 람다식
```java
@FunctionalInterface
public interface MyFunctionalInterface {
    public int accept(int x, int y);
}

public class MyFunctionalInterfaceExample {
    public static void main(String[] args) throws Exception {
        MyFunctionalInterface example;
        example = (x, y) -> {
            int result = x + y;
            return result;
        };
        int result1 = example.accept(2, 5);
        System.out.println(result1);
        

        example = (x, y) -> { return x + y; };
        int result2 = example.accept(2, 5);
        System.out.println(result2);
       

	      example = (x, y) ->  x + y;
				// 실행문이 한 줄인 경우, 중괄호 {}와 return문 생략가능
        int result3 = example.accept(2, 5);
        System.out.println(result3);
       

        example = (x, y) -> sum(x, y);
				// 실행문이 한 줄인 경우, 중괄호 {}와 return문 생략가능
        int result4 = example.accept(2, 5);
        System.out.println(result4);
 
    }

    public static int sum(int x, int y){
        return x + y;
    }
}

//출력값
7
7
7
7
```