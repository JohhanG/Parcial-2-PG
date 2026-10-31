package modelo;

/**
 * Subclase Guerrero (Capa MODELO)
 * Representa a un combatiente cuerpo a cuerpo experto en el uso de armas.
<<<<<<< HEAD
=======
 * Implementa sus propias reglas de danio y defensa sin salidas por consola.
>>>>>>> 9a4515bfdf0ccceb22ea685dc0e4ef0f2db26da8
 */
public class Guerrero extends Criatura {
    // Atributo especifico del Guerrero segun el diagrama UML
    private String arma;

    /**
     * Constructor de Guerrero.
     * 
     * @param nombre Nombre del guerrero.
     * @param salud  Puntos de vida.
     * @param fuerza Poder base de ataque.
     * @param arma   Arma principal que empunia.
     */
    public Guerrero(String nombre, int salud, int fuerza, String arma) {
        super(nombre, salud, fuerza);
        this.arma = arma;
    }

    /**
     * Ataque unico del Guerrero:
     * Utiliza su fuerza fisica e impacta con su arma al objetivo.
     */
    @Override
    public void atacar(Criatura objetivo) {
        int danio = this.fuerza;
        objetivo.defender(danio);
    }

    /**
     * Defensa unica del Guerrero:
     * Su armadura de combate reduce 5 puntos del danio entrante.
     */
    @Override
    public void defender(int danio) {
        int bloqueoArmadura = 5;
        int danioRecibido = Math.max(0, danio - bloqueoArmadura);

        this.ultimoBloqueo = bloqueoArmadura;
        this.ultimoDanioRecibido = danioRecibido;
        this.salud = Math.max(0, this.salud - danioRecibido);
    }

    @Override
    public String getTipo() {
        return "Guerrero";
    }

    @Override
    public String getDetalleEspecial() {
        return "Arma: " + this.arma;
    }

    @Override
    public String getAccionAtaqueTexto() {
        return "arremete ferozmente con su " + this.arma;
    }

    @Override
    public String getAccionDefensaTexto() {
        return "bloquea con firmeza en guardia de combate";
    }

    // Getter y Setter
    public String getArma() {
        return arma;
    }

    public void setArma(String arma) {
        this.arma = arma;
    }
}

