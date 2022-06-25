package reparacionDao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import reparacionModel.Orden;

public interface OrdenDAO {
	
	/*
	 obtiene todos las ordenes
	*/
	public List<Orden> findAllOrdenes() throws SQLException, NamingException;
	public Orden findOrdenById(int id) throws SQLException, NamingException;
	public void crearOrden(Orden orden) throws SQLException, NamingException;
	public void editarOrden(Orden orden) throws SQLException, NamingException;
	public void borrarOrden(int id) throws SQLException, NamingException;
}
