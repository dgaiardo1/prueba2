package ar.com.hotel;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public class Cliente {

	
	private String dni;
	private String apellido;
	private String nombre;
	private String telefono;
	private String direccion;
	private String email;

	public String getdni() {
		return dni;
	}

	public void setdni(String dni) {
		this.dni = dni;
	}

	public String getapellido() {
		return apellido;
	}

	public void setapellido(String apellido) {
		this.apellido = apellido;
	}

	public String getnombre() {
		return nombre;
	}

	public void setnombre(String nombre) {
		this.nombre = nombre;
	}

	public String gettelefono() {
		return telefono;
	}

	public void settelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getdireccion() {
		return direccion;
	}

	public void setdireccion(String direccion) {
		this.direccion = direccion;
	
	}

	public String getmail() {
		return email;
	}

	public void setemail(String email) {
		this.email = email;
	}
	
	
	public Cliente(String dni, String apellido, String nombre, String telefono, String direccion, String email ) {
		this.dni = dni;
		this.apellido = apellido;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
		this.email = email;
		
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
		String consultaSQL = "insert into tblclientes (dni,apellido,nombre, telefono, direccion, email) values ";
		consultaSQL += "('" + this.dni + "','" + this.nombre + "','"
				+ this.telefono + "','" + this.direccion + "','"+ "','" + this.email + "')";
		DataBaseHelper<Cliente> helper = new DataBaseHelper<Cliente>();
		helper.modificarRegistro(consultaSQL);
	}

	public void borrar() throws ClassNotFoundException, DataBaseException {
		String consultaSQL = "delete from tblusuarios where dni='"
				+ this.dni + "'";
		DataBaseHelper<Cliente> helper = new DataBaseHelper<Cliente>();
		helper.modificarRegistro(consultaSQL);
	}

	public void salvar() throws ClassNotFoundException, DataBaseException {
		String consultaSQL = "update tblclientes set dni='" + this.dni
				+ "', apellido='" + apellido + "', 'telefono='" + telefono + "', 'direccion='" + direccion +
				"', 'email='" + email +"' where idusuario='" + dni + "'";
		DataBaseHelper<Cliente> helper = new DataBaseHelper<Cliente>();
		helper.modificarRegistro(consultaSQL);
	}

	public static List<Cliente> buscarTodos() throws ClassNotFoundException,
			SQLException, InstantiationException, IllegalAccessException,
			InvocationTargetException, DataBaseException {
		String consultaSQL = "select dni,apellido,nombre,telefono, direccion, email from tblclientes";
		// String consultaSQL = "CALL buscartodos()";
		DataBaseHelper<Cliente> helper = new DataBaseHelper<Cliente>();
		List<Cliente> listaDeClientes = helper.seleccionarRegistros(consultaSQL,
				Cliente.class);
		return listaDeClientes;
	}

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





