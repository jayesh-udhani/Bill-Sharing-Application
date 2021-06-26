

import java.util.*;

public class User {
	private String name;
	private List<Group> groups;
	
	public User(String name)
	{
		this.name = name;
		groups = new ArrayList<>();
	}
	
	public String getName()
	{
		return name;
	}
	
	public void addGroup(Group group)
	{
		groups.add(group);
	}
	
	public List<Group> getGroups()
	{
		return this.groups;
	}
	
	@Override
	public int hashCode()
	{
		return this.getName().hashCode();
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if(this == obj)
			return true;
		
		if(obj==null || obj.getClass()!=this.getClass())
			return false;
		
		User user = (User) obj;
		
		return this.getName().equals(user.getName());
	}
	
	@Override
	public String toString()
	{
		return this.getName();
	}
}
