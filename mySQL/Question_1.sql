-- USE employee_management_evn_test;
USE employees;

-- Q1 ..
SELECT * FROM employees e WHERE e.hire_date >= '1999-01-01' ORDER BY hire_date LIMIT 10;
-- Q2 ..
SELECT count(*) FROM employees e 
WHERE e.birth_date >= '1950-01-01' AND e.birth_date < '1960-01-01' AND e.last_name LIKE 'Mon%';

-- Q3 !!
-- lieu luong co khac nhau trong qua trinh tu thay doi chuc kieu tu 1995 lam staff nhung 1990 1995 lai luong khac thay vi thay doi tu 1995? va salary tinh la luong tong from date to date hay la luong hang thang hang nam
-- e.emp_no,first_name,last_name,hire_date, sum(salary)
SELECT e.emp_no,first_name,last_name,hire_date, sum(salary) FROM employees e
LEFT JOIN salaries s ON e.emp_no = s.emp_no
LEFT JOIN titles t ON e.emp_no = t.emp_no WHERE e.emp_no = 10005 AND title ='Staff';

-- Q4
-- COUNT(DISTINCT de.emp_no) AS number_staff 
SELECT COUNT(DISTINCT de.emp_no) AS number_staff FROM employees e
LEFT JOIN titles t ON e.emp_no = t.emp_no
LEFT JOIN dept_manager dm ON e.emp_no = dm.emp_no 
LEFT JOIN dept_emp de ON dm.dept_no = de.dept_no
WHERE first_name =  'Margareta' AND last_name =  'Markovitch' AND title ='Manager' AND (de.to_date >= t.from_date AND de.from_date <= t.to_date) ;

-- Q5 ..
-- SALARY nay la salary kieu gi
SELECT t1998.title, SUM(salary) FROM (SELECT t.emp_no, t.title, s.salary FROM titles t
LEFT JOIN salaries s ON t.emp_no = s.emp_no
WHERE 1998 BETWEEN YEAR(s.from_date) AND YEAR(s.to_date)) as t1998
GROUP BY title;

-- Q6 ..
-- SELECT * FROM dept_emp de WHERE dept_no = 'd002' OR dept_no = 'd003'
SELECT * FROM (SELECT emp_no, count(dept_no) AS number_of_dept_no_join FROM dept_emp de WHERE dept_no = 'd002' OR dept_no = 'd003' GROUP BY emp_no) AS dept_no_join WHERE number_of_dept_no_join = 1;

-- Q7 !!
-- >3tr ?
SELECT * FROM (SELECT dept_no, SUM(salary) AS sum_salary FROM (SELECT * FROM salaries s WHERE from_date = '1988-06-25' AND to_date = '1989-06-25') as s
LEFT JOIN dept_emp de ON s.emp_no = de.emp_no
GROUP BY dept_no) AS dept_sum_salary
WHERE sum_salary >= 3000000;

-- Q8 -
-- So nguoi da tung nam giu 2 chuc vu tu luc vao va van con giu 1 chuc vu hien tai
SELECT emp_number_titles.emp_no, emp_number_titles.number_titles, emp_still_work.title_now FROM (SELECT emp_no, COUNT(title) AS number_titles FROM titles t
GROUP BY emp_no) AS emp_number_titles
INNER JOIN
(SELECT emp_no, title as title_now FROM titles t
WHERE to_date = '9999-01-01') AS emp_still_work 
ON emp_number_titles.emp_no = emp_still_work.emp_no
WHERE number_titles >= 2;

-- Q9 ..
-- Cho den hien tai
-- them test
SELECT * FROM (
SELECT s.emp_no, salary, dept_no, title, row_number() over(PARTITION BY dept_no ORDER BY salary DESC) as salary_rank FROM salaries s
LEFT JOIN titles t ON s.emp_no = t.emp_no 
LEFT JOIN dept_emp de ON s.emp_no = de.emp_no
WHERE t.to_date = '9999-01-01' AND title = 'Staff') AS ranks
-- WHERE t.to_date = '9999-01-01' AND title = 'Staff'
WHERE salary_rank <= 5;

-- Q10 ..
-- tung join 2 phong ban
-- them test
SELECT emp_dept_joined.emp_no, emp_dept_joined.dept_joined, emp_more_than_title_per_dept.title_per_dept  FROM(
SELECT t.emp_no, COUNT(DISTINCT dept_no) AS dept_joined FROM titles t
LEFT JOIN dept_emp de ON de.emp_no = t.emp_no
GROUP BY t.emp_no) AS emp_dept_joined
INNER JOIN
-- tung giu 2 chuc vu trong 1 phong ban
(SELECT * FROM (SELECT t.emp_no, COUNT(title) AS title_per_dept FROM titles t
LEFT JOIN dept_emp de ON de.emp_no = t.emp_no
GROUP BY t.emp_no, dept_no) AS emp_title_per_dept) emp_more_than_title_per_dept
ON emp_dept_joined.emp_no = emp_more_than_title_per_dept.emp_no
WHERE title_per_dept >=2 AND dept_joined >=2


