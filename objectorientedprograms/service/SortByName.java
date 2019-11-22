package com.bridgelabz.objectorientedprograms.service;

import java.util.Comparator;

public class SortByName implements Comparator<Person> 

{
public int compare(Person firstPerson,Person secondPerson)
{
	if(firstPerson.getFirstName().equals(secondPerson.getFirstName()))
	{
		return 0;
	}
	else
	{
		if(firstPerson.getFirstName().compareTo(secondPerson.getFirstName())>0)
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