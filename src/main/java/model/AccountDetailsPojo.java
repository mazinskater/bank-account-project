package model;

public class AccountDetailsPojo {
	
	private int accountId;
	private int userId;
	private double funds;
	
	public AccountDetailsPojo(int accountId, int userId, double funds) {
		super();
		this.accountId = accountId;
		this.userId = userId;
		this.funds = funds;
	}

	public AccountDetailsPojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public double getFunds() {
		return funds;
	}

	public void setFunds(double funds) {
		this.funds = funds;
	}

	@Override
	public String toString() {
		return "AccountDetailsPojo [accountId=" + accountId + ", userId=" + userId + ", funds=" + funds + "]";
	}
	
	
	
	

}
