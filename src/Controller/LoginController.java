package Controller;

import Controller.Helper.LoginHelper;
import Model.DAO.UsuarioDAO;
import Model.Usuario;
import View.Login;
import View.MenuPrincipal;

/**
 *
 * @author Pedro Henrique
 */
public class LoginController {
    // attributes
    private final Login view;
    private final LoginHelper helper;
    
    // constructor
    public LoginController(Login view) {
        this.view = view;
        this.helper = new LoginHelper(view);
    }
    
    // methods
    public void entrarNoSistema(){
        // Pegar um Usuario da View
        Usuario usuario = helper.obterModelo();
        
        // Pesquisar o Usuario no BD
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuarioAutenticado = usuarioDAO.selectPorNomeESenha(usuario);
        
        // Se o usuario da view tiver o mesmo usuario e senha que o usuario vindo do BD direcionar para o menu
        if(usuarioAutenticado != null){
            MenuPrincipal menu = new MenuPrincipal();
            menu.setVisible(true);
            this.view.dispose();
        } else{ // Senão mostrar mensagem ao usuario "Usuario ou senha invalidos"
           view.exibeMensagem("Usuário ou senha inválidos");
        }
    }
        
    public void fizTarefa(){
        System.out.println("Busquei algo do BD");
        this.view.exibeMensagem("Executei o fiz tarefa");
    }
}
