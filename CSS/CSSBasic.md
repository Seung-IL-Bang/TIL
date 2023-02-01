# CSS 개요

### 선택자(Selector)

: 선택자는 CSS 스타일을 html의 어떤 요소에 적용할지를 선택하는 일종의 규칙이다.

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