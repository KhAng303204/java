package a1_22BI13206;

import utils.*;

/**
 * @overview
 * Represents an undergraduate student of a university, extending the Student class.
 *
 * @attributes
 * year Integer
 *
 * @object
 * An undergraduate student is represented by (id, name, phoneNumber, address, year).
 *
 * @abstract_properties
 * Inherits properties from Student class and adds:
 * mutable(year) = true /\ optional(year) = false /\ min(year) = 1
 * Length constraints for other attributes remain the same as in Student class.
 *
 * @author
 * Nguyen Phuc Khang
 */

public class UndergradStudent extends Student {
    private static final int MIN_YEAR = 1;

    @DomainConstraint(type = "Integer", mutable = true, optional = false, min = MIN_YEAR)
    private int year;

    /**
     * @effects
     * initialise this as <id,name,phoneNumber,address,year> if those are valid, else throw NotPossibleException
     */
    public UndergradStudent(int id, String name, String phoneNumber, String address, int year) throws NotPossibleException {
        super(id, name, phoneNumber, address);
        if (!validate_year(year)) {
            throw new NotPossibleException("Invalid year for student " + name);
        }
        this.year = year;
    }

    // region: getters
    public int getYear() {
        return year;
    }
    // endregion

    // region: setters
    public boolean setYear(int year) {
        if (validate_year(year)) {
            this.year = year;
            return true;
        }
        return false;
    }
    // endregion

    // region: other methods
    @Override
    public String toString() {
        return String.format("UndergradStudent:<%d,%s,%s,%s,%d>", this.getId(), this.getName(), this.getPhoneNumber(), this.getAddress(), this.getYear());
    }

    public void printStudentInfo() {
        System.out.println("Undergrad Student Info:");
        System.out.println("ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Phone Number: " + getPhoneNumber());
        System.out.println("Address: " + getAddress());
        System.out.println("Year: " + getYear());
    }
    // endregion

    // region: helper methods
    protected boolean validate_year(int year) {
        return year >= MIN_YEAR;
    }
    // endregion
}
