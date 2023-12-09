package LogicClasses.UtilitiesClasses;

import processing.core.PApplet;

public class Random extends PApplet {

    private static Random random;

    private Random() {
    }

    public static int Int(int max) {
        return (int) (Math.random() * max);
    }

    public static double between(double min, double max) {
        return Math.random() * (max - min) + min;
    }

    public static int between(int min, int max) {
        return (int) (Math.random() * (max - min) + min);
    }

    public static boolean chance(double chance) {
        return Math.random() < chance;
    }

    public static float perlinNoise1D(float x) {
        if (random == null) {
            random = new Random();
        }
        return random.noise(x);
    }

}
