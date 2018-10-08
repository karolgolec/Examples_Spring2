package pl.karolgolec.examples.scheduled.reports.models;

import pl.karolgolec.examples.scheduled.mains.models.AbstractModel;

import javax.persistence.*;
import java.util.UUID;

/**
 * The type Report.
 */
@Entity
@Table(name = "reports")
public class Report extends AbstractModel {

    @Column(unique = true)
    private String uuid;

    @OneToOne(fetch = FetchType.EAGER)
    private Recipient recipient;

    private Integer year;

    private Boolean generated;


    /**
     * Instantiates a new Report.
     *
     * @param recipient the recipient
     * @param year      the year
     */
    public Report(Recipient recipient, Integer year) {
        this();
        this.recipient = recipient;
        this.year = year;
    }

    /**
     * Instantiates a new Report.
     */
    public Report() {
        this.uuid = UUID.randomUUID().toString();
        this.generated = false;
    }

    /**
     * Getter for property 'uuid'.
     *
     * @return Value for property 'uuid'.
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * Setter for property 'uuid'.
     *
     * @param uuid Value to set for property 'uuid'.
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * Getter for property 'recipient'.
     *
     * @return Value for property 'recipient'.
     */
    public Recipient getRecipient() {
        return recipient;
    }

    /**
     * Setter for property 'recipient'.
     *
     * @param recipient Value to set for property 'recipient'.
     */
    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }

    /**
     * Getter for property 'year'.
     *
     * @return Value for property 'year'.
     */
    public Integer getYear() {
        return year;
    }

    /**
     * Setter for property 'year'.
     *
     * @param year Value to set for property 'year'.
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * Getter for property 'generated'.
     *
     * @return Value for property 'generated'.
     */
    public Boolean getGenerated() {
        return generated;
    }

    /**
     * Setter for property 'generated'.
     *
     * @param generated Value to set for property 'generated'.
     */
    public void setGenerated(Boolean generated) {
        this.generated = generated;
    }
}
