package reparacionModel;

import java.time.LocalDate;

public class Orden {

	private int id;
	private String nombre;
	private String run;
	private String telefono;
	private String direccion;
	private String descripcion;
	private String estado;
	private String electrodomestico;
	private LocalDate fechaSolicitud;
	private LocalDate fechaActualizacion;
	//falta hacer los getters. setter contructores
	public Orden() {
	}
	public Orden(String nombre, String run, String telefono, String direccion, String descripcion, String estado,
			String electrodomestico, LocalDate fechaSolicitud, LocalDate fechaActualizacion) {
		super();
		this.nombre = nombre;
		this.run = run;
		this.telefono = telefono;
		this.direccion = direccion;
		this.descripcion = descripcion;
		this.estado = estado;
		this.electrodomestico = electrodomestico;
		this.fechaSolicitud = fechaSolicitud;
		this.fechaActualizacion = fechaActualizacion;
	}
	public Orden(int id, String nombre, String run, String telefono, String direccion, String descripcion,
			String estado, String electrodomestico, LocalDate fechaSolicitud, LocalDate fechaActualizacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.run = run;
		this.telefono = telefono;
		this.direccion = direccion;
		this.descripcion = descripcion;
		this.estado = estado;
		this.electrodomestico = electrodomestico;
		this.fechaSolicitud = fechaSolicitud;
		this.fechaActualizacion = fechaActualizacion;
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
	public String getRun() {
		return run;
	}
	public void setRun(String run) {
		this.run = run;
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
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getElectrodomestico() {
		return electrodomestico;
	}
	public void setElectrodomestico(String electrodomestico) {
		this.electrodomestico = electrodomestico;
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

	
}
