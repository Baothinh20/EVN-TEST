DROP PROCEDURE IF EXISTS Question_4;
DELIMITER $$
CREATE PROCEDURE Question_4(IN emp_id INT, IN dept_id CHAR(4), IN new_title VARCHAR(50))
BEGIN
	UPDATE dept_emp
    SET to_date = CURRENT_DATE()
    WHERE emp_no = emp_id AND to_date = '9999-01-01';
    INSERT INTO dept_emp (emp_no, dept_no, from_date, to_date)
    VALUES	(emp_id, dept_id, CURRENT_DATE(), '9999-01-01');
    UPDATE titles
    SET to_date = CURRENT_DATE()
    WHERE emp_no = emp_id AND to_date = '9999-01-01';
    INSERT INTO titles (emp_no, title, from_date, to_date)
    VALUES	(emp_id, new_title, CURRENT_DATE(), '9999-01-01');
    
	WITH emp_table_better AS (SELECT e.emp_no, CONCAT(e.first_name, ' ', e.last_name) AS full_name, e.gender, t.title, d.dept_name FROM employees e
    INNER JOIN titles t ON t.emp_no = e.emp_no
    INNER JOIN dept_emp de ON de.emp_no = e.emp_no 
    INNER JOIN departments d ON d.dept_no = de.dept_no
    WHERE t.to_date = '9999-01-01' AND de.to_date = '9999-01-01')
    SELECT * FROM emp_table_better WHERE emp_no = emp_id;
END$$
CALL Question_4(10007, 'd009','Senior Staff');

DROP PROCEDURE IF EXISTS Change_Emp_Dept;
DELIMITER $$
CREATE PROCEDURE Change_Emp_Dept(IN emp_id INT, IN dept_id CHAR(4))
BEGIN
	UPDATE dept_emp
    SET to_date = CURRENT_DATE()
    WHERE emp_no = emp_id AND to_date = '9999-01-01';
    INSERT INTO dept_emp (emp_no, dept_no, from_date, to_date)
    VALUES	(emp_id, dept_id, CURRENT_DATE(), '9999-01-01');
END$$
CALL  Change_Emp_Dept(10007, 'd001');