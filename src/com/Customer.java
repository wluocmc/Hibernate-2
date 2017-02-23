package com;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by weiluo on 2/21/17.
 */
@Entity
@Table(name="Customer")
public class Customer {
    @Id@GeneratedValue
    @Column(name="id")
    private int id;
    @Column(name="accountNum")
    private long accountNum;
    @Column(name="firstName")
    private String firstName;
    @Column(name="lastName")
    private String lastName;
    @OneToMany(cascade = CascadeType.ALL)
//    @PrimaryKeyJoinColumn(name = "id",referencedColumnName = "customerId")
//    @PrimaryKeyJoinColumn(name = "customerId",referencedColumnName = "id")
//    @JoinColumn(name = "customerId",referencedColumnName = "id")
//    @JoinColumn(name = "id",referencedColumnName = "customerId")
//    @JoinColumn(name="customerId")
    private Set<Responsible> Authorized;

    public Customer(){}
    public Customer(long accountNum,String firstName,String lastName, Set<Responsible> Authorized){
        this.accountNum=accountNum;
        this.firstName=firstName;
        this.lastName=lastName;
        this.Authorized=Authorized;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(long accountNum) {
        this.accountNum = accountNum;
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

    public Set<Responsible> getAuthorized() {
        return Authorized;
    }

    public void setAuthorized(Set<Responsible> authorized) {
        Authorized = authorized;
        for(Responsible individual: authorized){
            individual.setAccountNumber(this.getAccountNum());
            individual.setCustomerId(this.getId());
        }
    }
    public void setAuthorized() {
        for(Responsible individual: this.getAuthorized()){
            individual.setAccountNumber(this.getAccountNum());
            //individual.setCustomerId(this.getId());
        }
    }



}
