package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.JavaBeans;

/**
 * Servlet implementation class Controller
 */
@WebServlet(urlPatterns = {"/Controller", "/novoCliente", "/insert", "/select", "/update", "/delete"})
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	JavaBeans cliente = new JavaBeans();
	
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		if(action.equals("/novoCliente")) {
			try {
				clientes(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (action.equals("/insert")){
			novoCliente(request, response);
		} else if (action.equals("/select")){
			listarCliente(request, response);
			
		} else if (action.equals("/delete")){
			removerCliente(request, response);
		}	
		else {
			response.sendRedirect("cadastro.jsp");
		}
		
		//teste de conexao
//		try {
//			dao.testeConexao();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
	}
	
	//Listar Clientes
	protected void clientes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		ArrayList<JavaBeans> lista = dao.listarClientes();
		
		request.setAttribute("clientes", lista);
		RequestDispatcher rd = request.getRequestDispatcher("cadastro.jsp");
		rd.forward(request, response);
//		response.sendRedirect("cadastro.jsp");
	}		
	
	//Novo Cliente
	protected void novoCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		cliente.setRazaoSocial(request.getParameter("razaoSocial"));
		cliente.setCnpj(request.getParameter("cnpj"));
		cliente.setRegime(request.getParameter("regime"));
		cliente.setEmail(request.getParameter("email"));
		
		dao.inserirCliente(cliente);
		response.sendRedirect("cadastro.jsp");
		
	}	
	
	//Editar Cliente -- 
	protected void listarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idcli = request.getParameter("idcli");
		cliente.setIdcli(idcli);
		dao.selecionarCliente(cliente);
		
	}	
	
	//Deletar Cliente
	protected void removerCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idcli = request.getParameter("idcli");
		cliente.setIdcli(idcli);
		dao.deletarCliente(cliente);
		response.sendRedirect("cadastro.jsp");
	}	
	
}
