import java.util.Random;

public class Pilota extends Thread {
    private int indiceRettilineo;

    public void setIndiceRettilineo(int indiceRettilineo) {
        this.indiceRettilineo = indiceRettilineo;
    }

    private int tempoTotale;

    public void setTempoTotale(int tempoTotale) {
        this.tempoTotale = tempoTotale;
    }

    public int getTempoTotale() {
        return tempoTotale;
    }

    public int getIndiceRettilineo() {
        return indiceRettilineo;
    }

    datiCondivisi dc;

    private int skillRettilineo;
    private int skillCurva;

    private int tMinRettilineo;
    private int tMaxREttilineo;
    private int tMinCurva;
    private int tMaxCurva;

    public Pilota(){

    }

    public Pilota(datiCondivisi dc) {
        this.dc = dc;

        this.indiceRettilineo = 0;

        this.tempoTotale = 0;

        this.skillRettilineo = r.nextInt(1, 10);
        this.skillCurva = r.nextInt(1, 10);

        this.tMinRettilineo = 2000 / this.skillRettilineo - 50;
        this.tMaxREttilineo = 2000 / this.skillRettilineo + 400;
        this.tMinCurva = 2000 / this.skillCurva - 50;
        this.tMaxCurva = 2000 / this.skillCurva + 400;

    }

    public int getSkillRettilineo() {
        return skillRettilineo;
    }

    public int getSkillCurva() {
        return skillCurva;
    }

    public int gettMinRettilineo() {
        return tMinRettilineo;
    }

    public int gettMaxREttilineo() {
        return tMaxREttilineo;
    }

    public int gettMinCurva() {
        return tMinCurva;
    }

    public int gettMaxCurva() {
        return tMaxCurva;
    }

    Random r = new Random();

    @Override
    public void run() {
        while (true) {
            int tAttuale = getTempoTotale();
            int tCalcolato = dc.calcolaTempo();
            setTempoTotale(tAttuale+tCalcolato);
            
            if(!dc.prosegui()){
                break;
            }
        }
    }
}