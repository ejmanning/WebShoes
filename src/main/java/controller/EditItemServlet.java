/**
 * @author ${user} - ejmanning
 * CIS175 - Spring 2021
 * ${date}
 */

package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ShoeItem;

/**
 * Servlet implementation class EditItemServlet
 */
@WebServlet("/editItemServlet")
public class EditItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ShoeItemHelper dao = new ShoeItemHelper();
		
		String brand = request.getParameter("brand");
		String color = request.getParameter("color");
		String type = request.getParameter("type");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		ShoeItem itemToUpdate = dao.searchForItemById(tempId);
		itemToUpdate.setBrand(brand);
		itemToUpdate.setColor(color);
		itemToUpdate.setShoeType(type);
		
		dao.updateItem(itemToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllItemsServlet").forward(request, response);
		
	}

}
