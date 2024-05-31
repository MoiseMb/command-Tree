import java.util.ArrayList;
import java.util.List;
import java.io.File;

public class Dossier extends Composant {
    private List<Composant> enfants = new ArrayList<>();

    public Dossier(File file) {
        super(file);
    }

    public void ajouter(Composant composant) {
        enfants.add(composant);
    }

    @Override
    public void afficher(String indent, boolean isLast) {
        System.out.println(indent + (isLast ? "└───" : "├───") + file.getName());
        indent += isLast ? "    " : "│   ";

        for (int i = 0; i < enfants.size(); i++) {
            enfants.get(i).afficher(indent, i == enfants.size() - 1);
        }
    }
}