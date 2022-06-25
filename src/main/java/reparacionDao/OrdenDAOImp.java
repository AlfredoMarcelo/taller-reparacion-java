package reparacionDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import reparacionModel.Orden;

public class OrdenDAOImp implements OrdenDAO{

	@Override
	public List<Orden> findAllOrdenes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Orden findOrdenById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void crearOrden(Orden orden) throws SQLException, NamingException {
		String sql = "INSERT INTO ordenes(nombre, telefono, direccion, estado, fecha_solicitud, fecha_actualizacion, descripcion, electrodomestico) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		
		try (
				Connection conexion = DbUtils.getConexion();
				PreparedStatement declaracion = conexion.prepareStatement(sql);
			) {
				declaracion.setString(1, orden.getNombre());
				declaracion.setString(2, orden.getTelefono());
				declaracion.setString(3, orden.getDireccion());
				declaracion.setString(4, orden.getEstado());
				declaracion.setObject(5, orden.getFechaSolicitud());
				declaracion.setObject(6, orden.getFechaActualizacion());
				declaracion.setString(7, orden.getElectrodomestico());
				declaracion.setString(8, orden.getDescripcion());
				int filasInsertadas = declaracion.executeUpdate();
		}
	}

	@Override
	public void editarOrden(Orden orden) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borrarOrden(int id) {
		// TODO Auto-generated method stub
		
	}

}
