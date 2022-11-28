package Entidades;
import Main.*;
import Main.Enums.Raridade;

public class Treinador extends Carta {
    
    private String descricao;
    private int tipo;

    public Treinador(String nome, int tipo) {
        super(nome);
        this.tipo=tipo;
        descricao = setDescricao();
    }

    public String setDescricao() {
        if (tipo==1) return  "Recupera o HP completo do Pokemon";
        if (tipo==2) return  "Aumenta em 25% o dano do Pokemon";
        if (tipo==3) return  "Recupera o último pokemon morto";
        return "Evolui o pokemon";
    }

    public void aplicaBuff(Jogador jogador) {
        Pokemon pokemon = jogador.getPokemonAtivo();
        if (tipo==1) pokemon.setVida(pokemon.getMaxVida());
        if (tipo==2) pokemon.attackPointsBuff();
        if (tipo==3) jogador.ressucitaPokemon();
        if (tipo==4) jogador.evoluiPokemon();
    }

    @Override
    public String toString() {
        return "Treinador " + getNome() + " - Habilidade: " +descricao;
    }
}
