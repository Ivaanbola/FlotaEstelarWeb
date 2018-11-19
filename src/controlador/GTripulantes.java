package controlador;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Tripulantes;

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
		doGet(request, response);
		
		String nombre = request.getParameter("nombre");
		String cargo = request.getParameter("cargo");
		int sexo = Integer.parseInt(request.getParameter("sexo"));
		int experiencia = Integer.parseInt(request.getParameter("experiencia"));
		String origen = request.getParameter("origen");
		String raza = request.getParameter("raza");
		int edad = Integer.parseInt(request.getParameter("edad"));
		String foto = request.getParameter("foto");
		int nave = Integer.parseInt(request.getParameter("nave"));
				
		Tripulantes tripulante = new Tripulantes( nombre,  cargo,  sexo,  experiencia,  origen,  raza,  edad,
				 foto,  nave);
		
		tripulante.insertar();
		
		
		//request.setAttribute("listaTripu",lista);
		
		RequestDispatcher vista = request.getRequestDispatcher("tripulantes.jsp");
		vista.forward(request, response);
		
		
	}

}
