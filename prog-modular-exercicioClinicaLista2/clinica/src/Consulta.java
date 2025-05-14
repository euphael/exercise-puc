import java.time.LocalDateTime;

public class Consulta {

    private String nome;
    protected LocalDateTime dataHora;
    protected String nomePaciente;
    private Medico medico;

    public Consulta(String nomePaciente, Medico medico){
        this.medico = medico;
        this.nomePaciente = nomePaciente;
    }

 
    public double calcularValorConsulta(double valorConsulta){
        return 0;
    }

    public LocalDateTime getDia(){
        return dataHora;
    }

    public String getNome() {
        return nome;
    }
    
}
