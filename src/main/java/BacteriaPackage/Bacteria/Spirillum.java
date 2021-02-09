package BacteriaPackage.Bacteria;

import BacteriaPackage.util.Position;

public class Spirillum extends Bacteria {
    public Spirillum(Position position) {

        super(position);
        lifeSpan=40;
        nearby=2;
        lifeTimeLeft=lifeSpan;
    }
}
