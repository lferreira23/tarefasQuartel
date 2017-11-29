package model;

/**
 * @author Luiz Ferreira
 * @since 24/11/2017
 * Classe que representa o operador do sistema
 */
public class Admin {
    private String username;
    private String password;
    private boolean loggedIn;
    
    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
        this.loggedIn = false;
    }
    
    private boolean checkPassword(String password) {
        return this.password.equals(password);
    }
    
    public boolean login(String password) {
        if(checkPassword(password)) {
            loggedIn = true;
        }
        return loggedIn;
    }
    
    public void logout() {
        loggedIn = false;
    }
    
    public String getUsername() {
        return username;
    }
    
    public boolean isLoggedIn() {
        return loggedIn;
    }
    
}
