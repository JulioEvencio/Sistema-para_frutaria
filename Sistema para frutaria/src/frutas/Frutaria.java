package frutas;

import java.util.ArrayList;

import frutas.*;

public class Frutaria {

    private Estoque estoque = new Estoque();

    public Frutaria() {}

    public void adicionarFruta(Fruta fruta) {
        estoque.armazenar(fruta);
    }

    public boolean vender(ArrayList<Fruta> frutas){
        return estoque.vender(frutas);
    }

    public String relatorioArmazenamento() {
        String dados = "Relatório de Frutas Armazenadas\n";;
        dados += "\n";
        for (Fruta fruta : estoque.getArmazenado().values()) {
            dados += "Fruta: " + fruta.getNome() + "\n";
            dados += "Valor: " + fruta.getValor() + " reais\n";
            dados += "Quantidade: " + fruta.getQuantidade() + "\n\n\n";
        }
        dados += "\n";

        return dados;
    }

    public String relatorioVendas() {
        String dados = "Relatório de Frutas Vendidas\n";
        double totalAtual = 0;
        double totalVendido = 0;
        if (estoque.getVendido().size() == 0){
            dados += "Nenhuma Fruta Vendida\n";
        }
        for (Fruta fruta : estoque.getVendido().values()) {
            totalAtual = fruta.getQuantidade() * fruta.getValor();
            totalVendido += totalAtual;
            dados += "Fruta: " + fruta.getNome() + "\n";
            dados += "Valor: " + fruta.getValor() + " reais\n";
            dados += "Quantidade: " + fruta.getQuantidade() + "\n";
            dados += "Valor Adquirido: " + totalAtual + " reais\n\n\n";
        }
        dados += "Total vendido pela frutaria: " + totalVendido + " reais\n";
        
        return dados;
    }

    public String verRelatorio() {

        String dados = "";
        dados += relatorioArmazenamento();
        dados += "-----------------\n\n";
        dados += relatorioVendas();
        return dados;
    }
}