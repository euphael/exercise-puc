import java.util.List;

public class Main {
    public static void main(String[] args) {
        String fileName = "teste.txt";

        List<Acomodacao> acomodacoes = Acomodacao.lerDoArquivo(fileName);

        if (acomodacoes.size() == 0) {
            System.out.println("Arquivo não encontrado: " + fileName);
        } else {
            for (Acomodacao acomodacao : acomodacoes) {
                acomodacao.imprimir();
                System.out.println("asd"); // Adiciona uma linha em branco entre as acomodações
            }
        }

    }
}
