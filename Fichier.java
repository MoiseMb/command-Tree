import java.io.File;

public class Fichier extends Composant {
    public Fichier(File file) {
        super(file);
    }

    @Override
    public void afficher(String indent, boolean isLast) {
        System.out.println(indent + (isLast ? "└───" : "├───") + file.getName());
    }
}

