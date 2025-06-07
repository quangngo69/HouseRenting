/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


import java.sql.Date;

public class PropertyImages {
    private int imageId;
    private int propertyId;
    private String imageUrl;
    private Date uploadDate;
    
    public PropertyImages () {
        
    }
    
    public PropertyImages (int imageId, int propertyId, String imageUrl, Date uploadDate) {
        this.imageId = imageId;
        this.propertyId = propertyId;
        this.imageUrl = imageUrl;
        this.uploadDate = uploadDate;
    }   
    
    public int getImageId() { return imageId; }
    public void setImageId (int imageId) { this.imageId = imageId; }
    
    public int getPropertyId() { return propertyId; }
    public void setPropertyId (int propertyId) { this.propertyId = propertyId; }
    
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl (String imageUrl) { this.imageUrl = imageUrl; }
    
    public Date getUploadDate() { return uploadDate; }
    public void setUploadDate (Date uploadDate) { this.uploadDate = uploadDate; }
}
