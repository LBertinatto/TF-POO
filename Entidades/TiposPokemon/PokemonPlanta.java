package Entidades.TiposPokemon;

import Entidades.Pokemon;
import Main.Enums.Elementos;
import Main.Enums.Raridade;

public class PokemonPlanta extends Pokemon {

    public PokemonPlanta(String nome, Raridade raridade) {
        super(nome, raridade, Elementos.PLANTA);
    }

    /*
     agua > pedra
agua > fogo
agua < planta
agua < ar
fogo > pedra
fogo < agua
fogo > planta
fogo < ar
planta > agua
planta < fogo
planta < pedra
planta > ar
ar < pedra
ar > agua
ar > fogo
ar < planta
pedra > planta
pedra < fogo
pedra > ar
pedra < agua
     */

    @Override
    public void atacar(Pokemon p){
        if(p.getElemento()==Elementos.FOGO || p.getElemento()==Elementos.PEDRA) p.recebeAtaque(this.getAttackPoints()*0.8);
        else p.recebeAtaque(this.getAttackPoints()*1.2);
    }
}