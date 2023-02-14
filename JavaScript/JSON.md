# JSON

`Javascript Object Notation`의 약어이다. json 데이터를 js 파일에 import 해오면 JSON 파일에 존재하는 모든 데이터들이 정해진 규격으로 인해 하나의 `객체`로 할당된다. 하지만 원래의 JSON은 하나의 문자열 데이터이다.

```Javascript
import myData from './myData.json'
// myData는 객체로 인식된다.
```
<br>

반대로 js에서 작성한 객체 데이터를 JSON의 문자열 데이터로 변환하는 정적 메소드가 있다.

```Javascript
const str = JSON.stringify(obj)
```

JSON 규격에 맞는 문자열이 존재하는 경우에도 문자열에서 다시 Js 객체로 변환 가능하다.

```javascript
const obj = JSON.parse(str)
```

<br>

### JSON 규격

키-값 쌍의 패턴으로 표현된다.
```json
 {
    "이름": "홍길동",
    "나이": 55,
    "성별": "남",
    "주소": "서울특별시 양천구 목동",
    "특기": ["검술", "코딩"],
    "가족관계": {"#": 2, "아버지": "홍판서", "어머니": "춘섬"},
    "회사": "경기 수원시 팔달구 우만동"
 }
```