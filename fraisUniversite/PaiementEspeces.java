
package fraisUniversite;

import java.time.Instant;

public class PaiementEspeces extends Paiement {
    public PaiementEspeces(int id, double montant, Instant datePaiement) {
        super(id, montant, datePaiement);
    }
}
