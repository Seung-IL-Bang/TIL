# CSS 배경(background)

다음은 배경에 적용 가능한 속성들이다.

**1. background-color : 요소의 배경 색상**
- transparent(기본값) : 투명함
- 색상 : 지정 가능한 색상 표현 방법

<br>

**2. background-image : 요소의 배경 이미지 삽입**
- none(기본값) : 이미지 없음
- url("경로") : 이미지 경로, 큰따옴표 생략 가능하나 경로의 인식률을 높이기 위해 사용 권장, 이미지는 기본적으로 바둑판식 반복 배열 출력을 한다.

<br>

**3. background-repeat : 요소의 배경 이미지 반복**
- repeat(기본값) : 이미지를 수직, 수평 반복
- repeat-x : 이미지를 수평 반복
- repeat-y : 이미지를 수직 반복
- no-repeat : 반복 없음

<br>

**4. background-position : 요소의 배경 '이미지' 위치**
- 0% 0% (기본값) : 0% ~ 100% 사이 값
- 방향 : top, bottom, left, right, center 방향
- 단위: px, em, rem 등 단위로 지정
- 1개 단위 값 -> x축 y축 동일한 값
- 2개 단위 값 -> a b -> x y

<br>

**5. background-size : 요소의 배경 이미지 크기**
- auto(기본값) : 이미지의 실제 크기
- 단위 : px, em, rem 등 단위로 지정
- cover : 비율을 유지, 요소의 더 넓은 너비에 맞춤
- contain : 비율을 유지, 요소의 더 짧은 너비에 맞춤

<br>

**6. background-attahment : 요소의 배경 이미지 스크롤 생성**
- scroll(기본값) : 이미지가 요소를 따라서 같이 스크롤
- fixed : 이미지가 뷰포트에 고정, 스크롤 x