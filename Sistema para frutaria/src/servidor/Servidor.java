package servidor;

import frutas.Fruta;
import frutas.Frutaria;
import java.util.ArrayList;

public class Servidor {

    //public static Frutaria frutaria;
    private static Frutaria frutaria = new Frutaria();

    // Front -> Back
    /*
    *   Pega dados do usuario/interface e manda para o estoque
    */
    public static void setFrutas(String nome, double valor, int quantidade) {
        frutaria.adicionarFruta(new Fruta(nome, valor,  quantidade));
    }
    
    public static boolean setVender(String nome, int quantidade) {
        ArrayList<Fruta> carrinho = new ArrayList<>();
        carrinho.add(new Fruta(nome, 0.0,  quantidade));
        return frutaria.vender(carrinho);
    }
    
    //  Back -> Front
    /*
    *   Pega dados do estoque e manda para  o usuario/interface
    */
    public static String getArmazenamento() {
        String dados = frutaria.relatorioArmazenamento();
        return dados;
    }

}
