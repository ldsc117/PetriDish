package BacteriaPackage.Bacteria;

import BacteriaPackage.util.Position;

public class Bacteria {
    private Position position;
    protected int lifeSpan;
    protected int lifeTimeLeft;
    protected int nearby;

    public Bacteria(Position position){
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public int getLifeTimeLeft() {
        return lifeTimeLeft;
    }

    public int getNearby() {
        return nearby;
    }
    public void timePass(){this.lifeTimeLeft-=1;}

    public void cannotLive(){this.lifeTimeLeft=0;}

    public boolean isDead(){
        if(lifeTimeLeft<=0){return true;}
        return false;
    }

}
