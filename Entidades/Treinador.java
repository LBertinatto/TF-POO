package Entidades;
import Main.*;
import Main.Enums.Raridade;

public class Treinador extends Carta {
    
    private String descricao;
    private int tipo;

    public Treinador(String nome, int tipo) {
        super(nome);
        setDescricao();
        this.tipo=tipo;
    }
    
    public String getDescricao()    {
        return descricao;
    }
    
    public int getTipo()    {
        return tipo;
    }
    private void setDescricao() {
        if (tipo==1) this.descricao = "Recupera o HP completo do Pokemon";
        if (tipo==2) this.descricao = "Aumenta em 25% o dano do Pokemon";
        if (tipo==3) this.descricao = "Recupera o último pokemon morto";
        if (tipo==4) this.descricao = "Evolui o pokemon";

    }
}
