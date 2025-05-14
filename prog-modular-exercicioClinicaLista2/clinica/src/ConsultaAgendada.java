import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class ConsultaAgendada extends Consulta{
    public ConsultaAgendada(String nomeCliente, Medico medico){
        super(nomeCliente, medico);
    }

    @Override
    public double calcularValorConsulta(double valorConsulta){

         LocalDateTime dataHoje = LocalDateTime.now();
         long diasPassados = ChronoUnit.DAYS.between(dataHora, dataHoje);


        if(diasPassados > 30){
            valorConsulta = valorConsulta - (valorConsulta * 0.20);
        }
        return valorConsulta;
    }
    
    
}
