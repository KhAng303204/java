package a1_22BI13206;

import utils.*;

/**
 * @overview
 * Represents a postgraduate student of a university, extending the Student class.
 *
 * @attributes
 * gpa Float
 *
 * @object
 * A postgraduate student is represented by (id, name, phoneNumber, address, gpa).
 *
 * @abstract_properties
 * Inherits properties from Student class and adds:
 * mutable(gpa) = true /\ optional(gpa) = false /\ min(gpa) = 0.0 /\ max(gpa) = 4.0
 * Length constraints for other attributes remain the same as in Student class.
 *
 * @author
 * Nguyen Phuc Khang
 */

public class PostgradStudent extends Student {
    private static final float MIN_GPA = 0.0f;
    private static final float MAX_GPA = 4.0f;

    @DomainConstraint(type = "Float", mutable = true, optional = false, min = MIN_GPA, max = MAX_GPA)
    private float gpa;

    /**
     * @effects
     * initialise this as <id,name,phoneNumber,address,gpa> if those are valid, else throw NotPossibleException
     */
    public PostgradStudent(int id, String name, String phoneNumber, String address, float gpa) throws NotPossibleException {
        super(id, name, phoneNumber, address);
        if (!validate_gpa(gpa)) {
            throw new NotPossibleException("Invalid GPA for student " + name);
        }
        this.gpa = gpa;
    }

    // region: getters
    public float getGpa() {
        return gpa;
    }
    // endregion

    // region: setters
    public boolean setGpa(float gpa) {
        if (validate_gpa(gpa)) {
            this.gpa = gpa;
            return true;
        }
        return false;
    }
    // endregion

    // region: other methods
    @Override
    public String toString() {
        return String.format("PostgradStudent:<%d,%s,%s,%s,%.2f>", this.getId(), this.getName(), this.getPhoneNumber(), this.getAddress(), this.getGpa());
    }

    public void printStudentInfo() {
        System.out.println("Postgrad Student Info:");
        System.out.println("ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Phone Number: " + getPhoneNumber());
        System.out.println("Address: " + getAddress());
        System.out.println("GPA: " + getGpa());
    }
    // endregion

    // region: helper methods
    protected boolean validate_gpa(float gpa) {
        return gpa >= MIN_GPA && gpa <= MAX_GPA;
    }
    // endregion
}
