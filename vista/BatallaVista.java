package vista;

import modelo.Criatura;

/**
 * Clase BatallaVista (Capa VISTA)
 * En el patron MVC, la Vista es responsable EXCLUSIVA de formatear y presentar
 * la informacion visual al usuario (en este caso, salida formateada en consola).
 * No contiene reglas de negocio ni altera el estado de las criaturas.
 */
public class BatallaVista {

    /**
     * Muestra el banner principal de bienvenida al juego.
     */
    public void mostrarBienvenida() {
        System.out.println("==========================================================");
        System.out.println("     BIENVENIDOS A LA ARENA DE BATALLA DE CLASH ROYALE    ");
        System.out.println("            (ARQUITECTURA MODELO - VISTA - CONTROLADOR)   ");
        System.out.println("==========================================================\n");
    }

    /**
     * Muestra la cabecera y presentacion de los contendientes de una batalla.
     * 
     * @param arenaTitulo Nombre o titulo tematico de la arena.
     * @param c1 Primera criatura combatiente.
     * @param c2 Segunda criatura combatiente.
     */
    public void mostrarPresentacionBatalla(String arenaTitulo, Criatura c1, Criatura c2) {
        System.out.println(">>> [" + arenaTitulo + "] <<<");
        System.out.println("==========================================================");
        System.out.println("            COMIENZA LA BATALLA EN LA ARENA               ");
        System.out.println(" [" + c1.getNombre() + " (" + c1.getTipo() + ") | Salud: " + c1.getSalud() 
                           + " HP | Fuerza: " + c1.getFuerza() + " | " + c1.getDetalleEspecial() + "]");
        System.out.println("                          VS                              ");
        System.out.println(" [" + c2.getNombre() + " (" + c2.getTipo() + ") | Salud: " + c2.getSalud() 
                           + " HP | Fuerza: " + c2.getFuerza() + " | " + c2.getDetalleEspecial() + "]");
        System.out.println("==========================================================");
    }

    /**
     * Muestra el encabezado de inicio de ronda.
     */
    public void mostrarInicioRonda(int ronda) {
        System.out.println("\n--- Ronda " + ronda + " ---");
    }

    /**
     * Muestra a que criatura le corresponde el turno de accion.
     */
    public void mostrarTurno(Criatura atacante) {
        System.out.println(">> Turno de: " + atacante.getNombre());
    }

    /**
     * Muestra el resultado de la ejecucion del ataque.
     */
    public void mostrarAtaque(Criatura atacante, Criatura objetivo, int danioCalculado) {
        System.out.println(">>> [" + atacante.getNombre() + "] " + atacante.getAccionAtaqueTexto() 
                           + " sobre [" + objetivo.getNombre() + "] infligiendo " + danioCalculado + " de danio!");
    }

    /**
     * Muestra el reporte de defensa y mitigacion de danio del defensor.
     */
    public void mostrarDefensa(Criatura defensor) {
        System.out.println("    [DEFENSA] [" + defensor.getNombre() + "] " + defensor.getAccionDefensaTexto() 
                           + ", mitigando " + defensor.getUltimoBloqueo() + " de danio. Danio recibido: " 
                           + defensor.getUltimoDanioRecibido() + " | Salud restante: " + defensor.getSalud() + " HP");
    }

    /**
     * Informa que una criatura ha caido derrotada.
     */
    public void mostrarDerrota(Criatura derrotada) {
        System.out.println(" [DERROTA] [" + derrotada.getNombre() + "] ha caido en combate en la Arena.");
    }

    /**
     * Muestra el estado de salud de ambas criaturas al finalizar la ronda.
     */
    public void mostrarEstadoRonda(int ronda, Criatura c1, Criatura c2) {
        System.out.println(">> Estado tras la Ronda " + ronda + ":");
        System.out.println("   * " + c1.getNombre() + " -> " + c1.getSalud() + " HP");
        System.out.println("   * " + c2.getNombre() + " -> " + c2.getSalud() + " HP");
    }

    /**
     * Muestra el resultado final con el ganador coronado y el derrotado.
     */
    public void mostrarResultadoFinal(Criatura ganador, Criatura derrotado) {
        System.out.println("                  RESULTADO FINAL                         ");
        System.out.println(" [VICTORIA MAGISTRAL - TRES CORONAS]");
        System.out.println(" GANADOR: " + ganador.getNombre() + " con " + ganador.getSalud() + " HP restantes.");
        System.out.println(" DERROTADO: " + derrotado.getNombre());
        System.out.println("==========================================================\n");
    }
}
