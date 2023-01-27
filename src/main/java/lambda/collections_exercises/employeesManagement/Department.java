package lambda.collections_exercises.employeesManagement;

import java.util.List;

public class Department {
    private String nameDep;
    private String code;
    private List<Employee> employeeList;

    public Department(String nameDep, String code, List<Employee> employeeList) {
        this.nameDep = nameDep;
        this.code = code;
        this.employeeList = employeeList;
    }

    public String getNameDep() {
        return nameDep;
    }

    public void setNameDep(String nameDep) {
        this.nameDep = nameDep;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public String toString() {
        return "Departament{" +
                "nameDep='" + nameDep + '\'' +
                ", code='" + code + '\'' +
                ", employeeList=" + employeeList +
                '}';
    }
}
