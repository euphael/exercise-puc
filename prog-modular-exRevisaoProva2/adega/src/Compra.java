public class Compra {

    static final private double FRETE_FIXO = 12;
    private Vinho[] itens;
    private int qtdItens;
    private Cliente cliente = new Cliente();

    public Compra(Vinho[] itens, Cliente cliente) {
        this.itens = itens;
        this.qtdItens = itens.length;
        this.cliente = cliente;
    }

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


    private double aplicarDesconto(){
        double desconto = cliente.calcularDesconto();
        double valorSemDesconto = valorVinhos();
        double valorComDesconto = valorSemDesconto - (valorSemDesconto * desconto);
        return valorComDesconto;
    }

    private double adicionarFreteCompra(){
        double valorComDesconto = aplicarDesconto();
        double frete = cliente.calcularFrete(valorComDesconto);
        return frete;
    }
}
