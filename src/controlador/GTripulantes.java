package controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Tripulantes;
import modelo.Usuarios;

/**
 * Servlet implementation class GTripulantes
 */
@WebServlet("/GTripulantes")
public class GTripulantes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GTripulantes() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void inicio(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		switch (request.getParameter("opcion")) {
		case "1":
			nuevoTripulante(request, response);
			break;
		case "2":
			borrarTripulante(request, response);
			break;
		case "3":
			buscarTripulante(request, response);
			break;
		case "4":
			peticionLogin(request, response);
			break;
		case "5":
			System.out.println("hola sesion");
			cerrarLogin(request, response);
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
		response.setContentType("text/htmlUTF-8");
		this.inicio(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		inicio(request, response);

	}

	private void nuevoTripulante(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String cargo = request.getParameter("cargo");
		int sexo = Integer.parseInt(request.getParameter("sexo"));
		int experiencia = Integer.parseInt(request.getParameter("experiencia"));
		String origen = request.getParameter("origen");
		String raza = request.getParameter("raza");
		int edad = Integer.parseInt(request.getParameter("edad"));
		String foto = request.getParameter("foto");
		int nave = Integer.parseInt(request.getParameter("nave"));

		Tripulantes tripulante = new Tripulantes(nombre, cargo, sexo, experiencia, origen, raza, edad, foto, nave);

		tripulante.insertar();

		// request.setAttribute("listaTripu",lista);
		response.sendRedirect("tripulantes.jsp");
		/*
		 * RequestDispatcher vista = request.getRequestDispatcher("tripulantes.jsp");
		 * vista.forward(request, response);
		 */

	}

	private void borrarTripulante(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Tripulantes tripu= new Tripulantes();
		tripu.buscarID(Integer.parseInt(request.getParameter("id")));
		tripu.borrar();
		response.sendRedirect("tripulantes.jsp");

	}

	private void buscarTripulante(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		Tripulantes tripu= new Tripulantes();
		tripu.buscarID(Integer.parseInt(request.getParameter("id")));

		request.setAttribute("id", tripu.getId());
		RequestDispatcher vista = request.getRequestDispatcher("altaTripulantes.jsp");
		vista.forward(request, response);
		

	}

	private void cerrarLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		System.out.println("Cerrando sesion" + sesion.getAttribute("nombre"));

		if (sesion.getAttribute("nombre") != null) {
			sesion.removeAttribute("nombre");
		}
		response.sendRedirect("formularioLogin.jsp");

	}

	private void peticionLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {

		HttpSession sesion = request.getSession();
		String nombre = request.getParameter("nombre");
		String contrasena = request.getParameter("contrasena");

		if (Usuarios.buscar(nombre, contrasena)) {
			sesion.setAttribute("nombre", nombre);
			response.sendRedirect("index.jsp");
		} else {
			System.out.println("nombre" + nombre + "contrasena" + contrasena);
			response.sendRedirect("formularioLogin.jsp");
		}

	}

}
