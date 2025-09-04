
package fraisUniversite;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Etudiants {
    private String id;
    private String nom;
    private String prenom;
    private Instant dateInscription;
    private List<Groupes> historiqueGroupes;

    public Etudiants(String id, String nom, String prenom, Instant dateInscription) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateInscription = dateInscription;
        this.historiqueGroupes = new ArrayList<>();
    }

    public void ajouterGroupe(Groupes groupe) {
        historiqueGroupes.add(groupe);
    }

    public String getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Instant getDateInscription() {
        return dateInscription;
    }

    public List<Groupes> getHistoriqueGroupes() {
        return historiqueGroupes;
    }
}
