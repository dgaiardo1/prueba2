package ar.com.hotel;

//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import ar.com.hotel.DataBaseException;
import ar.com.hotel.DataBaseHelper;

public class Equipos {

	private String idequipo;
	private String serie;
	private String categoria;
	private String modelo;
	private String organismo;
	private String tecnico;
	private String estado;

	public String getidequipo() {
		return idequipo;
	}

	public void setidequipo(String idequipo) {
		this.idequipo = idequipo;
	}

	public String getserie() {
		return serie;
	}

	public void setserie(String serie) {
		this.serie = serie;
	}

	public String getcategoria() {
		return categoria;
	}

	public void setcategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getmodelo() {
		return modelo;
	}

	public void setmodelo(String modelo) {
		this.modelo = modelo;
	}

	public String getorganismo() {
		return organismo;
	}

	public void setorganismo(String organismo) {
		this.organismo = organismo;
	}

	public String gettecnico() {
		return tecnico;
	}

	public void settecnico(String tecnico) {
		this.tecnico = tecnico;
	}

	public String getestado() {
		return estado;
	}

	public void setestado(String estado) {
		this.estado = estado;
	}

	public Equipos(String idequipo) {
		super();
		this.idequipo = idequipo;
	}

	public Equipos() {
		super();
	}

	public Equipos(String idequipo, String serie, String categoria,
			String modelo, String organismo, String tecnico) {
		super();
		this.idequipo = idequipo;
		this.serie = serie;
		this.categoria = categoria;
		this.modelo = modelo;
		this.organismo = organismo;
		this.tecnico = tecnico;
		this.estado = estado;
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
		String consultaSQL = "insert into tblequipos (idequipo,serie,categoria) values ";
		consultaSQL += "('" + this.idequipo + "','" + this.serie + "','"
				+ this.categoria + "')";
		DataBaseHelper<Equipos> helper = new DataBaseHelper<Equipos>();
		helper.modificarRegistro(consultaSQL);
	}

	public void borrar() throws ClassNotFoundException, DataBaseException {
		String consultaSQL = "delete from tblequipos where idequipo='"
				+ this.idequipo + "'";
		DataBaseHelper<Equipos> helper = new DataBaseHelper<Equipos>();
		helper.modificarRegistro(consultaSQL);
	}

	public void salvar() throws ClassNotFoundException, DataBaseException {
		String consultaSQL = "update Libros set titulo='" + this.serie
				+ "', categoria='" + categoria + "' where idequipo='"
				+ idequipo + "'";
		DataBaseHelper<Equipos> helper = new DataBaseHelper<Equipos>();
		helper.modificarRegistro(consultaSQL);
	}

	public static List<Equipos> buscarTodos() throws ClassNotFoundException,
			SQLException, InstantiationException, IllegalAccessException,
			InvocationTargetException, DataBaseException {
		String consultaSQL = "select idequipo,serie,categoria,modelo, organismo, nombre as tecnico, estado from tblequipos inner join tblcategoria on tblequipos.idcategoria=tblcategoria.idcategoria inner join tblmodelo on tblequipos.idmodelo=tblmodelo.idmodelo inner join tblorganismo on tblequipos.idorganismo=tblorganismo.idorganismo inner join tbltecnicos on tblequipos.idtecnicoresponsable=tbltecnicos.idtecnicos inner join tblestado on tblequipos.idestado=tblestado.idestado";
		// String consultaSQL = "CALL buscartodos()";
		DataBaseHelper<Equipos> helper = new DataBaseHelper<Equipos>();
		List<Equipos> listaDeEquipos = helper.seleccionarRegistros(consultaSQL,
				Equipos.class);
		return listaDeEquipos;
	}

