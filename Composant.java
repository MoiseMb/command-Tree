import java.io.File;

public abstract class Composant {
    protected File file;

    public Composant(File file) {
        this.file = file;
    }

    public abstract void afficher(String indent, boolean isLast);
}