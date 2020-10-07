package SAX;

public class Libro {
    private String isbn;
    private String titulo;
    private String autor;
    private String anyo;
    private String editorial;

    public Libro() {
    }

    public Libro(String isbn, String titulo, String autor, String anyo, String editorial) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.anyo = anyo;
        this.editorial = editorial;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAnyo() {
        return anyo;
    }

    public void setAnyo(String anyo) {
        this.anyo = anyo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    @Override
    public String toString() {
        return ("ISBN: " + isbn + " Título: " + titulo + " Autor: " + autor + " Año: " + anyo + " Editorial: " + editorial);
    }
}
