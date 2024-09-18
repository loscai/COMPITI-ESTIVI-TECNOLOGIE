public class Statistica {
    private int tempo;

    private int nPilota;

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public int getnPilota() {
        return nPilota;
    }

    public void setnPilota(int nPilota) {
        this.nPilota = nPilota;
    }

    public Statistica(int tempo, int nPilota){
        this.tempo = tempo;
        this.nPilota = nPilota;
    }

    @Override
    public String toString() {
        return "pilota n" + (getnPilota()+1) + " - Tempo: " + getTempo();
    }

}
