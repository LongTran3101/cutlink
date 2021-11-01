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
   
    public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	private String  dayString;
    
    public String getDayString() {
		return dayString;
	}

	public void setDayString(String dayString) {
		this.dayString = dayString;
	}

	private int sale;
   
    private double money;
    
    private String email;

    public AccountMerch() {
    }

    public AccountMerch(Integer id) {
        this.id = id;
    }

    public AccountMerch(Integer id, String name, String ip, String dayString, int sale, double money, String email) {
        this.id = id;
        this.name = name;
        this.ip = ip;
        this.dayString = dayString;
        this.sale = sale;
        this.money = money;
        this.email = email;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccountMerch)) {
            return false;
        }
        AccountMerch other = (AccountMerch) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication5.AccountMerch[ id=" + id + " ]";
    }
    
}
