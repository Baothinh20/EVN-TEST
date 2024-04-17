DROP DATABASE IF EXISTS employee_management_evn_test;
CREATE DATABASE employee_management_evn_test;
USE employee_management_evn_test;

DROP TABLE IF EXISTS employees;
CREATE TABLE employees(
	emp_no INT(11) NOT NULL,
    birth_date DATE,
    first_name VARCHAR(14),
    last_name VARCHAR(16),
    gender ENUM('M','F'),
    hire_date DATE,
    PRIMARY KEY (emp_no)
);

DROP TABLE IF EXISTS titles;
CREATE TABLE titles(
	emp_no INT(11) NOT NULL,
    title VARCHAR(50) NOT NULL,
    from_date DATE NOT NULL,
    to_date DATE,
    PRIMARY KEY (title,from_date),
    FOREIGN KEY (emp_no) REFERENCES employees (emp_no),
    INDEX (emp_no)
);

DROP TABLE IF EXISTS salaries;
CREATE TABLE salaries(
	emp_no INT(11) NOT NULL,
    salary INT(11),
    from_date DATE NOT NULL,
    to_date DATE,
    PRIMARY KEY (from_date),
    FOREIGN KEY (emp_no) REFERENCES employees (emp_no),
    INDEX (emp_no)
);

DROP TABLE IF EXISTS departments;
CREATE TABLE departments(
	dept_no CHAR(4) NOT NULL,
    dept_name VARCHAR(40),
    PRIMARY KEY (dept_no),
    UNIQUE INDEX (dept_name)
);

DROP TABLE IF EXISTS dept_emp;
CREATE TABLE dept_emp(
	emp_no INT(11) NOT NULL,
    dept_no CHAR(4) NOT NULL,
    from_date DATE,
    to_date DATE,
    PRIMARY KEY (emp_no,dept_no),
    FOREIGN KEY (emp_no) REFERENCES employees (emp_no), 
	FOREIGN KEY (dept_no) REFERENCES departments (dept_no),
    INDEX (emp_no),
    INDEX (dept_no)
);

DROP TABLE IF EXISTS dept_manager;
CREATE TABLE dept_manager(
	dept_no CHAR(4) NOT NULL,
    emp_no INT(11) NOT NULL,
    from_date DATE,
    to_date DATE,
    PRIMARY KEY (dept_no,emp_no),
    FOREIGN KEY (emp_no) REFERENCES employees (emp_no), 
	FOREIGN KEY (dept_no) REFERENCES departments (dept_no),
    INDEX (emp_no),
    INDEX (dept_no)
);
