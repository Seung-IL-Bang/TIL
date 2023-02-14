# lodash 유용한 메소드

lodash는 default 통로로 가져오는 방법으로 { } 으로 감싸지 않고 할당받는 변수명을 자유롭게 쓸 수 있다. **통상적으로 언더바 ( _ )를 사용한다.**

<br>

`_ . uniq( arr ) -> arr`

중복 요소를 제외한 배열을 리턴한다. (=집합)

<br>

`_ . uniqBy(arr, identity) -> arr`

중복을 구별할 식별자를 통해 arr의 중복을 제거한 배열을 반환한다.

<br>

`_ . unionBy(...arr, indentity) -> arr`

식별자를 토대로 중복을 제거하여 합친 배열을 반환한다.

<br>

`_ . find(collection, identity, fromIndex=0)`

콜렉션에 0번 인덱스부터 식별자 조건에 부합하는 요소를 탐색하고, 가장 먼저 탐색되는 요소를 반환한다.

<br>

`_ . findIndex(collection. identity, fromindex=0)`

find와 로직이 같고 반환하는 값만 요소가 아닌 해당 인덱스를 반환한다.

<br>

`_ . remove(collection, indentity)`

식별자 조건에 부합하는 모든 요소를 콜렉션에서 지운다.

<br>

[lodash documentation](https://lodash.com/docs/4.17.15)