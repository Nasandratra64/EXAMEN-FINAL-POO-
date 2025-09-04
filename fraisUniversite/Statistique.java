
package fraisUniversite;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

public class Statistique {
    public List<Frais> getFraisEnRetard(List<Frais> frais, Instant t) {
        return frais.stream()
                .filter(f -> f.getStatut(t) == Frais.StatutFrais.EN_RETARD)
                .collect(Collectors.toList());
    }

    public double getTotalFraisManquants(List<Frais> frais, Instant t) {
        return getFraisEnRetard(frais, t).stream()
                .mapToDouble(f -> f.getMontant() - f.getPaiements().stream()
                        .mapToDouble(Paiement::getMontant).sum())
                .sum();
    }

    public double getTotalPayeParEtudiant(Etudiants etudiant, List<Frais> frais, Instant t) {
        return frais.stream()
                .filter(f -> f.getEtudiant().getId() == etudiant.getId())
                .flatMap(f -> f.getPaiements().stream())
                .filter(p -> !p.getDatePaiement().isAfter(t))
                .mapToDouble(Paiement::getMontant)
                .sum();
    }
}
