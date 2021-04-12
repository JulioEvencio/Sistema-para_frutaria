package servidor;

import frutas.Fruta;
import frutas.Frutaria;

public class Servidor {

    //public static Frutaria frutaria;
    private static Frutaria frutaria = new Frutaria();

    // Front -> Back
    public static void setFrutas(String nome, double valor, int quantidade) {
        frutaria.adicionarFruta(new Fruta(nome, valor,  quantidade));
    }
    
    //  Back -> Front
    public static String getArmazenamento() {
        String dados = frutaria.relatorioArmazenamento();
        return dados;
    }

}
