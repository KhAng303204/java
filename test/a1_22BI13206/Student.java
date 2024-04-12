package a1_22BI13206;

import utils.*;

/**
 * @overview
 * Represents a student of a university. There are two specific types:
 * UndergradStudent and PostgradStudent.
 *
 * @attributes
 * id Integer
 * name String
 * phoneNumber String
 * address String
 *
 * @object
 * A student is represented by (id, name, phoneNumber, address).
 *
 * @abstract_properties
 * mutable(id)=false /\ optional(id)=false /\ min(id)=1 /\ max(id)=1e9 /\
 * mutable(name)=true /\ optional(name)=false /\ length(name)=50 /\
 * mutable(phoneNumber)=true /\ optional(phoneNumber)=false /\ length(phoneNumber)=10 /\
 * mutable(address)=true /\ optional(address)=false /\ length(address)=100
 *
 * @author
 * Nguyen Phuc Khang
 */

public class Student implements Comparable<Student> {
    private static final int MINIMUM_ID = 1;
    private static final int MAXIMUM_ID = (int) 1e9;
    private static final int LENGTH_NAME = 50;
    private static final int LENGTH_ADDRESS = 100;
    private static final int LENGTH_PHONE_NUMBER = 10;

    @DomainConstraint(type = "Integer", mutable = false, optional = false, min = MINIMUM_ID, max = MAXIMUM_ID)
    private int id;

    @DomainConstraint(type = "String", optional = false, length = LENGTH_NAME)
    private String name;

    @DomainConstraint(type = "String", optional = false, length = LENGTH_PHONE_NUMBER)
    private String phoneNumber;

    @DomainConstraint(type = "String", optional = false, length = LENGTH_ADDRESS)
    private String address;

    /**
     * @effects initialise this as <id,name,phoneNumber,address> if those are valid, else throw NotPossibleException
     */
    public Student(int id, String name, String phoneNumber, String address) throws NotPossibleException {
        if (!validate_id(id)) {
            throw new NotPossibleException("Invalid ID for student " + name);
        }
        if (!validate_name(name)) {
            throw new NotPossibleException("Invalid name for student " + name);
        }
        if (!validate_phoneNumber(phoneNumber)) {
            throw new NotPossibleException("Invalid phone number for student " + name);
        }
        if (!validate_address(address)) {
            throw new NotPossibleException("Invalid address for student " + name);
        }
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    // region: getters
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
    // endregion

    // region: setters
    public boolean setPhoneNumber(String phoneNumber) {
        if (validate_phoneNumber(phoneNumber)) {
            this.phoneNumber = phoneNumber;
            return true;
        }
        return false;
    }

    public boolean setAddress(String address) {
        if (validate_address(address)) {
            this.address = address;
            return true;
        }
        return false;
    }

    public boolean setName(String name) {
        if (validate_name(name)) {
            this.name = name;
            return true;
        }
        return false;
    }
    // endregion

    // region: other methods
    public boolean repOK() {
        return validate_id(id) && validate_name(name) && validate_phoneNumber(phoneNumber) && validate_address(address);
    }

    @Override
    public String toString() {
        return String.format("Student:<%d,%s,%s,%s>", this.getId(), this.getName(), this.getPhoneNumber(), this.getAddress());
    }

    @Override
    public int compareTo(Student input_student) throws ClassCastException, NullPointerException {
        if (input_student == null) {
            throw new NullPointerException("Input student is null");
        }
        if (!(input_student instanceof Student)) {
            throw new ClassCastException("Input student is not a Student");
        }
        return this.getName().compareTo(input_student.getName());
    }
    // endregion

    // region: helper methods
    protected boolean validate_id(int id) {
        return id >= MINIMUM_ID && id <= MAXIMUM_ID;
    }

    protected boolean validate_name(String name) {
        return name.length() <= LENGTH_NAME;
    }

    protected boolean validate_phoneNumber(String phoneNumber) {
        return phoneNumber.length() <= LENGTH_PHONE_NUMBER;
    }

    protected boolean validate_address(String address) {
        return address.length() <= LENGTH_ADDRESS;
    }
    // endregion
}
