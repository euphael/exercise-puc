public class Cliente {

    protected double descontoFixo;
    protected double frete = 12;
    int totalCompras;
    protected Compra[] compras = new Compra[totalCompras];


    public double calcularDesconto(){
        return 0;
    }

    public double calcularFrete(double valorCompra){
        if(valorCompra <= 100){
            frete = 10;
        }
        return frete;
    }
}
