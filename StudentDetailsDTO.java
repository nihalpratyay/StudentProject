package com.nihal.hb.student;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Studentdetails")
public class StudentDetailsDTO {
	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator="auto")
	private int stid;
	private String stName;
	private String ststream;
	private int stpercent;
	private BigInteger stphone;
	private int stage;
	private String staddress;
	public int getStid() {
		return stid;
	}
	public void setStid(int stid) {
		this.stid = stid;
	}
	public String getStName() {
		return stName;
	}
	public void setStName(String stName) {
		this.stName = stName;
	}
	public String getStstream() {
		return ststream;
	}
	public void setStstream(String ststream) {
		this.ststream = ststream;
	}
	public int getStpercent() {
		return stpercent;
	}
	public void setStpercent(int stpercent) {
		this.stpercent = stpercent;
	}
	public BigInteger getStphone() {
		return stphone;
	}
	public void setStphone(BigInteger stphone) {
		this.stphone = stphone;
	}
	public int getStage() {
		return stage;
	}
	public void setStage(int stage) {
		this.stage = stage;
	}
	public String getStaddress() {
		return staddress;
	}
	public void setStaddress(String staddress) {
		this.staddress = staddress;
	}
	

}
