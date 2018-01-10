package me.yogeshwar.servlet.model;

import java.util.Date;

public class Person {
	int id;
	String name;
	String phone;
	Date dob;

	public Person() {
		super();
	}

	public Person(String name, String phone, Date dob) {
		super();
		this.name = name;
		this.phone = phone;
		this.dob = dob;
	}

	public Person(int id, String name, String phone, Date dob) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.dob = dob;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone
	 *            the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the dob
	 */
	public Date getDob() {
		return dob;
	}

	/**
	 * @param dob
	 *            the dob to set
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}

}
