package java112.employee;


/**
 * @author Corissa Engel
 * @version 1.0
 * class Employee
 */
public class Employee {

    private String employeeId;
    private String firstName;
    private String lastName;
    private String socialSecurityNumber;
    private String department;
    private String roomNumber;
    private String phoneNumber;


    /**
     * Constructor for Employee
     */
    public Employee() {
    }


    /**
     * Returns the value of employeeId.
     * @return employeeId The employee ID.
     */
    public String getEmployeeId() {
        return employeeId;
    }


    /**
     * Sets the value of employeeId.
     * @param employeeId The value to assign employeeId.
     */
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }


    /**
     * Returns the value of firstName.
     * @return firstName The employee's first name.
     */
    public String getFirstName() {
        return firstName;
    }


    /**
     * Sets the value of firstName.
     * @param firstName The value to assign firstName.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    /**
     * Returns the value of lastName.
     * @return lastName The employee's last name.
     */
    public String getLastName() {
        return lastName;
    }


    /**
     * Sets the value of lastName.
     * @param lastName The value to assign lastName.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    /**
     * Returns the value of socialSecurityNumber.
     * @return socialSecurityNumber The employee's social security number.
     */
    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }


    /**
     * Sets the value of socialSecurityNumber.
     * @param socialSecurityNumber The value to assign socialSecurityNumber.
     */
    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }


    /**
     * Returns the value of department.
     * @return department The employee's department.
     */
    public String getDepartment() {
        return department;
    }


    /**
     * Sets the value of department.
     * @param department The value to assign department.
     */
    public void setDepartment(String department) {
        this.department = department;
    }


    /**
     * Returns the value of roomNumber.
     * @return roomNumber The employee's room number.
     */
    public String getRoomNumber() {
        return roomNumber;
    }


    /**
     * Sets the value of roomNumber.
     * @param roomNumber The value to assign roomNumber.
     */
    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }


    /**
     * Returns the value of phoneNumber.
     * @return phoneNumber The employee's phone number.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }


    /**
     * Sets the value of phoneNumber.
     * @param phoneNumber The value to assign phoneNumber.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public String toString() {
        return getEmployeeId() + getFirstName() + getLastName() + getSocialSecurityNumber()
                + getDepartment() + getRoomNumber() + getPhoneNumber();
    }
}
