# 데이터 불변성(Immutability)

### 원시 데이터

- String
- Number
- Boolean
- undefined
- null

원시 데이터는 기존의 메모리 주소에 들어 있는 경우에 동일한 값의 새로운 원시 데이터가 만들어 진다면 기존 원시 데이터의 메모리 주소를 참조하게 된다. 따라서 원시 데이터는 한번 메모리에 등록되면 메모리 주소가 변하지 않기때문에, 원시 데이터는 불변성이 있다. 쉽게 말해 원시 데이터는 리터럴 값이 다르면 다른 값이고, 리터럴 값이 같으면 같은 값이다.(같은 주소를 가리킨다)

<br>

### 참조형 데이터

- Object
- Array
- Function

참조형 데이터는 기존의 메모리 주소에 동일한 리터럴 데이터 참조가 있더라도, 항상 새로운 메모리 주소를 만들어낸다. 참조형 데이터를 사용할 땐 같은 메모리 주소를 가리키는 참조형 변수들이 여럿 존재할 수 있기 때문에 데이터 변화에 유의해야한다. 왜냐하면 같은 메모리 주소를 가리키는 경우 한쪽 변수에서 변화가 일어나면 다른 변수에서도 똑같은 변화가 일어나기 때문이다.


> 요약: 원시형 데이터는 불변성을 지니고 참조형 데이터는 가변성을 갖는다.