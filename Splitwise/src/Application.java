

import java.util.*;

public class Application {
	private Map<String,User> users;
	private Map<String,Group> groups;
	
	public Application()
	{
		this.users = new HashMap<>();
		this.groups = new HashMap<>();
	}
	
	public Map<String,User> getUsers()
	{
		return this.users;
	}
	
	public Map<String,Group> getGroups()
	{
		return this.groups;
	}
	
	public void registerUser(String name)
	{
		User newUser = new User(name);
		users.put(name,newUser);
	}
	
	public void createGroup(String name)
	{
		Group newGroup = new Group(name);
		groups.put(name,newGroup);
	}
	
	public void addBill(int amount,String userWhoPaid,String group,Map<String,Integer> shares)
	{
		Map<User,Integer> billDivision=new HashMap<>();
		for(Map.Entry me:shares.entrySet())
		{
			billDivision.put(users.get((String)me.getKey()), (Integer)me.getValue());
		}
		Bill newBill = new Bill(amount, groups.get(group), users.get(userWhoPaid),billDivision);
		groups.get(group).addBill(newBill);
	}
	
	public void addUsersToGroup(List<String> usersToAdd,String group)
	{
		for(int index=0;index<usersToAdd.size(); index++)
		{
			groups.get(group).addUser(users.get(usersToAdd.get(index)));
			users.get(usersToAdd.get(index)).addGroup(groups.get(group));
		}
		
	}
	
	public int getGroupWiseBalance(String user,String group)
	{
		return groups.get(group).getBalanceOfUser(users.get(user));
	}
	
	public int getTotalBalance(String user)
	{
		int total = 0,index;
		for(index = 0; index<users.get(user).getGroups().size();index++)
		{
			total+= users.get(user).getGroups().get(index).getBalanceOfUser(users.get(user));
		}
		return total;
	}
}
