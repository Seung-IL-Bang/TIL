# join에 관하여

### EQUI JOIN

: `Equal(=)` 조건으로 JOIN 하는 것으로 가장 흔히 볼 수 있는 JOIN 방식이다. 보통 `WHERE` 절에 `= 조건`을 추가해서 사용한다.

```sql
SELECT A.PRODUCT_CODE,
			 A.PRODUCT_NAME,
		   B.MEMBER_ID,
			 B.CONTENT,
			 B.REG_DATE
FROM PRODUCT A,
		 PRODUCT_REVIEW B
WHERE A.PRODUCT_CODE = B.PRODUCT
	AND A.PRODUCT_CODE = '100001'; 
```

### Non EQUI JOIN

: Equal(=) 조건이 아닌 다른 `비교 연산자(BETWEEN, >, <, ≤, ≥)`로 JOIN 하는 방식.

<br>

### **INNER JOIN**

: JOIN 조건에 충족하는 데이터만 출력되는 방식이다. 이때 `표준 조인`은 앞서 본 SQL 과 다르게 JOIN 조건을 `ON` 절을 사용하여 작성해야 한다.

```sql
SELECT A.PRODUCT_CODE,
			 A.PRODUCT_NAME,
			 B.MEMBER_ID,
			 B.CONTENT,
			 B.REG_DATE
FROM PRODUCT A INNER JOIN PRODUCT_REVIEW B
	ON A.PRODUCT_CODE = B.PRODUCT_CODE;
```