package Main;

public abstract class Carta {
    private String nome;


    public Carta(String nome) {
        this.nome=nome;
    }
    
    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return nome;
    }
}
