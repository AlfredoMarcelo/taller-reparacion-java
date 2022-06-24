package reparacionModel;

import java.time.LocalDate;

public class OrdenServicioDTO {

	private int id;
	private String nombre;
	private String telefono;
	private String direccion;
	private String estado;
	private LocalDate fechaSolicitud;
	private LocalDate fechaActualizacion;
	private String electrodomestico;
	private String descripcion;
	
	
	public OrdenServicioDTO() {
		super();
	}


	public OrdenServicioDTO(String nombre, String telefono, String direccion, String estado,
			LocalDate fechaSolicitud, LocalDate fechaActualizacion, String electrodomestico,
			String descripcion) {
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
		this.estado = estado;
		this.fechaSolicitud = fechaSolicitud;
		this.fechaActualizacion = fechaActualizacion;
		this.electrodomestico = electrodomestico;
		this.descripcion = descripcion;
	}
	
	public OrdenServicioDTO(int id, String nombre, String telefono, String direccion, String estado,
			LocalDate fechaSolicitud, LocalDate fechaActualizacion, String electrodomestico,
			String descripcion) {
		this.id = id;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
		this.estado = estado;
		this.fechaSolicitud = fechaSolicitud;
		this.fechaActualizacion = fechaActualizacion;
		this.electrodomestico = electrodomestico;
		this.descripcion = descripcion;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public LocalDate getFechaSolicitud() {
		return fechaSolicitud;
	}


	public void setFechaSolicitud(LocalDate fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}


	public LocalDate getFechaActualizacion() {
		return fechaActualizacion;
	}


	public void setFechaActualizacion(LocalDate fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}


	public String getElectrodomestico() {
		return electrodomestico;
	}


	public void setElectrodomestico(String electrodomestico) {
		this.electrodomestico = electrodomestico;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	

	
	
}
