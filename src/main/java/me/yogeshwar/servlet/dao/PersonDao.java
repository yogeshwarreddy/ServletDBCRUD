package me.yogeshwar.servlet.dao;

import java.util.List;

import me.yogeshwar.servlet.model.Person;

public interface PersonDao {

	public Person getPersonById(int id);

	public List<Person> getAllPersons();

	public boolean savePerson(Person person);

	public Person updatePerson(Person person);

	public Person deletePersonById(int id);

}
