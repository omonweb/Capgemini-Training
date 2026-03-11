-- 1. emp earning more than adams

SELECT ename
FROM emp
WHERE sal > (
    SELECT sal
    FROM emp
    WHERE ename = 'ADAMS'
);

-- 2. deets of emp earning less than king

SELECT ename, sal
FROM emp
WHERE sal < (
    SELECT sal
    FROM emp
    WHERE ename = 'KING'
);

-- 3. name,deptno of emps working in same dept as jones

SELECT ename, deptno
FROM emp
WHERE deptno = (
    SELECT deptno
    FROM emp
    WHERE ename = 'JONES'
);

-- 4. deets of emp in same designation as james

SELECT ename, job
FROM emp
WHERE job = (
    SELECT job
    FROM emp
    WHERE ename = 'JAMES'
);


-- 5. deets if annual sal > ward's

SELECT empno, ename, sal * 12 AS annual_salary
FROM emp
WHERE (sal * 12) > (
    SELECT sal * 12
    FROM emp
    WHERE ename = 'WARD'
);


-- 6. deets of emp hired before scott

SELECT ename, hiredate
FROM emp
WHERE hiredate < (
    SELECT hiredate
    FROM emp
    WHERE ename = 'SCOTT'
);


-- 7. emps hired after president

SELECT ename, hiredate
FROM emp
WHERE hiredate > (
    SELECT hiredate
    FROM emp
    WHERE job = 'PRESIDENT'
);

-- 8. deets of emp sal < sal of emp w empno 7839

SELECT ename, sal
FROM emp
WHERE sal < (
    SELECT sal
    FROM emp
    WHERE empno = 7839
);


-- 9. deets of emp  hired before miller

SELECT *
FROM emp
WHERE hiredate < (
    SELECT hiredate
    FROM emp
    WHERE ename = 'MILLER'
);


-- 10. 

SELECT ename, empno
FROM emp
WHERE sal > (
    SELECT sal
    FROM emp
    WHERE ename = 'ALLEN'
);

use db_2;

-- waqtd deptname of smith 

SELECT d.dname 
FROM dept d 
	JOIN emp e
		ON d.deptno = e.deptno
WHERE e.ename = "Smith";

SELECT * FROM dept
WHERE deptno in (SELECT deptno FROM emp 
					WHERE ename IN ("Smith","Allen"));


-- emps working as dev
SELECT * FROM emp
	WHERE job IN ("DEVELOPER");

-- MIN SAL 
SELECT * FROM emp
WHERE sal IN (SELECT MIN(sal) FROM emp);

-- display dept deets of emp earning max sal

SELECT * FROM dept
	WHERE deptno IN 
		(select deptno from emp 
			WHERE sal IN (SELECT MAX(SAL) FROM emp));

-- name, sal, job, hiredate of emp in sales hired before king

SELECT ename,sal,job,hiredate FROM emp
	WHERE deptno IN 
		(select deptno from dept WHERE dname = 'Sales')
		  and hiredate < (select hiredate from emp where ename = 'King');

SELECT e.ename, e.sal, e.job, e.hiredate FROM emp e
	JOIN dept d ;
    
    
-- dname in which atleast 4 emps

SELECT dname FROM dept 
	WHERE deptno IN (SELECT DEPTNO FROM emp
						GROUP BY deptno
							HAVING count(*) >=4);

-- EMPS same sal in same dept

use db_2;

UPDATE emp
SET sal = 3000
WHERE ename = "Allen";

SELECT * from emp
WHERE (sal,deptno) IN 
			(select sal,deptno from emp 
				group by sal,deptno 
					having count(sal) > 1);

-- display first record
select * from emp;
SELECT * FROM EMP limit 1 offset 2;

-- DISPLAY 5,6,7TH RECORD
SELECT * FROM Emp
LIMIT 3 OFFSET 4;

-- display last 

SELECT * FROM Emp
ORDER BY empno DESC
LIMIT 1;

-- display 4th max sal

SELECT DISTINCT sal FROM emp
ORDER BY sal DESC
LIMIT 1 OFFSET 3;

-- display emp deets earning 3rd/4th min sal

SELECT * FROM emp
WHERE SAL IN (SELECT DISTINCT SAL FROM EMP ORDER BY sal ASC
LIMIT 2 OFFSET 3);


-- authors and books with genres

-- no. of books written by each author

-- user deets for book atomic habits

select * from users 
where user_id IN (select user_id from loans where book_id IN (select book_id from books where title = 'Atomic Habits'));


-- display no. of books borrowed by each user

select * from loans group by user_id;

-- display empname, sal, loc chicago

select e.ename, e.sal, d.loc from emp e join dept d 
	on e.deptno = d.deptno
WHERE d.loc IN ("Chicago");


select d.dname , e.job from emp e join dept d 
	on e.deptno = d.deptno
WHERE e.job LIKE 's%' AND d.dname LIKE 'S%';


select d.dname, e.mgr from emp e join dept d 
	on e.deptno = d.deptno
WHERE e.MGR = 7839; 

SELECT * FROM EMP;

select d.dname, e.hiredate from emp e join dept d 
	on e.deptno = d.deptno
WHERE e.hiredate > '1983-12-31' AND d.dname IN ('Accounting', 'Research');

select e.ename, d.dname from emp e join dept d 
	on e.deptno = d.deptno
WHERE (e.deptno IN (10,30) AND e.comm IS NOT NULL);

-- ``````````````````````````````````````````````````````````````````````

-- ename, dname even the emp who don't work in any dept 

SELECT e.ename, d.dname from Emp e LEFT JOIN Dept d 
	ON e.deptno = d.deptno;

-- right outer join - matched records from left table, but unmatched records from right table

SELECT * FROM dept RIGHT JOIN emp ON dept.deptno = emp.deptno;

-- ``````````````````````````````
-- display authors and their books 

SELECT a.author_name, b.title FROM authors a JOIN books b 
	ON a.author_id = b.author_id;
    
-- display author with no books

SELECT a.author_name 
FROM authors a 
	LEFT JOIN 
		books b 
				ON a.author_id = b.author_id 
					WHERE b.author_id IS NULL;
                    
                    

SELECT b.title,g.genre_name
FROM genres g 
	LEFT JOIN 
		books b 
				ON g.genre_id = b.genre_id
