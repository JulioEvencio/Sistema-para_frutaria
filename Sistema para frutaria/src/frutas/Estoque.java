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

    public void armazenar(Fruta fruta) {
        Fruta frutaTemp = armazenado.get(fruta.getNome());
        if (frutaTemp != null) {
            fruta.setQuantidade(fruta.getQuantidade() + frutaTemp.getQuantidade());
        }
        guardar(fruta);
    }

    public boolean vender(ArrayList<Fruta> frutas) {
        for (Fruta fruta : frutas) {
            Fruta frutaTemp = armazenado.get(fruta.getNome());
            if (frutaTemp != null) {
                int sobraNoArmazem = frutaTemp.getQuantidade() - fruta.getQuantidade();
                if (sobraNoArmazem >= 0) {
                    frutaTemp.setQuantidade(sobraNoArmazem);
                    guardar(frutaTemp);
                    addVendidas(fruta);
                } else {
                        return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public void addVendidas(Fruta fruta) {
        Fruta frutaTemp = vendido.get(fruta.getNome());
        if (frutaTemp != null) {
            fruta.setQuantidade(fruta.getQuantidade() + frutaTemp.getQuantidade());
        }
        vendido.put(fruta.getNome(), fruta);
    }

}