	public static List<Equipos> buscar(String categoria, String modelo,
			String organismo, String tecnicos, String serial)
			throws ClassNotFoundException, SQLException {
		String consultaSQL = "select idequipo,serie,categoria,modelo, organismo, nombre as tecnico, estado from tblequipos inner join tblcategoria on tblequipos.idcategoria=tblcategoria.idcategoria inner join tblmodelo on tblequipos.idmodelo=tblmodelo.idmodelo inner join tblorganismo on tblequipos.idorganismo=tblorganismo.idorganismo inner join tbltecnicos on tblequipos.idtecnicoresponsable=tbltecnicos.idtecnicos inner join tblestado on tblequipos.idestado= tblestado.idestado where 1=1";
		if (categoria.isEmpty() == false) {
			consultaSQL = consultaSQL + " AND categoria LIKE " + "'"
					+ categoria + "'";
		}
		if (modelo.isEmpty() == false) {
			consultaSQL = consultaSQL + " AND modelo LIKE " + "'" + modelo
					+ "'";
		}
		if (organismo.isEmpty() == false) {
			consultaSQL = consultaSQL + " AND organismo LIKE " + "'"
					+ organismo + "'";
		}
		;
		if (tecnicos.isEmpty() == false) {
			consultaSQL = consultaSQL + " AND nombre LIKE " + "'" + tecnicos
					+ "'";
		}
		;
		if (serial.isEmpty() == false) {
			consultaSQL = consultaSQL + " AND serie LIKE " + "'" + serial + "'";
		}
		;

		DataBaseHelper<Equipos> helper = new DataBaseHelper<Equipos>();
		List<Equipos> listaDeEquipos = helper.seleccionarRegistros(consultaSQL,
				Equipos.class);
		return listaDeEquipos;
	}

	public static List<Equipos> buscarPorSerial(String serial)
			throws ClassNotFoundException, SQLException {
		String consultaSQL = "select idequipo,serie,categoria,modelo, organismo, nombre as tecnico, estado from tblequipos inner join tblcategoria on tblequipos.idcategoria=tblcategoria.idcategoria inner join tblmodelo on tblequipos.idmodelo=tblmodelo.idmodelo inner join tblorganismo on tblequipos.idorganismo=tblorganismo.idorganismo inner join tbltecnicos on tblequipos.idtecnicoresponsable=tbltecnicos.idtecnicos inner join tblestado on tblequipos.idestado=tblestado.idestado where serie LIKE'"
				+ serial + "'";
		DataBaseHelper<Equipos> helper = new DataBaseHelper<Equipos>();
		List<Equipos> listaDeEquipos = helper.seleccionarRegistros(consultaSQL,
				Equipos.class);
		return listaDeEquipos;
	}

	public static Equipos buscarPorClave(String idequipo)
			throws ClassNotFoundException, SQLException {
		String consultaSQL = "select idequipo,serie,categoria,modelo, organismo, nombre as tecnico, estado from tblequipos inner join tblcategoria on tblequipos.idcategoria=tblcategoria.idcategoria inner join tblmodelo on tblequipos.idmodelo=tblmodelo.idmodelo inner join tblorganismo on tblequipos.idorganismo=tblorganismo.idorganismo inner join tbltecnicos on tblequipos.idtecnicoresponsable=tbltecnicos.idtecnicos inner join tblestado on tblequipos.idestado=tblestado.idestado where idequipo like'"
				+ idequipo + "'";
		DataBaseHelper<Equipos> helper = new DataBaseHelper<Equipos>();
		List<Equipos> listaDeEquipos = helper.seleccionarRegistros(consultaSQL,
				Equipos.class);
		return listaDeEquipos.get(0);
	}

	public static List<Equipos> buscarPorCategoria(String categoria)
			throws ClassNotFoundException, SQLException {
		String consultaSQL = "select idequipo,serie,categoria, modelo, organismo from tblequipos inner join tblcategoria on tblequipos.idcategoria = tblcategoria.idcategoria inner join tblmodelo on tblequipos.idmodelo = tblmodelo.idmodelo inner join tblorganismo on tblequipos.idorganismo=tblorganismo.idorganismo where categoria LIKE '"
				+ categoria + "'";
		DataBaseHelper<Equipos> helper = new DataBaseHelper<Equipos>();
		List<Equipos> listaDeEquipos = helper.seleccionarRegistros(consultaSQL,
				Equipos.class);
		return listaDeEquipos;
	}

