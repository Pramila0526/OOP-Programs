package com.bridgelabz.objectorientedprograms.service;

import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.bridgelabz.objectorientedprograms.service.Address;
import com.bridgelabz.objectorientedprograms.service.Person;

import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.type.TypeReference;

interface AddressBook1 {
	Person addUser();

	void save(String file);

	void deleteUser();

	void sortByName();

	void sortByZip();

	void printAll();

	void saveAs();

	void close(String a);

	void read(String a);

	void editAddressAndPhone(Person p, int i);

	List<Person> add();
}

public class AddressBook implements AddressBook1 {
	static Scanner sc = new Scanner(System.in);

	public static int integerInput() {
		return sc.nextInt();
	}

	public static double doubleInput() {
		return sc.nextDouble();
	}

	public static String stringInput() {
		return sc.nextLine();
	}

	Person p = new Person();
	Address a = new Address();

	/***** Adding the New User *****/

	public static List<Person> list = new ArrayList<Person>();
	ObjectMapper om = new ObjectMapper();

	public List<Person> add() {
		list.add(addUser());
		for (Person p : list) {
			System.out.println(p.toString());
		}
		return list;
	}
	// static int count=0;

	public Person addUser() {
		System.out.println("Enter Your Details");

		System.out.println("Enter First Name");
		p.setFirstName(stringInput());
		System.out.println(p.getFirstName());

		System.out.println("Enter Last Name");
		p.setLastName(stringInput());
		System.out.println(p.getLastName());

		System.out.println("Enter the City");
		a.setCity(stringInput());
		System.out.println(a.getCity());

		System.out.println("Enter the State");
		a.setState(stringInput());
		System.out.println(a.getState());

		System.out.println("Enter the zipcode");
		a.setZipCode(integerInput());
		System.out.println(a.getZipCode());

		System.out.println("Enter the Phone Number");
		p.setPhoneNumber(integerInput());
		System.out.println(p.getPhoneNumber());

		System.out.println("Enter the Address");
		Address address = null;
		p.setAddress(address);
		return p;

	}

	public void sortByName() {

		Collections.sort(list, new SortByName());
		for (Person p : list) {
			System.out.println(p.toString());
		}

	}

	public void sortByZip() {
		Collections.sort(list, new SortByZip());
		for (Person p : list) {
			System.out.println(p.toString());
		}
	}

	public void printAll() {
		for (Person p : list) {
			System.out.println(p.toString());
		}
	}

	public void deleteUser() {
		System.out.println("Enter First Name whose data is to be Removed");
		String firstname = stringInput();
		int count = 0;
		List<Person> toRemove = new ArrayList<>();
		for (Person p : list) {
			if (firstname.contentEquals(p.getFirstName())) {
				System.out.println("Data Found");
				toRemove.add(p);
				count++;
			}
		}
		list.removeAll(toRemove);
		if (count == 0)
			System.out.println("No such Data in the Record");
	}

	public void saveAs() {
		System.out.println("Enter the name of the new File");
		String fileName = stringInput();
		save(fileName);
		System.out.println("Data Saved in File" + fileName);
	}

	public void save(String file) {
		try {
			om.writeValue(new File("Address Book" + file + ".json"), list);
			System.out.println("Save");
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void editAddressAndPhone(Person p, int i)

	{
		switch (i) {
		case 1:
			System.out.println("Enter the State");
			p.address.setState(stringInput());
			System.out.println("Enter the City");
			p.address.setCity(stringInput());
			System.out.println("Enter the ZipCode");
			p.address.setZipCode(integerInput());
			System.out.println("New Address Updated");
			break;
		case 2:
			System.out.println("Enter new Phone Number");
			int phoneNumber = integerInput();
			p.setPhoneNumber(phoneNumber);
			System.out.println("NPhone Number Updated");
			break;
		}
	}

	public void read(String existingAddressBook) {
		ObjectMapper om = new ObjectMapper();
		try {
			BufferedReader br = new BufferedReader(new FileReader("Address Book" + existingAddressBook + ".json"));
			String arrayToJson;
			if ((arrayToJson = br.readLine()) != null) {
				TypeReference<ArrayList<Person>> type = new TypeReference<ArrayList<Person>>() {
				};
				list = om.readValue(arrayToJson, type);
				br.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void close(String existingAddressBook) {
		list.clear();
	}
}
