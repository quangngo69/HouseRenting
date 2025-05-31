/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;
import java.math.BigDecimal;
/**
 *
 * @author DELL
 */
public class Property {
    public enum PropertyType {
        APARTMENT,
        HOUSE,
        TOWNHOUSE,
        DUPLEX,
        BUNGAGLOW;
        public static PropertyType fromString(String dbValue) {
            return PropertyType.valueOf(dbValue.toUpperCase());
        }    
        
    }
    private int propertyId;
    private int landlordId;
    private String title;
    private String description;
    private BigDecimal price;
    private String district;
    private String street;
    private String town;
    private float area;
    private String propertyType;
    private int bathroomCount;
    private int bedroomCount;
    private boolean approvedStatus;
    private Date createDate;
    private Date availableFrom;
    private boolean status;

    // Default constructor
    public Property() {
    }

    // Constructor with all fields
    public Property(int propertyId, int landlordId, String title, String description, 
                   BigDecimal price, String district, String street, String town, 
                   float area, String propertyType, int bathroomCount, int bedroomCount, 
                   boolean approvedStatus, Date createDate, Date availableFrom, boolean status) {
        this.propertyId = propertyId;
        this.landlordId = landlordId;
        this.title = title;
        this.description = description;
        this.price = price;
        this.district = district;
        this.street = street;
        this.town = town;
        this.area = area;
        this.propertyType = propertyType;
        this.bathroomCount = bathroomCount;
        this.bedroomCount = bedroomCount;
        this.approvedStatus = approvedStatus;
        this.createDate = createDate;
        this.availableFrom = availableFrom;
        this.status = status;
    }

    // Constructor without propertyId (for new properties)
    public Property(int landlordId, String title, String description, BigDecimal price, 
                   String district, String street, String town, float area, 
                   String propertyType, int bathroomCount, int bedroomCount, 
                   boolean approvedStatus, Date createDate, Date availableFrom, boolean status) {
        this.landlordId = landlordId;
        this.title = title;
        this.description = description;
        this.price = price;
        this.district = district;
        this.street = street;
        this.town = town;
        this.area = area;
        this.propertyType = propertyType;
        this.bathroomCount = bathroomCount;
        this.bedroomCount = bedroomCount;
        this.approvedStatus = approvedStatus;
        this.createDate = createDate;
        this.availableFrom = availableFrom;
        this.status = status;
    }

    // Getters
    public int getPropertyId() {
        return propertyId;
    }

    public int getLandlordId() {
        return landlordId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getDistrict() {
        return district;
    }

    public String getStreet() {
        return street;
    }

    public String getTown() {
        return town;
    }

    public float getArea() {
        return area;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public int getBathroomCount() {
        return bathroomCount;
    }

    public int getBedroomCount() {
        return bedroomCount;
    }

    public boolean isApprovedStatus() {
        return approvedStatus;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Date getAvailableFrom() {
        return availableFrom;
    }

    public boolean isStatus() {
        return status;
    }

    // Setters
    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public void setLandlordId(int landlordId) {
        this.landlordId = landlordId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public void setBathroomCount(int bathroomCount) {
        this.bathroomCount = bathroomCount;
    }

    public void setBedroomCount(int bedroomCount) {
        this.bedroomCount = bedroomCount;
    }

    public void setApprovedStatus(boolean approvedStatus) {
        this.approvedStatus = approvedStatus;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setAvailableFrom(Date availableFrom) {
        this.availableFrom = availableFrom;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}    

