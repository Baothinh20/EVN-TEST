package JAVA_9.service.impl;

import JAVA_9.entity.Key.TitlesKey;
import JAVA_9.repository.*;
import JAVA_9.service.EmpManagerService;
import JAVA_9.dto.EmpTitleSalary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static JAVA_9.constant.Constant.TO_DATE_DEFAULT;

@Service
public class EmpManagerServiceImpl implements EmpManagerService {

    @Autowired
    private EmployeesRepository employeesRepository;
    @Autowired
    private SalariesRepository salariesRepository;
    @Autowired
    private TitlesRepository titlesRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private DeptEmpRepository deptEmpRepository;
    @Autowired
    private DeptManagerRepository deptManagerRepository;

    @Override
    @Transactional
    public void setupNewEmployees(EmpTitleSalary empTitleSalary) {
        // set from_date = hire_date
        empTitleSalary.getTitles().setTitlesKey(
                new TitlesKey(  empTitleSalary.getTitles().getTitlesKey().getTitle(),
                        empTitleSalary.getEmployees().getHireDate())
        );
        empTitleSalary.getSalaries().getSalaryKey().setFromDate(empTitleSalary.getEmployees().getHireDate());
        // set tgian lam den TO_DATE_DEFAULT
        empTitleSalary.getTitles().setToDate(TO_DATE_DEFAULT);
        empTitleSalary.getSalaries().setToDate(TO_DATE_DEFAULT);
        // set empid
        empTitleSalary.getTitles().setEmployees(empTitleSalary.getEmployees());
        empTitleSalary.getSalaries().getSalaryKey().setEmployees(empTitleSalary.getEmployees());
        // save vao database
        employeesRepository.save(empTitleSalary.getEmployees());
        titlesRepository.save(empTitleSalary.getTitles());
        salariesRepository.save(empTitleSalary.getSalaries());
    }

    @Override
    @Transactional
    public void changeDept(int empNo, String deptNo) {
//        DeptEmp deptEmp = new DeptEmp();
//        deptEmp.getDeptEmpKey().setEmployees(employeesRepository.findByEmpNo(empNo));
//        deptEmp.getDeptEmpKey().setDepartment(departmentRepository.findByDeptNo(deptNo));
//        deptEmp.setFromDate(LocalDate.now());
//        deptEmp.setToDate(TO_DATE_DEFAULT);
//        deptEmpRepository.checkEmpNo(empNo);
//        deptEmpRepository.save(deptEmp);
        //        Dung store proceduce
        deptEmpRepository.changeEmpDept(empNo, deptNo);
    }

}
