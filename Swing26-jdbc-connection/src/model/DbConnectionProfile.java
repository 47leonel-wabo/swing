package model;

/**
 *
 * @author ddok
 */
public class DbConnectionProfile {

    private String username;
    private String password;
    private Integer port;

    public DbConnectionProfile(String username, String password, Integer port) {
        this.username = username;
        this.password = password;
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "DbConnectionProfile{" + "username=" + username + ", password=" + password + ", port=" + port + '}';
    }

}
