package BacteriaPackage;

import BacteriaPackage.Bacteria.Bacillus;
import BacteriaPackage.Bacteria.Bacteria;
import BacteriaPackage.Bacteria.Coccus;
import BacteriaPackage.Bacteria.Spirillum;
import BacteriaPackage.util.Position;
import BacteriaPackage.util.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class Dish {

    private List<Bacteria> bacteria = new ArrayList<Bacteria>();
    private int timeUnit;

    public void timePulse(){
        timeUnit+=1;
        for(Bacteria element:bacteria){
            element.timePass();
            if(element.isDead()){reBirth(element);}
        }

    }
    public void reBirth(Bacteria bact){
        int nearby = bact.getNearby();
        int maxX = bact.getPosition().getX()+nearby;
        int minX = bact.getPosition().getX()-nearby;
        int maxY = bact.getPosition().getX()+nearby;
        int minY = bact.getPosition().getY()-nearby;
        int randomX = RandomUtils.getRANDOM().nextInt(maxX-minX)+minX;
        int randomY = RandomUtils.getRANDOM().nextInt(maxY-minY)+minY;
        Position randomPosition1 = new Position(randomX,randomY);
        randomX = RandomUtils.getRANDOM().nextInt(maxX-minX)+minX;
        randomY = RandomUtils.getRANDOM().nextInt(maxY-minY)+minY;
        Position randomPosition2 = new Position(randomX,randomY);
        while(randomPosition2.getX() == randomPosition1.getX()){
            randomX = RandomUtils.getRANDOM().nextInt(maxX-minX)+minX;
            randomY = RandomUtils.getRANDOM().nextInt(maxY-minY)+minY;
            randomPosition2 = new Position(randomX,randomY);
        }
        if(bact instanceof Bacillus){
            Bacteria bacteria1 = new Bacillus(randomPosition1);
            Bacteria bacteria2 = new Bacillus(randomPosition2);
            if(!canLive(bacteria1)){ bacteria1.cannotLive();}
            if(!canLive(bacteria2)){ bacteria1.cannotLive();}
            bacteria.add(bacteria1);
            bacteria.add(bacteria2);
        }
        else if(bact instanceof Coccus){
            Bacteria bacteria1 = new Coccus(randomPosition1);
            Bacteria bacteria2 = new Coccus(randomPosition2);
            if(!canLive(bacteria1)){ bacteria1.cannotLive();}
            if(!canLive(bacteria2)){ bacteria1.cannotLive();}
            bacteria.add(bacteria1);
            bacteria.add(bacteria2);

        }
        else if(bact instanceof Spirillum){
            Bacteria bacteria1 = new Spirillum(randomPosition1);
            Bacteria bacteria2 = new Spirillum(randomPosition2);
            if(!canLive(bacteria1)){ bacteria1.cannotLive();}
            if(!canLive(bacteria2)){ bacteria1.cannotLive();}
            bacteria.add(bacteria1);
            bacteria.add(bacteria2);
        }

    }
    public boolean canLive(Bacteria bact){
        int bactXPosition = bact.getPosition().getX();
        int bactYPosition = bact.getPosition().getY();
        if(bact instanceof Bacillus){

            for(Bacteria element:bacteria){
                int elementXPosition = element.getPosition().getX();
                int elementYPosition = element.getPosition().getY();
                int elementNearby = element.getNearby();
                if( elementXPosition >= (bactXPosition-elementNearby) && elementXPosition <= (bactXPosition+elementNearby)){
                    if( elementYPosition >= (bactYPosition-elementNearby) && elementYPosition <= (bactYPosition+elementNearby)){
                        if(element instanceof Coccus){return true;}
                    }
                }
            }
            return false;
        }
        else if(bact instanceof Coccus){
            int bacteriaCount = 0;
            for(Bacteria element:bacteria){
                int elementXPosition = element.getPosition().getX();
                int elementYPosition = element.getPosition().getY();
                int elementNearby = element.getNearby();
                if( elementXPosition >= (bactXPosition-elementNearby) && elementXPosition <= (bactXPosition+elementNearby)){
                    if( elementYPosition >= (bactYPosition-elementNearby) && elementYPosition <= (bactYPosition+elementNearby)){
                        bacteriaCount ++;
                    }
                }
            }
            if(bacteriaCount>=2){return true;}
            return false;

        }
        else if(bact instanceof Spirillum){
            for(Bacteria element:bacteria){
                int elementXPosition = element.getPosition().getX();
                int elementYPosition = element.getPosition().getY();
                int elementNearby = element.getNearby();
                if( elementXPosition >= (bactXPosition-elementNearby) && elementXPosition <= (bactXPosition+elementNearby)){
                    if( elementYPosition >= (bactYPosition-elementNearby) && elementYPosition <= (bactYPosition+elementNearby)){
                        if(element instanceof Bacillus){return true;}
                    }
                }
            }
            return false;

        }

        return false;
    }


}
