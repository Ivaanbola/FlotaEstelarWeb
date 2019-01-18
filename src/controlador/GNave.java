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
import javax.servlet.http.Part;

import modelo.Nave;

/**
 * Servlet implementation class GNave
 */
@WebServlet("/GNave")
@MultipartConfig
public class GNave extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String UPLOAD_DIR = "fotos";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GNave() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void inicio(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		switch (request.getParameter("opcion")) {
		case "1":
			nuevaNave(request, response);
			break;
		case "2":
			borrarNave(request, response);
			break;
		case "3":
			buscarNave(request, response);
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

	private void nuevaNave(HttpServletRequest request, HttpServletResponse response)
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

		String nombre = request.getParameter("nombre");
		String capitan = request.getParameter("capitan");
		String matricula = request.getParameter("matricula");
		String tipo = request.getParameter("tipo");
		//String foto = request.getParameter("foto");

		Nave nave = new Nave(nombre, capitan, matricula, tipo, rutafoto);
		if (request.getParameter("id") != "") {
			int id = Integer.parseInt(request.getParameter("id"));
			nave.setId(id);
			nave.actualizar();
		} else
			nave.insertar();

		response.sendRedirect("nave.jsp");
	}

	private void borrarNave(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Nave nave = new Nave();
		nave.buscarID(Integer.parseInt(request.getParameter("id")));
		nave.borrar();
		response.sendRedirect("nave.jsp");

	}

	private void buscarNave(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id;

		if (Integer.parseInt(request.getParameter("id")) != 0) {
			id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("id", id);
			RequestDispatcher vista = request.getRequestDispatcher("altaNave.jsp");
			vista.forward(request, response);
		} else {
			request.setAttribute("id", null);
			RequestDispatcher vista = request.getRequestDispatcher("altaNave.jsp");
			vista.forward(request, response);
		}

	}

}
