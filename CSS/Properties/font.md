# CSS font

**1. font-style : 글자의 기울기**
- normal(기본값) : 기울기 없음
- italic : 이텔릭체 (기울어진 글자 대체, 권장)
- oblique : 기울어진 글자 (잘 안씀)

<br>

**2. font-weight : 글자의 두께(가중치)**
- normal, 400 : 기본 두께
- bold, 700 : 두껍게
- bolder : 상위 요소보다 더 두껍게
- lighter : 상위 요소보다 더 얇게
- 100 ~ 900 : 100단위의 숫자 9개, normal과 bold 이외 두께 지정가능

<br>

**3. font-size : 글자의 크기**
- 16px(기본값) : 기본 크기
- 단위 : px, em, rem 등 단위로 지정
- 상위 요소 대비; %, smaller, larger 등 -> 잘 안쓰임

<br>

**4. line-height : 한 줄의 높이, 행간과 유사**
- normal(= 1, 기본값) : 브라우저의 기본 정의를 사용
- 숫자 : 요소의 글꼴 크기의 배수로 지정(권장), 글꼴의 크기가 변경되더라도 간격은 항상 유지 가능
- 단위 : px, em, rem 등의 단위로 지정

<br>

**5. font-family : 글꼴(서체) 지정**

* font-family: 글꼴1, "글꼴 2", ... , 글꼴계열;
* 1순위 -> 글꼴1
* 2순위 -> "글꼴 2" ; 띄어쓰기 등 특수문자가 포함된 글꼴 이름은 큰 따옴표로 묶어야 한다. 전부 다 큰따옴표로 감싸도 상관없다.
* 마지막 순위 -> 앞 순위가 전부 브라우저가 인식하지 못하면 글꼴계열 중 아무 글꼴이나 브라우저가 가져다가 사용
! **글꼴계열은 필수로 작성해야 한다!**

* **권장 글꼴계열 : sans-serif (고딕체 계열)**