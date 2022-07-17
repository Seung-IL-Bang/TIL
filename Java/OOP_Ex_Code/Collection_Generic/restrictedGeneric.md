1. `<T>` ➡️ 타입을 지정하는 데 아무런 제한이 없다.

```java
class Flower { ... }
class Rose extends Flower { ... }
class RosePasta { ... }

// 제네릭 클래스 정의 
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

		// 인스턴스화 
		Basket<Rose> roseBasket = new Basket<>();
		Basket<RosePasta> rosePastaBasket = new Basket<>();
}
```

<br>

2. `<T extends 상위클래스>` ➡️ 상위클래스의 하위클래스만 지정하도록 제한한다.

```java
class Flower { ... }
class Rose extends Flower { ... }
class RosePasta { ... }

class Basket<T extends Flower> {
    private T item;
	
		...
}

public static void main(String[] args) {

		// 인스턴스화 
		Basket<Rose> roseBasket = new Basket<>();
		Basket<RosePasta> rosePastaBasket = new Basket<>(); // 에러
}
```

<br>

3. 특정 인터페이스를 구현한 클래스만 타입으로 지정할 수 있도록 제한할 수도 있다. 이 경우에도 동일하게 `extends` 키워드를 사용한다.

```java
interface Plant { ... }
class Flower implements Plant { ... }
class Rose extends Flower implements Plant { ... }

class Basket<T extends Plant> {
    private T item;
	
		...
}

public static void main(String[] args) {

		// 인스턴스화 
		Basket<Flower> flowerBasket = new Basket<>();
		Basket<Rose> roseBasket = new Basket<>();
}

```

<br>

4. 특정 클래스를 상속받으면서 동시에 특정 인터페이스를 구현한 클래스만 타입으로 지정할 수 있도록 제한하려면 `&`를 사용하여 코드를 작성해주면 된다. `<T extends 인터페이스 & 클래스>`

```java
interface Plant { ... }
class Flower implements Plant { ... }
class Rose extends Flower implements Plant { ... }

class Basket<T extends Plant & Flower> {
    private T item;
	
		...
}

public static void main(String[] args) {

		// 인스턴스화 
		Basket<Flower> flowerBasket = new Basket<>();
		Basket<Rose> roseBasket = new Basket<>();
}


```