package Entidades;

import Main.Carta;

import java.util.ArrayList;
import java.util.List;

public class Deque {
    private ArrayList<Carta> deque;
    private Baralho baralho;

    public Deque() {
        baralho = new Baralho();
        deque = new ArrayList<>();
        for (int i=0; i<30; i++) deque.add(baralho.getBaralho().get(i));

    }

    public List<Carta> getDeque() {
        return deque;
    }

    //retira a carta do deque e retorna a carta retirada
    public Carta retiraCarta()    {
        Carta cartaRetirada = deque.get(deque.size()-1);
        deque.remove(deque.size());
        return cartaRetirada;
    }

}
