USE db_2;

Select ename from emp;

-- display ename, salary
	
    Select ename, sal
		From emp;
        
-- display all details of emp table

	Select * 
	From emp;
    
-- display salary from emp

	Select sal
		From emp;
        
-- display without duplicates

	Select DISTINCT sal
		From emp;

-- display name,sal distinct

	Select DISTINCT ename, sal 
		From emp;
        
        
	Select DISTINCT job,sal FROM emp;
    
    Select DISTINCT deptno,job From Emp;
    
    Select ename, sal, (sal * 12) AS Annual_Sal
		FROM Emp;
	
    SELECT ename, sal, (sal + sal*0.1) AS Sal_hike_10
    FROM Emp;
    
    SELECT ename, sal, (sal - sal*0.1) AS Sal_reduction_10
    FROM Emp;
    
    SELECT ename, sal, sal+1000 AS Bonus
		FROM emp;
        
	-- name, sal with monthly hike of 50
    SELECT ename, sal, (sal + 50) AS Sal_hike_50
    FROM Emp;
    
    -- annual deduction of 10%
    SELECT ename, sal*12 AS Annual_Sal_before_deduction, (sal*12 - sal*12*0.1) AS Sal_deduction_10
    FROM Emp;
    
    SELECT * FROM emp;
    
    -- total sal given to each emp, for null values in a column, use IFNULL(col_name, replace_with_value)
    SELECT ename, (sal + IFNULL(comm,0)) as Total_Salary from Emp;
    
    -- all deets, annual salary
    SELECT  Emp.*, sal*12 AS Annual_sal FROM Emp;
	
    -- salary and designation after 100 units penalty on salary
	SELECT ename, job, (sal - 100) AS Salary_after_penalty FROM Emp;
    
    SELECT ename, deptno FROM emp
		WHERE deptno = 20;
        
	-- Select details of employee where job is manager
	SELECT Emp.* 
    FROM Emp
		WHERE job = "Manager";
        
	-- name, hiredate of emps hired after 1981
    SELECT ename, hiredate FROM emp
		WHERE hiredate >= "1981-12-31";
        
	-- display name,sal , annual sal, annual sal > 12000
    SELECT ename, sal, (sal*12) AS Annual_sal FROM Emp
		WHERE sal*12 > 12000;
    
    -- [smith] is working as [clerk] and earning sal of [800]  (columns - strings + 1)
    
    SELECT CONCAT(ename , " is working as ", job, " and earning a salary of ", sal)  AS Description FROM emp;
    
    -- DEETS of emp in dept 20, sal > 2000
    SELECT Emp.* FROM emp
    WHERE deptno = 20 AND sal > 200;
    
    -- name, deptno , in 10,20 deptno
    SELECT Emp.* FROM Emp
    WHERE deptno = 10 OR deptno = 20;
    
    -- deets, sal > 2000, in dept 10,20
	SELECT Emp.* FROM Emp
    WHERE  (sal > 2000) AND deptno IN (10,20);
    
    -- not working as salesman, analyst
	SELECT Emp.* FROM Emp
    WHERE job NOT IN ("Analyst","Salesman");    
    
	SELECT Emp.* FROM Emp
    WHERE job != "Analyst" AND job != "Salesman"; 
    
    -- sal between 1000 and 3000
	SELECT Emp.* FROM Emp
    WHERE sal BETWEEN 1000 AND 3000;
    
    -- deets hired in the year 1981
    SELECT Emp.* FROM Emp
    WHERE hiredate BETWEEN "1981-01-01" AND "1981-12-31";

    SELECT Emp.* FROM Emp
    WHERE sal NOT BETWEEN 1000 AND 3000;
    
    -- deets  not earning commission
    SELECT Emp.* FROM Emp
    WHERE comm IS NULL;
    
    SELECT * FROM Emp
    WHERE comm IS NOT NULL;
    
    -- display deets of employee who are earning salary but not comission
    SELECT * FROM Emp
    WHERE Sal IS NOT NULL AND comm IS NULL;

	-- display names, name starts with s
    SELECT ename FROM Emp
    WHERE ename LIKE 's%';
    
    -- names, with char A
	SELECT ename FROM Emp
    WHERE ename LIKE '%a%';
    
    -- deets, char - a,two times
	SELECT * FROM Emp
    WHERE ename LIKE "%a%a%";
    
    -- exactly 2 'a'
    SELECT * FROM Emp
    WHERE Ename LIKE "%a%a%" AND Ename NOT LIKE "%a%a%a%";
    
    -- name, sal earning 4 digits
	SELECT ename, sal FROM Emp
    WHERE sal LIKE '____.%';
    
    SELECT * FROM Emp;
    
    -- deets hired in feb
    SELECT * FROM Emp
    WHERE Hiredate LIKE '____-02%';
    
    -- name not start with s
	SELECT * FROM Emp
    WHERE ename NOT LIKE 's%';
    
    -- names starting with a or s
	SELECT * FROM Emp
    WHERE ename LIKE 'a%' OR ename LIKE 's%';
    
    -- starting with vowel
    
    SELECT ename FROM Emp
    WHERE ename REGEXP '^[AEIOU]';
    
    -- display deets for consonants
    
    SELECT ename FROM Emp
    WHERE ename REGEXP '^[^AEIOU].*[AEIOU]$';
    
    -- ASSIGNMENT 
    -- 1. all emp with reporting mgrs in dept 10
    
    SELECT * FROM Emp;
    
    SELECT * FROM Emp
    WHERE mgr IN (SELECT empno FROM emp WHERE deptno = 10);
    
    -- 2. comm is null and job clerk
    
    SELECT * FROM Emp
    WHERE comm IS NULL AND job IN ('Clerk');
    
    -- 3. no reporting mgr in 10, or 30 deptno
    SELECT * FROM Emp
    WHERE mgr NOT IN (SELECT deptno FROM Emp where deptno IN (10,30));
    
    
    -- 4. Name starts with j and end with s
    SELECT * FROM Emp
    WHERE ename LIKE 'j%s';

	-- 5. 4 digit salary
    SELECT * FROM Emp
    WHERE sal LIKE '____.%';
    
    -- 6. Name 5 characters
    SELECT * FROM Emp
    WHERE LENGTH(ename) = 5;
    
	-- 7. name, hiredate of hired on 1/../1982
    SELECT ename, hiredate FROM Emp
    WHERE Hiredate LIKE '1982-__-01';
    
    -- 8. name 6 char, start and end with a
    SELECT * FROM Emp
    WHERE LENGTH(ename) = 6 AND ename LIKE 'a%a';
    
	-- 9. 'MAN' job
    SELECT * FROM Emp
    WHERE job LIKE '%MAN%';
    
    -- 10. name of emp with s as last char
    SELECT ename FROM Emp
    WHERE ename LIKE '%s';
    
    -- 11. analyst with 4 digit salary
    SELECT * FROM Emp
    WHERE job = 'Analyst' AND sal LIKE '____.%';
    
    -- 12. HIRED IN FIRST MONTH
    SELECT * FROM Emp
    WHERE Hiredate LIKE '____-01%';
    
    -- 13. NAME HAS TWO L'S AND MANAGER
    SELECT * FROM Emp
    WHERE (Ename LIKE '%l%l' AND Ename NOT LIKE '%l%l%l%') AND job = "Manager";
    
    -- 14. name starts with a,j,s
    SELECT * FROM Emp
    WHERE Ename REGEXP '^[AJS]';
    
    -- 15. ALL EMPLOYEE EXCEPT WITH A AS 3RD CHAR
    SELECT * FROM Emp
    WHERE Ename NOT LIKE '__A%';
    
    --
    
    SELECT ename,LENGTH(ename) FROM Emp;
    
    
    SELECT ename FROM Emp
    WHERE LENGTH(ename) = 4;
    
    SELECT * FROM EMP
    WHERE LENGTH(ename) > 4 AND LENGTH(Ename) < 7;