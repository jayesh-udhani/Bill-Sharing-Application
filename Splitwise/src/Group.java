

import java.util.*;

public class Group {
	private String name;
	private List<User> users;
	private List<Bill> bills;
	private List<Transaction> transactions;
	private Map<User,Integer> balances;
	
	public Group(String name)
	{
		this.name = name;
		this.users = new ArrayList<>();
		this.bills = new ArrayList<>();
		this.transactions = new ArrayList<>();
		this.balances = new HashMap<>();
	}
	
	public String getName()
	{
		return name;
	}
	
	public List<User> getUsers()
	{
		return this.users;
	}
	
	public List<Bill> getBills()
	{
		return this.bills;
	}
	
	public void addUser(User user)
	{
		users.add(user);
		balances.put(user, 0);
	}
	
	public void addUsers(List<User> usersToAdd)
	{
		for(int index=0;index<usersToAdd.size();index++)
		{
			addUser(usersToAdd.get(index));
		}
	}
	
	public void addBill(Bill bill)
	{
		bills.add(bill);
		balances.put(bill.getUserWhoPaidBill(),balances.get(bill.getUserWhoPaidBill())+bill.getAmount());
		for(Map.Entry me:bill.getUserShare().entrySet())
		{
			User user=(User)me.getKey();
			balances.put(user, balances.get(user)-(Integer)me.getValue());
			if(!user.equals(bill.getUserWhoPaidBill()))
				transactions.add(new Transaction(user, bill.getUserWhoPaidBill(), bill.getAmount()));
		}
	}
	
	public int getBalanceOfUser(User user)
	{
		return balances.get(user);
	}
}
