package ar.com.hotel;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import ar.com.hotel.DataBaseException;
import ar.com.hotel.DataBaseHelper;

public class Usuario {


		private String usuario;
		private String apellido;
		private String nombre;
		private String password;
		

		public String getusuario() {
			return usuario;
		}

		public void setusuario(String usuario) {
			this.usuario = usuario;
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

		public String getpassword() {
			return password;
		}

		public void setpassword(String password) {
			this.password = password;
		}

		
		public Usuario(String usuario, String apellido, String nombre, String password) {
			this.usuario = usuario;
			this.apellido = apellido;
			this.nombre = nombre;
			this.password = password;
			
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
			String consultaSQL = "insert into Usuarios (usuario,password,nombre,apellido) values ";
			consultaSQL += "('" + this.usuario + "','" + this.password + "','" + this.nombre + "','"
					+ this.apellido + "')";
			DataBaseHelper<Usuario> helper = new DataBaseHelper<Usuario>();
			helper.modificarRegistro(consultaSQL);
		}

		public void borrar() throws ClassNotFoundException, DataBaseException {
			String consultaSQL = "delete from tblusuarios where usuario='"
					+ this.usuario + "'";
			DataBaseHelper<Usuario> helper = new DataBaseHelper<Usuario>();
			helper.modificarRegistro(consultaSQL);
		}

		public void salvar() throws ClassNotFoundException, DataBaseException {
			String consultaSQL = "update Usuarios set usuario='" + this.usuario
					+ "', apellido='" + apellido + "', ´password='" + password +"' where idusuario='"
					+ usuario + "'";
			DataBaseHelper<Usuario> helper = new DataBaseHelper<Usuario>();
			helper.modificarRegistro(consultaSQL);
		}

		public static List<Usuario> buscarTodos() throws ClassNotFoundException,
				SQLException, InstantiationException, IllegalAccessException,
				InvocationTargetException, DataBaseException {
			String consultaSQL = "select usuario,apellido,nombre,password from tblusuarios";
			// String consultaSQL = "CALL buscartodos()";
			DataBaseHelper<Usuario> helper = new DataBaseHelper<Usuario>();
			List<Usuario> listaDeUsuarios = helper.seleccionarRegistros(consultaSQL,
					Usuario.class);
			return listaDeUsuarios;
		}

		public static List<Usuario> buscar(String usuario, String apellido,
				String nombre)
				throws ClassNotFoundException, SQLException {
			String consultaSQL = "select usuario,apellido,nombre from tblusuarios where 1=1";
			if (apellido.isEmpty() == false) {
				consultaSQL = consultaSQL + " AND apellido LIKE " + "'"
						+ apellido + "'";
			}
			if (usuario.isEmpty() == false) {
				consultaSQL = consultaSQL + " AND usuario LIKE " + "'" + usuario
						+ "'";
			}
			

			DataBaseHelper<Usuario> helper = new DataBaseHelper<Usuario>();
			List<Usuario> listaDeUsuarios = helper.seleccionarRegistros(consultaSQL,
					Usuario.class);
			return listaDeUsuarios;
		}

		public static List<Usuario> buscarPorUsuario(String usuario)
				throws ClassNotFoundException, SQLException {
			String consultaSQL = "select usuario,apellido,nombre from tblusuarios where usuario LIKE'"
					+ usuario + "'";
			DataBaseHelper<Usuario> helper = new DataBaseHelper<Usuario>();
			List<Usuario> listaDeUsuarios = helper.seleccionarRegistros(consultaSQL,
					Usuario.class);
			return listaDeUsuarios;
		}

		


	}

	
	
	

