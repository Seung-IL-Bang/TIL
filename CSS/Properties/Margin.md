# CSS margin

요소의 외부 여백(공간)을 지정하는 단축 속성이다.(한 개의 값으로 상하좌우 처리를 해줘서 단축키와 같다고 해서 단축 속성이라 부른다.) 음수를 사용할 수 있다는 특징이 있다. 

<br>

**💡Tip**
> 여러 요소가 붙어 있는 경우 마진값을 주어 각각의 요소끼리 밀어내는 효과를 볼 수 있다. 단, 음수값인 경우 각각의 요소끼리 겹쳐지는 효과가 있다.

<br>

- 0 : 외부 여백 없음

- auto : 브라우저가 여백을 계산 **(가로/세로 너비가 있는 요소의 "가운데 정렬"에 활용한다.)**

- 단위 : px, em, vw 등 단위로 지정

<br>

### 사용법
1. **한 개의 값**
- margin : 상하좌우
- margin-top : 상
- margin-bottom : 하
- margin-left : 좌
- margin-right : 우

2. **두 개의 값**
- margin: a b;
(a -> 상하에 적용, b -> 좌우에 적용)

3. **세 개의 값**
- margin : a b c;
(a -> 상, b -> 좌우, c -> 하)

4. **네 개의 값**
- margin : a b c d;
(a->상, b->우, c->하, d->좌 ; 시계방향)

<br>

### ⭐️ margin 속성 활용 - 요소 가운데 정렬

만약 블록 요소의 가로 사이즈(width)가 지정된 상태에서 margin 속성값의 좌우가 'auto'라면 요소는 가운데 정렬이 된다.

<br>

**<조건>**
1. 적용 대상이 '블록' 요소이어야 한다.
2. 가로 너비가 지정되어 있어야 한다.
3. 위아래가 아닌 '좌우' 에만 margin 값이 auto여야 한다.

**<예시>**

```css
margin: 0 auto;
```