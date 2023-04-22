# 정규화(Normalization)

### 1NF
1NF는 모든 속성이 원자값(Atomic Value)을 가지는 상태입니다. 즉, 각 속성은 더 이상 쪼갤 수 없는 단위여야 합니다. 예를 들어, 다음과 같은 테이블은 1NF를 만족하지 않습니다.
```css
[ Orders ]
Order_ID | Customer | Order_Items
--------|----------|----------------
   1    |  Alice   | Apples;Bananas
   2    |  Bob     | Oranges;Pears;Bananas
```

위의 테이블에서 "Order_Items" 속성은 여러 개의 값이 ";"로 구분되어 있습니다. 이러한 경우 "Order_Items" 속성을 원자값으로 나누어 별도의 테이블을 만들어야 1NF를 만족할 수 있습니다.

```css
[ Orders ]
Order_ID | Customer
--------|----------
   1    |  Alice
   2    |  Bob

[ Order_Items ]
Order_ID | Order_Item
--------|------------
   1    |   Apples
   1    |   Bananas
   2    |   Oranges
   2    |   Pears
   2    |   Bananas
```

<br>

### 2NF
2NF는 부분 함수적 종속을 제거하는 정규형이다. <u>부분 함수적 종속</u>을 없애는 가장 일반적인 방법 중 하나는 테이블을 **2개 이상의 테이블로 분할하는 것입니다.**

예를 들어, 학생들의 출석 정보를 저장하는 테이블이 있다고 가정해봅시다.

```css
[Student Attendance]
(Student_ID, Student_Name, Course_ID, Course_Name, Date, Attendance_Status)
```

위의 테이블에서는 학생의 수업 참여 정보가 모두 하나의 테이블에 저장되어 있습니다. 이 때, 학생_ID, Course_ID, Date를 기본 키로 사용하고 있습니다. 이 테이블에서는 (Student_ID, Course_ID)가 기본 키의 일부분이므로, **학생과 수업 간의 부분 함수적 종속이 발생합니다.**

이 경우, 테이블을 2NF로 분해하여 부분 함수적 종속을 제거할 수 있습니다. Student_ID, Student_Name을 가지고 있는 학생 정보 테이블과 Course_ID, Course_Name을 가지고 있는 수업 정보 테이블을 만들고, 이 두 테이블을 다음과 같이 수정할 수 있습니다.

```css
[Student]
(Student_ID, Student_Name)

[Course]
(Course_ID, Course_Name)

[Attendance]
(Student_ID, Course_ID, Date, Attendance_Status)
```

이렇게 분리하면 Student 테이블과 Course 테이블에서는 테이블의 기본 키에 의해 모든 속성이 완전 함수 종속성을 가지게 됩니다. 또한 Attendance 테이블에서도 {Student_ID, Course_ID, Date}를 기본 키로 사용함으로써, 이 테이블에서도 모든 속성이 완전 함수 종속성을 가지게 됩니다.

따라서, 이러한 분해를 통해 부분 함수적 종속을 없앨 수 있습니다.

<br>

### 3NF
3NF는 2NF을 만족하면서, 기본키가 아닌 모든 속성이 기본키에 대해 이행적 종속을 만족하지 않는 정규형이다. 즉, 이행적 종속을 제거하기 위해 사용됩니다. 이행적 종속은 A->B, B->C와 같은 종속관계가 있을 때, A->C와 같은 종속관계가 발생하는 것을 말합니다.

다음은 이행적 종속을 만족하지 않는 테이블의 예시입니다.
```css
[Employee Project]
(Employee_ID, Employee_Name, Project_Name, Department_Name, Department_Manager)
```

위의 테이블에서는 Employee_ID가 기본 키이며, Employee_Name, Project_Name, Department_Name, Department_Manager는 이 키에 함수 종속합니다. **또한 Department_Manager은 Department_Name에 함수 종속합니다. 이렇게 되면 Department_Name은 기본키에 대해 이행적 종속을 가지게 됩니다.**

다음은 이러한 테이블을 3NF로 분할하는 방법의 예시입니다.
```css
[Employee]
(Employee_ID, Employee_Name, Department_Name)

[Project]
(Employee_ID, Project_Name)

[Department]
(Department_Name, Department_Manager)
```

위의 분할된 테이블에서는 Employee 테이블에서 Employee_ID를 기본 키로 사용하고, Project 테이블에서 (Employee_ID, Project_Name)을 기본 키로 사용합니다. 또한 Department 테이블에서 Department_Name을 기본 키로 사용하며, Department_Name과 Department_Manager 간의 함수 종속성도 유지됩니다.

이러한 분할을 통해 이행적 종속성이 해결되며, 각 테이블에서는 모든 속성이 해당 테이블의 기본 키에 함수 종속됩니다.

<br>

### BCNF(Boyce-Codd Normal Form)
BCNF는 Boyce-Codd 정규형의 약어로, 모든 결정자가 후보 키인 관계형 스키마를 의미합니다. BCNF는 3NF를 보다 강화한 정규화 기준으로, 3NF가 만족하면서도 함수 종속의 특수한 경우를 처리할 수 있습니다.

예를 들어, 대학교에서 강의를 개설하는 경우 다음과 같은 테이블이 있다고 가정해보겠습니다.

| Course Code | Course Name                      | Instructor Name | Instructor Office |
| ----------- | -------------------------------- | --------------- | ----------------- |
| CS101       | Introduction to Computer Science | John Smith      | Room 100          |
| MATH201     | Calculus                         | Jane Doe        | Room 200          |
| CS101       | Introduction to Computer Science | Jane Doe        | Room 200          |

위의 테이블에서는 Course Code와 Instructor Name의 조합이 후보 키가 됩니다. 같은 강의를 가르치는 교수가 여러 명일 수 있습니다. 그리고 (Course Code → Course Name) 및 (Instructor Name → Instructor Office)와 같은 함수 종속성이 존재합니다.

이 경우, 테이블은 다음과 같이 2NF와 3NF를 만족하도록 분해될 수 있습니다.

| Course Code | Instructor Name |
| ----------- | --------------- |
| CS101       | John Smith      |
| MATH201     | Jane Doe        |
| CS101       | Jane Doe        |

| Course Code | Course Name                      |
| ----------- | -------------------------------- |
| CS101       | Introduction to Computer Science |
| MATH201     | Calculus                         |

| Instructor Name | Instructor Office |
| --------------- | ----------------- |
| John Smith      | Room 100          |
| Jane Doe        | Room 200          |

이제 모든 테이블이 3NF를 만족하고, 후보 키와 모든 결정자가 일치하여 BCNF도 만족합니다. 이렇게 정규화를 수행하면 데이터 중복이 제거되고 데이터 일관성이 향상됩니다.

<br>

