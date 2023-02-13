# CSS 전환(transition)

요소의 전환(시작과 끝) 효과를 지정하는 단축 속성이다. 쉼표를 사용하여 여러 개의 전환 속성들을 지정 가능하다.

<br>

### <사용법>

```css
transition : 속성명 지속시간 타이밍함수 대기시간;
```

<br>

### <쉼표 사용법>

```css
transition {
width 1s,
background-color 2s;
}
```
-> 가로너비는 1초동안 전환, 배경색은 2초동안 전환.

<br>

**주의❗️**

<u>**지속시간**</u>은 단축형(=4개 전부 입력 안하는 경우)으로 작성할 때, 필수 포함 속성이다!

<br>

### <개별속성>

`transition-property`

전환 효과를 사용할 속성 이름을 지정
- all(기본값) : 모든 속성에 적용
- 속성이름 : 전환 효과를 사용할 속성 이름 명시

<br>

`transition-duration`

전환 효과의 지속시간을 지정
- 0s(기본값) : 전환 효과 없음
- 시간 : 지속시간(s)을 지정

<br>

`transition-timing-function`

전환 효과의 타이밍 함수를 지정. Easing function 이라고도 불린다.
- ease(기본값) : 느리게 - 빠르게 - 느리게
- liner : 일정하게
- ease-in : 느리게 - 빠르게
- ease-out : 빠르게 - 느리게
- ease-in-out : 느리게 - 빠르게 - 느리게

<br>

`transition-delay`

전환 효과가 몇 초 뒤에 시작할지 대기시간을 지정
- 0s(기본값) : 대기시간 없음
- 시간 : 대기시간(s)을 지정

<br>

`transition: 시간 시간;`

위 처럼 시간 두 개가 속성값으로 입력되면
- 첫 번째 시간 : 지속시간 (duration)
- 두 번째 시간 : 대기시간 (delay)

<br>

### <구글 검색 추천>
* easing function -> easing 함수 치트 시트 참고
* esaing function mdn
* tweenmax easing -> 시각적 함수 확인 가능