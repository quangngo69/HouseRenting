/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

public class Renting {
    
    private int rentId;
    private int propertyId;
    private int tenantId;
    private String status;
    private Date bookDate;
    private Date startDate;
    private Date endDate;
    
    //Constructor
    public Renting(int rentId, int propertyId, int tenantId, String status, Date bookDate, Date startDate, Date endDate){
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
    
    public String getStatus(){
        return status;
    }
    
    public void setStatus(String status){
        this.status = status;
    }
}
