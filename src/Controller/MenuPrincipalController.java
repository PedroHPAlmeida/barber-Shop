package Controller;

import View.Agenda;
import View.MenuPrincipal;

/**
 *
 * @author Pedro Henrique
 */
public class MenuPrincipalController {
    // attributes
    private final MenuPrincipal view;
    
    // constructor
    public MenuPrincipalController(MenuPrincipal view) {
        this.view = view;
    }
    
    // methods
    public void navegarParaAgenda(){
        Agenda agenda = new Agenda();
        agenda.setVisible(true);
    }
}
