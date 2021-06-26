public class Transaction {
	private User fromUser,toUser;
	private int amount;
	
	public Transaction(User fromUser,User toUser,int amount)
	{
		this.fromUser = fromUser;
		this.toUser = toUser;
		this.amount = amount;
	}
	public int getAmount()
	{
		return amount;
	}
	
	public User getFromUser()
	{
		return fromUser;
	}
	
	public User getToUser()
	{
		return toUser;
	}
}
