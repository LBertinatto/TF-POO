package Main;

import Entidades.Baralho;

import java.util.ArrayList;
import java.util.List;

public class Jogador {
    Baralho baralho = new Baralho();
    private List<Carta> deque = new ArrayList<>();

    public Jogador() {
        //pega deque criado pelo metodo
        deque=baralho.criaDeque();
    }

    //retorna deque
    public List<Carta> getDeque() {
        return deque;
    }
}
