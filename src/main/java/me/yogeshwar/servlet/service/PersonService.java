package me.yogeshwar.servlet.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.yogeshwar.servlet.dao.PersonDao;
import me.yogeshwar.servlet.dao.PersonDaoImpl;
import me.yogeshwar.servlet.model.Person;

public class PersonService extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PersonDao personDao = new PersonDaoImpl();
		List<Person> persons = personDao.getAllPersons();
		PrintWriter writer = resp.getWriter();
		writer.println("Id\t Name\t Phone\t Dob");
		for (Person person : persons) {
			writer.println(
					person.getId() + "\t " + person.getName() + "\t " + person.getPhone() + "\t " + person.getDob());
		}
		writer.flush();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = (String) req.getParameter("name");
		String phone = req.getParameter("phone");
		String dateString = req.getParameter("dob");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Date date = Date.valueOf(LocalDate.parse(dateString, formatter));

		Person person = new Person();
		person.setName(name);
		person.setPhone(phone);
		person.setDob(date);
		PersonDao personDao = new PersonDaoImpl();
		if (personDao.savePerson(person)) {
			resp.setStatus(HttpServletResponse.SC_ACCEPTED);
			resp.flushBuffer();
		} else {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
		}
	}
}
