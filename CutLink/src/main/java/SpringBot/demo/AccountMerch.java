/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SpringBot.demo;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DreamStore
 */

public class AccountMerch  {
    
    private Integer id;
    
    private String name;
   
    private String ip;
    private String path;
    private String username;
    
   
   
	private String  dayString;
    
   
	private int sale;
   
    private double money;
    
    private String email;
    private Date day;

   

    

   
    
    public AccountMerch(Integer id, String name, String ip, String path, String username, String dayString, int sale,
			double money, String email, Date day) {
		super();
		this.id = id;
		this.name = name;
		this.ip = ip;
		this.path = path;
		this.username = username;
		this.dayString = dayString;
		this.sale = sale;
		this.money = money;
		this.email = email;
		this.day = day;
	}







	public AccountMerch() {
		super();
		// TODO Auto-generated constructor stub
	}







	public Integer getId() {
		return id;
	}







	public void setId(Integer id) {
		this.id = id;
	}







	public String getName() {
		return name;
	}







	public void setName(String name) {
		this.name = name;
	}







	public String getIp() {
		return ip;
	}







	public void setIp(String ip) {
		this.ip = ip;
	}







	public String getPath() {
		return path;
	}







	public void setPath(String path) {
		this.path = path;
	}







	public String getUsername() {
		return username;
	}







	public void setUsername(String username) {
		this.username = username;
	}







	public String getDayString() {
		return dayString;
	}







	public void setDayString(String dayString) {
		this.dayString = dayString;
	}







	public int getSale() {
		return sale;
	}







	public void setSale(int sale) {
		this.sale = sale;
	}







	public double getMoney() {
		return money;
	}







	public void setMoney(double money) {
		this.money = money;
	}







	public String getEmail() {
		return email;
	}







	public void setEmail(String email) {
		this.email = email;
	}







	public Date getDay() {
		return day;
	}







	public void setDay(Date day) {
		this.day = day;
	}







	@Override
    public String toString() {
        return "javaapplication5.AccountMerch[ id=" + id + " ]";
    }
    
}
