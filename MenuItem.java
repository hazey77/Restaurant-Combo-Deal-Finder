package MenuChoice;

import java.util.HashMap;
import java.util.Map;

public class MenuItem {
	// <Id, <item, price>>
	// items are grouped by restaurant IDs
	Map<Integer, Map<String, Float>> items = new HashMap<Integer, Map<String, Float>>();
	public MenuItem() {
		super();
	}
	
	public void addItem(int rID, String item, float price) {
		if (items.containsKey(rID)) {
			items.get(rID).put(item, price);
		} else {
			Map<String, Float> newItem = new HashMap<String, Float>();
			newItem.put(item, price);
			items.put(rID, newItem);
		}
	}
	
	public String beseChoice(String item1, String item2) {
		float total = Float.MAX_VALUE;
		StringBuilder res = new StringBuilder();
		for (Map.Entry<Integer, Map<String, Float>> entry : items.entrySet()) {
			int id = entry.getKey();
			Map<String, Float> itm = entry.getValue();
			if (itm.containsKey(item1) && itm.containsKey(item2)) {
				float sum = itm.get(item1) + itm.get(item2);
				if (sum<total) {
					total = sum;
					res = new StringBuilder();
					res.append(id);
					res.append(": " + item1 + " " + itm.get(item1) + " ");
					res.append(item2 + " " + itm.get(item2));
				}
			}
		}
		if (res.length()==0) {
			return "None";
		}
		return res.toString();
	}
	
}
