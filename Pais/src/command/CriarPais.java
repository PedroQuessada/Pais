package command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pais;
import service.PaisService;

public class CriarPais implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pNome = request.getParameter("nome");
		String pPopulacao = request.getParameter("populacao");
		String pArea = request.getParameter("area");
				
		//instanciar o javabean
		Pais pais = new Pais();
		pais.setNome(pNome);
		pais.setPopulacao(Long.parseLong(pPopulacao));
		pais.setArea(Double.parseDouble(pArea));
		
		//instanciar o service
		PaisService cs = new PaisService();
		int idPais = cs.criar(pais);
		
		System.out.println("Id:" + idPais);
		pais = cs.carregar(idPais);
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Cliente Cadastrado</title></head><body>");
		out.println(	"id: "+pais.getId()+"<br>");
		out.println(	"nome: "+pais.getNome()+"<br>");
		out.println(	"fone: "+pais.getPopulacao()+"<br>");
		out.println(	"e-mail: "+pais.getArea()+"<br>");
	    out.println("</body></html>");
	}
}
