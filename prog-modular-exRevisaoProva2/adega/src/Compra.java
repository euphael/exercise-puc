public class Compra {

    static final private double FRETE_FIXO = 12;
    static final private int QTD_DESCONTO = 10;
    private Vinho[] itens;
    private int qtdItens;

    private double valorVinhos(){

        double menor = itens[0].getPreco();
        double soma = 0;

        for(int i = 0; i < qtdItens; i++){
            soma += itens[i].getPreco();
            if(itens[i].getPreco() < menor){
                menor = itens[i].getPreco();
            }
        }

        if(qtdItens >= 10){
            soma = soma - menor;
        }
        return soma;
    }
    
}
