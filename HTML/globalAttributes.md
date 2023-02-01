# HTML 전역 속성들에 관하여

각 요소(태그)마다 사용할 수 있는 속성들이 정해져 있다. 하지만 **전역 속성은 \<body> 내부에 있는 어떤 요소든 모두 사용 가능한 속성을 뜻한다.**

<br>

### 전역 속성

- `title="설명"` : 커서를 올려 놓으면 요소의 정보나 설명을(tip) 표시해준다.
- `style="스타일"` : 요소에 적용할 스타일을 지정 가능하다.
- `class="이름"` : 요소를 지칭하는 **중복 가능한** 이름 설정이 가능하다. CSS 선택자 또는 JS 선택자를 통해 해당 요소를 제어하기 위한 속성으로 사용된다.
- `id="이름"` : 요소를 지칭하는 **고유한** 이름이다. CSS 선택자 또는 JS 선택자를 통해 해당 요소를 제어하기 위한 속성으로 사용된다.
- `data-이름="데이터"` : 요소에 데이터를 지정해줄 수 있다. JS에서 해당 요소에 저장된 데이터를 컨트롤하기 위한 속성이다. 여러 단어 연결시 '-(dash)'로 연결한다.

<br>

###  example of using the "data" attribute 

```html
<div data-product-id="12345" data-product-name="Example Product">
  <!-- your content here -->
</div>
```

<br>

```javascript
const div = document.querySelector('div[data-product-id="12345"]');
const productId = div.dataset.productId;
const productName = div.dataset.productName;
```