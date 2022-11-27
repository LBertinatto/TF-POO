package Entidades;

import Main.Carta;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//classe responsavel por controlar a "mao" de cartas do jogador
public class Mao {
    Baralho baralho = new Baralho();
    private List<Carta> mao = new ArrayList<>();
    private List<Carta> deque = new ArrayList<>();
    Random random = new Random();

    public Mao() {
        deque=baralho.criaDeque();
    }

    public List<Carta> getMao() {
        return mao;
    }
    public List<Carta> setMao() {
        //cria mao de cartas com 7 cartas aleatorias do deque
        for (int i = 0; i < 7; i++) {
            int randomIndex = random.nextInt(deque.size());
            Carta randomCarta = deque.get(randomIndex);
            //adiciona carta aleatoria no deque
            mao.add(randomCarta);
            //evita repetição de cartas
            deque.remove(randomIndex);
        }
        return mao;
    }
}
