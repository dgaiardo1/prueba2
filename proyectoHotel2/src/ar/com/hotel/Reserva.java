package ar.com.hotel;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public class Reserva {

	private String idReserva;
	private String fechaEntrada;
	private String fechaSalida;
	private String tipoHabitacion;
	private String cantidadPersonas;
	private Cliente cliente;

	public String getidReserva() {
		return idReserva;
	}

	public void setidReserva(String idReserva) {
		this.idReserva = idReserva;
	}

	public String getfechaEntrada() {
		return fechaEntrada;
	}

	public void setfechaEntrada(String fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public String getfechaSalida() {
		return fechaSalida;
	}

	public void setfechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public String gettipoHabitacion() {
		return tipoHabitacion;
	}

	public void settipoHabitacion(String tipoHabitacion) {
		this.tipoHabitacion = tipoHabitacion;
	}

	public String getcantPersonas() {
		return cantidadPersonas;
	}

	public void setcantidadPersonas(String cantPersonas) {
		this.cantidadPersonas = cantPersonas;
	
	}

	public Cliente getcliente() {
		return cliente;
	}

	public void setcliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	public Reserva(String idReserva, String fechaEntrada, String fechaSalida, String tipoHabitacion, String cantidadPersonas, Cliente cliente ) {
		this.idReserva = idReserva;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.tipoHabitacion = tipoHabitacion;
		this.cantidadPersonas = cantidadPersonas;
		this.cliente = cliente;
		
	}

	

	public void insertar() throws ClassNotFoundException, SQLException,
			DataBaseException {
		String consultaSQL = "insert into tblreservas (fechaEntrada,fechaSalida, tipoHabitacion, cantidadPersonas) values ";
		consultaSQL += "('" + this.fechaEntrada + "','" + this.fechaSalida + "','"
				+ this.tipoHabitacion + "','" + this.cantidadPersonas + "')";
		DataBaseHelper<Reserva> helper = new DataBaseHelper<Reserva>();
		helper.modificarRegistro(consultaSQL);
	}

	public void borrar() throws ClassNotFoundException, DataBaseException {
		String consultaSQL = "delete from tblreservas where idReserva='"
				+ this.idReserva + "'";
		DataBaseHelper<Reserva> helper = new DataBaseHelper<Reserva>();
		helper.modificarRegistro(consultaSQL);
	}

	public void salvar() throws ClassNotFoundException, DataBaseException {
		String consultaSQL = "update tblreservas set fechaEntrada='" + this.fechaEntrada
				+ "', fechaSalida='" + fechaSalida + "', 'tipoHabitacion='" + tipoHabitacion + "', 'cantidadPersonas='" +"' where idReserva='" + idReserva + "'";
		DataBaseHelper<Reserva> helper = new DataBaseHelper<Reserva>();
		helper.modificarRegistro(consultaSQL);
	}

	public static List<Cliente> buscarTodosLosClientes() throws ClassNotFoundException,
			SQLException, InstantiationException, IllegalAccessException,
			InvocationTargetException, DataBaseException {
		String consultaSQL = "select dni,apellido,nombre,telefono, direccion, email from tblclientes";
		// String consultaSQL = "CALL buscartodos()";
		DataBaseHelper<Cliente> helper = new DataBaseHelper<Cliente>();
		List<Cliente> listaDeClientes = helper.seleccionarRegistros(consultaSQL,
				Cliente.class);
		return listaDeClientes;
	}
	
	
	public static List<Reserva> buscarReserva(String idReserva) throws ClassNotFoundException,
			SQLException, InstantiationException, IllegalAccessException,
			InvocationTargetException, DataBaseException {
			String consultaSQL = "select idReserva,fechaEntrada,fechaSalida,tipoHabitacion, tblClientes.dni from tblReservas";
			// String consultaSQL = "CALL buscartodos()";
			DataBaseHelper<Reserva> helper = new DataBaseHelper<Reserva>();
			List<Reserva> listaDeReservas = helper.seleccionarRegistros(consultaSQL,
					Reserva.class);
			return listaDeReservas;
}
	

	public static List<Reserva> buscar(String idReserva ,String fechaEntrada, String fechaSalida,
			String tipoHabitacion, String cantidadPersonas)
			throws ClassNotFoundException, SQLException {
		String consultaSQL = "select idReserva,fechaEntrada,fechaSalida,tipoHabitacion, tblClientes.dni from tblReservas, tblClientes on tblClientes.dni = tblReservas.dni  where 1=1";
		
		if (idReserva.isEmpty() == false) {
			consultaSQL = consultaSQL + " AND idReserva LIKE " + "'"
					+ idReserva + "'";
		}
		
		
		if (fechaEntrada.isEmpty() == false) {
			consultaSQL = consultaSQL + " AND fechaEntrada LIKE " + "'"
					+ fechaEntrada + "'";
		}
		
		if (fechaSalida.isEmpty() == false) {
			consultaSQL = consultaSQL + " AND fechaSalida LIKE " + "'"
					+ fechaSalida + "'";
		}
		if (tipoHabitacion.isEmpty() == false) {
			consultaSQL = consultaSQL + " AND tipoHabitacion LIKE " + "'" + tipoHabitacion
					+ "'";
		}
		

		DataBaseHelper<Reserva> helper = new DataBaseHelper<Reserva>();
		List<Reserva> listaDeReservas = helper.seleccionarRegistros(consultaSQL,
				Reserva.class);
		return listaDeReservas;
	}

	
	

	
	
	
}
