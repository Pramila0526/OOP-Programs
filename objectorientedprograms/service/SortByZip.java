package com.bridgelabz.objectorientedprograms.service;

import java.util.Comparator;

public class SortByZip implements Comparator<Person> 
{
public int  compare(Person p1,Person p2)
{
	if(p1.address.getZipCode()==p2.address.getZipCode())
	{
		return 0;
	}
	else
	{
		if(p1.address.getZipCode()>p2.address.getZipCode())
		{
			return 1;
		}
		else
		{
			return -1;
		}
	}
	}

}
