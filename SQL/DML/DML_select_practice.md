# SQL DML 연습 (Data Manipulation Language; 데이터 조작어)

<details>
  <summary>1. employees 테이블에서 급여가 5000 이상인 직원의 이름과 급여를 조회하세요.</summary>

```sql
SELECT emp_name, salary
FROM employees
WHERE salary >= 5000;
```

| emp_name | salary |
| -------- | ------ |
| John     | 5500   |
| Jane     | 6000   |
| Bob      | 7000   |
| Sarah    | 5500   |
</details>

<br>

<details>
  <summary>2. orders 테이블에서 주문한 날짜가 2022년 3월인 주문의 주문번호와 주문한 날짜를 조회하세요.</summary>

```sql
SELECT order_id, order_date
FROM orders
WHERE order_date BETWEEN '2022-03-01' AND '2022-03-31';
```

| order_id | order_date |
| -------- | ---------- |
| 1001     | 2022-03-12 |
| 1003     | 2022-03-25 |
| 1006     | 2022-03-01 |
</details>

<br>

<details>
  <summary>3. products 테이블에서 가격이 10000원 이상이고 재고 수량이 50개 이상인 상품의 상품명, 가격, 재고 수량을 조회하세요.</summary>

```sql
SELECT product_name, price, stock_quantity
FROM products
WHERE price >= 10000 AND stock_quantity >= 50;
```

| product_name | price | stock_quantity |
| ------------ | ----- | -------------- |
| iPhone 13    | 12000 | 100            |
| Galaxy S21   | 11000 | 80             |
</details>

<br>

<details>
  <summary>4. customers 테이블에서 성이 'Kim'인 고객의 이름과 전화번호를 조회하세요.</summary>

```sql
SELECT customer_name, phone
FROM customers
WHERE customer_name LIKE '%Kim%';
```

| customer_name | phone         |
| ------------- | ------------- |
| Kim Yuna      | 010-1234-5678 |
| Park Sung Kim | 010-9876-5432 |
</details>

<br>

<details>
  <summary>5. employees 테이블에서 부서별 평균 급여를 조회하세요.</summary>

```sql
SELECT department, AVG(salary) AS avg_salary
FROM employees
GROUP BY department;
```

| department  | avg_salary |
| ----------- | ---------- |
| HR          | 4000       |
| Sales       | 6000       |
| Engineering | 5500       |
</details>

<br>

<details>
  <summary>6. orders 테이블에서 총 주문 금액이 50000원 이상인 주문의 주문번호와 총 주문 금액을 조회하세요.</summary>

```sql
SELECT order_id, (quantity * price) AS total_price
FROM order_details
JOIN orders ON order_details.order_id = orders.order_id
WHERE (quantity * price) >= 50000;
```

| order_id | total_price |
| -------- | ----------- |
| 1001     | 90000       |
| 1002     | 60000       |
| 1004     | 80000       |
| 1005     | 90000       |
| 1007     | 50000       |
</details>

<br>

<details>
  <summary>7. customers 테이블에서 도시(city)가 'Seoul'이거나 'Busan'인 고객의 이름과 도시를 조회하세요.</summary>

```sql
SELECT customer_name, city
FROM customers
WHERE city IN ('Seoul', 'Busan');
```

| customer_name | city  |
| ------------- | ----- |
| Kim Yuna      | Seoul |
| Lee Minho     | Busan |
| Park Ji Sung  | Seoul |
</details>

<br>

<details>
  <summary>8. products 테이블에서 카테고리(category)가 'Electronics'이고 브랜드(brand)가 'Samsung'인 상품의 상품명과 가격을 조회하세요.</summary>

```sql
SELECT product_name, price
FROM products
WHERE category = 'Electronics' AND brand = 'Samsung';
```

| product_name           | price |
| ---------------------- | ----: |
| Samsung Galaxy S21     |   800 |
| Samsung Galaxy Note 20 |   900 |
| Samsung Galaxy Tab S7  |   600 |
</details>

<br>

<details>
  <summary>9. employees 테이블에서 직원들의 총 급여를 조회하세요.</summary>

```sql
SELECT SUM(salary) as total_salary
FROM employees;
```

| total_salary |
| -----------: |
|       188300 |
</details>

<br>

<details>
  <summary>10. orders 테이블에서 주문한 날짜가 2022년 3월인 주문의 총 주문 금액을 조회하세요.</summary>

```sql
SELECT SUM(total_amount) as march_sales
FROM orders
WHERE order_date >= '2022-03-01' AND order_date <= '2022-03-31';
```

| march_sales |
| ----------: |
|       21500 |
</details>