import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class LibroTest {

  @Test
  void deberiaCrearLibroDisponible() {
    Libro libro = new Libro("1984", "George Orwell");

    assertEquals("1984", libro.getTitulo());
    assertEquals("George Orwell", libro.getAutor());
    assertTrue(libro.estaDisponible());
  }

  @Test
  void deberiaPrestarLibroDisponible() {
    Libro libro = new Libro("1984", "George Orwell");

    libro.prestar();

    assertFalse(libro.estaDisponible());
  }

  @Test
  void deberiaLanzarErrorAlPrestarLibroNoDisponible() {
    Libro libro = new Libro("1984", "George Orwell");

    libro.prestar();

    assertThrows(IllegalStateException.class, libro::prestar);
  }

  @Test
  void deberiaDevolverLibroPrestado() {
    Libro libro = new Libro("1984", "George Orwell");

    libro.prestar();
    libro.devolver();

    assertTrue(libro.estaDisponible());
  }

  // Antes estaba @Disabled: fallaba porque esMismoTitulo comparaba referencias con ==.
  @Test
  void deberiaCompararTitulosPorContenido() {
    Libro libro = new Libro("1984", "George Orwell");

    String otroTitulo = new String("1984");

    assertTrue(libro.esMismoTitulo(otroTitulo));
  }

  @Test
  void deberiaDetectarTitulosDiferentes() {
    Libro libro = new Libro("1984", "George Orwell");

    assertFalse(libro.esMismoTitulo("Rebelion en la granja"));
    assertFalse(libro.esMismoTitulo(null));
  }

  @Test
  void deberiaPermitirPrestarNuevamenteTrasDevolver() {
    Libro libro = new Libro("1984", "George Orwell");

    libro.prestar();
    libro.devolver();
    libro.prestar();

    assertFalse(libro.estaDisponible());
  }
}
