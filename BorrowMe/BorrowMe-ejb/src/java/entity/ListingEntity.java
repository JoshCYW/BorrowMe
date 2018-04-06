/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import util.enumeration.CategoryEnum;

/**
 *
 * @author User
 */
@Entity
public class ListingEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long listingId;
    @Column(length = 64, nullable = false)
    private String listingTitle;
    @Column(length = 1000, nullable = true) //I don't think this should be compulsory
    private String listingDescription;
    @Column(nullable = false)
    private Boolean listingAvailable;
    @Column(nullable = false)
    private Double costPerDay;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CategoryEnum category;
    
    @Column
    private List<String> images;
    
    @ManyToOne
    private CustomerEntity customerEntity;
    
    @OneToMany(mappedBy = "listingEntity")
    private List<RequestEntity> requestList;
    
    @OneToMany(mappedBy = "listingEntity")
    private List<FeedbackEntity> feedbackList;
    
    @OneToMany(mappedBy = "listingEntity")
    private List<PaymentEntity> paymentEntities;

    public ListingEntity() {
        feedbackList = new ArrayList<FeedbackEntity>();
        requestList = new ArrayList<RequestEntity>();
        paymentEntities = new ArrayList<PaymentEntity>();
        images = new ArrayList<String>();
    }

    public ListingEntity(Long listingId, String listingTitle, String listingDescription, Boolean listingAvailable, Double costPerDay, CategoryEnum category, CustomerEntity customerEntity) {
        this.listingId = listingId;
        this.listingTitle = listingTitle;
        this.listingDescription = listingDescription;
        this.listingAvailable = true; //default true
        this.costPerDay = costPerDay;
        this.category = category;
        this.customerEntity = customerEntity;
    }

    
    
    public String getListingTitle() {
        return listingTitle;
    }

    public void setListingTitle(String listingTitle) {
        this.listingTitle = listingTitle;
    }

    public String getListingDescription() {
        return listingDescription;
    }

    public void setListingDescription(String listingDescription) {
        this.listingDescription = listingDescription;
    }

    public Boolean getListingAvailable() {
        return listingAvailable;
    }

    public void setListingAvailable(Boolean listingAvailable) {
        this.listingAvailable = listingAvailable;
    }

    public Double getCostPerDay() {
        return costPerDay;
    }

    public void setCostPerDay(Double costPerDay) {
        this.costPerDay = costPerDay;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryEnum category) {
        this.category = category;
    }

    public CustomerEntity getCustomerEntity() {
        return customerEntity;
    }

    public void setCustomerEntity(CustomerEntity customerEntity) {
        this.customerEntity = customerEntity;
    }

    public List<RequestEntity> getRequestList() {
        return requestList;
    }

    public void setRequestList(List<RequestEntity> requestList) {
        this.requestList = requestList;
    }

    public List<FeedbackEntity> getFeedbackList() {
        return feedbackList;
    }

    public void setFeedbackList(List<FeedbackEntity> feedbackList) {
        this.feedbackList = feedbackList;
    }

    public Long getListingId() {
        return listingId;
    }

    public void setListingId(Long listingId) {
        this.listingId = listingId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (listingId != null ? listingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ListingEntity)) {
            return false;
        }
        ListingEntity other = (ListingEntity) object;
        if ((this.listingId == null && other.listingId != null) || (this.listingId != null && !this.listingId.equals(other.listingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ListingEntity[ id=" + listingId + " ]";
    }


    public List<PaymentEntity> getPaymentEntities() {
        return paymentEntities;
    }

    public void setPaymentEntitys(List<PaymentEntity> paymentEntities) {
        this.paymentEntities = paymentEntities;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
    
}
