```java
// getter & setter 예제 코드

public class GetterSetterTest {
    public static void main(String[] args) {
        Worker w = new Worker();
        w.setName("김코딩"); // setter method
        w.setAge(30);
        w.setId(5);

        String name = w.getName(); // getter method
        System.out.println("근로자의 이름은 " + name);
        int age = w.getAge();
        System.out.println("근로자의 나이는 " + age);
        int id = w.getId();
        System.out.println("근로자의 ID는 " + id);
    }
}

class Worker {
    private String name; // 변수의 은닉화. 외부로부터 접근 불가
    private int age;
    private int id;

    public String getName() { // 멤버변수의 값
        return name;
    }

    public void setName(String name) { // 멤버변수의 값 변경
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age < 1) return;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

// 출력값
근로자의 이름은 김코딩
근로자의 나이는 30
근로자의 ID는 5
```