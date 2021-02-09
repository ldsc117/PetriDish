package BacteriaPackage.Bacteria;

import BacteriaPackage.util.Position;

public class Bacillus extends Bacteria {
    public Bacillus(Position position) {
        super(position);
        lifeSpan=10;
        nearby=3;
        lifeTimeLeft=lifeSpan;
    }
}
