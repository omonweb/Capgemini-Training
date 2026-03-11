SELECT locate('a', 'malayalam') AS location_a;

SELECT locate('a', 'malayalam', 3) AS location_a;

SELECT locate('a', 'malayalam', 5) AS location_a;

SELECT SUBSTR( 'omarora@gmail.com',(locate('@','omarora@gmail.com'))+1) AS domain_email;

-- date/time

SELECT current_date();

SELECT curdate();

SELECT current_time();

SELECT current_timestamp();

SELECT now();

SELECT Year(now());


-- extracting various details from the now() function regarding time, date, month, year

SELECT extract(year from now());

SELECT extract(month from now());

SELECT extract(day from now());

SELECT extract(hour from now());

SELECT extract(minute from now());

SELECT extract(second from now());


-- want to retrieve who all were hired on friday??
-- to_char() - convert date to formate models

-- day - Monday
-- dy - mon
-- dd - 16
-- d - 1

USE db_2;

-- all emp hired on friday

SELECT emp.*, DAYNAME(Hiredate) as day
FROM emp
WHERE DAYNAME(Hiredate) = 'Friday';

SELECT emp.*, DATE_FORMAT(Hiredate, '%W') as day
FROM emp
WHERE DATE_FORMAT(Hiredate, '%a') = 'Fri';

-- hired in december
SELECT emp.*, MONTHNAME(Hiredate) as Month
FROM emp
WHERE monthname(Hiredate) = "December";

-- deets of emp hired in 1981, in feb, december, april on wednesday/friday

SELECT emp.*, YEAR(Hiredate) as Year, MONTHNAME(Hiredate) as Month, DAY(Hiredate) as day
FROM emp
WHERE Year(Hiredate) = '1981' AND month(Hiredate) in (2,12,4) AND dayofweek(Hiredate) in (4,6);

-- emps hired in last 2 years

-- emps with 10+ years exp

SELECT * FROM emp
WHERE timediff(curdate(), hiredate) >= 10;


-- emp with highest sal

SELECT ename, sal
FROM EMP
ORDER BY sal DESC LIMIT 1;


-- multi-row function accepts only 1 argument, no other columns written alongwith multi-row func.
-- count() only multi-row func which will accept * as an argument
SELECT COUNT(comm)
FROM emp;

SELECT COUNT(*)
FROM Emp;

-- num of emp name has char e

SELECT COUNT(ename) 
FROM Emp
WHERE ename LIKE '%A%';

-- max,min, avg sal in dept 20

SELECT max(sal) as maximum_sal, min(sal) as minimum_sal, avg(sal) as avg_sal
FROM emp
WHERE deptno = 20;

-- 

SELECT COUNT(ename) as total_emp, (sal + coalesce(comm,0)) AS Total_sal 
FROM Emp
GROUP BY total_emp
HAVING Total_sal > 1700;


SELECT deptno, count(*) AS total_emp
FROM emp
GROUP BY deptno
ORDER BY total_emp DESC;


-- MAX SALARY, each role

SELECT * FROM EMP;

SELECT MAX(Sal), job
FROM Emp
GROUP BY job;


-- NO. OF TIMES SALARY IS REPEATED

SELECT (COUNT(SAL) - COUNT(DISTINCT SAL)) AS repeated_sal FROM EMP;

-- avg sal per job

SELECT avg(sal), job
FROM emp
GROUP BY job;

-- num of emp, earning comission IN EACH DEPT

SELECT COUNT(comm) AS num_emp, deptno
FROM emp
GROUP BY deptno;

-- atleast 2 emp , grouped by dept, name - a or s

SELECT count(*) as number_emp, deptno
FROM Emp
WHERE ename LIKE '%a%' OR ename LIKE '%s%'
GROUP BY deptno
HAVING COUNT(*) >= 2;

-- repeated salary

SELECT Sal 
FROM Emp
GROUP BY Sal
HAVING COUNT(sal) >= 2;

-- job, total sal each job, totalsal > 9500
SELECT * FROM emp;

SELECT job, sum(sal) as total_SAL 
FROM EMP
GROUP BY job
HAVING total_SAL > 7000;

-- no of emp sal > 1200 per job
		-- total sal per job must exceed 3800
        
	SELECT COUNT(*) AS num_emp , sum(sal) AS Total_sal  ,job
    FROM emp
    WHERE sal > 1200
    GROUP BY job
    HAVING total_sal > 3800;



-- job,max sal in each job max sal > 2600

SELECT job, MAX(SAL) AS max_sal
FROM Emp
GROUP BY job
HAVING max_sal > 2600;


-- duplicate hiredate

SELECT Hiredate
FROM emp
GROUP BY Hiredate
HAVING COUNT(HIREDATE) >= 2;

-- MIN,MAX SAL EACH JOB, MIN SAL > 1000 , MAX < 5000

SELECT JOB, MIN(sal) as min_sal , MAX(sal) as max_sal
FROM Emp
GROUP BY job
HAVING MIN_SAL > 1000 AND MAX_SAL < 5000;


-- dept no, num of emp, 2 emp working in each dept as mgr

SELECT deptno, COUNT(*) AS num_emp
FROM Emp
GROUP BY deptno
HAVING COUNT(mgr) = 2;


select * from emp;


-- repeated sal

SELECT COUNT(sal), sal 
FROM Emp
GROUP BY Sal
ORDER BY COUNT(sal) DESC;

-- deets of emp, sal > allen

SELECT emp.* 
FROM Emp
WHERE sal > (SELECT sal FROM Emp WHERE ename = 'Allen');