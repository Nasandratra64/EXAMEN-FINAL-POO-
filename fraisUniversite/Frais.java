
package fraisUniversite;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Frais {
    private int id;
    private String libelle;
    private double montant;
    private Instant dateLimite;
    private Etudiants etudiant;
    private List<Paiement> paiements;

    public enum StatutFrais {
        NUL, EN_COURS, PAYE, EN_RETARD, SURPAYE
    }

    public Frais(int id, String libelle, double montant, Instant dateLimite, Etudiants etudiant) {
        this.id = id;
        this.libelle = libelle;
        this.montant = montant;
        this.dateLimite = dateLimite;
        this.etudiant = etudiant;
        this.paiements = new ArrayList<>();
    }

    public void ajouterPaiement(Paiement paiement) {
        paiements.add(paiement);
    }

    public StatutFrais getStatut(Instant instant) {
        double totalPaye = paiements.stream().mapToDouble(Paiement::getMontant).sum();

        if (totalPaye == 0) {
            return StatutFrais.NUL;
        }
        if (totalPaye > montant) {
            return StatutFrais.SURPAYE;
        }
        if (totalPaye == montant) {
            return StatutFrais.PAYE;
        }
        if (instant.isAfter(dateLimite)) {
            return StatutFrais.EN_RETARD;
        }
        return StatutFrais.EN_COURS;
    }

    public int getId() {
        return id;
    }

    public double getMontant() {
        return montant;
    }
    public String getLibelle() {
    return libelle;
}

    public Instant getDateLimite() {
        return dateLimite;
    }

    public Etudiants getEtudiant() {
        return etudiant;
    }

    public List<Paiement> getPaiements() {
        return paiements;
    }
    
}
