package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Car;

/**
 * Servlet implementation class AddCarServlet
 */
@WebServlet("/addCarServlet")
public class AddCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String make = request.getParameter("make");
        String model = request.getParameter("model");
        String yearParam = request.getParameter("year");
        int year = 0;
        
        if (make.isEmpty() || model.isEmpty() || make == null || model == null || yearParam == null ) {
			getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		} else {
		year = Integer.parseInt(yearParam);
        Car carToAdd = new Car(make, model, year);
        CarHelper carHelper = new CarHelper();
        carHelper.insertCar(carToAdd);
        getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		}
    }
}
