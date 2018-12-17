package controlador;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import modelo.Tripulantes;
import modelo.Usuarios;

/**
 * Servlet implementation class GTripulantes
 */
@WebServlet("/GTripulantes")
@MultipartConfig
public class GTripulantes extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String UPLOAD_DIR = "fotos";

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
		inicio(request, response);

	}

	private void nuevoTripulante(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String contexto = request.getServletContext().getRealPath("/");
		Part archivo = request.getPart("foto");

		// System.out.println("part.getContentType : " + archivo.getContentType());
		// System.out.println("part.getSize : " + archivo.getSize());
		// System.out.println("part.getName : " + archivo.getName());
		// System.out.println("part.getSubmittedFileName : " +
		// archivo.getSubmittedFileName());
		// System.out.println("Contexto:" + contexto);
		String nombreFoto = Paths.get(archivo.getSubmittedFileName()).getFileName().toString();

//	-------------------------------------------------------------------------------------------------------
		if (nombreFoto.length() > 0) {
			System.out.println("nombre foto controlando fallo: "+ nombreFoto.length());
			archivo.write(contexto + UPLOAD_DIR + File.separator + nombreFoto);
		}
		// request.setAttribute("message",
		// "File uploaded successfully (" + contexto + UPLOAD_DIR + File.separator +
		// nombreFoto + ")!");
		// request.setAttribute("ruta", UPLOAD_DIR + File.separator + nombreFoto);

		String rutafoto = UPLOAD_DIR + File.separator + nombreFoto;
		if (nombreFoto == null)
			rutafoto = "";

		// getServletContext().getRequestDispatcher("/response.jsp").forward(request,
		// response);

		String nombre = request.getParameter("nombre");
		String cargo = request.getParameter("cargo");
		int sexo = Integer.parseInt(request.getParameter("sexo"));
		int experiencia = Integer.parseInt(request.getParameter("experiencia"));
		String origen = request.getParameter("origen");
		String raza = request.getParameter("raza");
		int edad = Integer.parseInt(request.getParameter("edad"));
		// String foto =request.getParameter("foto");
		int nave = Integer.parseInt(request.getParameter("nave"));

		Tripulantes tripulante = new Tripulantes(nombre, cargo, sexo, experiencia, origen, raza, edad, rutafoto, nave);
		if (Integer.parseInt(request.getParameter("id")) != 0) {
			int id = Integer.parseInt(request.getParameter("id"));
			tripulante.setId(id);
			tripulante.actualizar();
		} else
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
		Tripulantes tripu = new Tripulantes();
		tripu.buscarID(Integer.parseInt(request.getParameter("id")));
		tripu.borrar();
		response.sendRedirect("tripulantes.jsp");

	}

	private void buscarTripulante(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id;

		if (Integer.parseInt(request.getParameter("id")) != 0) {
			id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("id", id);
			RequestDispatcher vista = request.getRequestDispatcher("altaTripulantes.jsp");
			vista.forward(request, response);
		} else {
			request.setAttribute("id", null);
			RequestDispatcher vista = request.getRequestDispatcher("altaTripulantes.jsp");
			vista.forward(request, response);
		}

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
