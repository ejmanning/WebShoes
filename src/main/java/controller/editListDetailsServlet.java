/**
 * @author ${user} - ejmanning
 * CIS175 - Spring 2021
 * ${date}
 */

package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListDetails;
import model.ShoeItem;
import model.ShoeOwner;

/**
 * Servlet implementation class editListDetailsServlet
 */
@WebServlet("/editListDetailsServlet")
public class editListDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editListDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		ListDetailsHelper dao = new ListDetailsHelper();
		ShoeItemHelper sih = new ShoeItemHelper();
		ShoeOwnerHelper sh = new ShoeOwnerHelper();
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		ListDetails listToUpdate = dao.searchForListDetailsById(tempId);
		String newListName = request.getParameter("listName");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String shoeOwnerName = request.getParameter("shoeOwnerName");
		//find our add the new shopper
		ShoeOwner newShoeOwner = sh.findShoeOwners(shoeOwnerName);
		LocalDate ld;
		
		try {
			ld = LocalDate.of(Integer.parseInt(year),Integer.parseInt(month), Integer.parseInt(day));
		} catch(NumberFormatException ex) {
			ld = LocalDate.now();
		}
		try {
			//items are selected in list to add
			String[] selectedItems = request.getParameterValues("allItemsToAdd");
			List<ShoeItem> selectedItemsInList = new ArrayList<ShoeItem>();
			
			for(int i = 0; i < selectedItems.length; i++) {
				System.out.println(selectedItems[i]);
				ShoeItem c = sih.searchForItemById(Integer.parseInt(selectedItems[i]));
				selectedItemsInList.add(c);
			}
			listToUpdate.setListOfShoes(selectedItemsInList);
		} catch (NullPointerException ex) {
			// no items selected in list-set to an empty list
			List<ShoeItem> selectedItemsInList = new ArrayList<ShoeItem>();
			listToUpdate.setListOfShoes(selectedItemsInList);
		}
			listToUpdate.setListName(newListName);
			listToUpdate.setTripDate(ld);
			listToUpdate.setShopper(newShoeOwner);
			
			dao.updateList(listToUpdate);
			
			getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);

	}

}

