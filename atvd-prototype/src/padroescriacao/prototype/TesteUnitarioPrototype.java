package padroescriacao.prototype;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TesteUnitarioPrototype {

    @Test
    public void testClonePacienteSimples() throws CloneNotSupportedException {
        Endereco endereco = new Endereco("Rua A", 123);
        Paciente paciente = new Paciente(1, "Joao", endereco, "Sao Paulo");
        Paciente pacienteClone = paciente.clone();
        assertEquals(paciente.getId(), pacienteClone.getId());
        assertEquals(paciente.getNome(), pacienteClone.getNome());
        assertEquals(paciente.getCidade(), pacienteClone.getCidade());
    }

    @Test
    public void testClonePacienteIndependencia() throws CloneNotSupportedException {
        Endereco endereco = new Endereco("Rua B", 456);
        Paciente paciente = new Paciente(2, "Maria", endereco, "Rio de Janeiro");
        Paciente pacienteClone = paciente.clone();
        pacienteClone.setNome("Maria Silva");
        assertNotEquals(paciente.getNome(), pacienteClone.getNome());
    }

    @Test
    public void testCloneEnderecoProfundo() throws CloneNotSupportedException {
        Endereco endereco = new Endereco("Rua C", 789);
        Paciente paciente = new Paciente(3, "Carlos", endereco, "Belo Horizonte");
        Paciente pacienteClone = paciente.clone();
        pacienteClone.getEndereco().setLogradouro("Rua D");
        assertNotEquals(paciente.getEndereco().getLogradouro(),
                pacienteClone.getEndereco().getLogradouro());
    }

    @Test
    public void testCloneEnderecoIndependente() throws CloneNotSupportedException {
        Endereco endereco = new Endereco("Rua E", 321);
        Paciente paciente = new Paciente(4, "Ana", endereco, "Curitiba");
        Paciente pacienteClone = paciente.clone();
        pacienteClone.getEndereco().setNumero(999);
        assertNotEquals(paciente.getEndereco().getNumero(),
                pacienteClone.getEndereco().getNumero());
    }

    @Test
    public void testCloneMantemDados() throws CloneNotSupportedException {
        Endereco endereco = new Endereco("Avenida Principal", 555);
        Paciente paciente = new Paciente(5, "Pedro", endereco, "Porto Alegre");
        Paciente pacienteClone = paciente.clone();
        assertEquals(paciente.toString(), pacienteClone.toString());
    }
}