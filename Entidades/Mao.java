package Entidades;

import Main.Carta;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//classe responsavel por controlar a "mao" de cartas do jogador
public class Mao {
    private Deque deque;
    private List<Carta> mao;


    public Mao(Deque deque) {
        this.deque = deque;
        mao = new ArrayList<>();
        for (int i=0;i<7;i++) mao.add(deque.getDeque().get(i));
    }

    public List<Carta> getMao() {
        return mao;
    }

}
