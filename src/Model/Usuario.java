package Model;

/**
 *
 * @author Pedro Henrique
 */
public class Usuario extends Pessoa{
    // attributes
    private String senha;
    private String nivelAcesso;
    
    // constructor
    public Usuario(int id, String nome, char sexo, String dataNascimento, String telefone, String email, String rg, String senha, String nivelAcesso) {
        super(id, nome, sexo, dataNascimento, telefone, email, rg);
        this.senha = senha;
        this.nivelAcesso = nivelAcesso;
    }
    
    public Usuario(int id, String nome, String senha) {
        super(id, nome);
        this.senha = senha;
    }

    // getters & setters
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(String nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }
}
