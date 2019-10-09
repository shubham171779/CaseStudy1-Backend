package com.caseStudy.ecart.modal;
import javax.persistence.*;
import java.io.Serializable;

@Entity
public class items implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;
    private String name;
    private double price;
    private String details;
    private String image;
    private String category;
    private String subcategory;
    @Column(nullable=false,columnDefinition = "int default '1'")
    private int active;
    @Embedded
    private itemdetails itemdetails;
     items(){

    }
    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public com.caseStudy.ecart.modal.itemdetails getItemdetails() {
        return itemdetails;
}

    public void setItemdetails(com.caseStudy.ecart.modal.itemdetails itemdetails) {
        this.itemdetails = itemdetails;
    }
}
