# props

### 컴포넌트의 매개변수 props

- 함수 컴포넌트는 오직 하나의 매개변수만 받는데, 이것을 props라 한다. (관행적으로 props 로 쓴다.)

- **props 는 컴포넌트를 재사용할 수 있게 해주고, 컴포넌트에서 다른 컴포넌트로 데이터를 전달해주는 역할을 한다.**

- JSX 요소의 앞쪽 태그에 원하는 속성명을 적고 {} 를 통해 원하는 속성값을 넘겨주면, 모든 속성들이 props 의 **"키:값"** 의 쌍으로 전달된다.

```javascript
      <ExpenseItem
        title={props.items[0].title}
        amount={props.items[0].amount}
        date={props.items[0].date}
      />
```

- props를 전달받은 컴포넌트에서 전달된 속성들의 이름과 동일한 이름으로만 접근할 수 있다. `props.속성명`

```javascript
export default function ExpenseItem(props) {

  return (
    <Card className="expense-item">
      <ExpenseDate date={props.date} />
      <div className="expense-item__description">
        <h2>{props.title}</h2>
        <div className="expense-item__price">${props.amount}</div>
      </div>
    </Card>
  );
}
```

<br>

### props.children

열고 닫는 컴포넌트 태그 컨텐츠 부분에 들어가는 요소들은 해당 컴포넌트의 `props.children`으로 모두 전달된다.

```javascript
import './ExpenseItem.css'
import ExpenseDate from './ExpenseDate';
import Card from '../UI/Card';

export default function ExpenseItem(props) {

  return (
    <Card className="expense-item">
      <ExpenseDate date={props.date} />
      <div className="expense-item__description">
        <h2>{props.title}</h2>
        <div className="expense-item__price">${props.amount}</div>
      </div>
    </Card>
  );
}

```

```javascript
import './Card.css'

export default function Card(props) {
  const classes = 'card ' + props.className
  return (
    <div className={classes}>{props.children}</div>
  );
}

```

보통 루트 역할의 div 태그를 Card 컴포넌트로 대체하게 되는데 이때 기존 div의 적용되고 있는 css는 classname으로 작동하고 있을 것이다. 이때 div 의 className은 Card 컴포넌트의 props 속성으로 넘어갈테니, Card 컴포넌트에서 props.className으로 접근할 수 있다. 따라서 기존 div 태그의 CSS와 Card 레이아웃의 CSS 부분을 합치려면 Card 컴포넌트안의 로직으로 `const classes = 'card ' + props.className` 와 같이 Card 안에서 적용할 클래스명을 새로 정의해주어 적용하면 된다. `<div className={classes}></div>`