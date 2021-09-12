package Utils;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class KeyReader {
    public static PublicKey getPublicKey(String filename)
            throws Exception {

        byte[] keyBytes = FileUtils.readByte(filename);
        if (keyBytes != null) {
            X509EncodedKeySpec spec =
                    new X509EncodedKeySpec(keyBytes);
            KeyFactory kf = KeyFactory.getInstance("RSA");
            return kf.generatePublic(spec);
        }
        return null;
    }

    public static PrivateKey getPrivateKey(String filename)
            throws Exception {

        byte[] keyBytes = FileUtils.readByte(filename);

        if (keyBytes != null) {
            PKCS8EncodedKeySpec spec =
                    new PKCS8EncodedKeySpec(keyBytes);
            KeyFactory kf = KeyFactory.getInstance("RSA");
            return kf.generatePrivate(spec);
        }
        return null;
    }
}
