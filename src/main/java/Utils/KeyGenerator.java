package Utils;

import java.security.*;

public class KeyGenerator {

    private final PrivateKey privateKey;
    private final PublicKey publicKey;

    public KeyGenerator(int keyLength) throws NoSuchAlgorithmException, NoSuchProviderException {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(keyLength);
        KeyPair pair = keyGen.generateKeyPair();
        this.privateKey = pair.getPrivate();
        this.publicKey = pair.getPublic();
    }

    public boolean savePrivateKey(String path) {
        return FileUtils.writeByte(path, privateKey.getEncoded());
    }

    public boolean savePublicKey(String path) {
        return FileUtils.writeByte(path, publicKey.getEncoded());
    }

    public PrivateKey getPrivateKey() {
        return this.privateKey;
    }

    public PublicKey getPublicKey() {
        return this.publicKey;
    }


}