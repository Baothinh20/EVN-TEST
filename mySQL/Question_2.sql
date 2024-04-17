USE employee_management_evn_test;

-- Q1
DROP PROCEDURE IF EXISTS update_title;

DELIMITER $$
CREATE PROCEDURE update_title(IN emp_id INT)
BEGIN
	INSERT INTO titles (emp_no, title, from_date, to_date)
    VALUES	(emp_id, 'Senior Staff', CURRENT_DATE(), '9999-01-01');
	UPDATE titles
    SET to_date = CURRENT_DATE()
    WHERE title = 'Staff' AND emp_no = emp_id AND to_date = '9999-01-01';
END $$
CALL update_title(10002)

-- Q2
DROP PROCEDURE IF EXISTS delete_department;

DELIMITER $$
CREATE PROCEDURE delete_department(IN dname VARCHAR(40))
BEGIN
	DECLARE dept_delete_no CHAR(4);
	SET dept_delete_no = (SELECT dept_no FROM departments WHERE dept_name = dname);
	DELETE FROM departments
    WHERE dept_name = dname;
    DELETE FROM dept_emp
    WHERE dept_no = dept_delete_no;
    DELETE FROM dept_manager
    WHERE dept_no = dept_delete_no;
END$$
CALL delete_department('Production')

-- Q3
DROP PROCEDURE IF EXISTS create_department_and_manager;

DELIMITER $$
CREATE PROCEDURE create_department_and_manager(IN dno Char(4), IN dname VARCHAR(40),IN emp_id INT)
BEGIN
	INSERT INTO departments (dept_no, dept_name)
    VALUES	(dno, dname);
    INSERT INTO dept_manager (emp_no, dept_no, from_date, to_date)
    VALUES	(emp_id, dno, CURRENT_DATE(), '9999-01-01');
END$$
CALL create_department_and_manager('d010','Bigdata & ML', 10173)