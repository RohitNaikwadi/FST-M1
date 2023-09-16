package Activities;

public class Activity1 {

    public static void main(String args[])
    {
        Car carName = new Car();
        carName.make=2014;
        carName.color="black";
        carName.transmission="transmission ";

        carName.displayCharacteristics();;
        carName.accelarate();
        carName.brake();
    }


}


