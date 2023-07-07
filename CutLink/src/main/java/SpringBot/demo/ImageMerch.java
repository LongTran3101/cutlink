package SpringBot.demo;

import java.math.BigDecimal;
import java.util.Date;

public class ImageMerch {
	private Integer id;
	private String name;
	private String url;
	private Date day;
	private String acc;
	private BigDecimal royaltie;
	private int sold;
	public BigDecimal getRoyaltie() {
		return royaltie;
	}
	public void setRoyaltie(BigDecimal royaltie) {
		this.royaltie = royaltie;
	}
	public int getSold() {
		return sold;
	}
	public void setSold(int sold) {
		this.sold = sold;
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Date getDay() {
		return day;
	}
	public void setDay(Date day) {
		this.day = day;
	}
	public String getAcc() {
		return acc;
	}
	public void setAcc(String acc) {
		this.acc = acc;
	}
	
	
}
