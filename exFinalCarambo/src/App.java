import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class App {

    private HashMap<String, Automovel> automovel = new HashMap<>();
    private List<Roteiro> roteiros = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }

    public double RetornarMediaKmRoteiros(){
        return roteiros.stream()
                        .mapToDouble(Roteiro::getKm)
                        .average()
                        .orElse(0.0);
    }

    public Automovel RealizouMaiorQtdRoteiros(){
        return automovel.values().stream()
                        .max((a1, a2) -> Integer.compare(a1.getRoteiros(), a2.getRoteiros()))
                        .orElse(null);
    }

    public Automovel PercorreuMaiorQtdKm() {
        return automovel.values().stream()
            .max((a1, a2) -> {
                double km1 = a1.getRoteiros().stream()
                                .mapToDouble(Roteiro::getKm).sum();
                double km2 = a2.getRoteiros().stream()
                                .mapToDouble(Roteiro::getKm).sum();
                return Double.compare(km1, km2);
            })
            .orElse(null);
    }

    public Integer QuantosPercorreuMaisKm(Automovel automovelInf){
        int kmInf = automovelInf.kmPercorridos();
            return (int) automovel.values().stream()
                    .filter(a -> a.kmPercorridos() > kmInf)
                    .count();         
    }

    public List<Automovel> QuaisPercorreramMaisKm(Automovel automovelInf){
        int kmInf = automovelInf.kmPercorridos();
        List<Automovel> automoveisMaisKm;
            return automovel.values().stream()
                    .filter(a -> a.kmPercorridos() > kmInf)
                    .collect(Collectors.toList());
    }

    public List<String> relatorioPlacasKmDecrescente() {
        return automovel.values().stream()
                .sorted((a1, a2) -> Integer.compare(a2.kmPercorridos(), a1.kmPercorridos()))
                .map(a -> a.getPlaca() + " - " + a.kmPercorridos() + " km")
                .collect(Collectors.toList());
    }
}
