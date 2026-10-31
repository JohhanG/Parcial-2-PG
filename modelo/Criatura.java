package modelo;

/**
 * Clase Abstracta Criatura (Capa MODELO)
 * Representa la base generica para cualquier criatura del juego de batallas.
 * Aplica los principios de abstraccion, encapsulamiento y polimorfismo.
 * En la arquitectura MVC, el Modelo es responsable unicamente de los datos,
 * estado y logica de negocio, sin realizar impresiones en consola.
 */
public abstract class Criatura {
    // Atributos protegidos para permitir el acceso directo en las subclases
    protected String nombre;
    protected int salud;
    protected int fuerza;

    // Atributos de soporte para que la Vista y el Controlador consulten los resultados
    protected int ultimoDanioRecibido;
    protected int ultimoBloqueo;

    /**
     * Constructor para inicializar los atributos basicos de una Criatura.
     * 
     * @param nombre Nombre identificativo de la criatura.
     * @param salud  Puntos de vida iniciales.
     * @param fuerza Poder base de ataque.
     */
    public Criatura(String nombre, int salud, int fuerza) {
        this.nombre = nombre;
        this.salud = Math.max(salud, 0);
        this.fuerza = Math.max(fuerza, 1);
        this.ultimoDanioRecibido = 0;
        this.ultimoBloqueo = 0;
    }

    // --- METODOS ABSTRACTOS ---

    /**
     * Metodo polimorfico para atacar a otra criatura.
     * Cada subclase define el calculo de su ataque unico e invoca defender() en el objetivo.
     * 
     * @param objetivo La criatura que recibira el ataque.
     */
    public abstract void atacar(Criatura objetivo);

    /**
     * Metodo polimorfico para defenderse de un ataque entrante.
     * Cada subclase define como mitiga o absorbe el danio segun sus defensas.
     * 
     * @param danio Cantidad de danio enviado por el atacante.
     */
    public abstract void defender(int danio);

    /**
     * Retorna el tipo de criatura (ej. "Guerrero", "Mago", "Dragon").
     */
    public abstract String getTipo();

    /**
     * Retorna la descripcion del detalle especial (Arma, Hechizo o Escamas).
     */
    public abstract String getDetalleEspecial();

    /**
     * Retorna el texto descriptivo de la accion de ataque.
     */
    public abstract String getAccionAtaqueTexto();

    /**
     * Retorna el texto descriptivo de la accion de defensa.
     */
    public abstract String getAccionDefensaTexto();

    // --- METODO CONCRETO ---

    /**
     * Verifica si la criatura sigue con vida.
     * 
     * @return true si la salud es mayor a 0, false de lo contrario.
     */
    public boolean estaViva() {
        return this.salud > 0;
    }

    // --- GETTERS Y SETTERS ---

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = Math.max(0, salud);
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getUltimoDanioRecibido() {
        return ultimoDanioRecibido;
    }

    public int getUltimoBloqueo() {
        return ultimoBloqueo;
    }
}

