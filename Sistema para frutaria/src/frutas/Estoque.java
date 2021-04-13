package frutas;

import java.util.ArrayList;
import java.util.HashMap;

public final class Estoque {

    private HashMap<String, Fruta> armazenado = new HashMap<String, Fruta>();
    private HashMap<String, Fruta> vendido = new HashMap<String, Fruta>();

    public HashMap<String, Fruta> getArmazenado() {
        return armazenado;
    }

    public void setArmazenado(HashMap<String, Fruta> armazenado) {
        this.armazenado = armazenado;
    }

    public HashMap<String, Fruta> getVendido() {
        return vendido;
    }

    public void setVendido(HashMap<String, Fruta> vendido) {
        this.vendido = vendido;
    }

    public void guardar(Fruta fruta){
        armazenado.put(fruta.getNome(), fruta);
    }

    // Serve para Adicionar uma fruta ou repor estoque
    public void armazenar(Fruta fruta) {
        Fruta frutaTemp = armazenado.get(fruta.getNome());
        if (frutaTemp != null) {
            fruta.setQuantidade(fruta.getQuantidade() + frutaTemp.getQuantidade());
        }
        guardar(fruta);
    }

    //  Adicionei retorno para saber se a operacao realizada com sucesso
    public boolean vender(ArrayList<Fruta> frutas) {
        for (Fruta fruta : frutas) {
            Fruta frutaTemp = armazenado.get(fruta.getNome());
            if (frutaTemp != null) {
                int sobraNoArmazem = frutaTemp.getQuantidade() - fruta.getQuantidade();
                if (sobraNoArmazem >= 0) {
                    frutaTemp.setQuantidade(sobraNoArmazem);
                    guardar(frutaTemp);
                    addVendidas(fruta);
                    System.out.println("");
                    System.out.println("Você comprou: " + fruta.getQuantidade() + " de " + fruta.getNome()
                            + " total de: " + fruta.getQuantidade() * fruta.getValor());
                    System.out.println("");
                } else {
                    System.out.println(
                            "Erro na compra: Não temos a quantidade desejada para a fruta: " + fruta.getNome());
                            return false;
                }
            } else {
                System.out.println("Erro na compra: Não existe a fruta: " + fruta.getNome());
                return false;
            }
        }
        return true;
    }

    // metodo para adicionar no hash que contem as frutas vendidas
    public void addVendidas(Fruta fruta) {
        Fruta frutaTemp = vendido.get(fruta.getNome());
        if (frutaTemp != null) {
            fruta.setQuantidade(fruta.getQuantidade() + frutaTemp.getQuantidade());
        }
        vendido.put(fruta.getNome(), fruta);
    }

}