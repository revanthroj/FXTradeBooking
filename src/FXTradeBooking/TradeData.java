package FXTradeBooking;

public class TradeData {
	private Long tradeNo;
	private String username;
	private String currencyPair;
	private String transferAmount;
	private float tranferRate;

	public TradeData() {

	}

	public TradeData(Long tradeNo, String username, String currencyPair, String transferAmount, float tranferRate) {
		this.tradeNo = tradeNo;
		this.username = username;
		this.currencyPair = currencyPair;
		this.transferAmount = transferAmount;
		this.tranferRate = tranferRate;
	}

	public Long getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(Long tradeNo) {
		this.tradeNo = tradeNo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCurrencyPair() {
		return currencyPair;
	}

	public void setCurrencyPair(String currencyPair) {
		this.currencyPair = currencyPair;
	}

	public String getTransferAmount() {
		return transferAmount;
	}

	public void setTransferAmount(String transferAmount) {
		this.transferAmount = transferAmount;
	}

	public float getTranferRate() {
		return tranferRate;
	}

	public void setTranferRate(float tranferRate) {
		this.tranferRate = tranferRate;
	}

	@Override
	public String toString() {
		return "TradeData [username=" + username + ", currencyPair=" + currencyPair + ", transferAmount="
				+ transferAmount + ", tranferRate=" + tranferRate + "]";
	}

}
