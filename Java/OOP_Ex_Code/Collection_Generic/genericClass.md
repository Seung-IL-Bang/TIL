```java
// 제네릭 클래스를 사용할 때에도 다형성을 적용할 수 있습니다.

class Flower { ... }
class Rose extends Flower { ... }
class RosePasta { ... }

class Basket<T> {
    private T item;

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}

public static void main(String[] args) {
		Basket<Flower> flowerBasket = new Basket<>();
		flowerBasket.setItem(new Rose());      // 다형성 적용
		flowerBasket.setItem(new RosePasta()); // 에러
}

```

`new Rose()`를 통해 생성된 인스턴스는 `Rose` 타입이며, `Rose` 클래스는 `Flower` 클래스를 상속받고 있으므로, `Basket<Flower>`의 item에 할당될 수 있다. `Basket<Flower>`은 결국 `item`의 타입을 `Flower`로 지정하는 것이고, `Flower` 클래스는 `Rose` 클래스의 상위 클래스이기 때문이다.

<br>

반면, `new RosePasta()`를 통해 생성된 인스턴스는 `RosePasta` 타입이며, `RosePasta `클래스는 `Flower` 클래스와 아무런 관계가 없다. 따라서, `flowerBasket`의 `item`에 할당될 수 없다.

