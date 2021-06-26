import java.util.*;

public class Driver {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Application app=new Application();
		app.registerUser("Mudit");
		app.registerUser("Shouvik");
		app.registerUser("Sourav");
		app.registerUser("Saloni");
		app.createGroup("Buddies");
		app.createGroup("Colleagues");
		app.addUsersToGroup(new ArrayList<String>(Arrays.asList("Mudit","Shouvik","Sourav")) , "Buddies");
		app.addUsersToGroup(new ArrayList<String>(Arrays.asList("Mudit","Saloni")) , "Colleagues");
		Map<String,Integer> shares=new HashMap<>();
		shares.put("Mudit", 250);
		shares.put("Shouvik", 50);
		shares.put("Sourav", 0);
		app.addBill(300, "Shouvik", "Buddies",shares );
		shares = new HashMap<>();
		shares.put("Mudit", 50);
		shares.put("Saloni", 50);
		app.addBill(100, "Mudit", "Colleagues", shares);
		System.out.println(app.getGroupWiseBalance("Mudit", "Buddies"));
		System.out.println(app.getGroupWiseBalance("Sourav", "Buddies"));
		System.out.println(app.getGroupWiseBalance("Shouvik", "Buddies"));
		System.out.println(app.getGroupWiseBalance("Mudit", "Colleagues"));
		System.out.println(app.getGroupWiseBalance("Saloni", "Colleagues"));
		System.out.println(app.getTotalBalance("Mudit"));
		input.close();
	}

}
