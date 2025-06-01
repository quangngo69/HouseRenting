/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

public class Renting {
    
    public enum RentingStatus {
        PENDING,
        APPROVED,
        CANCELLED;

        public static RentingStatus fromString(String dbValue) {
            if (dbValue == null) {
                return null; // or return a default, e.g., TENANT;
            }
            return RentingStatus.valueOf(dbValue.toUpperCase());
        }
    }
    
    private int rentId;
    private int propertyId;
    private int tenantId;
    private RentingStatus status;
    private Date bookDate;
    private Date startDate;
    private Date endDate;
    
    //Constructor
    public Renting(){
        
    }
    
    public Renting(int rentId, int propertyId, int tenantId, RentingStatus status, Date bookDate, Date startDate, Date endDate){
        this.rentId = rentId;
        this.propertyId = propertyId;
        this.tenantId = tenantId;
        this.bookDate = bookDate;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    
    //Getters and Setters
    public int getRentId(){
        return rentId;
    }
    
    public void setRentId(int rentId){
        this.rentId = rentId;
    }
    
   public int getPropertyId(){
        return propertyId;
    }
    
    public void setPropertyId(int propertyId){
        this.propertyId = propertyId;
    }
    
    public int getTenantId(){
        return tenantId;
    }
    
    public void setTenantId(int tenantId){
        this.tenantId = tenantId;
    }
    
    public Date getBookDate(){
        return bookDate;
    }
    
    public void setBookDate(Date bookDate){
        this.bookDate = bookDate;
    }
    
    public Date getStartDate(){
        return startDate;
    }
    
    public void setStartDate(Date startDate){
        this.startDate = startDate;
    }
    
    public Date getEndDate(){
        return endDate;
    }
    
    public void setEndDate(Date endDate){
        this.endDate = endDate;
    }
    
    public RentingStatus getStatus(){
        return status;
    }
    
    public void setStatus(RentingStatus status){
        this.status = status;
    }
}
