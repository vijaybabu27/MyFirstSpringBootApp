package com.example.vijaybabu27.springboot.demo.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.Size;

public class Todo {
	
	private int id;
	private String user;
	
	@Size(min=10, message="Enter atleast 10 chars...")
	private String desc;
	private Date targetDate;
	private boolean status;
	
	public Todo() {
		super();
	}
	
	public Todo(int id, String user, String desc, Date targetDate, boolean isDone) {
		super();
		this.id = id;
		this.user = user;
		this.desc = desc;
		this.targetDate = targetDate;
		this.status = isDone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getFormatedTargetDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YYYY");
		return sdf.format((this.targetDate == null)? new Date() : this.targetDate);
	}
	
	public Date getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean isDone) {
		this.status = isDone;
	}
	
	@Override
	public String toString() {
		return String.format("Todo [id=%s, User=%s, Desc=%s, TargetDate=%s, Completed=%s", this.id, this.user, this.desc, this.getFormatedTargetDate(), this.status);
	}
	
	@Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Todo other = (Todo) obj;
        if (id != other.id) {
            return false;
        }
        return true;
    }

}