	public static List<Equipos> buscarPorOrganismo(String organismo)
			throws ClassNotFoundException, SQLException {
		String consultaSQL = "select idequipo,serie,categoria, modelo, organismo from tblequipos inner join tblcategoria on tblequipos.idcategoria = tblcategoria.idcategoria inner join tblmodelo on tblequipos.idmodelo=tblmodelo.idmodelo inner join tblorganismo on tblequipos.idorganismo=tblorganismo.idorganismo where organismo LIKE '"
				+ organismo + "'";
		DataBaseHelper<Equipos> helper = new DataBaseHelper<Equipos>();
		List<Equipos> listaDeEquipos = helper.seleccionarRegistros(consultaSQL,
				Equipos.class);
		return listaDeEquipos;
	}

	public static List<String> buscarPorModelo(String modelo)
			throws ClassNotFoundException, SQLException {
		String consultaSQL = "select idequipo,serie,categoria, modelo, organismo from tblequipos inner join tblcategoria on tblequipos.idcategoria = tblcategoria.idcategoria inner join tblmodelo on tblequipos.idmodelo=tblmodelo.idmodelo inner join tblorganismo on tblequipos.idorganismo=tblorganismo.idorganismo where modelo LIKE '"
				+ modelo + "'";
		DataBaseHelper<String> helper = new DataBaseHelper<String>();
		List<String> listaDeEquipos = helper.seleccionarRegistros(consultaSQL,
				Equipos.class);
		return listaDeEquipos;
	}

	public static List<String> buscarLasCategorias()
			throws ClassNotFoundException, SQLException {
		String consultaSQL = "select distinct(categoria) as categoria from tblcategoria";
		DataBaseHelper<String> helper = new DataBaseHelper<String>();
		List<String> listaDeCategorias = helper.seleccionarRegistros(
				consultaSQL, String.class);
		return listaDeCategorias;
	}

	public static List<String> buscarmarca() throws ClassNotFoundException,
			SQLException {
		String consultaSQL = "select distinct(modelo) as modelo from tblmodelo inner join tblcategoria on tblmodelo.idcategoria=tblcategoria.idcategoria where 1=1";

		DataBaseHelper<String> helper = new DataBaseHelper<String>();
		List<String> listaDemarcas = helper.seleccionarRegistros(consultaSQL,
				String.class);
		return listaDemarcas;
	}

	public static List<String> buscartodaslasmarca(String categoria)
			throws ClassNotFoundException, SQLException {
		String consultaSQL = "select distinct(modelo) as modelo from tblmodelo";
		DataBaseHelper<String> helper = new DataBaseHelper<String>();
		List<String> listaDemarcas = helper.seleccionarRegistros(consultaSQL,
				String.class);
		return listaDemarcas;
	}

	public static List<String> buscartecnico() throws ClassNotFoundException,
			SQLException {
		String consultaSQL = "select nombre as Tecnico from tbltecnicos";
		DataBaseHelper<String> helper = new DataBaseHelper<String>();
		List<String> listaDetecnicos = helper.seleccionarRegistros(consultaSQL,
				String.class);
		return listaDetecnicos;
	}

	public static List<String> buscarorganismo() throws ClassNotFoundException,
			SQLException {
		String consultaSQL = "select distinct(organismo) as Organismo from tblorganismo";
		DataBaseHelper<String> helper = new DataBaseHelper<String>();
		List<String> listaDeorganismos = helper.seleccionarRegistros(
				consultaSQL, String.class);
		return listaDeorganismos;
	}

}
