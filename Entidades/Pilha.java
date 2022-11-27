package Entidades;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

//classe destinada a controlar a pilha de pokemons mortos
public class Pilha {
    private List<Pokemon> lista = new ArrayList<>();

    public Pilha() {
    }

    public List<Pokemon> getLista() {
        return lista;
    }

    public void addPilha(Pokemon p) {
        lista.add(p);
    }

    //retira e retorna pokemon retirado
    public Pokemon retiraPilha(int i) {
        Pokemon pokemonRetirado = lista.get(i);
        lista.remove(i);
        return pokemonRetirado;
    }

}
