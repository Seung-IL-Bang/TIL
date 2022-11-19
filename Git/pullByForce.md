# 원격 브랜치 로컬로 강제 pull 하기

**주의 사항 ❗️**

로컬에 있는 파일들이 모두 날라가도 문제 없는 상황일 때, 원격 브랜치의 내용을 로컬로 덮어 쓰고 싶을 때 사용한다.


<br>

```
git fetch --all
git reset --hard origin/<브랜치명>
git pull origin <브랜치명>
```
