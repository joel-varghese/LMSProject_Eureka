package com.example.demo;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="leave_history")
public class LeaveHistory {
	
	@Id
	private int leaveId;
	private int leaveNoOfDays;
	private String leaveMngrComments;
	private int empId;
	private Date leaveStartDate;
	private Date leaveEndDate;
	private LeaveStatus leaveStatus;
	private LeaveType leaveType;
	private String leaveReason;
	public int getLeaveId() {
		return leaveId;
	}
	public void setLeaveId(int leaveId) {
		this.leaveId = leaveId;
	}
	public int getLeaveNoOfDays() {
		return leaveNoOfDays;
	}
	public void setLeaveNoOfDays(int leaveNoOfDays) {
		this.leaveNoOfDays = leaveNoOfDays;
	}
	public String getLeaveMngrComments() {
		return leaveMngrComments;
	}
	public void setLeaveMngrComments(String leaveMngrComments) {
		this.leaveMngrComments = leaveMngrComments;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public Date getLeaveStartDate() {
		return leaveStartDate;
	}
	public void setLeaveStartDate(Date leaveStartDate) {
		this.leaveStartDate = leaveStartDate;
	}
	public Date getLeaveEndDate() {
		return leaveEndDate;
	}
	public void setLeaveEndDate(Date leaveEndDate) {
		this.leaveEndDate = leaveEndDate;
	}
	public LeaveStatus getLeaveStatus() {
		return leaveStatus;
	}
	public void setLeaveStatus(LeaveStatus leaveStatus) {
		this.leaveStatus = leaveStatus;
	}
	public LeaveType getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(LeaveType leaveType) {
		this.leaveType = leaveType;
	}
	public String getLeaveReason() {
		return leaveReason;
	}
	public void setLeaveReason(String leaveReason) {
		this.leaveReason = leaveReason;
	}
	@Override
	public String toString() {
		return "LeaveHistory [leaveId=" + leaveId + ", leaveNoOfDays=" + leaveNoOfDays + ", leaveMngrComments="
				+ leaveMngrComments + ", empId=" + empId + ", leaveStartDate=" + leaveStartDate + ", leaveEndDate="
				+ leaveEndDate + ", leaveStatus=" + leaveStatus + ", leaveType=" + leaveType + ", leaveReason="
				+ leaveReason + "]";
	}
	
}
