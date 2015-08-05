/*
 * Given a list of restaurants menu in csv file format
 * id,price,item
 * 
 * Given two items names: item1, item2
 * find the restaurant id and prices that provides the best deal of combo item1 & item2
 * 
 */

package MenuChoice;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MenuDriver {

	public static void main(String[] args) {
		/*
		Scanner scan = new Scanner(System.in);
		String fileName = scan.nextLine().trim();
		*/
		String fileName = "/Users/yangping/Documents/java/MenuChoice/src/MenuChoice/menu.csv";
		BufferedReader br = null;
		MenuItem mi = new MenuItem();
		try {
			FileReader file = new FileReader(fileName);
			br = new BufferedReader(file);
			String line = null;
			while ((line = br.readLine())!=null) {
				String[] str = line.trim().split(",");
				// skip invalid csv line
				if (str==null || str.length<3) continue;
				int id = Integer.parseInt(str[0].trim());
				float price = Float.parseFloat(str[1].trim());
				String item = str[2].trim();
				mi.addItem(id, item, price);
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			e.printStackTrace();
		} catch (IOException e) {  
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				System.out.println("File close error.");
				e.printStackTrace();
			}
			
		}
		String item1 = "tofu";
		String item2 = "burger";
		System.out.println("Best choice for " + item1 + " " + item2);
		System.out.println(mi.beseChoice("tofu", "burger"));

	}

}


