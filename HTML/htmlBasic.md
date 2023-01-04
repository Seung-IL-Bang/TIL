# HTML 개요

`index.html`

브라우저는 어떤 경로를 탐색하든 우선적으로 index.html을 찾는다. 따라서 랜딩페이지에 해당하는 index.html 파일은 최상위 경로(root)에 존재해야 한다.

<br>

`DOCTYPE(Document Type Definition, DTD)`

DOCTYPE은 마크업 언어에서 문서 형식을 정의하며, 웹 브라우저가 어떤 HTML 버전의 해석 방식으로 페이지를 해석하면 되는지를 알려주는 정의이다.

Version 순서
<ol>
    <li>HTML1</li>
    <li>HTML2</li>
    <li>HTML3</li>
    <li>HTML4</li>
    <li>XHTML</li>
    <li>HTML5(현재 웹 표준)</li>
</ol>

<br>

`<html></html>`

html 문서의 전체 범위를 나타낸다. 어디서 시작하고 어디서 끝나는지 명시.

<br>

`<head></head>`

문서의 **정보**를 나타내는 범위이다.

- 웹 페이지의 제목, 설명
- 사용할 파일 위치
- 스타일(CSS)
- **웹 페이지의 보이지 않는 정보를 작성하는 범위**

<br>

`<body></body>`

문서의 **구조**를 나타내는 범위이다.

- 사용자 화면을 통해 보여지는 로고, 헤더, 푸터, 내비게이션, 메뉴, 버튼, 이미지 등
- **웹 페이지의 보여지는 구조를 작성하는 범위**

<br>

`<html lang="en">`

html 태그의 lang 속성은 문서의 언어를 지정하는 속성이다. 기본적으로 en으로 되어 있다.

- "en"로 설정 시 구글 번역기가 자동 실행 된다.
- "ko"로 설정 시 구글 번역기가 자동 실행 안된다.