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
        for (int i=0; i<15; i++) deque.add(baralho.getPokemon().get(i));
        for (int i=0; i<15; i++) deque.add(baralho.getBaralho().get(i));

    }

    public List<Carta> getDeque() {
        return deque;
    }
}
