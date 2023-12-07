package LogicClasses.Simulation;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class SimConfig {
    private static final String FILE_NAME = "src\\LogicClasses\\Simulation\\simconfig.properties";
    private static Properties properties;

    static {
        properties = new Properties();
        try (FileInputStream fis = new FileInputStream(FILE_NAME)) {
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int getNAgents() {
        return Integer.parseInt(properties.getProperty("nAgents"));
    }

    public static int getFramesPerDay() {
        return Integer.parseInt(properties.getProperty("framesPerDay"));
    }

    public static float getAgentSpeed() {
        return Float.parseFloat(properties.getProperty("agentSpeed"));
    }

    public static int getAgentRadius() {
        return Integer.parseInt(properties.getProperty("agentRadius"));
    }

    public static int getRecoveryTime() {
        return Integer.parseInt(properties.getProperty("recoveryTime"));
    }

    public static void setProperty(String key, String value) {
        properties.setProperty(key, value);
        try (FileOutputStream fos = new FileOutputStream(FILE_NAME)) {
            properties.store(fos, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
