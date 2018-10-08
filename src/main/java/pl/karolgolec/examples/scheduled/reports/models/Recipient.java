package pl.karolgolec.examples.scheduled.reports.models;

import pl.karolgolec.examples.scheduled.mains.models.AbstractModel;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The type Recipient.
 */
@Entity
@Table(name = "recipients")
public class Recipient extends AbstractModel {

    private String firstName;

    private String lastName;

    public Recipient() {
    }

    public Recipient(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Getter for property 'firstName'.
     *
     * @return Value for property 'firstName'.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Setter for property 'firstName'.
     *
     * @param firstName Value to set for property 'firstName'.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Getter for property 'lastName'.
     *
     * @return Value for property 'lastName'.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter for property 'lastName'.
     *
     * @param lastName Value to set for property 'lastName'.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
