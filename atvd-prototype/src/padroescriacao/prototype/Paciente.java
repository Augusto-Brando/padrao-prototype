package padroescriacao.prototype;

public class Paciente implements Cloneable {
    private int id;
    private String nome;
    private Endereco endereco;
    private String cidade;

    public Paciente(int id, String nome, Endereco endereco, String cidade) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.cidade = cidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public Paciente clone() throws CloneNotSupportedException {
        Paciente pacienteClone = (Paciente) super.clone();
        pacienteClone.endereco = (Endereco) pacienteClone.endereco.clone();
        return pacienteClone;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", endereco=" + endereco +
                ", cidade='" + cidade + '\'' +
                '}';
    }
}