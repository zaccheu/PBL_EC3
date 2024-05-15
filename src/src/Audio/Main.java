package Audio;

public class Main {
    public static void main(String[] args) {
        Seno taylor = new Seno();
        System.out.println(taylor.sinTaylorSeries(45));

        System.out.println("math "+Math.sin(45));


    }
}
