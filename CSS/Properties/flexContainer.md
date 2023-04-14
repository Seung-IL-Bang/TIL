# CSS Flex Container

부모 요소인 Flex Cotainer에 적용 가능한 속성들은 아래와 같다.

### `display` 
Flex Container의 화면 출력(보여짐) 특성
- flex : 블록 요소와 같이 Flex Container 정의
- inline-flex : 인라인 요소와 같이 Flex Container 정의

<br>

### `flex-direction`
주 축(Main-Axis)을 설정; 수평정렬? or 수직정렬? 보통 블록 요소는 기본적으로 수직으로 쌓이기 때문에 column 속성값들은 거의 쓰지 않음. 주축에 직각인 축을 교차축(Cross-Axis)라고 한다. 주축과 교차축, 시작점과 끝점은 상대적이다.

<수평>
- row : 행 축 정렬(좌 -> 우)
- row-reverse : 행 축 정렬 (우 -> 좌)
  
<수직>
- column : 열 축 정렬 (위 -> 아래)
- column-reverse : 열 축 정렬 (아래 -> 위)

<시작점과 끝점>

- flex-start: 시작점
- flex-end: 끝점

<br>

### `flex-wrap`

Flex-items 묶음(줄 바꿈) 여부

- nowrap(기본값) : 묶음(줄 바꿈) 없음
- wrap : 여러 줄로 묶음

자식 요소들이 정렬될 때 컨테이너의 너비를 초과하면 요소들의 너비가 찌그러진다. 이 현상을 막기 위해 만약 컨테이너의 너비를 초과한다면 줄 바꿈을 하는 속성이다(wrap). 줄바꿈을 하면 자식 요소의 너비는 찌그러지지 않는다.

<br>

### `justify-content`

주 축의 정렬 방법

- flex-start(기본값) : Flex Items(자식 요소들) 를 시작점에서 정렬
- flex-end : Flex Items 를 끝점에서 정렬
- center : Flex Items 를 가운데에서 정렬

[MDN Reference](https://developer.mozilla.org/ko/docs/Web/CSS/justify-content)

> 주의 ❗️
>
>flex-direction 을 바꿔서 주축을 변경하지 않는 이상, 정렬되는 위치만 다를 뿐 정렬되는 요소들의 순서는 바뀌지 않는다!

> Tip ⭐️
>
> 보통 자식 요소들의 '수평 정렬'에 사용된다.

<br>

### `align-content`

교차 축의 '여러 줄' 정렬 방법. `flex`는 대부분 수평 정렬에 사용하게 되므로 교차 축을 보통 수직 축으로 생각하면 편하다.

- stretch(기본값) : Flex Items(자식 요소들)를 교차축으로 늘림
- flex-start : Flex Items를 시작점으로 정렬
- flex-end : Flex Items를 끝점으로 정렬
- center : Flex Items를 가운데 정렬

> 사용 시 주의 사항 ❗️
> 
> `align-content`를 사용하기 위해선 두 줄 이상이어야 하고 컨테이너의 여백이 남아 있어야 한다. 즉 `flex-wrap: wrap;` 적용이 선행되어야 하고 컨테이너에 여유 공간이 남아 있어야 한다.

> Tip⭐️
> 
> 사용 조건이 위 사항처럼 까다롭기 때문에 해당 속성보단 'align-itmes' 속성을 더 많이 사용하게 된다.

<br>

### `align-items`

교차 축의 '한 줄' 정렬 방법

- stretch : Flex Items(자식 요소들)를 교차 축으로 늘림
- flex-start : Flex Items를 각 줄의 시작점으로 정렬
- flex-end : Flex Items를 각 줄의 끝점으로 정렬
- center : Flex Items를 각 줄의 가운데 정렬

자식 요소들의 정렬이 한 줄에서 표현이 된다면 `align-items`를 사용하는 것이 좋고, 여러 줄로 표현이 된다면 `align-content`를 사용하는 것이 좋다.

> Tip ⭐️
>
> 보통 자식 요소들의 '수직 정렬'에 많이 사용된다.