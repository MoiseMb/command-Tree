import java.io.File;

public class TreeCommand {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java TreeCommand <directory>");
            return;
        }

        String cheminRepertoire = args[0];
        File repertoire = new File(cheminRepertoire);

        if (!repertoire.isDirectory()) {
            System.out.println(cheminRepertoire + " is not a directory.");
            return;
        }

        Composant racine = construireStructureRepertoire(repertoire);
        racine.afficher("", true);
    }

    private static Composant construireStructureRepertoire(File repertoire) {
        Dossier racine = new Dossier(repertoire);

        File[] fichiers = repertoire.listFiles();
        if (fichiers != null) {
            for (File fichier : fichiers) {
                if (fichier.isDirectory()) {
                    Composant enfantComposant = construireStructureRepertoire(fichier);
                    racine.ajouter(enfantComposant);
                } else {
                    Composant feuilleComposant = new Fichier(fichier);
                    racine.ajouter(feuilleComposant);
                }
            }
        }

        return racine;
    }
}