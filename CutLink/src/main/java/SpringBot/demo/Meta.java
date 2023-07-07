package SpringBot.demo;

public class Meta {
	DailyProduct DailyProductObject;
	OverallProduct OverallProductObject;
	OverallDesign OverallDesignObject;

	// Getter Methods

	public DailyProduct getDailyProduct() {
		return DailyProductObject;
	}

	public OverallProduct getOverallProduct() {
		return OverallProductObject;
	}

	public OverallDesign getOverallDesign() {
		return OverallDesignObject;
	}

	// Setter Methods

	public void setDailyProduct(DailyProduct dailyProductObject) {
		this.DailyProductObject = dailyProductObject;
	}

	public void setOverallProduct(OverallProduct overallProductObject) {
		this.OverallProductObject = overallProductObject;
	}

	public void setOverallDesign(OverallDesign overallDesignObject) {
		this.OverallDesignObject = overallDesignObject;
	}

	public class OverallDesign {
		private int count;
		private int limit;

		// Getter Methods

		public int getCount() {
			return count;
		}

		public int getLimit() {
			return limit;
		}

		// Setter Methods

		public void setCount(int count) {
			this.count = count;
		}

		public void setLimit(int limit) {
			this.limit = limit;
		}
	}

	public class OverallProduct {
		private int count;
		private int limit;

		// Getter Methods

		public int getCount() {
			return count;
		}

		public int getLimit() {
			return limit;
		}

		// Setter Methods

		public void setCount(int count) {
			this.count = count;
		}

		public void setLimit(int limit) {
			this.limit = limit;
		}
	}

	public class DailyProduct {
		private int count;
		private int limit;

		// Getter Methods

		public int getCount() {
			return count;
		}

		public int getLimit() {
			return limit;
		}

		// Setter Methods

		public void setCount(int count) {
			this.count = count;
		}

		public void setLimit(int limit) {
			this.limit = limit;
		}
	}

}
