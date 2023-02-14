# npm(node package Manager)

전 세계의 개발자들이 만든 다양한 패키지(기능, 모듈)들을 관리. npm 생태계(허브)에 있는 다양한 패키지들을 다운 받아 개발에 자유롭게 사용할 수 있다.

<br>

### npm 명령어

`npm init -y`

해당 프로젝트 npm으로 노드 패키지 관리가 가능해진다. 이 명령어로 `package.json` 가 생성된다.

<br>

`npm install <패키지명>@<유의적 버전>`

해당 패키지의 최신 버전이 아닌 명시된 유의적 버전으로 설치가 진행된다. 기존에 존재하던 똑같은 패키지의 의존성은 덮어쓰여진다. 줄여서 "npm i" 으로 사용 가능하며, 해당 명령어를 통해 node_modules 생성된다.

<br>

`npm install <패키지명> -D`

해당 이름의 노드 패키지를 설치한다. 설치한 패키지의 이력이 package.json 파일의 "devDependencies" 속성에 "패키지명":"버전"으로 기록된다.
그리고 package-lock.json 와 node_modules 디렉토리가 생성된다. 해당 패키지를 사용하는데 연관되거나 필요한 패키지들도 다같이 node_modules 모듈에 다운로드된다.

<br>

**옵션 -D에 관하여**

(옵션: --save-dev == -D)

개발용 의존성 패키지 설치할 때 붙이는 옵션이다. 즉 개발할 때만 필요하고 웹 브라우저에선 직접적으로 동작하지 않는 패키지의 용도를 설치할 때 -D를 사용한다. 개발용이 아닌 일반 의존성 설치할 때, 즉 웹 브라우저에서 실제로 동작하는 패키지를 설치할 땐 -D를 뺀다.

<br>

> Tip 💡
>
> package.json에 의존성에 기록된 패키지들은, 만약 node_modules가 지워진다 해도, 명령어 npm install 줄여서 "npm i"를 사용하면 package.json에 기록된 의존성을 참고하여 해당 패키지들을 다시 재설치할 수 있다. 따라서 개발을 하면서 node_modules 폴더를 언제든 지워도 된다. 언제든지 다시 재설치 할 수 있기 때문이다.

> 주의 ❗️
>
> package.json과 package-lock.json은 프로젝트의 패키지 의존성 및 정보를 직접 담고 있기 때문에 절대!!!! 지워선 안된다.

<br>

`npm update <패키지명>`

해당 패키지의 최신 버전으로 업데이트 한다. Package.json 파일의 의존성도 최신화 된다.

<br>

`npm run`

npm install로 설치한 해당 패키지는 프로젝트 내에서만 적용된 것이기 때문에, 터미널에선 동작할 수 없다. 따라서 패키지 관련 명령어를 터미널에서 바로 실행하면 아래 오류가 발생한다.

```bash
zsh: command not found: parcel
```

**따라서 터미널에서 작동할 수 있도록 하기 위해선 package.json 파일의 scripts 속성에 다음과 같이 스크립트 명령어를 적어준다.**

```bash
"dev":"parcel index.html"
```

터미널에서 `npm run dev` 를 사용하면 `parcel index.html`에 해당하는 명령어가 터미널에서도 동작하게 된다. **즉, package.json 의 scripts에 작성한 "키:값"에서 값에 해당하는 명령어들을 터미널에 적용하려면 "npm run <키>" 를 사용하면 된다.**


`npm run <키>` 사용함으로써 생겨나는 폴더
- dist
- .cache

**dist**

dist 폴더는 build 된 결과물이 들어있는 폴더이다. 해당 폴더에 존재하는 파일들은 난독화 과정을 거치므로, 작성된 코드를 읽기 어렵다. 빌드된 결과는 브라우저에서 해석되는 용도로, 용량을 축소하고 읽기 어렵게 만드는 등의 최적화를 거치게 된다.

<br>

`npm info <패키지명>`

이 명령어를 통해서 패키지의 정보를 알 수 있다.

<br>

### 📁 프로젝트 버전관리

- .cache
- .dist
- node_modules

위 폴더 들은 따로 버전 관리를 할 필요가 없다. 따라서 깃헙에 푸시할 필요도 없다. 위 폴더들은 프로젝트 내에서 삭제해도 문제가 없다. 왜냐하면 package.json 과 package-lock.json 파일 내에 해당 폴더들에 대한 정보가 이미 다 담겨져 있기 때문에, 지워진 폴더들을 다시 생성하려면 아래 명령어들을 다시 실행하면 다시 재생성된다.

▼ < npm run xxx>
- .cache
- .dist

▼ < npm i >
- node_modules

<br>

**why No versioning?**

모듈 안에 수많은 패키지들을 각각 버저닝 하는 것은 매우 비효율적이며, npm i 나 npm run을 통해 해당 폴더들을 빠르게 재생성할 수 있기 때문에, 직접 버저닝을 통한 버전관리를 하는 것 보다 재생성을 하는 것이 더 효율적이기 때문이다. 따라서 .gitignore 파일에 해당 폴더들을 명시하여 깃헙 버저닝에서 제외한다. 협업할 땐 깃헙에서 프로젝트를 내려받은 다음, 해당 폴더들을 pacakge.json을 기반으로 npm i 나 npm run을 통해 다시 재생성할 수 있다.

<br>

.gitignore 작성법 ▼

```
.cache/

dist/

node_modules/
```
 .gitignore에 명시된 폴더들은 프로젝트 구조 상에서 버저닝 트랙킹이 안된다. 즉 깃헙 푸시되지 않는다.
