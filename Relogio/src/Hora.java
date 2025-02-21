public class Hora {

    int horasRelogio, minutosRelogio, segundosRelogio;

    public Hora(int horas, int minutos, int segundos) {
        horasRelogio = horas;
        minutosRelogio = minutos;
        segundosRelogio = segundos;
    }

    public boolean verificarHora(){
        if(horasRelogio < 0 || horasRelogio > 23 ||
         minutosRelogio < 0 || minutosRelogio > 59 || 
         segundosRelogio < 0 || segundosRelogio > 59){
            return false;
        }
        return true;
    }


    public Hora alterarHora(int novaHora, int novoMinuto, int novoSegundo) {
            

    }

    public int verificarHoraAdiante() {

    }

}
