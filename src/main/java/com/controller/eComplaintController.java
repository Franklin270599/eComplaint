package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.model.Complaint;
import com.model.User;
import com.service.EmailService;
import com.service.eComplaintService;

@Controller
public class eComplaintController {
	
	@Autowired
	private EmailService emailService;

	@Autowired
	private eComplaintService ecomplaintService;

//	Load value for dropdown in Complaint Type 
	@ModelAttribute("compType") //It can be accessed by the AddComplaint.jsp page to the select option by path name and items
	public List<String> complaintType() {
		List<String> type = new ArrayList<String>();
		type.add("Credit Card");
		type.add("Debit Card");
		type.add("Loan");
		type.add("Net Banking");
		type.add("Cheque Issue");
		type.add("Withdrawal Issue");
		type.add("Others");
		return type;
	}
//Home Page
	@RequestMapping(value = "/EasyBank Home", method = RequestMethod.GET)
	public String showHomePage() {
		return "EasyBank Home";
	}

//User Registration Page
	@RequestMapping(value = "/Signup", method = RequestMethod.GET)
	public String showRegPage(@ModelAttribute("user") User user, Model model) {
		return "Signup";
	}
//Add customer details to database
	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
	public String addCustomerToDb(@ModelAttribute("user") User user, Model model) {
	ecomplaintService.saveUser(user);
	model.addAttribute("Regsuc", "You have been registered successfully");
		return "redirect:UserLogin";
	}
//User Login
	@RequestMapping(value = "/UserLogin", method = RequestMethod.GET)
	public String showUserLogin(@ModelAttribute("user") User user, Model model) {
		return "UserLogin";
	}
//Validate the username and Password
	@RequestMapping(value = "/Authenticate", method = RequestMethod.POST)
	public String showAuthenticate(@ModelAttribute("user") User user, Model model, HttpSession session) {

	int validate = ecomplaintService.validateUser(user, session);
	if (validate == 1) {
		return "redirect:UserHome";
	} else {
	model.addAttribute("Invalid", "Invalid Login");
		return "UserLogin";
	}
}
//User Home Page
	@RequestMapping(value = "/UserHome", method = RequestMethod.GET)
	public String showCustomerHome(@ModelAttribute("user") User user, Model model) {
		return "UserHome";
	}
//Add Complaint Page
	@RequestMapping(value = "/AddComplaint", method = RequestMethod.POST)
	public String showAddComplaint(@ModelAttribute("complaint") Complaint comp, @ModelAttribute("user") User user, Model model) {
		return "AddComplaint";
	}
//Add the complaint by user
	@RequestMapping(value = "/regComplaint", method = RequestMethod.POST)
	public String showRegComplaint(@ModelAttribute("complaint") Complaint comp, @ModelAttribute("user") User user, Model model, HttpSession session) {
	ecomplaintService.addComplaint(comp, session);
	model.addAttribute("CS", "Complaint added successfully");
		return "ComplaintReg";
	}
//Customer can view their registered complaints	
	@RequestMapping(value = "/ViewCustComp", method = RequestMethod.POST)
	public String showCustComplaint(@ModelAttribute("complaint") Complaint comp, @ModelAttribute("user") User user, Model model,HttpSession session) {
	List<Complaint> vl=ecomplaintService.viewCustComplaintList(comp,session);
	model.addAttribute("viewcomp", vl);
		return "ViewCustComp";
	}
//Admin Login
	@RequestMapping(value = "/AdminLogin", method = RequestMethod.GET)
	public String showAdminLogin(@ModelAttribute("admin") User user, Model model) {
		return "AdminLogin";
	}		
//Display the complaint list to admin
	@RequestMapping(value = "/ComplaintList", method = RequestMethod.POST)
	public String showComplaintList(@ModelAttribute("complaint") Complaint comp, @ModelAttribute("user") User user,
			Model model) {
		List<Complaint> bank=ecomplaintService.viewComplaintList(comp);
		model.addAttribute("bank", bank);
		return "ComplaintList";
	}
//Complaint status update by Admin
	@RequestMapping(value = "/ComplaintUpdate", method = RequestMethod.POST)
	public String showComplaintUpdate(@ModelAttribute("complaint") Complaint comp, User user, Model model, Integer id,
			HttpSession session) {
		System.out.println(id);
		comp.setcId(id);
		ecomplaintService.modifyComplaint(comp);
		
//When the admin updates about the complaint mail will be sent to the user's mail id	
		//Sending Email
		List<User> ur=ecomplaintService.generateEmail(id);
		String str = "";
		String name = "";
		String ctype = "";
		String acctno ="";
		for (User u : ur) 
		{
			str = u.getEmail();
			name = u.getName();
			ctype = u.getComplaint().getCompType();
			acctno=u.getComplaint().getAcctno().toString(); //Account Number is converted to String datatype
		}
		System.out.println(str);
		System.out.println(name);
		System.out.println(ctype);
		emailService.sendMail(str, "Complaint Status", "Dear " + name + ", \nComplaint ID: " + id +"\nAccount Number:" +acctno
				+ "\nYour Complaint on " + ctype + " has been resolved.\nPlease check the site for confirmation.");
		emailService.sendMail("officialatfranklin@gmail.com", "Complaint Update",
				"Complaint ID: " + id + " has been resolved");
		model.addAttribute("CS", "Complaint Update Success");
		return "ComplaintReg";
	}
//Logout page	
 @RequestMapping(value="/Logout",method=RequestMethod.GET)
 public String showLogout(@ModelAttribute("complaint")Complaint comp,Model model) {
		model.addAttribute("CS", "You have been logged out");
	return "Logout";
}
}