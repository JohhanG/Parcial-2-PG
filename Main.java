import modelo.Criatura;
import modelo.Dragon;
import modelo.Guerrero;
import modelo.Mago;
import vista.BatallaVista;
import controlador.BatallaControlador;

/**
 * Clase Principal Main (Punto de entrada de la aplicacion)
 * Configura la arquitectura MVC instanciando el Modelo, la Vista y el Controlador.
 * Implementa el metodo polimorfico simularBatalla(Criatura, Criatura) exigido en el UML.
 */
public class Main {

    // Controlador que orquesta las batallas comunicando Modelo y Vista
    private static BatallaControlador controlador = new BatallaControlador(new BatallaVista());

    /**
     * Metodo simularBatalla segun el diagrama UML del parcial.
     * Recibe de forma polimorfica dos instancias genericas de Criatura
     * y delega su ejecucion en el controlador.
     * 
     * @param criatura1 Primera criatura combatiente.
     * @param criatura2 Segunda criatura combatiente.
     */
    public static void simularBatalla(Criatura criatura1, Criatura criatura2) {
        controlador.simularBatalla("DUELO EN LA ARENA", criatura1, criatura2);
    }

    public static void main(String[] args) {
        // Inicializacion de la Capa VISTA
        controlador.getVista().mostrarBienvenida();

        // Inicializacion de la Capa MODELO (Heroes y Tropas de Clash Royale)
        Criatura caballeroDorado = new Guerrero("Caballero Dorado", 115, 23, "Espada Real Dorada");
        Criatura dragonInfernal = new Dragon("Dragon Infernal", 120, 18, "Casco Blindado y Escamas Termicas");
        Criatura magoFuego = new Mago("Mago de Fuego", 95, 26, "Fireball (Bola de Fuego)");
        Criatura megaCaballero = new Guerrero("Mega Caballero", 125, 21, "Guanteletes de Acero con Puntas");
        Criatura bebeDragon = new Dragon("Bebe Dragon", 105, 17, "Escamas Igneas Volcanicas");
        Criatura magoElectrico = new Mago("Mago Electrico", 90, 25, "Electrificacion Zapp!");

        // Ejecucion de batallas polimorficas
        // Batalla 1: Guerrero vs Dragon
        controlador.simularBatalla("ARENA 1: ENFRENTAMIENTO DE CAMPEONES", caballeroDorado, dragonInfernal);

        // Batalla 2: Mago vs Guerrero
        controlador.simularBatalla("ARENA 2: DUELO POR LAS TRES CORONAS", magoFuego, megaCaballero);

        // Batalla 3: Mago vs Dragon
        controlador.simularBatalla("ARENA 3: DESAFIO AEREO Y ELEMENTAL", magoElectrico, bebeDragon);
    }
}
