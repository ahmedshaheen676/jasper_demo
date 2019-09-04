/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jasper_demo.Model;

/**
 *
 * @author lts
 */
public class Employee {

    //Queries
    public static final String SELECT_BY_ID = "SELECT * FROM employee WHERE id = ?";
    public static final String SELECT_ALL = "SELECT * FROM employee ";

    private int id;
    private String fistName;
    private String lastName;
    private String Address;
    private int age;
    private String phone;
    private String nationalId;

    public Employee() {
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the fistName
     */
    public String getFistName() {
        return fistName;
    }

    /**
     * @param fistName the fistName to set
     */
    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the Address
     */
    public String getAddress() {
        return Address;
    }

    /**
     * @param Address the Address to set
     */
    public void setAddress(String Address) {
        this.Address = Address;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the nationalId
     */
    public String getNationalId() {
        return nationalId;
    }

    /**
     * @param nationalId the nationalId to set
     */
    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

}
