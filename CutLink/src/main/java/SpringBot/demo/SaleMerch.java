/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SpringBot.demo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DreamStore
 */

public class SaleMerch  {
    
    private Integer id;
    private String name;
    private String ip;
    private Date day;
    private int sale;
    private double money;
    private String email;
    private String path;
    private String username;
    private String tier;
    private int coutDesgin;
    private double last7dayMoney;
    private int last7daySale ;
    private double thismonthMoney;
    private int thismonthSale;
    private double previousmonthMoney;
    private int previousmonthSale ;
    private double alltimeMoney;
    private int alltimeSale;
    private List<ImageMerch> LstimageMerch;

   

    
    public List<ImageMerch> getLstimageMerch() {
		return LstimageMerch;
	}

	public void setLstimageMerch(List<ImageMerch> imageMerch) {
		this.LstimageMerch = imageMerch;
	}

	public String getTier() {
		return tier;
	}

	public void setTier(String tier) {
		this.tier = tier;
	}

	public int getCoutDesgin() {
		return coutDesgin;
	}

	public void setCoutDesgin(int coutDesgin) {
		this.coutDesgin = coutDesgin;
	}

	public double getLast7dayMoney() {
		return last7dayMoney;
	}

	public void setLast7dayMoney(double last7dayMoney) {
		this.last7dayMoney = last7dayMoney;
	}

	public int getLast7daySale() {
		return last7daySale;
	}

	public void setLast7daySale(int last7daySale) {
		this.last7daySale = last7daySale;
	}

	public double getThismonthMoney() {
		return thismonthMoney;
	}

	public void setThismonthMoney(double thismonthMoney) {
		this.thismonthMoney = thismonthMoney;
	}

	public int getThismonthSale() {
		return thismonthSale;
	}

	public void setThismonthSale(int thismonthSale) {
		this.thismonthSale = thismonthSale;
	}

	public double getPreviousmonthMoney() {
		return previousmonthMoney;
	}

	public void setPreviousmonthMoney(double previousmonthMoney) {
		this.previousmonthMoney = previousmonthMoney;
	}

	public int getPreviousmonthSale() {
		return previousmonthSale;
	}

	public void setPreviousmonthSale(int previousmonthSale) {
		this.previousmonthSale = previousmonthSale;
	}

	public double getAlltimeMoney() {
		return alltimeMoney;
	}

	public void setAlltimeMoney(double alltimeMoney) {
		this.alltimeMoney = alltimeMoney;
	}

	public int getAlltimeSale() {
		return alltimeSale;
	}

	public void setAlltimeSale(int alltimeSale) {
		this.alltimeSale = alltimeSale;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	private int yesterday;
    private double moneyyesterday;

    public int getYesterday() {
		return yesterday;
	}

	public void setYesterday(int yesterday) {
		this.yesterday = yesterday;
	}

	public double getMoneyyesterday() {
		return moneyyesterday;
	}

	public void setMoneyyesterday(double moneyyesterday) {
		this.moneyyesterday = moneyyesterday;
	}

    private String dayString;
    public String getDayString() {
		return dayString;
	}

	public void setDayString(String dayString) {
		this.dayString = dayString;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public SaleMerch() {
    }

    public SaleMerch(Integer id) {
        this.id = id;
    }

    public SaleMerch(Integer id, String name, String ip, Date day, int sale, double money, String email) {
        this.id = id;
        this.name = name;
        this.ip = ip;
        this.day = day;
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

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
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
        if (!(object instanceof SaleMerch)) {
            return false;
        }
        SaleMerch other = (SaleMerch) object;
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
