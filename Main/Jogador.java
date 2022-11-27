package Main;

import Entidades.*;

import java.util.ArrayList;
import java.util.List;

public class Jogador {
    private Baralho baralho;
    private Pokemon pokemonAtivo;
    private Deque deque;
    private Mao mao;
    private Reserva reserva;
    private Pilha pilha;

    public Jogador() {
        deque = new Deque();
        Mao mao = new Mao();
        baralho  = new Baralho();
        reserva = new Reserva();
        pilha = new Pilha();
    }

    private void getMaoInicial() {
        for (int i=0;i<7;i++) mao.addCartaNaMao(deque.getDeque().get(i));
    }

    //retorna deque
    public List<Carta> getDeque() {
        return deque.getDeque();
    }

    public Mao getMao() {
        return mao;
    }



}
