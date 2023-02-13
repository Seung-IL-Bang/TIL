# CSS 변환 속성(perspective)

### `perspective`

하위 요소를 관찰하는 원근 거리를 지정하는 속성

- 단위: px 등 단위로 지정

<br>

### <perspective 속성과 함수 차이점>

`속성 perspective: px;`
   - 사용 권장
   - 사용법 : perspective: 600px;
   - 적용 대상 : 관찰 대상의 부모!!!
   - 기준점 설정 : perspective-origin

<br>


`함수 perspective(px)`
   - 사용법: transform: perspective(600px) ... ;
   - 적용 대상 : 관찰 대상 자체!!!
   - 기준점 설정 : transform-origin

**속성의 원근 거리 시작점은 부모 요소의 중심점으로부터 시작한다.**