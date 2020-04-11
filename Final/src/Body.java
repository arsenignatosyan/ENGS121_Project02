public class Body {
    private int mass;
    private double fricCoeff;
    private int posX;
    private int posY;

    public Body(int newMass, double newFricCoeff, int newPosX, int newPosY){
        setMass(newMass);
        setFricCoeff(newFricCoeff);
        posX = newPosX;
        posY = newPosY;
    }

    public void setMass(int newMass){
        if(newMass > 0 & newMass <= 15){
            mass = newMass;
        }
        else if(newMass <= 0){
            mass = 1;
        }
        else{
            mass = 15;
        }
    }

    public void setFricCoeff(double newFricCoeff){
        if(newFricCoeff >= 0 & newFricCoeff <= 0.5){
            fricCoeff = newFricCoeff;
        }
        else if(newFricCoeff < 0){
            fricCoeff = 0;
        }
        else{
            fricCoeff = 0.5;
        }
    }

    public int getMass(){return mass;}
    public double getFricCoeff(){return fricCoeff;}
    public int getPosX(){return posX;}
    public int getPosY(){return posY;}
}

