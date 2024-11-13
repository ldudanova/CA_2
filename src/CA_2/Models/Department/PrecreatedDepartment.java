package CA_2.Models.Department;

import CA_2.Models.Department.Department;
import CA_2.Models.Department.DepartmentBaseType;
import CA_2.Models.Department.DepartmentDefaultType;

public class PrecreatedDepartment extends Department {
    private DepartmentDefaultType SelectedDepartment;

    public PrecreatedDepartment(DepartmentDefaultType department) {
        SelectedDepartment = department;
    }

    public DepartmentDefaultType GetSelectedDepartment() {
        return SelectedDepartment;
    }

    @Override
    public String getName() {
        return SelectedDepartment.toString();
    }

    @Override
    public DepartmentBaseType getType() {
        return DepartmentBaseType.DEFAULT;
    }
}
