package modelo;

/**
 * Subclase Mago (Capa MODELO)
 * Representa a un hechicero capaz de canalizar hechizos y barreras arcanas.
 * Implementa sus propias reglas de danio y defensa sin salidas por consola.
 */
public class Mago extends Criatura {
    // Atributo especifico del Mago segun el diagrama UML
    private String hechizos;

    /**
     * Constructor de Mago.
     * 
     * @param nombre   Nombre del mago.
     * @param salud    Puntos de vida.
     * @param fuerza   Poder de ataque.
     * @param hechizos Tipo de conjuro principal.
     */
    public Mago(String nombre, int salud, int fuerza, String hechizos) {
        super(nombre, salud, fuerza);
        this.hechizos = hechizos;
    }

    /**
     * Ataque unico del Mago:
     * Conjura un hechizo utilizando su fuerza base.
     */
    @Override
    public void atacar(Criatura objetivo) {
        int danio = this.fuerza;
        objetivo.defender(danio);
    }

    /**
     * Defensa unica del Mago:
     * Su barrera arcana absorbe 4 puntos del danio entrante.
     */
    @Override
    public void defender(int danio) {
        int absorcionMagica = 4;
        int danioRecibido = Math.max(0, danio - absorcionMagica);

        this.ultimoBloqueo = absorcionMagica;
        this.ultimoDanioRecibido = danioRecibido;
        this.salud = Math.max(0, this.salud - danioRecibido);
    }

    @Override
    public String getTipo() {
        return "Mago";
    }

    @Override
    public String getDetalleEspecial() {
        return "Hechizo: " + this.hechizos;
    }

    @Override
    public String getAccionAtaqueTexto() {
        return "conjura el hechizo '" + this.hechizos + "'";
    }

    @Override
    public String getAccionDefensaTexto() {
        return "canaliza una barrera arcana de proteccion";
    }

    // Getter y Setter
    public String getHechizos() {
        return hechizos;
    }

    public void setHechizos(String hechizos) {
        this.hechizos = hechizos;
    }
}

