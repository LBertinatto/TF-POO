package Entidades;
import Main.Carta;
import Main.Enums.Raridade;
import Main.Enums.TipoEnergias;

public class Energia extends Carta{
    private int energyPoints;
    private TipoEnergias tipoenergia;

    public Energia(String nome, int energyPoints, TipoEnergias tipoEnergia, Raridade raridade) {
        super(nome, raridade);
        this.energyPoints = energyPoints;
        this.tipoenergia = tipoEnergia;
    }

    public int getEnergyPoints() {
        return energyPoints;
    }

    public void setEnergyPoints(int energyPoints) {
        this.energyPoints = energyPoints;
    }

    public TipoEnergias getTipoenergia() {
        return tipoenergia;
    }

    public void setTipoenergia(TipoEnergias tipoenergia) {
        this.tipoenergia = tipoenergia;
    }
    
    public void addEnergy(Energia e, Pokemon p){
       if(e.getTipoenergia() == TipoEnergias.VIDA){
        if(e.getRaridade() == Raridade.COMUM){
                p.setVida(p.getVida() + e.getEnergyPoints());
            }else if(e.getRaridade() == Raridade.RARO){
                p.setVida(p.getVida() + (int)(e.getEnergyPoints() * 1.5));
            }else{
                p.setVida(p.getVida() + (e.getEnergyPoints() * 2));
            }
       }else{
            if(e.getRaridade() == Raridade.COMUM){
                p.setAttackPoints(p.getAttackPoints() + e.getEnergyPoints());
            }else if(e.getRaridade() == Raridade.RARO){
                p.setAttackPoints(p.getAttackPoints() + (int)(e.getEnergyPoints() * 1.5));
            }else{
                p.setAttackPoints(p.getAttackPoints() + (e.getEnergyPoints() * 2));
        }
       }
    }

    
}
