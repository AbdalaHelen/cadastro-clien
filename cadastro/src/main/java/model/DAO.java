package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAO {
	/**Modulo de conexão **/
	//Parâmetros
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/dbcadastro?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private String user = "root";
	private String password = "root";
	
	//Método de conexão
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	
	/** CRUD **/
	public void inserirCliente(JavaBeans cliente) {
		String create = "insert into clientes (razaoSocial,cnpj,regime,email) values (?,?,?,?)";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			
			pst.setString(1, cliente.getRazaoSocial());
			pst.setString(2, cliente.getCnpj());
			pst.setString(3, cliente.getRegime());
			pst.setString(4, cliente.getEmail());
			
			pst.executeUpdate();
			
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public ArrayList<JavaBeans> listarClientes() throws SQLException{
		ArrayList<JavaBeans> clientes = new ArrayList<>();
		String read = "select * from clientes order by razaoSocial";
		Connection con = conectar();
		try {
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String idcli = rs.getString(1);
				String razaoSocial = rs.getString(2);
				String cnpj = rs.getString(3);
				String regime = rs.getString(4);
				String email = rs.getString(5);
				
				clientes.add(new JavaBeans(idcli,razaoSocial,cnpj,regime,email));
			}
//			con.close();
			return clientes;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		finally {
			con.close();
		}	
	}
	
	public void selecionarCliente(JavaBeans cliente) {
		String read = "select * from clientes where idcli = ?";
		Connection con = conectar();
		try {
			PreparedStatement pst = con.prepareStatement(read);
			pst.setString(1, cliente.getIdcli());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				cliente.setIdcli(rs.getString(1));
				cliente.setRazaoSocial(rs.getString(2));
				cliente.setCnpj(rs.getString(3));
				cliente.setRegime(rs.getString(4));
				cliente.setEmail(rs.getString(5));
			}
			
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	public void deletarCliente(JavaBeans cliente) {
		String delete = "delete * from clientes where idcli = ?";
		Connection con = conectar();
		try {
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1, cliente.getIdcli());
			pst.executeUpdate();
			
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
}
