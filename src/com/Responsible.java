package com;

import javax.persistence.*;

/**
 * Created by weiluo on 2/21/17.
 */
@Entity
@Table(name="Responsible")
public class Responsible {
    @Id@GeneratedValue
    @Column(name = "id")
    private int id;
//    if we set insertable =false, it means responsible instance will not use customerId to populate Responsible table- customerId field
    @Column(name = "customerId",insertable = false,updatable = false)
    private int customerId;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "accountNum")
    private long accountNumber;

    public Responsible(){}

    public Responsible( String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }


}
