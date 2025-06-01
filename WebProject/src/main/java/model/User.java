/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;


public class User {
    public enum UserType {
        ADMIN,
        LANDLORD,
        TENANT;
        public static UserType fromString(String dbValue) {
            if (dbValue == null) {
                return null; // or return a default, e.g., TENANT;
            }
            return UserType.valueOf(dbValue.toUpperCase());
        }
        
    }
    
    private int userId;
    private String fullname;
    private String username;
    private String email;
    private String phone;
    private String password;
    private Date joinDate;
    private UserType userType;
    
    public User() {
        userId = 0;
        fullname = "";
        username = "";
        email = "";
        phone = "";
        password = "";
        joinDate = null;
        userType = null;
    }
    
    public User(int userId, String fullname, String username, String email, String phone, String password, Date joinDate, UserType userType) {
        this.userId = userId;
        this.fullname = fullname;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.joinDate = joinDate;
        this.userType = userType;
    }
    
    public int getUserId() { return userId; }
    public void setUserId (int userId) { this.userId = userId; }
    
    public String getFullname() { return fullname; }
    public void setFullname (String fullname) { this.fullname = fullname; }
    
    public String getUsername() { return username; }
    public void setUsername (String username) { this.username = username; }
    
    public String getEmail() { return email; }
    public void setEmail (String email) { this.email = email; }
    
    public String getPhone() { return phone; }
    public void setPhone (String phone) { this.phone = phone; }
    
    public String getPassword() { return password; }
    public void setPassword (String password) { this.password = password; }
    
    public Date getJoinDate() { return joinDate; }
    public void setJoinDate (Date joinDate) { this.joinDate = joinDate; }
    
    public UserType getUserType() { return userType; }
    public void setUserType (UserType userType) { this.userType = userType; }
}