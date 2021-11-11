package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class LeaveDAO {

	@Autowired  
    JdbcTemplate jdbc; 
	
	public List<LeaveHistory> findall() {
		String cmd = "select * from leave_history";
		List<LeaveHistory> ordersList=null;
		ordersList=jdbc.query(cmd,new Object[] {}, new RowMapper<LeaveHistory>() {

			@Override
			public LeaveHistory mapRow(ResultSet rs, int rowNum) throws SQLException {
				LeaveHistory leave = new LeaveHistory();
				leave.setLeaveId(rs.getInt("LEAVE_ID"));
				leave.setLeaveNoOfDays(rs.getInt("LEAVE_NO_OF_DAYS"));
				leave.setLeaveMngrComments(rs.getString("LEAVE_MNGR_COMMENTS"));
				leave.setEmpId(rs.getInt("EMP_ID"));
				leave.setLeaveStartDate(rs.getDate("LEAVE_START_DATE"));
				leave.setLeaveEndDate(rs.getDate("LEAVE_END_DATE"));
				leave.setLeaveType(LeaveType.valueOf(rs.getString("LEAVE_TYPE")));
				leave.setLeaveStatus(LeaveStatus.valueOf(rs.getString("LEAVE_STATUS")));
				leave.setLeaveReason(rs.getString("LEAVE_REASON"));
				return leave;
			}
			
		});
		return ordersList;
	}
	
	public LeaveHistory findid(int ordId) {
		String cmd = "select * from leave_history where emp_id=?";
		List<LeaveHistory> ordersList=null;
		ordersList=jdbc.query(cmd,new Object[] {ordId}, new RowMapper<LeaveHistory>() {

			@Override
			public LeaveHistory mapRow(ResultSet rs, int rowNum) throws SQLException {
				LeaveHistory leave = new LeaveHistory();
				leave.setLeaveId(rs.getInt("LEAVE_ID"));
				leave.setLeaveNoOfDays(rs.getInt("LEAVE_NO_OF_DAYS"));
				leave.setLeaveMngrComments(rs.getString("LEAVE_MNGR_COMMENTS"));
				leave.setEmpId(rs.getInt("EMP_ID"));
				leave.setLeaveStartDate(rs.getDate("LEAVE_START_DATE"));
				leave.setLeaveEndDate(rs.getDate("LEAVE_END_DATE"));
				leave.setLeaveType(LeaveType.valueOf(rs.getString("LEAVE_TYPE")));
				leave.setLeaveStatus(LeaveStatus.valueOf(rs.getString("LEAVE_STATUS")));
				leave.setLeaveReason(rs.getString("LEAVE_REASON"));
				return leave;
			}
			
		});
		return ordersList.get(0);
	}
	public LeaveHistory pending(int id) {
		String cmd = "select * from leave_history where emp_id=? and LEAVE_STATUS='PENDING'";
		List<LeaveHistory> leavelist=null;
		leavelist=jdbc.query(cmd,new Object[] {id}, new RowMapper<LeaveHistory>(){

			@Override
			public LeaveHistory mapRow(ResultSet rs, int rowNum) throws SQLException {
				LeaveHistory leave = new LeaveHistory();
				leave.setLeaveId(rs.getInt("LEAVE_ID"));
				leave.setLeaveNoOfDays(rs.getInt("LEAVE_NO_OF_DAYS"));
				leave.setLeaveMngrComments(rs.getString("LEAVE_MNGR_COMMENTS"));
				leave.setEmpId(rs.getInt("EMP_ID"));
				leave.setLeaveStartDate(rs.getDate("LEAVE_START_DATE"));
				leave.setLeaveEndDate(rs.getDate("LEAVE_END_DATE"));
				leave.setLeaveType(LeaveType.valueOf(rs.getString("LEAVE_TYPE")));
				leave.setLeaveStatus(LeaveStatus.valueOf(rs.getString("LEAVE_STATUS")));
				leave.setLeaveReason(rs.getString("LEAVE_REASON"));
				return leave;
			}
			
		});
		return leavelist.get(0);
	}
}
