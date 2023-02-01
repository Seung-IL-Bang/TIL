# head 영역에서 사용하는 태그

`<link rel="" href="" />`

CSS 파일 연동 및 외부 문서를 연결할 때 사용한다.

- rel : 현재 html 파일과 가져올 문서의 관계
- href : 현재 html 파일로부터 가져올 문서의 경로

```html
<link rel="stylesheet" href="main.css" />
```

<br>

`<script defer src=""></script>`

Javascript 파일을 연동할 때 사용한다. JS 파일의 인라인 선언 방식도 지원한다.

- src : 자바스크립트 파일의 경로를 지정하는 속성이다.
- defer : HTML 파일의 해석이 끝난 후에 JS 연동을 진행시키는 속성이다. 해당 속성을 적용해야지만, html 전역속성인 data 속성을 제대로 쿼리할 수 있다. 해당 속성을 적용하지 않는다면, html 파일에 script 요소를 통해 js를 연동하더라도, \<head> 태그 까지만 해석하기 때문에, js파일이 \<body> 부분의 요소들에 제대로 접근&쿼리하지 못한다.

```html
<!--JS 연동-->
<script defer src="./main.js"></script>

<!--인라인 선언-->
<script>
    console.log('Hello World!')
</script>
```

<br>

`<style></style>`

css 파일을 링크하는 대신 html 파일에 직접 스타일을 적용하는 방식이다. 인라인 방식과 내장 방식 두 가지가 있다.

- 인라인 방식
  - 요소의 전역 속성인 style 속성에 직접 스타일을 작성하는 방식 (선택자 없음, 우선 순위 높음)
- 내장 방식
  - \<head> 부분에 \<style>\</style> 내용으로 스타일을 작성하는 방식

<br>

`<title></title>`

HTML 문서의 제목을 정의한다. 웹 브라우저 탭에 표시된다.

<br>

`<meta />`

HTML 문서(웹 페이지)의 제작자, 내용, 키워드, 저자 같은 여러 정보를 검색 엔진이나 브라우저에게 제공한다.

```html
<!--meta 예시-->
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
```

- charset: 문자 인코딩 방식
- name: 정보의 종류
- content: 정보의 값

참고로 `viewport` 정보는 모바일 기기에만 해당된다.

<br>

`Charset`

문자 인코딩 방식을 지정하는 HTML 속성이다. 문자 인코딩이랑 문자나 기호들을 컴퓨터가 이용할 수 있는 신호로 만드는 것을 말한다. 대표적으로 한글 사용에서는 EUC-KR 혹은 UTF-8 등이 사용되며, **웹에선 UTF-8 사용이 권장된다.**

