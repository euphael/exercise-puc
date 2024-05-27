import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Acomodacao {

    public static void main(String[] args) {

        List<String> lista;
    
        File file = new File("Acomodacao.txt");
    
        try (Scanner scanner = new Scanner(file)) {
            // First part: Inserting at the beginning
            while (true) {
                String linha = scanner.nextLine();
                if (linha.equals("FIM")) {
                    break;
                }
                lista.inserirInicio(linha);
            }
    
            // Second part: Processing commands
            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
    
                if (linha.startsWith("II")) {
                    lista.inserirInicio(linha);
                } else if (linha.startsWith("RF")) {
                    lista.removerFinal();
                    System.out.println("(R) " + lista.obterFinal());
                }
            }
    
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + e.getMessage());
        }
        lista.imprimirTodos();
    }

    private final int roomId;
    private final int hostId;
    private final String roomType;
    private final String propertyType;
    private final int reviews;
    private final int accommodates;
    private final String country;
    private final String city;
    private final String neighbourhood;
    private final Double overallSatisfaction;
    private final Double bedrooms;
    private final Double price;

    public Acomodacao(int roomId, int hostId, String roomType, String propertyType, int reviews, int accommodates,
            String country, String city, String neighbourhood, Double overallSatisfaction, Double bedrooms,
            Double price) {
        this.roomId = roomId;
        this.hostId = hostId;
        this.roomType = roomType;
        this.propertyType = propertyType;
        this.reviews = reviews;
        this.accommodates = accommodates;
        this.country = country;
        this.city = city;
        this.neighbourhood = neighbourhood;
        this.overallSatisfaction = overallSatisfaction;
        this.bedrooms = bedrooms;
        this.price = price;
    }

    public int getRoomId() {
        return roomId;
    }

    public int getHostId() {
        return hostId;
    }

    public String getRoomType() {
        return roomType;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public int getReviews() {
        return reviews;
    }

    public int getAccommodates() {
        return accommodates;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getNeighbourhood() {
        return neighbourhood;
    }

    public Double getOverallSatisfaction() {
        return overallSatisfaction;
    }

    public Double getBedrooms() {
        return bedrooms;
    }

    public Double getPrice() {
        return price;
    }

    public static List<Acomodacao> lista(String fileName) {
        List<Acomodacao> acomodacoesList = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split("\t");

                if (data.length == 12) {
                    int roomId = Integer.parseInt(data[0]);
                    int hostId = Integer.parseInt(data[1]);
                    String roomType = data[2];
                    String propertyType = data[3];
                    int reviews = Integer.parseInt(data[4]);
                    int accommodates = Integer.parseInt(data[5]);
                    String country = data[6];
                    String city = data[7];
                    String neighbourhood = data[8];
                    Double overallSatisfaction = Double.parseDouble(data[9]);
                    Double bedrooms = Double.parseDouble(data[10]);
                    Double price = Double.parseDouble(data[11]);

                    Acomodacao acomodacao = new Acomodacao(roomId, hostId, roomType, propertyType, reviews,
                            accommodates,
                            country, city, neighbourhood, overallSatisfaction, bedrooms, price);
                    acomodacoesList.add(acomodacao);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Arquivo não encontrado: " + fileName);
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.err.println("Erro ao converter número: " + e.getMessage());
            e.printStackTrace();
        }

        return acomodacoesList;
    }

    public void imprimir() {
        System.out.println("Room ID: " + roomId);
        System.out.println("Host ID: " + hostId);
        System.out.println("Room Type: " + roomType);
        System.out.println("Property Type: " + propertyType);
        System.out.println("Reviews: " + reviews);
        System.out.println("Accommodates: " + accommodates);
        System.out.println("Country: " + country);
        System.out.println("City: " + city);
        System.out.println("Neighbourhood: " + neighbourhood);
        System.out.println("Overall Satisfaction: " + overallSatisfaction);
        System.out.println("Bedrooms: " + bedrooms);
        System.out.println("Price: " + price);
    }

    public void inserirInicio (E item){
		inserir(item, 0);
	}

	public void removerFinal(){
		remover(tamanho-1);
	}

	public void imprimirTodos(){
		Celula<E> atual = this.primeiro.getProximo(); // começa do primeiro item
		while(atual != null){
			System.out.println(atual.getItem());
			atual = atual.getProximo();
		}
	}

	public E obterFinal(){
		if(vazia()){
			throw new IllegalStateException("lista vazia");
		}

		Celula<E> atual = this.primeiro;
		while(atual.getProximo() != null){
			atual = atual.getProximo();
		}
		return atual.getItem();

	}

	public int getTamanho(){
		return this.tamanho;
	}
}

