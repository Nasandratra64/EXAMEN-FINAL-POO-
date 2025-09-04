
package fraisUniversite;

import java.time.Instant;

public abstract class Paiement {
    private int id;
    private double montant;
    private Instant datePaiement;

    public Paiement(int id, double montant, Instant datePaiement) {
        this.id = id;
        this.montant = montant;
        this.datePaiement = datePaiement;
    }

    public int getId() {
        return id;
    }

    public double getMontant() {
        return montant;
    }

    public Instant getDatePaiement() {
        return datePaiement;
    }
}
