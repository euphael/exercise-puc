import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Acomodacao {

    private int roomId;
    private int hostId;
    private String roomType;
    private String country;
    private String city;
    private String neighbourhood;
    private int reviews;
    private double overallSatisfaction;
    private int accommodates;
    private double bedrooms;
    private double price;
    private String propertyType;

    public Acomodacao(int roomId, int hostId, String roomType, String country, String city, String neighbourhood,
            int reviews, double overallSatisfaction, int accommodates, double bedrooms, double price,
            String propertyType) {
        this.roomId = roomId;
        this.hostId = hostId;
        this.roomType = roomType;
        this.country = country;
        this.city = city;
        this.neighbourhood = neighbourhood;
        this.reviews = reviews;
        this.overallSatisfaction = overallSatisfaction;
        this.accommodates = accommodates;
        this.bedrooms = bedrooms;
        this.price = price;
        this.propertyType = propertyType;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getHostId() {
        return hostId;
    }

    public void setHostId(int hostId) {
        this.hostId = hostId;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNeighbourhood() {
        return neighbourhood;
    }

    public void setNeighbourhood(String neighbourhood) {
        this.neighbourhood = neighbourhood;
    }

    public int getReviews() {
        return reviews;
    }

    public void setReviews(int reviews) {
        this.reviews = reviews;
    }

    public double getOverallSatisfaction() {
        return overallSatisfaction;
    }

    public void setOverallSatisfaction(double overallSatisfaction) {
        this.overallSatisfaction = overallSatisfaction;
    }

    public int getAccommodates() {
        return accommodates;
    }

    public void setAccommodates(int accommodates) {
        this.accommodates = accommodates;
    }

    public double getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(double bedrooms) {
        this.bedrooms = bedrooms;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public static Acomodacao ler() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("/tmp/dados_airbnb.txt"));
            String line;
            reader.readLine(); // Ignorar a primeira linha
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\t");
                int roomId = Integer.parseInt(parts[0]);
                int hostId = Integer.parseInt(parts[1]);
                String roomType = parts[2];
                String country = parts[3];
                String city = parts[4];
                String neighbourhood = parts[5];
                int reviews = Integer.parseInt(parts[6]);
                double overallSatisfaction = Double.parseDouble(parts[7]);
                int accommodates = Integer.parseInt(parts[8]);
                double bedrooms = Double.parseDouble(parts[9]);
                double price = Double.parseDouble(parts[10]);
                String propertyType = parts[11];
                return new Acomodacao(roomId, hostId, roomType, country, city, neighbourhood, reviews,
                        overallSatisfaction, accommodates, bedrooms, price, propertyType);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Acomodacao clone() {
        return new Acomodacao(roomId, hostId, roomType, country, city, neighbourhood, reviews, overallSatisfaction,
                accommodates, bedrooms, price, propertyType);
    }

    public static void main(String[] args) {
        // Contar o número de linhas no arquivo
        int numLinhas = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader("/tmp/dados_airbnb.txt"))) {
            while (reader.readLine() != null) {
                numLinhas++;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        Acomodacao[] acomodacoes = new Acomodacao[numLinhas]; // Define o tamanho do vetor de acomodações

        // Carregar dados do arquivo para o array de acomodações
        int i = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader("/tmp/dados_airbnb.txt"))) {
            String line;
            reader.readLine(); // Ignorar a primeira linha
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\t");
                int roomId = Integer.parseInt(parts[0]);
                int hostId = Integer.parseInt(parts[1]);
                String roomType = parts[2];
                String country = parts[3];
                String city = parts[4];
                String neighbourhood = parts[5];
                int reviews = Integer.parseInt(parts[6]);
                double overallSatisfaction = Double.parseDouble(parts[7]);
                int accommodates = Integer.parseInt(parts[8]);
                double bedrooms = Double.parseDouble(parts[9]);
                double price = Double.parseDouble(parts[10]);
                String propertyType = parts[11];
                acomodacoes[i++] = new Acomodacao(roomId, hostId, roomType, country, city, neighbourhood, reviews,
                        overallSatisfaction, accommodates, bedrooms, price, propertyType);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Processar a entrada padrão
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        String id;
        while (!(id = scanner.nextLine()).equals("FIM")) {
            int idAcomodacao = Integer.parseInt(id);
            for (Acomodacao a : acomodacoes) {
                if (a != null && a.getRoomId() == idAcomodacao) {
                    a.imprimir();
                    break;
                }
            }
        }
        scanner.close();
    }

    public void imprimir() {
        System.out.println("[" + roomId + " ## " + hostId + " ## " + roomType + " ## " + country + " ## " + city
                + " ## " + neighbourhood + " ## " + reviews + " ## " + overallSatisfaction + " ## " + accommodates
                + " ## " + bedrooms + " ## " + price + " ## " + propertyType + "]");
    }
}
