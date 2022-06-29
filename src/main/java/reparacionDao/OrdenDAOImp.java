package reparacionDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import reparacionModel.Orden;

public class OrdenDAOImp implements OrdenDAO{

	@Override
	public List<Orden> findAllOrdenes() throws SQLException, NamingException {
		try (
				Connection conexion = DbUtils.getConexion();
				Statement declaracion = conexion.createStatement();
			){
				ResultSet rs = declaracion.executeQuery("SELECT * FROM ordenes");
				List<Orden> ordenes = new ArrayList<>();
				while(rs.next()) {
					int id = rs.getInt("id");
					String nombre = rs.getString("nombre");
					String run = rs.getString("run");
					String telefono = rs.getString("telefono");
					String direccion = rs.getString("direccion");
					String descripcion = rs.getString("descripcion");
					String estado = rs.getString("estado");
					String electrodomestico = rs.getString("electrodomestico");
					LocalDate fechaSolicitud = rs.getObject("fecha_solicitud", LocalDate.class);
					LocalDate fechaActualizacion = rs.getObject("fecha_actualizacion", LocalDate.class);
					Orden orden = new Orden(id, nombre, run, telefono, direccion, descripcion, estado, electrodomestico, fechaSolicitud, fechaActualizacion);
					ordenes.add(orden);
				}
			return ordenes;
		}
	}

	@Override
	public Orden findOrdenById(int idOrden) throws SQLException, NamingException {
		try (
				Connection conexion = DbUtils.getConexion();
				PreparedStatement declaracion = conexion.prepareStatement("SELECT * FROM ordenes WHERE id = ?");
		){
			declaracion.setInt(1, idOrden);
			ResultSet rs = declaracion.executeQuery();
			if(rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String run = rs.getString("run");
				String telefono = rs.getString("telefono");
				String direccion = rs.getString("direccion");
				String descripcion = rs.getString("descripcion");
				//se deben caster los datos tipo fecha para usarlos en la vista
				String estado = rs.getString("estado");
				String electrodomestico = rs.getString("electrodomestico");
				LocalDate fechaSolicitud = rs.getObject("fecha_solicitud", LocalDate.class);
				LocalDate fechaActualizacion = rs.getObject("fecha_actualizacion", LocalDate.class);
				return new Orden(id, nombre, run, telefono, direccion, descripcion, estado, electrodomestico, fechaSolicitud, fechaActualizacion);
			} else {
				return null;
			}
		} 
	}

	@Override
	public void crearOrden(Orden orden) throws SQLException, NamingException {
		String sql = "INSERT INTO ordenes(nombre, run, telefono, direccion, estado, fecha_solicitud, fecha_actualizacion, descripcion, electrodomestico) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try (
				Connection conexion = DbUtils.getConexion();
				PreparedStatement declaracion = conexion.prepareStatement(sql);
			) {
				declaracion.setString(1, orden.getNombre());
				declaracion.setString(2, orden.getRun());
				declaracion.setString(3, orden.getTelefono());
				declaracion.setString(4, orden.getDireccion());
				declaracion.setString(5, orden.getEstado());
				declaracion.setObject(6, orden.getFechaSolicitud());
				declaracion.setObject(7, orden.getFechaActualizacion());
				declaracion.setString(8, orden.getDescripcion());
				declaracion.setString(9, orden.getElectrodomestico());
				int filasInsertadas = declaracion.executeUpdate();
		}
	}

	@Override
	public void editarOrden(Orden orden) throws SQLException, NamingException {
		try (
				Connection conexion = DbUtils.getConexion();
				PreparedStatement declaracion = conexion.prepareStatement("UPDATE ordenes SET nombre = ?, run = ?, telefono = ?, direccion = ?, estado = ?, fecha_solicitud = ?, fecha_actualizacion = ?, descripcion = ?, electrodomestico = ? WHERE id = ?");
		){
			declaracion.setString(1, orden.getNombre());
			declaracion.setString(2, orden.getRun());
			declaracion.setString(3, orden.getTelefono());
			declaracion.setString(4, orden.getDireccion());
			declaracion.setString(5, orden.getEstado());
			declaracion.setObject(6, orden.getFechaSolicitud());
			declaracion.setObject(7, orden.getFechaActualizacion());
			declaracion.setString(8, orden.getDescripcion());
			declaracion.setString(9, orden.getElectrodomestico());
			declaracion.setInt(10, orden.getId());
			declaracion.executeUpdate();
		}
	}

	@Override
	public void borrarOrden(int id) {
		try (
				Connection conexion = DbUtils.getConexion();
				PreparedStatement declaracion = conexion.prepareStatement("DELETE FROM ordenes WHERE id = ?");
		){
			declaracion.setInt(1, id);
			int filasEliminadas = declaracion.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public Orden findOrdenByRun(String runImport) throws SQLException, NamingException {
		try (
				Connection conexion = DbUtils.getConexion();
				PreparedStatement declaracion = conexion.prepareStatement("SELECT id, nombre, run, telefono, direccion, descripcion, estado, electrodomestico, fecha_solicitud, fecha_actualizacion FROM ordenes WHERE run = ?");
		){
			declaracion.setString(1, runImport);
			ResultSet rs = declaracion.executeQuery();
			if(rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String run = rs.getString("run");
				String telefono = rs.getString("telefono");
				String direccion = rs.getString("direccion");
				String descripcion = rs.getString("descripcion");
				//se deben caster los datos tipo fecha para usarlos en la vista
				String estado = rs.getString("estado");
				String electrodomestico = rs.getString("electrodomestico");
				LocalDate fechaSolicitud = rs.getObject("fecha_solicitud", LocalDate.class);
				LocalDate fechaActualizacion = rs.getObject("fecha_actualizacion", LocalDate.class);
				return new Orden(id, nombre, run, telefono, direccion, descripcion, estado, electrodomestico, fechaSolicitud, fechaActualizacion);
			} else {
				return null;
			}
		} 
	}

}
