package com.example.demo;

import java.util.List;
import java.sql.SQLException;
import javax.transaction.Transactional;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class LeaveService {

	@Autowired
    private LeaveRepository repo;
	
	@Autowired  
    JdbcTemplate jdbc; 
	
	@Autowired
	private LeaveDAO dao;
	
	public LeaveHistory pending(int id) {
		return dao.pending(id);
	}
	
	public LeaveHistory search(int menuId) {
		return dao.findid(menuId);
	}
	public List<LeaveHistory> showLeave() {
		return dao.findall();
	}
	public String applyleave(LeaveHistory leaveDetails) throws ClassNotFoundException, SQLException {
		
		
		/*
		 * 1. LeaveStartDate cannot be greater than leave End Date
		 * 2. Balance must be available
		 */
		 long ms = leaveDetails.getLeaveEndDate().getTime() - leaveDetails.getLeaveStartDate().getTime();
		    long m = ms / (1000 * 24 * 60 * 60);
		    int days = (int) m;
		    days = days + 1;
		    leaveDetails.setLeaveType(LeaveType.EL);
		    leaveDetails.setLeaveStatus(LeaveStatus.PENDING);
		    System.out.println("Difference is " + days);
		    Employee employee = new EmployService().search(leaveDetails.getEmpId());
		    int leaveBalance = employee.getEmpAvailLeaveBal();
		   // System.out.println("Balance is  " +employee.getLeaveAvail());
		    if (days < 0) {
		    	return "Leave-Start Date Cannot be Greater than leave-End Date...";
		    } else if (leaveBalance-days < 0) {
		    	return "Insufficient Leave Balance...";
		    } else {
		    	int diff = leaveBalance-days;
		    	leaveDetails.setLeaveNoOfDays(days);
		    	
		    	String cmd = "Insert into LEAVE_HISTORY(Emp_ID,Leave_Start_Date, "
		    			+ "Leave_End_Date,Leave_Type,Leave_Status,Leave_Reason,LEAVE_NO_OF_DAYS) "
		    			+ "VALUES(?,?,?,?,?,?,?)";
		    	jdbc.update(cmd, new Object[] {leaveDetails.getEmpId()
		    			,leaveDetails.getLeaveStartDate(),leaveDetails.getLeaveEndDate(),
		    			leaveDetails.getLeaveType().toString(),leaveDetails.getLeaveStatus().toString(),
		    			leaveDetails.getLeaveReason(),leaveDetails.getLeaveNoOfDays()});

		    	cmd = "Update Employee set EMP_AVAIL_LEAVE_BAL=? WHERE EMP_ID=?";
		    	jdbc.update(cmd, new Object[] {diff,leaveDetails.getEmpId()});
		    	return "Leave Applied Successfully...";
		    }
		//    return "NULL";
	}
}
