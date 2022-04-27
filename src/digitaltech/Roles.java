package digitaltech;

public class Roles {
    private String userName;
    private String userPassword;
    private String adminName;
    private String adminPassword;

    public Roles() {
        this.userName = "user";
        this.userPassword = "s3cr3t";
        this.adminName = "admin";
        this.adminPassword = "s3cr3t0";
    }

    public boolean verifyUserPassword(String password) {
        return (this.userPassword.equals(password));
    }

    public boolean verifyAdminPassword(String password) {
        return (this.adminPassword.equals(password));
    }

    public boolean verifyUserName(String name) {
        return (this.userName.equals(name));
    }

    public boolean verifyAdminName(String name) {
        return (this.adminName.equals(name));
    }

    public void uptadeUserName(String newName) {
        this.userName = newName;
    }

    public void uptadeAdminName(String newName) {
        this.adminName = newName;
    }

    public void uptadeUserPassword(String newPassword) {
        this.userPassword = newPassword;
    }

    public void uptadeAdminPassword(String newPassword) {
        this.adminPassword = newPassword;
    }

}
