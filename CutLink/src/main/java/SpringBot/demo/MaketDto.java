package SpringBot.demo;

public class MaketDto {
	public int unitsSold;
    public int unitsCancelled;
    public int unitsReturned;
    public RevenueExclTax revenueExclTax;
    public Royalties royalties;
    public Revenue revenue;
    public int getUnitsSold() {
		return unitsSold;
	}
	public void setUnitsSold(int unitsSold) {
		this.unitsSold = unitsSold;
	}
	public int getUnitsCancelled() {
		return unitsCancelled;
	}
	public void setUnitsCancelled(int unitsCancelled) {
		this.unitsCancelled = unitsCancelled;
	}
	public int getUnitsReturned() {
		return unitsReturned;
	}
	public void setUnitsReturned(int unitsReturned) {
		this.unitsReturned = unitsReturned;
	}
	public RevenueExclTax getRevenueExclTax() {
		return revenueExclTax;
	}
	public void setRevenueExclTax(RevenueExclTax revenueExclTax) {
		this.revenueExclTax = revenueExclTax;
	}
	public Royalties getRoyalties() {
		return royalties;
	}
	public void setRoyalties(Royalties royalties) {
		this.royalties = royalties;
	}
	public Revenue getRevenue() {
		return revenue;
	}
	public void setRevenue(Revenue revenue) {
		this.revenue = revenue;
	}
	public class Revenue{
        public int value;
        public String code;
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
    }

    public class RevenueExclTax{
        public int value;
        public String code;
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
    }
    public class Royalties{
        public int value;
        public String code;
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
    }
}
