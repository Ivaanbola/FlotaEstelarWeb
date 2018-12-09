package controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import modelo.Misiones;

/**
 * Servlet implementation class GMisiones
 */
@WebServlet("/GMisiones")
public class GMisiones extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GMisiones() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void inicio(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		switch (request.getParameter("opcion")) {
		case "1":
			nuevaMision(request, response);
			break;
		case "2":
			borrarMision(request, response);
			break;
		case "3":
			buscarMision(request, response);
			break;
		default:
			System.out.println("Opcion no valida");
		}

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		inicio(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		inicio(request, response);
	}

	private void nuevaMision(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		int nave = Integer.parseInt(request.getParameter("nave"));

		Misiones misiones = new Misiones(nombre, nave, descripcion);
		if (request.getParameter("id") != "") {
			int id = Integer.parseInt(request.getParameter("id"));
			misiones.setId(id);
			misiones.actualizar();
		} else
			misiones.insertar();

		response.sendRedirect("misiones.jsp");

	}
	
	private void borrarMision(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Misiones m = new Misiones();
		m.buscarID(Integer.parseInt(request.getParameter("id")));
		m.borrar();
		response.sendRedirect("misiones.jsp");

	}
	
	private void buscarMision(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id;

		if (Integer.parseInt(request.getParameter("id")) != 0) {
			id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("id", id);
			RequestDispatcher vista = request.getRequestDispatcher("altaMisiones.jsp");
			vista.forward(request, response);
		} else {
			request.setAttribute("id", null);
			RequestDispatcher vista = request.getRequestDispatcher("altaMisiones.jsp");
			vista.forward(request, response);
		}

	}

}
