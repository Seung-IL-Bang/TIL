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

<br>

### **LEFT OUTER JOIN**

: SQL 에서 왼쪽에 표기된 테이블의 데이터는 무조건 출력된다. 대신 오른쪽 테이블에 JOIN 되는 데이터가 없는 ROW들은 오른쪽 테이블 컬럼의 값이 NULL 로 출력된다.

<br>

### **RIGHT OUTER JOIN**

: SQL에서 오른쪽에 표기된 테이블의 데이터는 무조건 출력되는 방식이다. 대신 왼쪽 테이블에 JOIN 되는 데이터가 없는 Row 들은 왼쪽 테이블 컬럼의 값이 NULL로 출력된다.

<br>

### **FULL OUTER JOIN**

: 왼쪽, 오른쪽 테이블의 데이터가 모두 출력되는 방식이다. LEFT OUTER JOIN 과 RIGHT OUTER JOIN의 `합집합`이다. (단, 중복값은 제거)


<br>

### NATURAL JOIN

: A 테이블과 B 테이블에서 같은 이름을 가진 컬럼들이 모두 동일한 데이터를 가지고 있을 경우 JOIN 되는 방식이다. (단, SQL Server(MSSQL) 에서는 지원하지 않는다.) Oracle 에서는 `USING` 조건절을 이용하여 같은 이름을 가진 컬럼 중 원하는 컬럼만 JOIN 에 이용할 수 있다. 단, SELECT 절에서 USING 절로 정의된 컬럼 앞에는 별도의 ALIAS나 테이블명을 붙이지 않아야 한다. 또한 WHERE 절을 통해 JOIN 조건을 추가 할 수 없다.

<br>

### CROSS JOIN

: CROSS JOIN은 A 테이블과 B 테이블 사이에 JOIN 조건이 없는 경우, 조합할 수 있는 모든 경우를 출력하는 방식이다. 모든 경우의 수를 출력할 때 다른 말로 `Cartesian Product` 라고 표현한다. 그리고 WHERE 절에 JOIN 조건을 추가할 수는 있지만, 이런 경우 INNER JOIN 과 같은 결과를 얻기 때문에 CROSS JOIN 을 사용하는 의미가 없어지므로 WHERE 절에 조건을 추가하는 것은 권장하지 않는다.