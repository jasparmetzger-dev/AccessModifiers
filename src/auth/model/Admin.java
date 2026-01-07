package auth.model;

import auth.repository.UserRepository;

public class Admin extends User {

    public Admin(String username, String password) {
        super(username, password);
        this.permissionLevel = defaultPermissionLevel();
    }

    @Override
    protected int defaultPermissionLevel() {
        return 3;
    }

    public void resetPassword(User user, String newPassword) {
        if (user instanceof Admin) throw new SecurityException("CANT CHANGE PASSWORDS ON ADMINS!");
        if(user.hasPermission(this.permissionLevel)) {
            setPassword(newPassword);
        }
        else throw new SecurityException("SECURITY EXCEPTION!");
    }

    public void deleteUser(User user) {
        if (user instanceof Admin) throw new SecurityException("CANT DELETE ADMINS!");
        if (user.hasPermission(this.permissionLevel)) {
            UserRepository.removeUser(user);
        }
    }


}
