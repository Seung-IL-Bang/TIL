// super() 메서드 사용에 대한 예제 코드

package Inheritance_Encapsulation; // package declare for preventing error


public class Test {
    public static void main(String[] args) {
        Student s = new Student();
    }
}

class Human {
    Human() {
        System.out.println("휴먼 클래스 생성자");
    }
}

class Student extends Human { // Human 클래스로부터 상속
    Student() {
        super(); // Human 클래스의 생성자 호출
        System.out.println("학생 클래스 생성자");
    }
}