package controlador;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Bitacoras;

/**
 * Servlet implementation class GBitacoras
 */
@WebServlet("/GBitacoras")
public class GBitacoras extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GBitacoras() {
		super();
	}

	protected void inicio(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		switch (request.getParameter("opcion")) {
		case "1":
			nuevoBitacoras(request, response);
			break;
		case "2":
			borrarBitacoras(request, response);
			break;
		case "3":
			buscarBitacoras(request, response);
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
		response.setContentType("text/htmlUTF-8");
		this.inicio(request, response);
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

	private void nuevoBitacoras(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String audio = request.getParameter("audio");
		LocalDate fecha = LocalDate.parse(request.getParameter("fecha"), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		int nave = Integer.parseInt(request.getParameter("nave"));

		Bitacoras bitacoras = new Bitacoras(nave, fecha, audio);
		if (request.getParameter("id") != "") {
			int id = Integer.parseInt(request.getParameter("id"));
			bitacoras.setId(id);
			bitacoras.actualizar();
		} else
			bitacoras.insertar();

		response.sendRedirect("bitacoras.jsp");

	}

	private void borrarBitacoras(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Bitacoras bitacoras = new Bitacoras();
		bitacoras.buscarID(Integer.parseInt(request.getParameter("id")));
		bitacoras.borrar();
		response.sendRedirect("bitacoras.jsp");

	}

	private void buscarBitacoras(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id;

		if (Integer.parseInt(request.getParameter("id")) != 0) {
			id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("id", id);
			RequestDispatcher vista = request.getRequestDispatcher("altaBitacoras.jsp");
			vista.forward(request, response);
		} else {
			request.setAttribute("id", null);
			RequestDispatcher vista = request.getRequestDispatcher("altaBitacoras.jsp");
			vista.forward(request, response);
		}

	}

}
