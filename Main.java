import modelo.Criatura;
import modelo.Dragon;
import modelo.Guerrero;
import modelo.Mago;
import vista.BatallaVista;
import controlador.BatallaControlador;

/**
 * Clase Principal Main (Punto de entrada de la aplicacion)
 * Configura la arquitectura MVC instanciando el Modelo, la Vista y el Controlador.
 * Ejecuta los enfrentamientos tematicos de heroes de Clash Royale.
 */
public class Main {

    public static void main(String[] args) {
        // 1. Inicializacion de la Capa VISTA
        BatallaVista vista = new BatallaVista();
        vista.mostrarBienvenida();

        // 2. Inicializacion de la Capa CONTROLADOR (Inyeccion de la Vista)
        BatallaControlador controlador = new BatallaControlador(vista);

        // 3. Inicializacion de la Capa MODELO (Heroes y Tropas de Clash Royale)
        Criatura caballeroDorado = new Guerrero("Caballero Dorado", 115, 23, "Espada Real Dorada");
        Criatura dragonInfernal = new Dragon("Dragon Infernal", 120, 18, "Casco Blindado y Escamas Termicas");
        Criatura magoFuego = new Mago("Mago de Fuego", 95, 26, "Fireball (Bola de Fuego)");
        Criatura megaCaballero = new Guerrero("Mega Caballero", 125, 21, "Guanteletes de Acero con Puntas");
        Criatura bebeDragon = new Dragon("Bebe Dragon", 105, 17, "Escamas Igneas Volcanicas");
        Criatura magoElectrico = new Mago("Mago Electrico", 90, 25, "Electrificacion Zapp!");

        // 4. Ejecucion de batallas orquestadas por el Controlador
        // Batalla 1: Campeon Guerrero vs Dragon Infernal
        controlador.simularBatalla("ARENA 1: ENFRENTAMIENTO DE CAMPEONES", caballeroDorado, dragonInfernal);

        // Batalla 2: Mago vs Guerrero Colosal
        controlador.simularBatalla("ARENA 2: DUELO POR LAS TRES CORONAS", magoFuego, megaCaballero);

        // Batalla 3: Mago Electrico vs Bebe Dragon
        controlador.simularBatalla("ARENA 3: DESAFIO AEREO Y ELEMENTAL", magoElectrico, bebeDragon);
    }
}
