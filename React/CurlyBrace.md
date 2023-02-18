# 중괄호(Curly Brace)

JSX 코드 내에서 Javascript 식을 사용하려면 `{}` 중괄호로 감싸서 사용해야한다.

```javascript
export default function Card(props) {
  const classes = 'card ' + props.className
  return (
    <div className={classes}>{props.children}</div>
  );
}
```

열고 닫히는 태그의 내용(Content) 안에 객체(Object)는 {} 로 감싸서 바로 렌더링할 수 없다. 즉, 객체의 속성값으로 반환하거나, 특정 메소드를 사용해서 문자열과 같은 값으로 변환해줘야 렌더링이 가능하다.

<br>

js 로직을 JSX 블록 안에 있는 중괄호 {}로 직접 넣을 수 있겠지만, 로직이 길어지다보면 코드가 가독성이 떨어질 수도 있으므로, 로직을 따로 빼서 변수에 할당하고 `{}` 에는 변수만을 넣는 것이 가독성이 올라간다.

```javascript
const month = props.date.toLocaleString('en-US', {month: 'long'})
 
...
 
return (
    ...
    <div>{month}</div>
    ...);
```