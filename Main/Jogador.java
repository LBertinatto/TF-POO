package Main;

import Entidades.Baralho;
import Entidades.Deque;
import Entidades.Mao;
import Entidades.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class Jogador {
    private Baralho baralho;
    private Pokemon pokemonAtivo;
    private Deque deque;
    private Mao mao;

    public Jogador() {
        //pega deque criado pelo metodo
        deque = new Deque();
        Mao m = new Mao(deque);
        baralho  = new Baralho();
    }

    //retorna deque
    public List<Carta> getDeque() {
        return deque.getDeque();
    }

    public Mao getMao() {
        return mao;
    }

}
