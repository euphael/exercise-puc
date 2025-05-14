public class ConsultaSobDemanda extends Consulta{

    public ConsultaSobDemanda(String nomePaciente, Medico medico) {
        super(nomePaciente, medico);
    }

    @Override
    public double calcularValorConsulta(double valorConsulta){
        return valorConsulta + (valorConsulta * 0.10); // Replace with the actual calculation logic
    }
    
}
