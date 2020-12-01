package ar.com.hotel;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public class Estadia {
	private String idEstadia;
	private String fechaEntrada;
	private String fechaSalida;
	private String tipodeHabitacion;
	private String cantidadDePersonas;
	
	public String idEstadia() {
		return idEstadia;
	}

	public void setidEstadia(String idEstadia) {
		this.idEstadia = idEstadia;
	}
	public String fechaEntrada() {
		return fechaEntrada;
	}

	public void setdni(String fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public String getfechaSalida() {
		return fechaSalida;
	}

	public void setfechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public String gettipodeHabitacion() {
		return tipodeHabitacion;
	}

	public void settipodeHabitacion(String tipodeHabitacion) {
		this.tipodeHabitacion = tipodeHabitacion;
	}

	public String getcantidadDePersonas() {
		return cantidadDePersonas;
	}
	
	
	public Estadia(String idEstadia, String fechaEntrada, String fechaSalida, String tipodeHabitacion, String cantidadDePersonas) {
		this.idEstadia = idEstadia;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.tipodeHabitacion = tipodeHabitacion;
		this.cantidadDePersonas = cantidadDePersonas;
		
	}

	

	public void insertar() throws ClassNotFoundException, SQLException,
			DataBaseException {
		String consultaSQL = "insert into tblestadias (idEstadia, fechaEntrada,fechaSalida,tipoHabitacion, cantidadDePersonas) values ";
		consultaSQL += "('"+ this.fechaEntrada + "','" + this.fechaEntrada + "','" + this.fechaSalida + "','"
				+ this.tipodeHabitacion + "','" + this.cantidadDePersonas +"')";
		DataBaseHelper<Estadia> helper = new DataBaseHelper<Estadia>();
		helper.modificarRegistro(consultaSQL);
	}

	public void borrar() throws ClassNotFoundException, DataBaseException {
		String consultaSQL = "delete from tblEstadia where idEstadia='"
				+ this.idEstadia + "'";
		DataBaseHelper<Estadia> helper = new DataBaseHelper<Estadia>();
		helper.modificarRegistro(consultaSQL);
	}

	public void salvar() throws ClassNotFoundException, DataBaseException {
		String consultaSQL = "update tblEstadia set FechaEntrada='" + this.fechaEntrada
				+ "', fechaSalida='" + this.fechaSalida + "', 'tipoHabitacion='" + this.tipodeHabitacion + 
				"', 'cantidadDePersonas='" + this.cantidadDePersonas + "'";
		DataBaseHelper<Estadia> helper = new DataBaseHelper<Estadia>();
		helper.modificarRegistro(consultaSQL);
	}

	public static List<Estadia> buscarTodos() throws ClassNotFoundException,
			SQLException, InstantiationException, IllegalAccessException,
			InvocationTargetException, DataBaseException {
		String consultaSQL = "select idEstadia,fechaEntrada,fechaSalida,tipoDeHabitacion, cantidadDePersonas from tblestadia";
		// String consultaSQL = "CALL buscartodos()";
		DataBaseHelper<Estadia> helper = new DataBaseHelper<Estadia>();
		List<Estadia> listaDeEstadias = helper.seleccionarRegistros(consultaSQL,
				Estadia.class);
		return listaDeEstadias;
	}

	
	//Hay que hacer las estadias por cliente
	
	public static List<Cliente> buscar(String dni, String apellido,
			String nombre, String telefono, String direccion, String email)
			throws ClassNotFoundException, SQLException {
		String consultaSQL = "select dni,apellido,nombre from tblClientes where 1=1";
		
		if (dni.isEmpty() == false) {
			consultaSQL = consultaSQL + " AND dni LIKE " + "'"
					+ dni + "'";
		}
		
		if (apellido.isEmpty() == false) {
			consultaSQL = consultaSQL + " AND apellido LIKE " + "'"
					+ apellido + "'";
		}
		if (nombre.isEmpty() == false) {
			consultaSQL = consultaSQL + " AND nombre LIKE " + "'" + nombre
					+ "'";
		}
		

		DataBaseHelper<Cliente> helper = new DataBaseHelper<Cliente>();
		List<Cliente> listaDeClientes = helper.seleccionarRegistros(consultaSQL,
				Cliente.class);
		return listaDeClientes;
	}

	public static List<Cliente> buscarPorApellido(String apellido)
			throws ClassNotFoundException, SQLException {
		String consultaSQL = "select dni,apellido,nombre, telefono, direccion, email from tblClientes where apellido LIKE'"
				+ apellido + "'";
		DataBaseHelper<Cliente> helper = new DataBaseHelper<Cliente>();
		List<Cliente> listaDeClientes = helper.seleccionarRegistros(consultaSQL,
				Cliente.class);
		return listaDeClientes;
	}

	

	
	
	
	
	
}
