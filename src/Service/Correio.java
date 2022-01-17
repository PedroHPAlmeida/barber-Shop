package Service;

import Model.Agendamento;

/**
 *
 * @author Pedro Henrique
 */
public class Correio {
    // attributes
    
    // constructor
    
    // methods
    public void notificarPorEmail(Agendamento agendamento){
        String emailFormatado = formatarEmail(agendamento);
        String destinatario = agendamento.getCliente().getEmail();
        
        // Uso da classe de Email
        Email email = new Email("Agendamento BarberShop", emailFormatado, destinatario);
        email.enviar(); 
    }

    private String formatarEmail(Agendamento agendamento) {
        String nomeCliente = agendamento.getCliente().getNome();
        String servico = agendamento.getServico().getDescricao();
        String dataAgendamento = agendamento.getDataFormatada();
        String horaAgendamento = agendamento.getHoraFormatada();
        Float valor = agendamento.getValor();
        
        return "Olá " + nomeCliente + ", vai dar um tapa no visu... Seu agendamento para " + servico
                + ", está marcado para o dia " + dataAgendamento + " às " + horaAgendamento + ". O preço para você sai baratinho, fica R$ " + valor +
                "\nForte abraço!";
    }
}
