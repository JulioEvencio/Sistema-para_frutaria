package gerenciamento;

import frutas.Fruta;
import frutas.Frutaria;
import java.util.ArrayList;

public class Gerenciador {

    private static Frutaria frutaria = new Frutaria();

    public static void setFrutas(String nome, double valor, int quantidade) {
        frutaria.adicionarFruta(new Fruta(nome, valor,  quantidade));
    }
    
    public static boolean setVender(String nome, int quantidade) {
        ArrayList<Fruta> carrinho = new ArrayList<>();
        carrinho.add(new Fruta(nome, 0.0,  quantidade));
        return frutaria.vender(carrinho);
    }
    
    public static String getArmazenamento() {
        String dados = frutaria.verRelatorio();
        return dados;
    }

}
