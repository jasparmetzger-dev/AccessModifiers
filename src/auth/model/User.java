package auth.model;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public abstract class User {
    private final String username;
    private String encodedPassword;
    protected int permissionLevel;

    public User(String username, String password) {
        this.username = username;
        this.encodedPassword = encodePassword(password);
    }

    protected void setPassword(String password) {
        this.encodedPassword = encodePassword(password);
    }

    public final boolean login(String password) {
        return encodedPassword.equals(encodePassword(password));
    }

    protected boolean hasPermission(int accessLevel) { //maybe change
        return accessLevel > permissionLevel;
    }
    protected abstract int defaultPermissionLevel();

    public boolean changePassword(String oldPassword, String newPassword) {
        if (!oldPassword.equals(decodePassword(encodedPassword))) return false;
        encodedPassword = encodePassword(newPassword);
        return true;
    }
    private String encodePassword(String password) {
        return Base64.getEncoder().encodeToString(password.getBytes(StandardCharsets.UTF_8));
    }
    private String decodePassword(String encodedPassword) {
        byte[] decodePassword = Base64.getDecoder().decode(encodedPassword);
        return new String(decodePassword, StandardCharsets.UTF_8);
    }

}
