package Main;

import Entidades.Baralho;
import Entidades.Deque;
import Entidades.Mao;

import java.util.ArrayList;
import java.util.List;

public class Jogador {
    Baralho baralho = new Baralho();

    private Deque deque;
    private Mao mao;

    public Jogador() {
        //pega deque criado pelo metodo
        deque = new Deque();
        Mao m = new Mao(deque);
    }

    //retorna deque
    public List<Carta> getDeque() {
        return deque.getDeque();
    }

    public Mao getMao() {
        return mao;
    }

}
