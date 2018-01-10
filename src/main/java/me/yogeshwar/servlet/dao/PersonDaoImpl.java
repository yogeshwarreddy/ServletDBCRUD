package me.yogeshwar.servlet.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import me.yogeshwar.servlet.model.Person;
import me.yogeshwar.servlet.util.SingletonConnectionFactory;
import me.yogeshwar.servlet.util.SingletonMySQLDatabaseConnectionFactory;

public class PersonDaoImpl implements PersonDao {

	@Override
	public Person getPersonById(int id) {
		SingletonConnectionFactory connectionFactory = new SingletonMySQLDatabaseConnectionFactory();
		try (Statement statement = connectionFactory.createStatement()) {
			try (ResultSet resultSet = statement
					.executeQuery("select id,name,phone,dob from persons where id = " + id);) {
				if (resultSet.next()) {
					System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3)
							+ " " + resultSet.getDate(4));
					return new Person(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
							resultSet.getDate(4));
				} else {
					return null;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean savePerson(Person person) {
		SingletonConnectionFactory connectionFactory = new SingletonMySQLDatabaseConnectionFactory();
		try (Statement statement = connectionFactory.createStatement()) {
			String sql = "insert into persons (name,phone,dob) values('" + person.getName() + "','" + person.getPhone()
					+ "','" + person.getDob() + "')";
			System.out.println(sql);
			if (statement.executeUpdate(sql) > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Person deletePersonById(int id) {
		SingletonConnectionFactory connectionFactory = new SingletonMySQLDatabaseConnectionFactory();
		try (Statement statement = connectionFactory.createStatement()) {
			// TODO to be implemented
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Person> getAllPersons() {
		SingletonConnectionFactory connectionFactory = new SingletonMySQLDatabaseConnectionFactory();
		List<Person> persons;
		try (Statement statement = connectionFactory.createStatement()) {
			try (ResultSet resultSet = statement.executeQuery("select id,name,phone,dob from persons");) {
				persons = new ArrayList<>();
				while (resultSet.next()) {
					System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3)
							+ " " + resultSet.getDate(4));
					persons.add(new Person(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
							resultSet.getDate(4)));
				}
				return persons;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}

	@Override
	public Person updatePerson(Person person) {
		SingletonConnectionFactory connectionFactory = new SingletonMySQLDatabaseConnectionFactory();
		try (Statement statement = connectionFactory.createStatement()) {
			// TODO to be implemented
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
