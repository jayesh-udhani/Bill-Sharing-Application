

import java.util.*;

public class Bill {
	private int amount;
	private User paidBy;
	private Group group;
	private Map<User,Integer> shares;
	
	public Bill(int amount, Group group, User paidBy, Map<User,Integer> shares)
	{
		this.amount = amount;
		this.group = group;
		this.paidBy = paidBy;
		this.shares = shares;
	}
	
	public int getAmount()
	{
		return amount;
	}
	
	public Group getGroup()
	{
		return group;
	}
	
	public User getUserWhoPaidBill()
	{
		return paidBy;
	}
	
	public Map<User,Integer> getUserShare()
	{
		return shares;
	}
}
