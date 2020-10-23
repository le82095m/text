import java.util.List;

// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Employee people = employees.get(id);
        if (!people.subordinates.isEmpty()) {
            for (int e : people.subordinates) {
                return getImportance(employees,e) + employees.get(e).id;
            }
        } else {
            return people.id;
        }
        return 0;
    }
}