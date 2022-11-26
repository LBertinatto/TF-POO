package Entidades;

import Main.*;
import Main.Enums.Raridade;
import Entidades.TiposPokemon.PokemonAgua;
import Entidades.TiposPokemon.PokemonFogo;
import Entidades.TiposPokemon.PokemonAr;
import Entidades.TiposPokemon.PokemonPedra;
import Entidades.TiposPokemon.PokemonPlanta;


import java.util.*;

//classe responsavel por criar o baralho geral
public class Baralho {
    private final List<Carta> baralho = new ArrayList<>();
    private List<Carta> baralhoAux = new ArrayList<>();
    private List<Carta> deque = new ArrayList<>();

    public void criaBaralho()  {
        //todos os pokemons tipo agua: 5comum 3raro 1lendario
        baralho.add(new PokemonAgua("Popplio", Raridade.COMUM));
        baralho.add(new PokemonAgua("Magikarp", Raridade.COMUM));
        baralho.add(new PokemonAgua("Psyduck", Raridade.COMUM));
        baralho.add(new PokemonAgua("Phione", Raridade.COMUM));
        baralho.add(new PokemonAgua("Tapu Fini", Raridade.COMUM));
        baralho.add(new PokemonAgua("Blastoise", Raridade.RARO));
        baralho.add(new PokemonAgua("Glaceon", Raridade.RARO));
        baralho.add(new PokemonAgua("Vaporeon", Raridade.RARO));
        baralho.add(new PokemonAgua("BlastoiseVMax", Raridade.LENDARIO));

        //todos os pokemons tipo ar: 5comum 3raro 1lendario
        baralho.add(new PokemonAr("Pidgey", Raridade.COMUM));
        baralho.add(new PokemonAr("Butterfree", Raridade.COMUM));
        baralho.add(new PokemonAr("Spearow", Raridade.COMUM));
        baralho.add(new PokemonAr("Zubat", Raridade.COMUM));
        baralho.add(new PokemonAr("Doduo", Raridade.COMUM));
        baralho.add(new PokemonAr("Aerodactyl", Raridade.RARO));
        baralho.add(new PokemonAr("Pidgeot", Raridade.RARO));
        baralho.add(new PokemonAr("Fearow", Raridade.RARO));
        baralho.add(new PokemonAr("Lugia", Raridade.LENDARIO));

        //todos os pokemons tipo fogo: 5comum 3raro 1lendario
        baralho.add(new PokemonFogo("Charmander", Raridade.COMUM));
        baralho.add(new PokemonFogo("Litten", Raridade.COMUM));
        baralho.add(new PokemonFogo("Turtonator", Raridade.COMUM));
        baralho.add(new PokemonFogo("Salandit", Raridade.COMUM));
        baralho.add(new PokemonFogo("Victini", Raridade.COMUM));
        baralho.add(new PokemonFogo("Flareon", Raridade.RARO));
        baralho.add(new PokemonFogo("Marowak", Raridade.RARO));
        baralho.add(new PokemonFogo("Charizard", Raridade.RARO));
        baralho.add(new PokemonFogo("Blaziken", Raridade.LENDARIO));

        //todos os pokemons tipo pedra: 5comum 3raro 1lendario
        baralho.add(new PokemonPedra("Geodude", Raridade.COMUM));
        baralho.add(new PokemonPedra("Aron", Raridade.COMUM));
        baralho.add(new PokemonPedra("Nosepass", Raridade.COMUM));
        baralho.add(new PokemonPedra("Rhyhorn", Raridade.COMUM));
        baralho.add(new PokemonPedra("Sudowoodo", Raridade.COMUM));
        baralho.add(new PokemonPedra("Onix", Raridade.RARO));
        baralho.add(new PokemonPedra("Golem", Raridade.RARO));
        baralho.add(new PokemonPedra("Graveler", Raridade.RARO));
        baralho.add(new PokemonPedra("Regirock", Raridade.LENDARIO));

        //todos os pokemons tipo planta: 5comum 3raro 1lendario
        baralho.add(new PokemonPlanta("Rowlet", Raridade.COMUM));
        baralho.add(new PokemonPlanta("Bulbasaur", Raridade.COMUM));
        baralho.add(new PokemonPlanta("Wimpod", Raridade.COMUM));
        baralho.add(new PokemonPlanta("Pheromosa", Raridade.COMUM));
        baralho.add(new PokemonPlanta("Scyther", Raridade.COMUM));
        baralho.add(new PokemonPlanta("Tapu Bulu", Raridade.RARO));
        baralho.add(new PokemonPlanta("Lurantis", Raridade.RARO));
        baralho.add(new PokemonPlanta("Tsareena", Raridade.RARO));
        baralho.add(new PokemonPlanta("Orbeetle", Raridade.LENDARIO));

        //cartas treinadores
        baralho.add(new Treinador("Spark",1));
        baralho.add(new Treinador("Professor Nogueira",2));
        baralho.add(new Treinador("Professora Bruna", 3));
        baralho.add(new Treinador("Cintia",4));

        //embaralhar cartas
        Collections.shuffle(baralho);
    }

    public void imprimeBaralho()    {
        for (Carta c : baralho)   {
            System.out.println(c.getNome());
        }
    }

    public List<Carta> criaDeque() {
        criaBaralho();
        Random random = new Random();

            //criar baralho auxiliar para evitar repetições
            baralhoAux.addAll(baralho);

            //criar deque com 30 cartas
            for (int i = 0; i < 30; i++) {
                int randomIndex = random.nextInt(baralhoAux.size());
                Carta randomCarta = baralhoAux.get(randomIndex);
                //adiciona carta aleatoria no deque
                deque.add(randomCarta);
                //evita repetição de cartas
                baralhoAux.remove(randomIndex);
        }

        //retorna lista pra poder ser usado na classe Jogador
        return deque;
    }

}
