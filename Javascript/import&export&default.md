# import & export & default

js 확장자를 가진 자바스크립트 파일들은 외부로부터 다른 Js 파일을 내부로 Import(가져오기)를 할 수 있고, 본 js 파일을 export(내보내기)로 외부로 보낼 수도 있다. 또한 여러 js 파일에서 동일한 함수가 사용된다면, 각 js 파일마다 동일한 함수를 중복적으로 재정의 할 필요 없다. `export default function`을 정의한 js 파일을 **'내보내기(export)'를 통해 여러 Js 파일에서 동일한 함수를 중복 재정의 없이 끌어와서(import) 사용 가능하다.**

> 보통 내보내기만 진행하는 js 파일을 '모듈'이라 부른다.


<br>

```javascript
// getType.js
export default function getType(data) {
  return Object.prototype.toString.call(data).slice(8, -1)
}
```

```javascript
// test.js
import getType from './getType'
// import 할당명 from '경로/파일명'
```

경로에 존재하는 파일에서 사용하고자 하는 함수명을 할당명에 작성하고, import 해온 파일에서 할당명으로 함수들에 대한 접근이 가능해진다. 이때 경로/파일명에서 js 파일에 대한 확장자는 안 쓴다.

<br>

### `default`

default로 설정된 함수는 해당 함수가 정의된 js 파일에서 이름을 지정하지 않아도 된다.(익명 함수) 그리고 Import로 불러올 때 할당 받는 변수명을 무엇으로 정하든 상관없다. default는 파일내에 오직 하나만 존재할 수 있다.

<br>

### `Named`

default가 붙지 않은 함수로, 이름을 지정해줘야 하는 함수이다. Named 함수는 여러 개 정의할 수 있다. 즉 export 키워드를 여러 번 사용하여 여러 개를 내보낼 수 있다. **중요한 것은 import 받는 js 파일에서 할당 변수명을 { }으로 감싸줘야 하며, { } 안에 export 파일에서 사용하고자 하는 Named 함수 변수를 작성할 수 있다. 변수명은 export 파일의 데이터 이름하고 일치해야한다.** 변수명 뒤에 `as` 키워드로 별칭을 사용할 수도 있다.

```javascript
import {func1, func2 as getFunc} from './src'
```
위처럼 별칭을 사용하면 func2를 getFunc으로도 호출 할 수 있다.

<br>

### `WildCard ( * )`

여러 함수들을 한꺼번에 지정할 목적으로 사용하는 기호이다. 마찬가지로 as 키워드를 통해 별칭을 지정할 수 있다.

```javascript
Import * as R from 'pacakge'
```
위처럼 별칭 'R' 을 통해 'package' 안에 모든 함수들에 접근이 가능하다.