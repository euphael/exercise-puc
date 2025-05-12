public class Especialista extends Cliente{

    @Override
    public double calcularDesconto(){
        descontoFixo = 0.15;
        if(this.compras.length >= 10){
            descontoFixo = 0.20;
        }
        return descontoFixo;
    }
    
}
