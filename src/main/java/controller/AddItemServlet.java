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
 * Servlet implementation class AddItemServlet
 */
@WebServlet("/addItemServlet")
public class AddItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String brand = request.getParameter("brand");
		String color = request.getParameter("color");
		String type = request.getParameter("type");
		
		ShoeItem li = new ShoeItem(brand, color, type);
		ShoeItemHelper dao = new ShoeItemHelper();
		dao.insertItem(li);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		
	}

}
