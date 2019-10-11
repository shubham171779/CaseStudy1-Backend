package com.caseStudy.ecart.modal;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class cart implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;
    private int quantity;
    @ManyToOne
    private items items;
    @ManyToOne
    private Users users;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public items getItm() {
        return items;
    }

    public void setItm(items itm) {
        this.items = itm;
    }

    public Users getUsr() {
        return users;
    }

    public void setUsr(Users usr) {
        this.users = usr;
    }
}
