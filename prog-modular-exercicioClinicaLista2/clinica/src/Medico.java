import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Medico {
    double valorConsulta;
    List<Consulta> consultas = new ArrayList<>();
    String nome;
    String crm;
    String especialidade;


    public Medico(String nome, String crm, String especialidade){
        this.nome = nome;
        this.crm = crm;
        this.especialidade = especialidade;

    }

    public List<Consulta> agendaDoDia(){

        List<Consulta> consultasDoDia = new ArrayList<>();
        LocalDateTime diaAtual = LocalDateTime.now();

        for(int i = 0; i < consultas.size() ; i++){
            if(consultas.get(i).getDia().isEqual(diaAtual)){
                consultasDoDia.add(consultas.get(i));
            }
        }

        return consultasDoDia;
    }

    public double valorConsulta(String nomeCliente){
        double valorFinal = 0.0;
        List<Consulta> consultasHoje = new ArrayList<>();
        for(int i = 0; i < consultas.size() ; i++){
            if(consultas.get(i).getNome().equals(nomeCliente)){
                consultasHoje.add(consultas.get(i));
            }
            
        }
            for(int i = 0; i < consultasHoje.size() ; i++){    
                valorFinal += consultasHoje.get(i).calcularValorConsulta(valorConsulta);   
            }
        return valorFinal;
    }
    
}
