package fieldformat;

public class DisplayUserStockInfo {
	private int userId;

	private int compId;

	private String compName;

	private int numStock;

	private int buyingPrice;

	private int sellingPrice;

	private String numStockStr;

	private String buyingPriceStr;

	private String sellingPriceStr;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getCompId() {
		return compId;
	}

	public void setCompId(int compId) {
		this.compId = compId;
	}

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public int getNumStock() {
		return numStock;
	}

	public void setNumStock(int numStock) {
		this.numStock = numStock;
	}

	public int getBuyingPrice() {
		return buyingPrice;
	}

	public void setBuyingPrice(int buyingPrice) {
		this.buyingPrice = buyingPrice;
	}

	public int getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(int sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public String getNumStockStr() {
		return numStockStr;
	}

	public void setNumStockStr(String numStockStr) {
		this.numStockStr = numStockStr;
	}

	public String getBuyingPriceStr() {
		return buyingPriceStr;
	}

	public void setBuyingPriceStr(String buyingPriceStr) {
		this.buyingPriceStr = buyingPriceStr;
	}

	public String getSellingPriceStr() {
		return sellingPriceStr;
	}

	public void setSellingPriceStr(String sellingPriceStr) {
		this.sellingPriceStr = sellingPriceStr;
	}
}
