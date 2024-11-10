package CA_2.Models;

public class CustomDepartment extends Department {
    private String EnteredName;

    public CustomDepartment(String name) {
        EnteredName = name;
    }

    @Override
    public String getName() {
        return EnteredName;
    }

    @Override
    public DepartmentBaseType getType() {
        return DepartmentBaseType.CUSTOM;
    }

}
