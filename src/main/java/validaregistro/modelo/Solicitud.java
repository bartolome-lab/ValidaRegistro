package validaregistro.modelo;

public class Solicitud {
    private String login;
    private String clave;
    private String email;
    private String nombre;
    private String apellidos;

    public Solicitud(String login, String clave, String email, String nombre, String apellidos) {
        this.login = login;
        this.clave = clave;
        this.email = email;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getLogin() {
        return login;
    }

    public String getClave() {
        return clave;
    }

    public String getEmail() {
        return email;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String toString() {
        return "Login: " + this.login + " clave: " + this.clave + " email: " + this.email
                + " nombre: " + this.nombre + " apellidos: " + this.apellidos;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Solicitud solicitud = (Solicitud) obj;
        return login.equals(solicitud.getLogin());
    }

    @Override
    public int hashCode() {
        return login.hashCode();
    }

    public boolean esValido() {
        if (login == null || clave == null || email == null || nombre == null || apellidos == null) {
            return false;
        }
        return login.length() >= 5 &&
                clave.length() >= 5 &&
                email.length() >= 5 &&
                email.contains("@") &&
                nombre.length() >= 5 &&
                apellidos.length() >= 5;
    }

}
