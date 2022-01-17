package View;

import Model.Agendamento;
import Model.Cliente;
import Model.Pessoa;
import Model.Servico;
import Model.Usuario;

/**
 *
 * @author Pedro Henrique
 */
public class Main {
    
    public static void main(String[] args){
        Servico servico = new Servico(1, "barba", 30);
        
        Cliente cliente = new Cliente(1, "Pedro", "Rua Azul", "06695-290");
        System.out.println(cliente.getNome());
        
        Usuario usuario = new Usuario(1, "Barbeiro", "123");
        System.out.println(usuario.getNome());
        
        Agendamento agendamento = new Agendamento(1, cliente, servico, 30, "09/05/2022 09:15");
        System.out.println(agendamento.getCliente().getNome());
    }
}
