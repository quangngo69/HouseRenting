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
public class Properties {
    enum PropertyType {
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
    private double area;
    private PropertyType propertyType;
    private int bathroomCount;
    private int bedroomCount;
    private boolean approveStatus;
    private Date createDate;
    private Date availableFrom;
    
    public Properties () {  
    }
    public Properties (int propertyId, int landlordId, String title, String description, BigDecimal price, String district, String street, String town, double area, PropertyType propertyType, int bathroomCount, int bedroomCount, boolean approveStatus, Date createDate, Date availableFrom) {
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
        this.approveStatus = approveStatus;
        this.createDate = createDate;
        this.availableFrom = availableFrom;
    }
    
    public int getPropertyId() { return propertyId; }
    public void setPropertyId (int propertyId) { this.propertyId = propertyId; }
    
    public int getLandlordId() { return landlordId; }
    public void setLandlordId (int landlordId) { this.landlordId = landlordId; }
    
    public String getTitle() { return title; }
    public void setTitle (String title) { this.title = title; }
    
    public String getDescription() { return description; }
    public void setDescription (String description) { this.description = description; }
    
    public BigDecimal getPrice() { return price; }
    public void setPrice (BigDecimal price) { this.price = price; }
    
    public String getDistrict() { return district; }
    public void setDistrict (String district) { this.district = district; }
    
    public String getStreet() { return street; }
    public void setStreet (String street) { this.street = street; }
    
    public String getTown() { return town; }
    public void setTown (String town) { this.town = town; }
    
    public double getArea() { return area; }
    public void setArea (double area) { this.area = area; }
    
    public PropertyType getPropertyType() { return propertyType; }
    public void setPropertyType (PropertyType propertyType) { this.propertyType = propertyType; }
    
    public int getBathroomCount() { return bathroomCount; }
    public void setBathroomCount (int bathroomCount) { this.bathroomCount = bathroomCount; }
    
    public int getBedroomCount() { return bedroomCount; }
    public void setBedroomCount (int bedroomCount) { this.bedroomCount = bedroomCount; }
    
    public boolean getApproveStatus() { return approveStatus; }
    public void setApproveStatus (boolean approveStatus) { this.approveStatus = approveStatus; }
    
    public Date getCreateDate() { return createDate; }
    public void setCreateDate (Date createDate) { this.createDate = createDate; }
    
    public Date getAvailableFrom() { return availableFrom; }
    public void setAvailableFrom (Date availableFrom) { this.availableFrom = availableFrom; }
    
}
