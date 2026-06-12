package cn.henu.software.stu2510250128.ch04;

abstract class Spaceship {
    int engineNum;
    int crewCapacity;

    public int getEngineNum() {
        return engineNum;
    }

    public int getCrewCapacity() {
        return crewCapacity;
    }

    public Spaceship(int engineNum, int crewCapacity) {
        this.engineNum = engineNum;
        this.crewCapacity = crewCapacity;
    }

    public abstract void display();
}

class CargoShip extends Spaceship {
    public CargoShip(int engineNum, int crewCapacity) {
        super(engineNum, crewCapacity);
    }

    @Override
    public void display() {
        System.out.println("======CargoShip info======");
        System.out.println("Engine Number:" + getEngineNum());
        System.out.println("Crew Capacity:" + getCrewCapacity());

    }
}

class FighterShip extends Spaceship {
    public FighterShip(int engineNum, int crewCapacity) {
        super(engineNum, crewCapacity);
    }

    @Override
    public void display() {
        System.out.println("======FighterShip info======");
        System.out.println("Engine Number:" + getEngineNum());
        System.out.println("Crew Capacity:" + getCrewCapacity());

    }
}


public class SpaceshipTest {
    public static void main(String[] args) {
        Spaceship cargoShip1 = new CargoShip(4, 100);
        Spaceship fighterShip1 = new FighterShip(8, 20);
        cargoShip1.display();
        fighterShip1.display();
    }
}
