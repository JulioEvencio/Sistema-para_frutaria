import java.util.ArrayList;

import frutas.Fruta;

public class Start {
    
    private ArrayList<Fruta> carrinho = new ArrayList<>();

    public ArrayList<Fruta> getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(ArrayList<Fruta> carrinho) {
        this.carrinho = carrinho;
    }
    public static void main(String args[]) {

        Start start = new Start();
        Frutaria frutaria = new Frutaria();
        frutaria.adicionarFruta(new Fruta("Banana", 5.00,  30));
        frutaria.adicionarFruta(new Fruta("Maçã", 2,  60));
        frutaria.adicionarFruta(new Fruta("Abacaxi", 8.00,  12));
        frutaria.verFrutas();

        frutaria.verRelatorio();
        start.carrinho.add(new Fruta("Banana", 5.00,  5));
        frutaria.vender(start.getCarrinho());
        frutaria.verRelatorio();

    }
}