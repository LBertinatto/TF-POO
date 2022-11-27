package Main;

import Entidades.*;
import Main.Enums.Raridade;

import java.util.List;

public class Jogador {
    private String nome;
    private Baralho baralho;
    private Pokemon pokemonAtivo;
    private Deque deque;
    private Mao mao;
    private Reserva reserva;
    private Pilha pilha;
    private Jogador inimigo;
    private int pokemonVivos;

    public Jogador(String nome) {
        //pega deque criado pelo metodo
        deque = new Deque();
        mao = new Mao();
        baralho  = new Baralho();
        reserva = new Reserva();
        pilha = new Pilha();
        this.nome = nome;
        getMaoInicial();
    }

    private void getMaoInicial() {
        for (int i=0;i<7;i++) mao.addCartaNaMao(deque.retiraCarta());
    }
    public void checkPokeVivos() {
        pokemonVivos = reserva.getReserva().size()+1;
        if (pokemonAtivo.checkDeath()) {
            pilha.addPilha(pokemonAtivo);
            pokemonAtivo = null;
            pokemonVivos--;
        }

    }
    public int getPokemonVivos() {
        checkPokeVivos();
        return pokemonVivos;
    }

    public void addPokeNaReserva(String nomePoke) {
        reserva.addReserva((Pokemon) mao.getCartaDaMao(nomePoke));
    }

    public void trocaPokeNaReserva(String antigo, String novo) {
        Pokemon pokeNovo = (Pokemon) mao.getCartaDaMao(novo);
        reserva.trocaReservaMao(antigo,pokeNovo);
    }
    public void trocaPokeAtivo(String nomePoke) {
        pokemonAtivo = reserva.trocaReservaPrincipal(nomePoke, pokemonAtivo);
    }
    public void trocaAtivoMorto(String nomePoke) {
        pokemonAtivo = reserva.trocaPokemonMorto(nomePoke);
    }

    public void usarTreinador(String nome) {
        Treinador treinador = (Treinador) mao.getCartaDaMao(nome);
        treinador.aplicaBuff(this);
        mao.getCartaDaMao(nome);
    }

    public void atacar(Jogador inimigo) {
        pokemonAtivo.atacar(inimigo.pokemonAtivo);
    }

    public void comprarCarta() {
        mao.addCartaNaMao(deque.retiraCarta());
    }

    //retorna deque
    public List<Carta> getDeque() {
        return deque.getDeque();
    }

    public Mao getMao() {
        return mao;
    }


    public Pokemon getPokemonAtivo() {return pokemonAtivo;}

    public void pokemonMorte(String nome) {
        pilha.addPilha(pokemonAtivo);
        pokemonAtivo = reserva.trocaPokemonMorto(nome);
    }
    public Pokemon ressucitaPokemon() {
        return pilha.retiraPilha();
    }

    public void evoluiPokemon() {
        if (pokemonAtivo.getRaridade()== Raridade.COMUM) pokemonAtivo.setRaridade(Raridade.RARO);
        else if (pokemonAtivo.getRaridade()== Raridade.RARO) pokemonAtivo.setRaridade(Raridade.LENDARIO);
        else System.out.println("Pokemon já é lendário");

    }

    public Baralho getBaralho() {
        return baralho;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public Pilha getPilha() {
        return pilha;
    }

    public Jogador getInimigo() {
        return inimigo;
    }

    public void setInimigo(Jogador inimigo) {
        this.inimigo = inimigo;
    }

    public String getNome() {
        return nome;
    }

    public String pokemonAtivoString() {
        return pokemonAtivo.getNome() + " " + pokemonAtivo.getVida() + " " + pokemonAtivo.getElemento() + " " + pokemonAtivo.getRaridade();
    }
}
