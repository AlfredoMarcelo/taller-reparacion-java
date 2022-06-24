package reparacionController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import reparacionModel.OrdenServicioDTO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ClienteController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String seleccion = request.getParameter("seleccion");
		String vistaJSP = "";
		switch(seleccion) {
		case "solicitar":
			vistaJSP = "/WEB-INF/views/client/order.jsp";
			request.getRequestDispatcher(vistaJSP)
			.forward(request, response);
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
			OrdenServicioDTO nuevaOrden = new OrdenServicioDTO(nombre, telefono, direccion, estado, fechaSolicitud, fechaActualizacion, descripcion, electrodomestico);
			try {
				crearOrden(nuevaOrden);
				response.sendRedirect("/");
			} catch (SQLException | NamingException e) {
				e.printStackTrace();
				response.sendError(500);
			}
			
		}
	}
	
	
	public Connection getConexion() throws NamingException, SQLException {
		InitialContext contextoInicial = new InitialContext();
		DataSource dataSource = (DataSource) contextoInicial.lookup("java:comp/env/jdbc/postgres");
		return dataSource.getConnection();
	}


	private void crearOrden(OrdenServicioDTO nuevaOrden) throws SQLException, NamingException {
		String sql = "INSERT INTO ordenes(nombre, telefono, direccion, estado, fecha_solicitud, fecha_actualizacion, descripcion, electrodomestico) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		
		try (
				Connection conexion = getConexion();
				PreparedStatement declaracion = conexion.prepareStatement(sql);
			) {
				declaracion.setString(1, nuevaOrden.getNombre());
				declaracion.setString(2, nuevaOrden.getTelefono());
				declaracion.setString(3, nuevaOrden.getDireccion());
				declaracion.setString(4, nuevaOrden.getEstado());
				declaracion.setObject(5, nuevaOrden.getFechaSolicitud());
				declaracion.setObject(6, nuevaOrden.getFechaActualizacion());
				declaracion.setString(7, nuevaOrden.getDescripcion());
				declaracion.setString(8, nuevaOrden.getElectrodomestico());
				int filasInsertadas = declaracion.executeUpdate();
		} 
	}

}
