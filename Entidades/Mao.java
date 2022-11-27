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
        Carta carta = mao.stream().filter(p -> p.getNome().equals(nome)).toList().get(0);
        mao.remove(carta);
        return carta;
    }

    @Override
    public String toString() {
        StringBuilder line = new StringBuilder();
        mao.forEach(p -> line.append(p.toString()+ "\n"));
        return line.toString();
    }
}
