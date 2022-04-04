package com.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.dao.eComplaintDao;
import com.model.Complaint;
import com.model.User;

@Service
public class eComplaintService {
	
	private ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	eComplaintDao dao = (eComplaintDao) ctx.getBean("compdao");
	
//Redirects to DAO to save the user details into the database
	public void saveUser(User user) {
		int status = dao.saveCustomer(user); 
		System.out.println("Status-Customer:" + status);

	}
//Validate whether the registered username and password is being used to login by the user
	public int validateUser(User user, HttpSession session) {
		List<User> credential = dao.authenticateUser(user);
		for (User ur : credential) {
			//System.out.println(user.getPassword() + " " + ur.getPassword());
			if (user.getPassword().equals(ur.getPassword())) {
				session.setAttribute("uname", ur.getName());
				System.out.println(ur.getName());
			}
			return 1;
		}
		return 0;
	}
//Add the complaint (By the user)
	public void addComplaint(Complaint comp, HttpSession session) {
		comp.setName((String) session.getAttribute("uname")); //Name is carried to the complaint page
		int status = dao.saveComplaint(comp);
		System.out.println("Status-Complaint:" + status);
	}
//View the ComplaintList by the admin
	public List<Complaint> viewComplaintList(Complaint comp) {
		List<Complaint> cl = dao.showComplaintList(comp);
		List<Complaint> bank = new ArrayList<Complaint>();
		for (Complaint x : cl) {
			bank.add(x);
		}
		return bank;
	}
//Update the complaint status by the admin	
	public void modifyComplaint(Complaint comp) {
		int status = dao.updateComplaint(comp);
		System.out.println("Status-ComplaintUpdate:" + status);

	}
//Send mail to the user with the complaint ID
	public List<User> generateEmail(Integer id) {
		List<User> ur = dao.sendMail(id);
		return ur;
	}
//Customers can view their registered complaints
	public List<Complaint> viewCustComplaintList(Complaint comp, HttpSession session) {
		String un=(String)session.getAttribute("uname");
		comp.setName(un);
		List<Complaint> vc=dao.viewCustComplaint(comp);
		List<Complaint> vcl = new ArrayList<Complaint>();
		for (Complaint x : vc) {
			vcl.add(x);
		}
		return vcl;
	}	
}
