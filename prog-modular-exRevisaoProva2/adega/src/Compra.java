public class Compra {

    double freteFixo = 12;
    private Vinho[] itens;
    private int qtdItens = 0;
    private Cliente cliente;

    public Compra(Vinho[] itens, Cliente cliente) {
        this.itens = itens;
        this.qtdItens = itens.length;
        this.cliente = cliente;
    }

    public void adicionarVinhoNovo(Vinho vinho){
        Vinho[] novosItens = new Vinho[itens.length + 1];
        for(int i = 0; i < itens.length ; i++){
            novosItens[i] = itens[i];
        }
        novosItens[itens.length] = vinho;
        itens = novosItens;
        qtdItens++;
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
        freteFixo = cliente.calcularFrete(valorComDesconto);
        return freteFixo;
    }

    public double valorTotal(){
        double valorComDesconto = aplicarDesconto();
        double valorFrete = adicionarFreteCompra();
        double valorTotal = valorComDesconto + valorFrete;
        return valorTotal;
    }
}
