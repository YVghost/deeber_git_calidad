import java.util.Objects;

/**
 * Representa un libro de la biblioteca universitaria que puede prestarse y devolverse.
 */
public class Libro {

  private final String titulo;
  private final String autor;
  private boolean disponible = true;

  /**
   * Crea un libro disponible para prestamo.
   *
   * @param titulo titulo del libro
   * @param autor autor del libro
   */
  public Libro(String titulo, String autor) {
    this.titulo = titulo;
    this.autor = autor;
  }

  public String getTitulo() {
    return titulo;
  }

  public String getAutor() {
    return autor;
  }

  public boolean estaDisponible() {
    return disponible;
  }

  /**
   * Presta el libro si esta disponible.
   *
   * @throws IllegalStateException si el libro ya esta prestado
   */
  public void prestar() {
    if (!disponible) {
      throw new IllegalStateException("Libro no disponible");
    }
    disponible = false;
  }

  /**
   * Devuelve el libro y lo deja disponible nuevamente.
   */
  public void devolver() {
    disponible = true;
  }

  /**
   * Compara el titulo del libro por contenido y no por referencia.
   *
   * @param otroTitulo titulo a comparar
   * @return true si ambos titulos tienen el mismo contenido
   */
  public boolean esMismoTitulo(String otroTitulo) {
    return Objects.equals(titulo, otroTitulo);
  }
}
