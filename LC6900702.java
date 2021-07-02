package solution;

import java.util.List;

// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};

public class LC690 {
    public int getImportance(List<Employee> employees, int id) {
        if(employees.size() == 0){
            return 0;
        }
        Employee e = null;
        for(Employee employee : employees){
            if(employee.id == id){
                e = employee;
                break;
            }
        }
        if(e == null){
            return 0;
        }
        int num = e.importance;
        for(Integer n : e.subordinates){
            num += getImportance(employees,n);
        }
        return (int)num;
    }
}
