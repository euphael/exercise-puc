public class App {
    public static void main(String[] args) throws Exception {
        String str = "33321";
        boolean isVogais = VogaisRecursivo.verificaVogais(str);
        boolean isConsoantes = VogaisRecursivo.verificaConsoantes(str);
        boolean isNumeroInteiro = VogaisRecursivo.VerificaNumeroRecursivo.verificaNumero(str);
        boolean isNumeroReal = VogaisRecursivo.VerificaNumeroRealRecursivo.verificaNumeroReal(str);
        
        System.out.println(formatOutput(isVogais) + " " + formatOutput(isConsoantes) + " " + formatOutput(isNumeroInteiro) + " " + formatOutput(isNumeroReal));
    }

    private static String formatOutput(boolean value) {
        return value ? "SIM" : "NAO";
    }

    static class VogaisRecursivo {
        public static boolean verificaVogais(String str) {
            if (str.isEmpty()) {
                return true;
            }
            char firstChar = str.charAt(0);
            if (firstChar != 'a' && firstChar != 'e' && firstChar != 'i' && firstChar != 'o' && firstChar != 'u') {
                return false;
            }
            return verificaVogais(str.substring(1));
        }

        public static boolean verificaConsoantes(String str) {
            str = str.toLowerCase();
            if (str.isEmpty()) {
                return true;
            }
            char firstChar = str.charAt(0);
            if (!(firstChar >= 'a' && firstChar <= 'z') ||
                    firstChar == 'a' || firstChar == 'e' || firstChar == 'i' || firstChar == 'o' || firstChar == 'u') {
                return false;
            }
            return verificaConsoantes(str.substring(1));
        }

        public static class VerificaNumeroRecursivo {
            public static boolean verificaNumero(String str) {
                if (str.isEmpty()) {
                    return false;
                }
                return verificaNumeroAux(str, false);
            }

            private static boolean verificaNumeroAux(String str, boolean hasDecimal) {
                if (str.isEmpty()) {
                    return true;
                }
                char firstChar = str.charAt(0);
                if (!(firstChar >= '0' && firstChar <= '9') && firstChar != '.' && firstChar != '-') {
                    return false;
                }
                if (firstChar == '.') {
                    if (hasDecimal) {
                        return false;
                    }
                    return verificaNumeroAux(str.substring(1), true);
                }
                if (firstChar == '-' && str.length() > 1) {
                    return verificaNumeroAux(str.substring(1), hasDecimal);
                }
                return verificaNumeroAux(str.substring(1), hasDecimal);
            }
        }

        public static class VerificaNumeroRealRecursivo {

            public static boolean verificaNumeroReal(String str) {
                if (str.isEmpty()) {
                    return false;
                }

                return verificaNumeroRealAux(str, false);
            }

            private static boolean verificaNumeroRealAux(String str, boolean hasDecimal) {
                if (str.isEmpty()) {
                    return true;
                }

                char firstChar = str.charAt(0);
                if (!(firstChar >= '0' && firstChar <= '9') && firstChar != '.' && firstChar != '-') {
                    return false;
                }

                if (firstChar == '.') {
                    if (hasDecimal) {
                        return false;
                    }
                    return verificaNumeroRealAux(str.substring(1), true);
                }

                if (firstChar == '-' && str.length() > 1) {
                    return verificaNumeroRealAux(str.substring(1), hasDecimal);
                }

                return verificaNumeroRealAux(str.substring(1), hasDecimal);
            }
        }
    }
}
