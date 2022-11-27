package Entidades;

import Main.Carta;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//classe responsavel por controlar a "mao" de cartas do jogador
public class Mao {
    private Deque deque;
    private List<Carta> mao;
    private Pokemon ativo;
    private List<Carta> reserva=new ArrayList<>();


    public Mao(Deque deque) {
        this.deque = deque;
        mao = new ArrayList<>();
        for (int i=0;i<7;i++) mao.add(deque.getDeque().get(i));
    }

    public List<Carta> getMao() {
        return mao;
    }

    //compra carta pelo metodo retira carta do deque
    public void compraCarta()    {
        mao.add(deque.retiraCarta());
    }

    //a partir do index ele ativa um pokemon especifico
    public void pokemonAtivo(int i) {
        if (mao.get(i).getClass().equals("Pokemon")) ativo = (Pokemon) mao.get(i);
        else {
            throw new IllegalArgumentException("A carta selecionada não é um pokemon.");
        }
    }

    public void addReserva(Carta carta)    {
        reserva.add(carta);
    }

    //retira carta da reserva e retorna a retirada
    public Carta tiraReserva(int i)    {
        Carta retirada = reserva.get(i);
        reserva.remove(reserva.get(i));
        return retirada;
    }

}
