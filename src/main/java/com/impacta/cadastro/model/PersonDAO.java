package com.impacta.cadastro.model; 

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Email; 
import javax.validation.constraints.NotEmpty;
 

@Entity(name = "person")
@Table(name = "person")
public class PersonDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column( nullable = false)
	@NotEmpty(message = "password.not.blank")
    private String password;
	
    @Column(unique=true, nullable = false) 
    @Email(message = "email.not.valid")
    @NotEmpty(message = "email.not.blank")
    private String  email;
    
    @Column() 
    private char active;
    
    @Column()  
    private Date createdDate;
    
    @Column(unique=true, nullable = false) 
    private String document;

    @Column() 
    private String name;
    
    @Column() 
    private Date birthday;
    
    @Column() 
    private String motherName;
    
    @Column() 
    private String fatherName;
    
    @Column() 
    private int maritalStatus;
    
    @Column() 
    private String pinCard;
    
    
  

	@Column() 
    private String maritalStatusDescription;
    
    @Column() 
    private String profession;
    
    @Column() 
    private String gender;
    
    @Column() 
    private String cityOrigin;
    
    @Column() 
    private String country;
    
    @Column() 
    private int statusID;
    

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public int getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(int maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getMaritalStatusDescription() {
		return maritalStatusDescription;
	}

	public void setMaritalStatusDescription(String maritalDescription) {
		this.maritalStatusDescription = maritalDescription;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCityOrigin() {
		return cityOrigin;
	}

	public void setCityOrigin(String cityOrigin) {
		this.cityOrigin = cityOrigin;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getStatusID() {
		return statusID;
	}

	public void setStatusID(int statusID) {
		this.statusID = statusID;
	}

	public char getActive() {
		return active;
	}

	
    
    
    public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public char isActive() {
		return active;
	}

	public void setActive(char active) {
		this.active = active;
	}

	public String getEmail() {
		return email;
	}

	 
	public void setEmail(String email) {
		this.email = email;
	}

 
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
 

    public String getPinCard() {
  		return pinCard;
  	}

  	public void setPinCard(String pinCard) {
  		this.pinCard = pinCard;
  	}


}

