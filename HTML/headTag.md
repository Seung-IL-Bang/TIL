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
- defer : HTML 파일의 해석이 끝난 후에 JS 연동을 진행시키는 속성이다.

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