package Controller.Helper;

import Model.Agendamento;
import Model.Cliente;
import Model.Servico;
import View.Agenda;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pedro Henrique
 */
public class AgendaHelper implements IHelper{
    // attributes
    private final Agenda view;
    
    // constructor
    public AgendaHelper(Agenda view) {
        this.view = view;
    }
    
    // methods

    public void preencherTabela(ArrayList<Agendamento> agendamentos) {
        DefaultTableModel tableModel = (DefaultTableModel) this.view.getTblAgendamentos().getModel();
        tableModel.setNumRows(0);
        
        // Percorrer a lista preenchendo o tableModel
        for (Agendamento agendamento : agendamentos) {
            tableModel.addRow(new Object[]{
                agendamento.getId(),
                agendamento.getCliente().getNome(),
                agendamento.getServico().getDescricao(),
                agendamento.getValor(),
                agendamento.getDataFormatada(),
                agendamento.getHoraFormatada(),
                agendamento.getObservacao()
            }); 
        }
    }

    public void preencherClientes(ArrayList<Cliente> clientes) {
        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) view.getCmbCliente().getModel();
        
        for (Cliente cliente : clientes) {
            comboBoxModel.addElement(cliente);
        }
    }

    public void preencherServicos(ArrayList<Servico> servicos) {
       DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) view.getCmbServico().getModel();
        
        for (Servico servico : servicos) {
            comboBoxModel.addElement(servico);
        }
    }

    public Cliente obterCliente() {
        return (Cliente) view.getCmbCliente().getSelectedItem();
    }
    
    public Servico obterServico() {
        return (Servico) view.getCmbServico().getSelectedItem();
    }

    public void setarValor(float valor) {
        view.getTxtValor().setText(valor + "");
    }
    
    public Agendamento obterModelo() {
        int id = Integer.parseInt(view.getTxtId().getText());
        Cliente cliente = this.obterCliente();
        Servico servico = this.obterServico();
        float valor = Float.parseFloat(view.getTxtValor().getText());
        String data = view.getTxtData().getText();
        String hora = view.getTxtHora().getText();
        String dataHora = data + " " + hora;
        String observacao = view.getTxtObservacao().getText();
        
        Agendamento agendamento = new Agendamento(id, cliente, servico, valor, dataHora, observacao);
        
        return agendamento;
    }

    public void limparTela() {
        view.getTxtId().setText("0");
        view.getCmbCliente().setSelectedItem(null);
        view.getCmbServico().setSelectedItem(null);
        view.getTxtData().setText("");
        view.getTxtHora().setText("");
        view.getTxtObservacao().setText("");
    }
}
