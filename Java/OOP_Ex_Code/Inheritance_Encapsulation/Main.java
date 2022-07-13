package Inheritance_Encapsulation; // package declare for preventing error


public class Main {
    public static void main(String[] args) {
        Bike bike = new Bike(); // 각각의 타입으로 선언 + 각각의 타입으로 객체 생성
        Car car = new Car();
        MotorBike motorBike = new MotorBike();

        bike.run();
        car.run();
        motorBike.run();

        Vehicle bike2 = new Bike(); // 상위 클래스 타입으로 선언 + 각각 타입으로 객체 생성
        Vehicle car2 = new Car();
        Vehicle motorBike2 = new MotorBike();

        bike2.run();
        car2.run();
        motorBike2.run();

        // 모든 객체를 상위 클래스 타입 하나로 선언하면 다음과 같이 간편하게 배열로 선언하여 관리할 수 있다는 편리성이 있습니다.
        Vehicle[] vehicles = new Vehicle[] { new Bike(), new Car(), new MotorBike()};
        for (Vehicle vehicle : vehicles) {
            vehicle.run();
        }
    }
}

class Vehicle { // 상위 클래스
    void run() {
        System.out.println("Vehicle is running");
    }
}

class Bike extends Vehicle { // 하위 클래스
    void run() { // 메서드 오버라이딩
        System.out.println("Bike is running");
    }
}

class Car extends Vehicle { // 하위 클래스
    void run() { // 메서드 오버라이딩
        System.out.println("Car is running");
    }
}

class MotorBike extends Vehicle { // 하위 클래스
    void run() { // 메서드 오버라이딩
        System.out.println("MotorBike is running");
    }
}


/*출력값
Bike is running
Car is running
MotorBike is running
Bike is running
Car is running
MotorBike is running
Bike is running
Car is running
MotorBike is running
 */