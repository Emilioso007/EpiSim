/*
 * A random class that is used to generate random numbers.
 * It uses Singleton to give Perlin Noise accessability to all classes.
 */

package LogicClasses.UtilitiesClasses;

import processing.core.PApplet;

public class Random extends PApplet {

    private static Random random;

    private Random() {
    }

    public static int randomInt(int max) {
        return (int) (Math.random() * max);
    }

    public static float perlinNoise1D(float x) {
        if (random == null) {
            random = new Random();
        }
        return random.noise(x);
    }

}
