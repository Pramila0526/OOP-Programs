package com.bridgelabz.objectorientedprograms.service;

public class Address 
{
	public String city;
	public String state;
	public int zipcode;
	
	
	public String getCity()
	{
		return city;
	}
	public void setCity(String city)
	{
		this.city=city;
	}
	public String getState()
	{
		return state;
	}
	public void setState(String state)
	{
		this.state=state;
	}
	public int getZipCode()
	{
		return zipcode;
	}
	public void setZipCode(int zipcode)
	{
		this.zipcode=zipcode;
	}
	public String toString()
	{
		return "Person's [City=" +city+ ", State=" +state+ ", Zip Code=" +zipcode+"]";
	}
}
