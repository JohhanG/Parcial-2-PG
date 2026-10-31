package modelo;

/**
 * Subclase Dragon (Capa MODELO)
 * Representa una criatura de tipo Dragon.
 * Posee un ataque potenciado (fuerza * 2)
 */
public class Dragon extends Criatura {
    // Atributo especifico del Dragon segun el diagrama UML
    private String escamas;

    /**
     * Constructor de Dragon.
     * 
     * @param nombre  Nombre del dragon.
     * @param salud   Puntos de vida.
     * @param fuerza  Poder base de ataque.
     * @param escamas Tipo o descripcion de sus escamas protectoras.
     */
    public Dragon(String nombre, int salud, int fuerza, String escamas) {
        super(nombre, salud, fuerza);
        this.escamas = escamas;
    }

    /**
     * Ataque unico del Dragon:
     * Duplica su fuerza base al realizar un ataque devastador (fuerza * 2).
     */
    @Override
    public void atacar(Criatura objetivo) {
        int danio = this.fuerza * 2;
        objetivo.defender(danio);
    }

    /**
     * Defensa unica del Dragon:
     * La dureza de sus escamas mitiga 7 puntos de danio entrante.
     */
    @Override
    public void defender(int danio) {
        int reduccion = 7;
        int danioRecibido = Math.max(0, danio - reduccion);

        this.ultimoBloqueo = reduccion;
        this.ultimoDanioRecibido = danioRecibido;
        this.salud = Math.max(0, this.salud - danioRecibido);
    }

    @Override
    public String getTipo() {
        return "Dragon";
    }

    @Override
    public String getDetalleEspecial() {
        return "Escamas: " + this.escamas;
    }

    @Override
    public String getAccionAtaqueTexto() {
        return "exhala una llamarada colosal abrasadora";
    }

    @Override
    public String getAccionDefensaTexto() {
        return "endurece sus " + this.escamas;
    }

    // Getter y Setter
    public String getEscamas() {
        return escamas;
    }

    public void setEscamas(String escamas) {
        this.escamas = escamas;
    }
}

