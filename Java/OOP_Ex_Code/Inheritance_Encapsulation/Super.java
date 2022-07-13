// super 키워드에 대한 예제 코드

package Inheritance_Encapsulation; // package declare for preventing error


public class Super {
    public static void main(String[] args) {
        Lower l = new Lower();
        l.callNum();
    }
}

class Upper {
    int count = 20; // super.count
}

class Lower extends Upper {
    int count = 15; // this.count

    void callNum() {
        System.out.println("count = " + count); // super를 붙이지 않았기에 자신이 속한 클래스의 객체를 먼저 참조
        System.out.println("this.count = " + this.count);
        System.out.println("super.count = " + super.count);
    }
}

/*출력값
count = 15
count = 15
*/