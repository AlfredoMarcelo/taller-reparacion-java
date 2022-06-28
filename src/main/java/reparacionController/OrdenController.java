package reparacionController;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import reparacionDao.OrdenDAO;
import reparacionDao.OrdenDAOImp;
import reparacionModel.Orden;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.naming.NamingException;


public class OrdenController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//1-importacion de intefaz DAO
	private OrdenDAO ordenDAO;
	
	
    public OrdenController() {
        super();
    }
    
    //2-metodo init se asigna el valor de implementacion a la interfaz DAO
    @Override
    public void init() throws ServletException {
    	super.init();
    	this.ordenDAO = new OrdenDAOImp();
    }
	
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String seleccion = request.getParameter("seleccion");
		String vistaJSP = "";
		switch(seleccion) {
		case "solicitar":
			vistaJSP = "/WEB-INF/views/cliente/orden.jsp";
			request.getRequestDispatcher(vistaJSP)
			.forward(request, response);
			break;
		case "editar":
			try{
				
				int id = Integer.parseInt(request.getParameter("id"));
				Orden orden = ordenDAO.findOrdenById(id);
				request.setAttribute("orden", orden);
				vistaJSP = "/WEB-INF/views/cliente/orden.jsp";
				request
					.getRequestDispatcher(vistaJSP)
					.forward(request, response)
				;
			} catch (SQLException e) {
				e.printStackTrace();
				response.sendError(500);
			} catch (NamingException e) {
				e.printStackTrace();
				response.sendError(500);
			}
			break;
			
		case "listar":
			try {
				List<Orden> ordenes = ordenDAO.findAllOrdenes();
				request.setAttribute("ordenes", ordenes);
				vistaJSP = "/WEB-INF/views/servicio/lista-ordenes.jsp";
				request
					.getRequestDispatcher(vistaJSP)
					.forward(request, response)
				;
			} catch (SQLException | NamingException e) {				
				response.sendError(500);
			}
			break;
			default:
				response.sendError(404);
			
		case "eliminar":
			try {
				int id = Integer.parseInt(request.getParameter("id"));
				ordenDAO.borrarOrden(id);
				vistaJSP = "/WEB-INF/views/servicio/lista-ordenes.jsp";
				response.sendRedirect("/reparacion/orden?seleccion=listar");
				
			} catch (SQLException | NamingException e) {
				e.printStackTrace();
			}
			break;
		}
		
		
	}

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
			
		} catch (NumberFormatException e) {
			System.err.println("id se setea a 0 automatico");
		}
		String nombre = request.getParameter("nombre");
		String telefono = request.getParameter("telefono");
		String direccion = request.getParameter("direccion");
		String estado = request.getParameter("estado");
		LocalDate fechaSolicitud = LocalDate.now();
		LocalDate fechaActualizacion = LocalDate.parse(request.getParameter("fechaActualizacion"));		
		String descripcion = request.getParameter("descripcion");
		String electrodomestico = request.getParameter("electrodomestico");
		
		//crear orden nueva con solicitudes guardadas
		if(id == 0 ) {
			Orden orden = new Orden(nombre, telefono, direccion, descripcion, estado, electrodomestico, fechaSolicitud, fechaActualizacion);
			try {
				ordenDAO.crearOrden(orden);
				response.sendRedirect("/reparacion/orden?seleccion=listar");
			} catch (SQLException | NamingException e) {
				e.printStackTrace();
				response.sendError(500);
			}
		} else {
			Orden ordenActualizada = new Orden(id, nombre, telefono, direccion, descripcion, estado, electrodomestico, fechaSolicitud, fechaActualizacion);
			try {
				ordenDAO.editarOrden(ordenActualizada);
				response.sendRedirect("/reparacion/orden?seleccion=listar");
			} catch (SQLException | NamingException e) {
				e.printStackTrace();
				response.sendError(500);
			}
		}
	}
	
	
	
}
