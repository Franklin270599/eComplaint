package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.model.Complaint;
import com.model.User;

public class eComplaintDao {

	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

//	Fetch customer details from Signup.jsp and insert into database
	public int saveCustomer(User user) {
		String query;
		try {
			query = "insert into user (name,username,password,email,contact) values('" + user.getName() + "','"
					+ user.getUsername() + "','" + user.getPassword() + "','" + user.getEmail() + "','"
					+ user.getContact() + "')";
			return jdbcTemplate.update(query);

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

	}
//Validate the username and password whether it is a valid user
	public List<User> authenticateUser(User user) {
		String check;
		check = "select username,password,name from user where username='" + user.getUsername() + "' and password='"
				+ user.getPassword() + "'";
		return jdbcTemplate.query(check, new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int rownumber) throws SQLException {
				User userobj = new User();
				userobj.setUsername(rs.getString(1));
				userobj.setPassword(rs.getString(2));
				userobj.setName(rs.getString(3));
				//System.out.println(userobj);
				return userobj;
			}
		});
	}
//Complaints get saved into the database which can be viewed by Admin and User
	public int saveComplaint(Complaint comp) {
		String query;
		try {
			query = "insert into complaint(name,acctno,compType,description)values('" + comp.getName() + "','" + comp.getAcctno() + "','"
					+ comp.getCompType() + "','" + comp.getDescription() + "')";
			return jdbcTemplate.update(query);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

	}
//Admin can view the customer raised complaints with the customer name
	public List<Complaint> showComplaintList(Complaint comp) {
		String sql = "select * from complaint";
		return jdbcTemplate.query(sql, new RowMapper<Complaint>() {
			@Override
			public Complaint mapRow(ResultSet rs, int rownumber) throws SQLException {
				Complaint compobj = new Complaint();
				compobj.setcId(rs.getInt("cId"));
				compobj.setCompType(rs.getString("compType"));
				compobj.setName(rs.getString("name"));
				compobj.setAcctno(rs.getLong("acctno"));
				compobj.setDescription(rs.getString("description"));
				return compobj;
			}
		});
	}

//Update Complaint Status 
	public int updateComplaint(Complaint comp) {
		String up;
		try {
			up = "update complaint set status='" + comp.getStatus() + "', priority ='" + comp.getPriority()
					+ "' where cId='" + comp.getcId() + "'";
			return jdbcTemplate.update(up);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
//Send Mail to the customer mail-id
	public List<User> sendMail(int id) {
		String mail="select user.name,user.email,complaint.compType,complaint.acctno from user join complaint on complaint.name=user.name where complaint.cId='"+id+"'";
		return jdbcTemplate.query(mail, new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int rownumber) throws SQLException {
				User userobj= new User();
				userobj.setName(rs.getString("name"));
				userobj.setEmail(rs.getString("email"));
				Complaint compobj=new Complaint();
				compobj.setCompType(rs.getString("compType"));
				compobj.setAcctno(rs.getLong("acctno"));
				userobj.setComplaint(compobj);
				return userobj;
			}
		});
	}

//Customer can view their raised complaints
	public List<Complaint> viewCustComplaint(Complaint comp) {
		String view="select * from complaint where name='"+comp.getName()+"'";
		return jdbcTemplate.query(view,new RowMapper<Complaint>() {
		@Override
		public Complaint mapRow(ResultSet rs, int rownumber)throws SQLException {
		Complaint compobj=new Complaint();
		compobj.setcId(rs.getInt("cId"));
		compobj.setName(rs.getString("name"));
		compobj.setAcctno(rs.getLong("acctno"));
		compobj.setCompType(rs.getString("compType"));
		compobj.setDescription(rs.getString("description"));
		compobj.setStatus(rs.getString("status"));
		compobj.setPriority(rs.getString("priority"));
		return compobj;
	}
	});
}
}
