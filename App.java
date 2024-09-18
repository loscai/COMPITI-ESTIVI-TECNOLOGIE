class App {
    public static void main(String[] args) {
        datiCondivisi dc = new datiCondivisi();

        Pilota[] piloti = {
                new Pilota(dc),
                new Pilota(dc),
                new Pilota(dc),
                new Pilota(dc),
                new Pilota(dc),
                new Pilota(dc),
                new Pilota(dc),
                new Pilota(dc),
                new Pilota(dc),
                new Pilota(dc),
                new Pilota(dc),
                new Pilota(dc),
                new Pilota(dc),
                new Pilota(dc),
                new Pilota(dc)
        };

        Statistica[] statistiche = new Statistica[15];
        int tTotale = 0;

        for (int i = 0; i < piloti.length; i++) {
            System.out.println("----------------------------------\nParte il pilota numero " + (i + 1)
                    + "\n----------------------------------");
            dc.iniziaGara(piloti[i]);
            piloti[i].start();

            try {
                piloti[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tTotale += piloti[i].getTempoTotale();

            statistiche[i] = new Statistica(piloti[i].getTempoTotale(), i);
        }


        for (int i = 0; i < piloti.length; i++) {
            System.out.println("Tempo pilota " + (i+1) + ": " + piloti[i].getTempoTotale());
        }

        for (int i = 0; i < statistiche.length; i++) {
            boolean flag = false;
            for (int j = 0; j < statistiche.length - 1; j++) {
                // Se l' elemento j e maggiore del successivo allora
                // scambiamo i valori
                if (statistiche[j].getTempo() > statistiche[j + 1].getTempo()) {
                    Statistica k = statistiche[j];
                    statistiche[j]= statistiche[j + 1];
                    statistiche[j + 1] = k;
                    flag = true; // Lo setto a true per indicare che é avvenuto uno scambio
                }
            }
            if (!flag)
                break;
        }

        for (int i = 0; i < statistiche.length; i++) {
            System.out.println((i + 1) + ")" + statistiche[i].toString());
        }
        System.out.println("Tempo totale: " + tTotale);
        System.out.println("Tempo medio = " + (tTotale/15));
    }
}