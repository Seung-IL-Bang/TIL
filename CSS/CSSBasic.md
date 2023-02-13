# CSS(Cascading Style Sheet) 개요

### 선택자(Selector)

: 선택자는 CSS 스타일을 html의 어떤 요소에 적용할지를 선택하는 일종의 규칙이다. 

```css
선택자 {
  속성: 값;
}
```

- 선택자: 스타일 적용할 대상
- 속성: 스타일의 종류(Property)
- 값: 특정 속성의 값
- { }: 해당 선택자에 적용될 스타일 범위

<br>

### 브라우저 스타일 초기화

: 크로스 브라우징 이슈를 해결하기 위해 각 브라우저가 기본으로 제공하는 CSS 스타일을 초기화 해줘야 한다.

- 주로 www.jsdelivr.com 사이트 이용
- 구글 검색: [reset.css cdn](https://www.jsdelivr.com/package/npm/reset-css)
- reset.min.css -> Copy HTML link -> \<head> 태그에 link
- 주의❗️ 메인 css 파일보다 위에 link를 적용하는 것이 깔끔히 리셋되고 충돌 우려가 적다.

```css
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.min.css">
```

<br>

### CSS 주석 처리
```css
/* Comment */
```

<br>

### CSS 선언 방식 4 가지
1. 내장 방식: \<head> 부분에 \<style>\</style> 작성
2. 링크 방식: \<head> 부분에 \<link />로 외부 CSS 문서 연동(병렬 연결)
3. 인라인 방식: 요소의 전역 속성(style="")에 직접 스타일 작성(우선 순위 높음)
4. @import 방식: CSS문서 안에서 또 다른 CSS 문서를 가져와 연결하는 방식이다.(직렬 연결) 지연 연결이 발생할 수 있다.

> @import 방식 장단점
> 
> link로 연결되는 메인 CSS파일이 연동되고 메인 파일크기가 클 경우 import 구문의 해석이 딜레이 되기 때문에 임포트 파일은 지연 연결이 일어날 수 밖에 없다. 고의로 지연 시킬 의도로 사용할 수 있다.

💡 사용 권장 시나리오
- 권장하지 않는 방식: 내장, 인라인
- 권장 방식 : link 로 전부 head에 작성
- 지연 연결 의도 시 고려 방식 : @import

<br>

### CSS 단위

아래 표현 단위 중 px만 절대 단위 이다. 나머진 상대 단위이다.

- px (픽셀)

- % (상대적 백분율, 부모 요소와 비교)

- em (부모 요소의 글꼴 크기)

- rem (루트 요소(html)의 글꼴 크기)
루트 요소(html)의 기본 글꼴 크기는 16px이다.

- vw (뷰포트 가로 너비의 백분율)
50vw -> 뷰포트 가로 너비의 절반
100vw -> 뷰포트 가로 너비 전체

- vh (뷰포트 세로 너비의 백분율)
50vh -> 뷰포트 세로 너비의 절반
50vh -> 뷰포트 세로 너비의 전체