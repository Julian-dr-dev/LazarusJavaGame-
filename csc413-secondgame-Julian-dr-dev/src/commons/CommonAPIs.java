package commons;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CommonAPIs {

    public static void validateFileExists(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        if (!file.exists()) {
            throw new FileNotFoundException("Map file not found!");
        }
    }

    public static BufferedImage loadImages(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }

    public static String getMapFileName(int level) throws IllegalLevelException {
        if (level == 1) return Globals.MAP1_FILENAME;
        if (level == 2) return Globals.MAP2_FILENAME;
        throw new IllegalLevelException();
    }

}
class IllegalLevelException extends Exception {};
