package Main;

import Entidades.Baralho;
import Entidades.Mao;

import java.util.ArrayList;
import java.util.List;

public class Jogador {
    Baralho baralho = new Baralho();
    Mao m = new Mao();
    private List<Carta> deque = new ArrayList<>();
    private List<Carta> mao = new ArrayList<>();

    public Jogador() {
        //pega deque criado pelo metodo
        deque=baralho.criaDeque();
    }

    //retorna deque
    public List<Carta> getDeque() {
        return deque;
    }

    public void criaMao()   {
        mao=m.setMao();
    }

    public void compraCarta()    {

    }

}
