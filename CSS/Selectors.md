# CSS 선택자 

### 선택자 다섯 종류 
- [기본](#기본-선택자basic-selector)
- [복합](#복합-선택자combinator)
- [가상 클래스](#가상-클래스-선택자pseudo-classes)
- [가상 요소](#가상-요소-선택자pseudo-elements)
- [속성](#속성-선택자attribute)

<br>

### 기본 선택자(Basic Selector) <!-- omit in toc -->

- 전체 선택자(Universl Selector): 모든 요소 선택
```css
* {
  color: red;
}
```

- 태그 선택자(Type Selector): 해당 태그 요소 선택
```css
div {
  color: red;
}
```

- 클래스 선택자(Class Selector): HTML 요소 중 해당 class 이름을 가진 요소 선택
```css
.className {
  color: red;
}
```

- 아이디 선택자(Id Selector): HTML 요소 중 해당 Id 이름을 가진 요소 선택
```css
#Id {
  color: red;
}
```

<br>

### 복합 선택자(Combinator) <!-- omit in toc -->

- 일치 선택자(Basic Combinator): 선택자 A와 B를 동시에 만족하는 요소를 선택한다. 주의할 점은 클래스 선택자 사용시 클래스 선택자는 맨 뒤에 붙어야 한다. 안 그러면 클래스 선택자로 인식될 우려가 있다.
```css  
AB { }

태그명.클래스명 { } /* Yes */
.클래스명태그명 { } /* No */
```

- 자식 선택자(Child Combinator): 선택자 A의 자식 요소 B 선택
```css
A > B { }
```

- 하위(후손) 선택자(Descendent Combinator): 선택자 A의 하위 요소 B 선택. '띄어쓰기'가 선택자의 기호이다.
```css
A B { }
```

- 인접 형제 선택자(Adjacent Sibling Combinator): 선택자 A의 다음 형제 요소 B 하나를 선택
```css
A + B { }
```

- 일반 형제 선택자(General Sibling Combinator): 선택자 A의 다음 형제 요소 B 모두를 선택
```css
A ~ B { }
```

<br>

### 가상 클래스 선택자(Pseudo-Classes) <!-- omit in toc -->

: 기존의 선택자에 추가적인 동작이나 스타일을 입힐 수 있다.

```css
선택자:가상클래스선택자 { }

.box:hover { }

.box:active { }

.box:focus { }

.box:first-child { }

.box:last-child { }

.box:nth-child(n) { }

.box:not(B) { }
```

- `hover` : 마우스 커서가 요소에 올라갔을 때 스타일 및 동작 추가
- `active` : 요소를 마우스로 클릭하고 있는 동안 스타일 및 동작 추가
- `focus` : 요소가 포커싱되면 스타일 및 동작이 추가된다. 포커싱 될 수 있는 요소는 HTML 대화형 요소가 있다. 대화형 요소가 아니더라도 `tabindex` 속성을 사용하면 포커싱이 가능해진다. (검색: html 대화형 콘텐츠 mdn)
- `first-child`: 선택자가 형제 요소 중 첫째라면 선택.
- `last-child`: 선택자가 형제 요소 중 막내라면 선택.
- `nth-child(n)`: 선택자가 형제 요소 중 (n)째라면 선택. n 인수를 사용하여 여러 수식 적용도 가능하다.
- `A:not(B)`: 선택자 B가 아닌 A 요소 선택

> HTML 대화형 요소
> 
> input, button, label, select etc.

> tabindex
>
> tabindex="-1" 속성을 통해 포커싱 될 수 있는 요소로 만들 수 있다. tab키를 사용해 포커스 할 수 있는 요소를 지정하는 속성이다. 순서(값)으로 -1이 아닌 다른 값을 넣는 것은 논리적 흐름을 방해하기 때문에 권장하지 않는다. (검색: tabindex mdn)

<br>

### 가상 요소 선택자(Pseudo-Elements) <!-- omit in toc -->

: 요소를 인라인 요소로 취급해도 무방하다. 삽입되는 내용(content)은 필수 속성이다. before와 after은 `content:""`은 한 쌍이다. 공백으로 두더라도 필수로 작성해야 한다.

- `before`: 선택자 요소의 내부 앞에 내용(content)을 인라인 요소로 삽입한다.
- `after`: 선택자 요소의 내부 뒤에 내용(content)을 인라인 요소로 삽입한다.

```css

.text::before {
  content: "";
 }

.text::after { 
  content: "";
}
```

<br>

### 속성 선택자(Attribute) <!-- omit in toc -->

- ATTR: 특정 속성을 포함한 요소 선택
- ATTR=value: 특정 속성을 포함하고 value에 해당하는 값을 가진 요소 선택
```css
/* ATTR */
[disabled] {
  color: red;
}

/* ATTR=value */
[type="password"] {
  color: red;
}
```