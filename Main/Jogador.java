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
        Mao m = new Mao();
        deque = new Deque();
    }

    //retorna deque
    public List<Carta> getDeque() {
        return deque.getDeque();
    }



    public void compraCarta()    {

    }

}
