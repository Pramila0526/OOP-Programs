package com.bridgelabz.objectorientedprograms.service;

public class Person 
{
	public String firstname;
	public String lastname;
	public Address address;
	public int phonenumber;
	
	public String getFirstName()
	{
		return firstname;
	}
	public void setFirstName(String fname)
	{
		this.firstname=fname;
	}
	public String getLastName()
	{
		return lastname;
	}
	public void setLastName(String lname)
	{
		this.lastname=lname;
	}
	
	public int getPhoneNumber()
	{
		return phonenumber;
	}
	public void setPhoneNumber(int phonenumber)
	{
		this.phonenumber=phonenumber;
	}
	public Address getAddress()
	{
		return address;
	}
	public void setAddress(Address address)
	{
		this.address=address;
	}
	public String toString()
	{
		return "Person's [First Name=" +firstname+ ", Last Name=" +lastname+
				          ", Address=" +address+ ", Phone Number=" +phonenumber+"]";
	}

}
