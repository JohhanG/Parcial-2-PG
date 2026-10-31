package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import modelo.Criatura;
import modelo.Dragon;
import modelo.Guerrero;
import modelo.Mago;

/**
 * Pruebas Unitarias con JUnit 5 para las clases del paquete modelo.
 * Evaluacion de logica de combate, mitigacion de danio, polimorfismo y estado vital.
 */
public class CriaturaTest {

    private Guerrero guerrero;
    private Mago mago;
    private Dragon dragon;

    @BeforeEach
    void setUp() {
        // Se ejecuta antes de CADA prueba para asegurar objetos limpios
        guerrero = new Guerrero("Caballero Dorado", 100, 20, "Espada Real");
        mago = new Mago("Mago de Fuego", 80, 25, "Fireball");
        dragon = new Dragon("Dragon Infernal", 120, 15, "Escamas Termicas");
    }

    @Test
    @DisplayName("Guerrero: La armadura debe mitigar exactamente 5 puntos de danio")
    void testGuerreroDefensaMitiga5DeDanio() {
        // Act: El guerrero recibe un golpe de 20 de danio
        guerrero.defender(20);

        // Assert: 20 danio - 5 bloqueo = 15 danio recibido -> 100 - 15 = 85
        assertEquals(85, guerrero.getSalud(), "La salud restante deberia ser 85");
        assertEquals(5, guerrero.getUltimoBloqueo(), "El bloqueo del guerrero debe ser 5");
        assertEquals(15, guerrero.getUltimoDanioRecibido(), "El danio recibido neto debe ser 15");
    }

    @Test
    @DisplayName("Mago: La barrera arcana debe absorber exactamente 4 puntos de danio")
    void testMagoDefensaAbsorbe4DeDanio() {
        // Act: El mago recibe 20 de danio
        mago.defender(20);

        // Assert: 20 danio - 4 absorcion = 16 danio recibido -> 80 - 16 = 64
        assertEquals(64, mago.getSalud(), "La salud restante deberia ser 64");
        assertEquals(4, mago.getUltimoBloqueo(), "La absorcion del mago debe ser 4");
        assertEquals(16, mago.getUltimoDanioRecibido(), "El danio recibido neto debe ser 16");
    }

    @Test
    @DisplayName("Dragon: Las escamas deben reducir exactamente 7 puntos de danio")
    void testDragonDefensaReduce7DeDanio() {
        // Act: El dragon recibe 20 de danio
        dragon.defender(20);

        // Assert: 20 danio - 7 reduccion = 13 danio recibido -> 120 - 13 = 107
        assertEquals(107, dragon.getSalud(), "La salud restante deberia ser 107");
        assertEquals(7, dragon.getUltimoBloqueo(), "El bloqueo del dragon debe ser 7");
        assertEquals(13, dragon.getUltimoDanioRecibido(), "El danio recibido neto debe ser 13");
    }

    @Test
    @DisplayName("Dragon: El ataque debe duplicar la fuerza base (fuerza * 2)")
    void testDragonAtaqueDuplicaFuerza() {
        // Act: Dragon (fuerza 15) ataca al Guerrero (bloqueo 5)
        // Danio emitido por dragon = 15 * 2 = 30
        // Danio recibido por guerrero = 30 - 5 = 25
        // Salud final del guerrero = 100 - 25 = 75
        dragon.atacar(guerrero);

        // Assert
        assertEquals(75, guerrero.getSalud(), "El guerrero deberia quedar con 75 de vida tras el ataque x2 del dragon");
        assertEquals(25, guerrero.getUltimoDanioRecibido());
    }

    @Test
    @DisplayName("Guerrero: El ataque debe usar la fuerza base directa")
    void testGuerreroAtaqueUsaFuerzaBase() {
        // Act: Guerrero (fuerza 20) ataca al Mago (absorcion 4)
        // Danio recibido por mago = 20 - 4 = 16
        // Salud final del mago = 80 - 16 = 64
        guerrero.atacar(mago);

        // Assert
        assertEquals(64, mago.getSalud(), "El mago deberia quedar con 64 de vida");
    }

    @Test
    @DisplayName("Salud: Si el ataque es inferior a la defensa, el danio recibido debe ser 0 y la salud no debe aumentar")
    void testDanioMenorAlBloqueoNoCausaDanioNiCura() {
        // Act: Dragon con reduccion de 7 recibe ataque débil de 3 de danio
        dragon.defender(3);

        // Assert: Danio neto = Math.max(0, 3 - 7) = 0
        assertEquals(0, dragon.getUltimoDanioRecibido(), "El danio neto no debe ser negativo");
        assertEquals(120, dragon.getSalud(), "La salud debe mantenerse intacta");
    }

    @Test
    @DisplayName("Salud: Un danio letal no debe dejar la salud en numeros negativos")
    void testSaludNuncaEsNegativa() {
        // Act: Recibe 999 de danio
        guerrero.defender(999);

        // Assert
        assertEquals(0, guerrero.getSalud(), "La salud debe quedar en 0, jamas negativa");
    }

    @Test
    @DisplayName("Estado vital: estaViva() responde adecuadamente segun la salud")
    void testEstaVivaSegunSalud() {
        // Inicialmente con 100 de salud
        assertTrue(guerrero.estaViva(), "Una criatura con salud > 0 debe estar viva");

        // Al reducir la salud a 0
        guerrero.setSalud(0);
        assertFalse(guerrero.estaViva(), "Una criatura con 0 de salud debe considerarse derrotada/muerta");
    }

    @Test
    @DisplayName("Polimorfismo: Una referencia Criatura ejecuta el ataque especifico de su subclase")
    void testPolimorfismoEnAtaque() {
        // Arrange: Referencia polimorfica de Criatura que apunta a un Dragon
        Criatura criaturaGenerica = new Dragon("Dragon Polimorfico", 100, 10, "Escamas Duras");
        Guerrero objetivo = new Guerrero("Objetivo", 100, 5, "Escudo");

        // Act: En tiempo de ejecucion debe llamar a Dragon.atacar() (fuerza * 2 = 20)
        // El objetivo bloquea 5 -> Recibe 15 -> Vida restante: 85
        criaturaGenerica.atacar(objetivo);

        // Assert
        assertEquals(85, objetivo.getSalud(), "Debe haberse aplicado el ataque especial polimorfico del Dragon (fuerza * 2)");
    }
}

