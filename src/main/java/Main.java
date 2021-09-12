import Utils.FileUtils;
import Utils.KeyGenerator;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        try {
            KeyGenerator key1 = new KeyGenerator(1024);
            KeyGenerator key2 = new KeyGenerator(1024);

            ClassLoader classLoader = Main.class.getClassLoader();
            File document = new File(classLoader.getResource("hopdong.docx").getFile());
            String documentAbsolutePath = document.getAbsolutePath();

            // sign with key1
            byte[] ds = DigitalSignature.sign(FileUtils.readByte(documentAbsolutePath), key1.getPrivateKey());
            // write digital signature if needed

            // verify with true key
            boolean verifyDS1 = DigitalSignature.verify(FileUtils.readByte(documentAbsolutePath), ds, key1.getPublicKey());
            System.out.println("verify with true key, status: " + verifyDS1);
            // verify with false key
            boolean verifyDS2 = DigitalSignature.verify(FileUtils.readByte(documentAbsolutePath), ds, key2.getPublicKey());
            System.out.println("verify with false key, status: " + verifyDS2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
