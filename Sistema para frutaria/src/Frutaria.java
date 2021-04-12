import java.util.ArrayList;

import frutas.*;

public class Frutaria {

    private Estoque estoque = new Estoque();

    public Frutaria() {
        System.out.println("Frutaria aberta");
    }

    public void adicionarFruta(Fruta fruta) {
        estoque.armazenar(fruta);
    }

    public void verFrutas() {
        System.out.println("");
        System.out.println("Frutas Disponíveis");
        System.out.println("");
        for (Fruta fruta : estoque.getArmazenado().values()) {
            System.out.println("Fruta: " + fruta.getNome());
            System.out.println("Valor: " + fruta.getValor() + " reais");
            System.out.println("Quantidade: " + fruta.getQuantidade());
        }
    }

    public void vender(ArrayList<Fruta> frutas){
        estoque.vender(frutas);
    }

    public void relatorioArmazenamento() {
        System.out.println("");
        System.out.println("Relatório de Frutas Armazenadas");
        System.out.println("");
        for (Fruta fruta : estoque.getArmazenado().values()) {
            System.out.println("Fruta: " + fruta.getNome());
            System.out.println("Valor: " + fruta.getValor() + " reais");
            System.out.println("Quantidade: " + fruta.getQuantidade());
        }
        System.out.println("");
    }

    public void relatorioVendas() {
        System.out.println("");
        double totalAtual = 0;
        double totalVendido = 0;
        System.out.println("Relatório de Frutas Vendidas");
        System.out.println("");
        if (estoque.getVendido().size() == 0){
            System.out.println("Nenhuma Fruta Vendida");
            System.out.println("");
        }
        for (Fruta fruta : estoque.getVendido().values()) {
            System.out.println("Fruta: " + fruta.getNome());
            System.out.println("Valor: " + fruta.getValor() + " reais");
            System.out.println("Quantidade: " + fruta.getQuantidade());
            totalAtual = fruta.getQuantidade() * fruta.getValor();
            System.out.println("Valor Adquirido: " + totalAtual + " reais");
            totalVendido += totalAtual;
        }
        System.out.println("Total vendido pela frutaria: " + totalVendido + " reais");
        System.out.println("");
    }

    public void verRelatorio() {

        relatorioArmazenamento();
        System.out.println("-----------------");
        relatorioVendas();
    }
}