import java.util.Random;

public class datiCondivisi {
    Pilota[] circuito;
    Pilota pAttuale;
    Random r;

    public datiCondivisi() {
        this.circuito = new Pilota[8];
    }

    void iniziaGara(Pilota p) {
        this.pAttuale = p;
        circuito[0] = p;
        this.r = new Random();

        stampaVettore();
    }

    int calcolaTempo() {
        // entro se si trova in un rettilineo (indice pari)
        if (pAttuale.getIndiceRettilineo() % 2 == 0) {
            return r.nextInt(pAttuale.gettMinRettilineo(), pAttuale.gettMaxREttilineo());
        }
        // entro se si trova in una curva (indice dispari)
        else {
            return r.nextInt(pAttuale.gettMinCurva(), pAttuale.gettMaxCurva());
        }
    }

    boolean prosegui() {
        /*
         * se ritorno false la gara è terminata
         */
        if (pAttuale.getIndiceRettilineo() < 7) {


            pAttuale.setIndiceRettilineo(pAttuale.getIndiceRettilineo() + 1);
            circuito[pAttuale.getIndiceRettilineo()] = pAttuale;
            circuito[pAttuale.getIndiceRettilineo()-1] = null;

            stampaVettore();
            return true;
        }

        for (int i = 0; i < circuito.length; i++) {
            circuito[i] = null;
        }
        return false;

    }

    void stampaVettore() {
        String s = "";
        for (int i = 0; i < circuito.length; i++) {
            if (circuito[i] == null)
                s += " v ";
            else
                s += " p ";
        }
        System.out.println(s);
    }
}