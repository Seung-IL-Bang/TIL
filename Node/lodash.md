# import _ from 'lodash'

from 뒤에 오는 패키지 'lodash' 단어 양 옆에 아무런 특수 기호들이 없기 때문에 해당 패키지는 프로젝트 내의 node_modules 로부터 import 한다는 것을 뜻한다. node_modules 에서 'lodash' 패키지를 해당 js 파일에 import 해오는데, 이 때 lodash 패키지 내부의 존재하는 package.json에 명시되어 있는 main 속성의 자바스크립트 파일을 가져와서 사용하게 된다.

<br>

### '_' 의미

import 해온 lodash 패키지의 자바스크립트 파일을 언더바 _ 에 할당해서 사용 가능하다는 의미이다. 관행적으로 _(언더바)로 사용한다.

```javascript
console.log(_.camelCase('Hello world');
// helloWorld
```