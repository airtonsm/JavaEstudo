package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.UserLogado;

@WebServlet("/pages/ServletAutenticacao")
public class ServletAutenticacao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ServletAutenticacao() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		// pode ser realizado validação no banco de dados
		if(login.equalsIgnoreCase("admin") && senha.equalsIgnoreCase("123")) {
			// se login efetuado com sucesso
			
			UserLogado userLogado = new UserLogado();
			userLogado.setLogin(login);
			userLogado.setSenha(senha);
			
			String url = request.getParameter("url");
			
			// adiciona usuario logado na sessão
			HttpServletRequest req = (HttpServletRequest) request;
			HttpSession session = req.getSession();
			session.setAttribute("usuario", userLogado);
			
			//redirecionar para o sistema e autorizar
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}else {
			// redirecionar para login novamente caso login falhar
			RequestDispatcher dispatcher = request.getRequestDispatcher("/autenticar.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
