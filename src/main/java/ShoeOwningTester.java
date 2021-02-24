/**
 * @author ${user} - ejmanning
 * CIS175 - Spring 2021
 * ${date}
 */

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.ListDetailsHelper;
import controller.ShoeOwnerHelper;
import model.ListDetails;
import model.ShoeItem;
import model.ShoeOwner;

public class ShoeOwningTester {
	public static void main(String[]args) {
		/*ShoeOwner bill = new ShoeOwner("Bill");
		
		ShoeOwnerHelper sh = new ShoeOwnerHelper();
		
		sh.insertShoeOwner(bill);
		
		List<ShoeOwner> allShoeOwners = sh.showAllShoeOwners();
		for(ShoeOwner a: allShoeOwners) {
			System.out.println(a.toString());
		}
		
		
		ShoeOwner cameron = new ShoeOwner("Cameron");
		
		sh.insertShoeOwner(cameron);
		
		ListDetailsHelper ldh = new ListDetailsHelper();
		
		ListDetails cameronsList = new ListDetails("Cameron's List", LocalDate.now(), cameron);
		
		ldh.insertNewListDetails(cameronsList);
		
		List<ListDetails> allLists = ldh.getLists();
		for (ListDetails a: allLists) {
			System.out.println(a.toString());
		}
		
		
		ShoeOwner susan = new ShoeOwner("Susan");
		ListDetailsHelper ldh = new ListDetailsHelper();
		
		ShoeItem blackNikeSlides = new ShoeItem("Nike", "Black", "Slides");
		ShoeItem grayDudeShoes = new ShoeItem("HeyDude", "Gray", "Slip ons");
		
		List<ShoeItem> susansShoes = new ArrayList<ShoeItem>();
		
		susansShoes.add(blackNikeSlides);
		susansShoes.add(grayDudeShoes);
		
		ListDetails susansList = new ListDetails("Susan's Shoes", LocalDate.now(), susan);
		susansList.setListOfShoes(susansShoes);
		
		ldh.insertNewListDetails(susansList);
		
		List<ListDetails> allLists = ldh.getLists();
		for(ListDetails a: allLists) {
			System.out.println(a.toString());
		}
		*/
		
	}
}