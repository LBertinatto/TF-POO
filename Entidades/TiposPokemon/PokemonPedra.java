package Entidades.TiposPokemon;

import Entidades.Pokemon;
import Main.Enums.Raridade;

public class PokemonPedra extends Pokemon {

    public PokemonPedra(String nome, int vida, int attackPoints, Raridade raridade) {
        super(nome, vida, attackPoints, raridade);
    }
    
    /*
     * Tabela de danos - Tipo Pedra:
     * Agua e Planta: Ultra-Eficaz (2x)
     * Fogo e Ar: Fraco (0.5x)
     */

    @Override
    public int dano(Pokemon p){
        if(p instanceof PokemonPlanta || p instanceof PokemonAgua) return this.getAttackPoints() * 2;
        if (p instanceof PokemonFogo || p instanceof PokemonAr) return (int)(this.getAttackPoints() * 0.5);
        else return super.dano(p);
    }
}