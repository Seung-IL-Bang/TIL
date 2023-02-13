# CSS Flex Items

자식 요소들인 Flex Items에 적용 가능한 속성들은 아래와 같다.

### `order`

Flex Item 의 정렬 순서를 지정한다

- 0 (기본값) : 순서 없음
- 숫자 : 숫자가 작을 수록 먼저, 음수 사용 가능

<br>

### `flex-grow`

Flex Item의 증가 너비 비율, 컨테이너의 '여백'을 차지하는 비율 정도를 의미한다.

- 0(기본값) : 증가 비율 없음
- 숫자 : 증가 비율

<br>

`flex-shrink`

Flex Item의 감소 너비 비율, 아이템(자식요소)들의 정렬된 크기보다 컨테이너(부모요소)가 작아질 경우 찌그러지는 경우가 있다. 이때 기본 값이 1이기 때문에, 줄어드는 것이다.

- 1(기본값) : Flex Container 너비에 따라 감소 비율 적용
- 숫자 : 감소 비율

<br>

### `flex-basis`

Flex Item의 공간 배분 전 기본 너비

- auto(기본값) : 요소의 Content 너비
- 단위 : px, em, rem 등 단위로 지정

기본 너비를 지정하지 않을 땐 flex-basis: 0; 으로 설정한다.

