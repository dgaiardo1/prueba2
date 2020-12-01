package ar.com.hotel;


import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public class Habitacion {

	private String nroHabitacion;
	private String nroPiso;
	private String precio;
	private String tipoHabitacion;
	private String cantCamas;
	

	public String getnroHabitacion() {
		return nroHabitacion;
	}

	public void setnroHabitacion(String nroHabitacion) {
		this.nroHabitacion = nroHabitacion;
	}

	public String getnroPiso() {
		return nroPiso;
	}

	public void setnroPiso(String nroPiso) {
		this.nroPiso = nroPiso;
	}

	public String getprecio() {
		return precio;
	}

	public void setprecio(String precio) {
		this.precio = precio;
	}

	public String gettipoHabitacion() {
		return tipoHabitacion;
	}

	public void settipoHabitacion(String tipoHabitacion) {
		this.tipoHabitacion = tipoHabitacion;
	}

	public String getcantCamas() {
		return cantCamas;
	}

	public void setcantCamas(String cantCamas) {
		this.cantCamas = cantCamas;
	}
	
	public Habitacion(String nroHabitacion, String nroPiso, String precio, String tipoHabitacion, String cantCamas ) {
		this.nroHabitacion = nroHabitacion;
		this.nroPiso = nroPiso;
		this.precio = precio;
		this.tipoHabitacion = tipoHabitacion;
		this.cantCamas = cantCamas;
				
	}

	public static List<String> buscarTodasLasCategorias()
			throws ClassNotFoundException, SQLException {
		String consultaSQL = "select distinct(categoria) as categoria from tblequipos inner join tblcategoria on tblequipos.idcategoria=tblcategoria.idcategoria";
		DataBaseHelper<String> helper = new DataBaseHelper<String>();
		List<String> listaDeCategorias = helper.seleccionarRegistros(
				consultaSQL, String.class);
		return listaDeCategorias;
	}

	public void insertar() throws ClassNotFoundException, SQLException,
			DataBaseException {
		String consultaSQL = "insert into tblhabitacion (nroHabitacion,nroPiso,precio, tipoHabitacion, cantCamas) values ";
		consultaSQL += "('" + this.nroHabitacion + "','" + this.nroPiso + "','"
				+ this.precio + "','" + this.tipoHabitacion + "','"+ "','" + this.cantCamas + "')";
		DataBaseHelper<Habitacion> helper = new DataBaseHelper<Habitacion>();
		helper.modificarRegistro(consultaSQL);
	}

	public void borrar() throws ClassNotFoundException, DataBaseException {
		String consultaSQL = "delete from tblhabitacion where nroHabitacion='"
				+ this.nroHabitacion + "'";
		DataBaseHelper<Habitacion> helper = new DataBaseHelper<Habitacion>();
		helper.modificarRegistro(consultaSQL);
	}

	public void salvar() throws ClassNotFoundException, DataBaseException {
		String consultaSQL = "update tblHabitacion set nroHabitacion='" + this.nroHabitacion
				+ "', nroPiso='" + this.nroPiso + "', 'precio='" + this.precio + "', 'tipoHabitacion='" + 
				this.tipoHabitacion +
				"', 'cantCamas='" + this.cantCamas +"' where nroHabitacion='" + this.nroHabitacion + "'";
		DataBaseHelper<Habitacion> helper = new DataBaseHelper<Habitacion>();
		helper.modificarRegistro(consultaSQL);
	}

	public static List<Habitacion> buscarTodos() throws ClassNotFoundException,
			SQLException, InstantiationException, IllegalAccessException,
			InvocationTargetException, DataBaseException {
		String consultaSQL = "select nroHabitacion, nroPiso,precio,tipoHabitacion, cantCamas from tblhabitaciones";
		// String consultaSQL = "CALL buscartodos()";
		DataBaseHelper<Habitacion> helper = new DataBaseHelper<Habitacion>();
		List<Habitacion> listaDeHabitaciones = helper.seleccionarRegistros(consultaSQL,
				Habitacion.class);
		return listaDeHabitaciones;
	}

	public static List<Habitacion> buscar(String nroHabitacion, String nroPiso,
			String precio, String tipoHabitacion, String cantCamas)
			throws ClassNotFoundException, SQLException {
		String consultaSQL = "select nroHabitacion,nroPiso,precio, tipoHabitacion, cantCamas from tblHabitaciones where 1=1";
		
		if (nroHabitacion.isEmpty() == false) {
			consultaSQL = consultaSQL + " AND nroHabitacion LIKE " + "'"
					+ nroHabitacion + "'";
		}
		
		if (nroPiso.isEmpty() == false) {
			consultaSQL = consultaSQL + " AND nroPiso LIKE " + "'"
					+ nroPiso + "'";
		}
		if (precio.isEmpty() == false) {
			consultaSQL = consultaSQL + " AND precio LIKE " + "'" + precio
					+ "'";
		}
		
		if (cantCamas.isEmpty() == false) {
			consultaSQL = consultaSQL + " AND cantCamas LIKE " + "'" + cantCamas
					+ "'";
		}

		DataBaseHelper<Habitacion> helper = new DataBaseHelper<Habitacion>();
		List<Habitacion> listaDeHabitaciones = helper.seleccionarRegistros(consultaSQL,
				Habitacion.class);
		return listaDeHabitaciones;
	}

	

	

	
	
	
}
