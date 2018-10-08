package pl.karolgolec.examples.scheduled.mains.models;

import javax.persistence.*;
import java.util.Calendar;

/**
 * The type Abstract model.
 */
@MappedSuperclass
public abstract class AbstractModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Calendar createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Calendar updatedAt;

    /**
     * Instantiates a new Abstract model.
     */
    public AbstractModel() {
    }

    /**
     * On create.
     */
    @PrePersist
    protected void onCreate() {
        this.updatedAt = this.createdAt = Calendar.getInstance();
    }

    /**
     * On update.
     */
    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = Calendar.getInstance();
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Gets created at.
     *
     * @return the created at
     */
    public Calendar getCreatedAt() {
        return this.createdAt;
    }

    /**
     * Sets created at.
     *
     * @param createdAt the created at
     */
    public void setCreatedAt(Calendar createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Gets updated at.
     *
     * @return the updated at
     */
    public Calendar getUpdatedAt() {
        return this.updatedAt;
    }

    /**
     * Sets updated at.
     *
     * @param updatedAt the updated at
     */
    public void setUpdatedAt(Calendar updatedAt) {
        this.updatedAt = updatedAt;
    }
}
