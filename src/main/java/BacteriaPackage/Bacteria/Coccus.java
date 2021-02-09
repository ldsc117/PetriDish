package BacteriaPackage.Bacteria;

import BacteriaPackage.util.Position;

public class Coccus extends Bacteria {
    public Coccus(Position position) {

        super(position);
        lifeSpan=100;
        nearby=1;
        lifeTimeLeft=lifeSpan;
    }
}
