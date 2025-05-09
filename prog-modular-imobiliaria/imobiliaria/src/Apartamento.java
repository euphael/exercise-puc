public class Apartamento extends Imovel {
    private double taxaCondominio;

    @Override 
    public double calcularValorInicial(){
        double valorAluguel = this.valorVenda * 0.04; 
        return valorAluguel + taxaCondominio; 
    } 

    @Override
    public double calcularDesconto(){
        int qntAno = 2025 - this.anoConstrucao;
        int aux = qntAno / 5;
        int desconto = aux * 5;

        if(desconto > 30){
            desconto = 30;
        }

        return desconto; 
    }

}