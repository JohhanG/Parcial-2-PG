package controlador;

import modelo.Criatura;
import modelo.Dragon;
import vista.BatallaVista;

/**
 * Clase BatallaControlador (Capa CONTROLADOR)
 * En el patron MVC, el Controlador es el intermediario que orquesta el flujo de
 * la aplicacion. Conecta los modelos (Criatura) con la vista (BatallaVista),
 * gestiona los turnos, valida las condiciones de victoria/derrota y solicita a
 * la vista que muestre cada suceso sin mezclar la logica en la interfaz.
 */
public class BatallaControlador {

    private BatallaVista vista;

    /**
     * Constructor que inyecta la vista requerida para la comunicacion.
     * 
     * @param vista Instancia de BatallaVista para reportar los eventos.
     */
    public BatallaControlador(BatallaVista vista) {
        this.vista = vista;
    }

    /**
     * Orquesta y simula un combate completo por turnos entre dos criaturas cualesquiera.
     * Aplica polimorfismo al interactuar con la clase base Criatura.
     * 
     * @param arenaTitulo Titulo de la arena o enfrentamiento.
     * @param criatura1   Primera criatura combatiente.
     * @param criatura2   Segunda criatura combatiente.
     */
    public void simularBatalla(String arenaTitulo, Criatura criatura1, Criatura criatura2) {
        vista.mostrarPresentacionBatalla(arenaTitulo, criatura1, criatura2);

        int ronda = 1;

        // La batalla se desarrolla mientras ambos combatientes tengan salud > 0
        while (criatura1.estaViva() && criatura2.estaViva()) {
            vista.mostrarInicioRonda(ronda);

            // --- Turno de la Criatura 1 ataca a la Criatura 2 ---
            ejecutarTurno(criatura1, criatura2);
            if (!criatura2.estaViva()) {
                vista.mostrarDerrota(criatura2);
                break;
            }

            // --- Turno de la Criatura 2 contraataca a la Criatura 1 ---
            ejecutarTurno(criatura2, criatura1);
            if (!criatura1.estaViva()) {
                vista.mostrarDerrota(criatura1);
                break;
            }

            // Reporte de salud al cierre de la ronda
            vista.mostrarEstadoRonda(ronda, criatura1, criatura2);
            ronda++;
        }

        // Determinacion del vencedor
        if (criatura1.estaViva()) {
            vista.mostrarResultadoFinal(criatura1, criatura2);
        } else {
            vista.mostrarResultadoFinal(criatura2, criatura1);
        }
    }

    /**
     * Ejecuta la secuencia de un turno individual:
     * 1. Solicita a la vista anunciar el turno.
     * 2. Calcula el danio potencial segun las reglas del modelo.
     * 3. Invoca el metodo polimorfico atacar() del modelo.
     * 4. Solicita a la vista reportar el ataque y la defensa resultante.
     */
    private void ejecutarTurno(Criatura atacante, Criatura defensor) {
        vista.mostrarTurno(atacante);

        // El Dragon duplica su fuerza base segun las reglas del modelo
        int danioPotencial = (atacante instanceof Dragon) ? atacante.getFuerza() * 2 : atacante.getFuerza();

        // Ejecucion polimorfica en el Modelo
        atacante.atacar(defensor);

        // Notificacion a la Vista
        vista.mostrarAtaque(atacante, defensor, danioPotencial);
        vista.mostrarDefensa(defensor);
    }

    // Getter y Setter de la Vista
    public BatallaVista getVista() {
        return vista;
    }

    public void setVista(BatallaVista vista) {
        this.vista = vista;
    }
}

