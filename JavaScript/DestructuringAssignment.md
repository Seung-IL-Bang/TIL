# 구조 분해 할당(Destructuring assignment)

비구조화 할당이라고도 한다. 객체 또는 배열의 데이터 중 원하는 값만 빼올 때 유용하게 사용할 수 있다. **구조 분해 하려는 데이터의 타입에 맞게 할당 받는 변수의 형식을 맞춰줘야 한다.**

<br>

### 배열의 구조 분해
```Javascript
const [a, b, c, ...] = 배열
const [ , b] = 배열
```
순서대로 인덱싱되어 할당된다. 중간 데이터만 가져오고 싶으면 앞에 변수는 명시하지 않고 쉼표만 적어준다.

<br>

### 객체의 구조 분해
```Javascript
const {key1, key2, ... } = 객체
```
키 값에 매핑되어 할당된다.

<br>

```javascript
const user = {
  name: 'Heropy',
  age: 85,
  email: 'geg@gmail.com'
}

const {name, age, email, address} = user

console.log(`${name}`) // Heropy
console.log(`${age}`) // 85
console.log(`${email}`) // geg@gmail.com
console.log(`${address}`) // undefined
```

만약 객체의 존재하지 않는 속성이 있을 수 있으므로 기본값을 설정해 줄 수 있다.

```Javascript
const {address = 'Korea'} = user

console.log(`${address}`) // Korea
```

하지만 객체 데이터에 address 속성값이 전달되면 기본값은 무시된다.

<br>

구조 분해 할당 과정에서 할당 받는 변수의 이름을 따로 지정해줄 수도 있다. 이런 경우엔 지정해준 이름으로만 사용해야 한다. 안그러면 에러가 발생한다.

```javascript
const {name: heropy} = user

console.log(`${heropy}`) // Heropy
```