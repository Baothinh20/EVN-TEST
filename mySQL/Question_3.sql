DROP PROCEDURE IF EXISTS Question_3;
DELIMITER $$
CREATE PROCEDURE Question_3(IN full_name_emp VARCHAR(30))
BEGIN
	WITH emp_table_better AS (SELECT e.emp_no, CONCAT(e.first_name, ' ', e.last_name) AS full_name, e.gender, t.title, d.dept_name FROM employees e
    INNER JOIN titles t ON t.emp_no = e.emp_no
    INNER JOIN dept_emp de ON de.emp_no = e.emp_no 
    INNER JOIN departments d ON d.dept_no = de.dept_no)
    SELECT * FROM emp_table_better WHERE emp_table_better.full_name = full_name_emp;
    WITH emp_sum_salary AS (SELECT e.emp_no, CONCAT(e.first_name, ' ', e.last_name) AS full_name, SUM(salary) AS sum_salary FROM employees e 
    INNER JOIN salaries s ON e.emp_no = s.emp_no
    GROUP BY e.emp_no)
    SELECT * FROM emp_sum_salary 
    WHERE emp_sum_salary.full_name = full_name_emp;
END$$
CALL Question_3('Kyoichi Maliniak')