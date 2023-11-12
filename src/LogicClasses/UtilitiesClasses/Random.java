package LogicClasses.UtilitiesClasses;

public class Random {
    
    public Random() {
        
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

}
