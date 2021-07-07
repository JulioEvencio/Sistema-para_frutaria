/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema;

import produto.Produto;
import java.util.HashMap;

/**
 *
 * @author julio
 */
public class Sistema {

    private static final HashMap<String, Produto> lista = new HashMap<>();

    public static Produto[] getProdutos() {

        if (lista.isEmpty()) return null;

        int i = 0;
        Produto[] produto = new Produto[lista.size()];

        for (String chave: lista.keySet()) {
            produto[i] = lista.get(chave);
            i++;
        }

        return produto;

    }

    public static void adicionarProduto(String nome, int quantidade, double preco) throws ChaveInvalidaException {

        if (lista.containsKey(nome)) throw new ChaveInvalidaException();

        lista.put(nome, new Produto(nome, quantidade, preco));

    }

    public static void alterarProduto(String nome, int quantidade, double preco) throws ChaveInvalidaException {

        if (!lista.containsKey(nome)) throw new ChaveInvalidaException();

        lista.put(nome, new Produto(nome, quantidade, preco));

    }

    public static void removerProduto(String nome) throws ChaveInvalidaException {

        if (!lista.containsKey(nome)) throw new ChaveInvalidaException();

        lista.remove(nome);

    }

}
