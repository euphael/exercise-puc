import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Medico {
    List<Consulta> consultas = new ArrayList<>();

    private List<Consulta> agendaDoDia(){

        List<Consulta> consultasDoDia = new ArrayList<>();
        LocalDateTime diaAtual = LocalDateTime.now();

        for(int i = 0; i < consultas.size() ; i++){
            if(consultas.get(i).getDia().isEqual(diaAtual)){
                consultasDoDia.add(consultas.get(i));
            }
        }

        return consultasDoDia;
    }
    
}
