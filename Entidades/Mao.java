package Entidades;

import Main.Carta;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

//classe responsavel por controlar a "mao" de cartas do jogador
public class Mao {
    private List<Carta> mao;

    public Mao() {
        mao = new ArrayList<>();

    }

    public void addCartaNaMao(Carta carta) {mao.add(carta);}

    public List<Carta> getMao() {
        return mao;
    }


    public Carta getCartaDaMao(String nome)    {
        return mao.stream().filter(p -> p.getNome().equals(nome)).collect(Collectors.toList()).get(0);
    }


}
