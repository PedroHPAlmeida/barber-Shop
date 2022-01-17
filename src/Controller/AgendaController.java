package Controller;

import Controller.Helper.AgendaHelper;
import Model.Agendamento;
import Model.Cliente;
import Model.DAO.AgendamentoDAO;
import Model.DAO.ClienteDAO;
import Model.DAO.ServicoDAO;
import Model.Servico;
import Service.Correio;
import View.Agenda;
import java.util.ArrayList;

/**
 *
 * @author Pedro Henrique
 */
public class AgendaController {
    // attributes
    private final Agenda view;
    private final AgendaHelper helper;
    
    // constructor
    public AgendaController(Agenda view) {
        this.view = view;
        this.helper = new AgendaHelper(view);
    }
    
    // methods
    public void atualizaTabela(){
        // Buscar uma lista com os agendamentos do BD
        AgendamentoDAO agendamentoDAO = new AgendamentoDAO(); 
        ArrayList<Agendamento> agendamentos = agendamentoDAO.selectAll();
        
        // Exibir a lista na view
        helper.preencherTabela(agendamentos);
    }
    
    public void atualizaCliente(){
        // Buscar clientes do BD
        ClienteDAO clienteDAO = new ClienteDAO();
        ArrayList<Cliente> clientes = clienteDAO.selectAll();
        
        // Exibir clientes no Combobox cliente
        helper.preencherClientes(clientes);
    }
    
    public void atualizaServico(){
        // Buscar servicos do BD
        ServicoDAO servicoDAO = new ServicoDAO();
        ArrayList<Servico> servicos = servicoDAO.selectAll();
        
        // Exibir servicos no Combobox cliente
        helper.preencherServicos(servicos);
    }
    
    public void atualizaValor(){
        Servico servico = helper.obterServico();
        if(servico != null){            
            helper.setarValor(servico.getValor());
        }
    }
    
    public void agendar(){
        // Buscar objeto agendamento da tela
        Agendamento agendamento = helper.obterModelo();
        // Salvar objeto no BD
        new AgendamentoDAO().insert(agendamento);
        // Enviar email para o cliente
        Correio correio = new Correio();
        correio.notificarPorEmail(agendamento);
        // Inserir elemento na tabela
        this.atualizaTabela();
        helper.limparTela();
    }
}
