package Utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtils {
    public static boolean writeByte(String filePath, byte[] bytes) {
        try {
            Files.write(Paths.get(filePath), bytes);
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    public static byte[] readByte(String filePath) {
        try {
            return Files.readAllBytes(Paths.get(filePath));
        } catch (IOException e) {
            return null;
        }
    }

}
