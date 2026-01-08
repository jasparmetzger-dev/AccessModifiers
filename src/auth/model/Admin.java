package auth.model;

import auth.repository.UserRepository;

public class Admin extends User {

    public Admin(String username, String password) {
        super(username, password);
        this.permissionLevel = defaultPermissionLevel();
    }

    @Override
    protected int defaultPermissionLevel() {
        return 10;
    }

    public void resetPassword(User user, String newPassword) {
        if (user instanceof Admin) throw new SecurityException("CANT CHANGE PASSWORDS ON ADMINS!");
        if(!assertPermission(10)) throw new SecurityException("SECURITY EXCEPTION!");
        else setPassword(newPassword);
    }

    public void deleteUser(User user) {
        if (user instanceof Admin) throw new SecurityException("CANT DELETE ADMINS!");
        if (!assertPermission(10)) throw new SecurityException("SECURITY EXCEPTION!");
        else UserRepository.removeUser(user);
    }


}
