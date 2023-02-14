# nvm(Node Version Manager)

node.js의 원하는 버전으로 개발하기 위해서 쉽게 버전 컨트롤 할 수 있게 도와주는 라이브러리다. 웹 프론트엔드 개발 시 nvm 또는 node 버전에 영향을 받을 수 있기 때문에, 협업할 때 버전을 동일시 하는 것이 중요하다.

<br>

### nvm 명령어

`nvm install <유의적 버전>`
```bash
nvm install 12.21.0
# 해당 버전의 node.js 설치
```
<br>

`nvm ls`

설치되어 있는 node.js 버전 목록 출력

<br>

`nvm use <유의적 버전>`
```bash
nvm use 12.21.0
# 해당 버전으로 node.js 사용
```

<br>

`node --version`

현재 노드의 버전 출력

<br>

`nvm --version`

현재 nvm 버전 출력

<br>

`nvm uninstall <유의적 버전>`
```bash
nvm uninstall 12.21.0
# 해당 버전의 Node.js 삭제
```

<br>

