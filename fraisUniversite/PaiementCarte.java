
package fraisUniversite;

import java.time.Instant;

public class PaiementCarte extends Paiement {
    public PaiementCarte(int id, double montant, Instant datePaiement) {
        super(id, montant, datePaiement);
    }
}

