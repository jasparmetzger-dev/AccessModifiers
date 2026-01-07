package auth.model;

public class Guest extends User {


    public Guest(String username, String password) {
        super(username, password);
        this.permissionLevel = defaultPermissionLevel();
    }

    @Override
    protected int defaultPermissionLevel() {
        return 1;
    }

    public void beGuest() {
        System.out.print("im a guest");
    }
}
