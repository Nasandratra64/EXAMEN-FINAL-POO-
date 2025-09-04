package FraisTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fraisUniversite.Frais.StatutFrais;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import static org.junit.jupiter.api.Assertions.*;

public class Test {
    private Etudiant etudiant;
    private Frais frais;
    private Instant now;
    private Instant past;
    private Instant future;


    @BeforeEach
    void setUp() {
        
        ZonedDateTime franceTime = ZonedDateTime.of(2025, 9, 4, 10, 43, 0, 0, ZoneId.of("Europe/Paris"));
        now = franceTime.toInstant();
        past = now.minusSeconds(3600 * 24); 
        future = now.plusSeconds(3600 * 24); 
       
         = new Etudiant(24062, "RANDRIANANTENAINA", "Nasandratra", now.minusSeconds(3600 * 24 * 365));
        frais = new Frais(1, "Frais de scolarité", 1500.0, future, etudiant); 
    }

    @Test
    void testStatutNulQuandAucunPaiement() {
        assertEquals(StatutFrais.NUL, frais.getStatut(now), 
            "Le statut devrait être NUL si aucun paiement n'est effectué.");
    }

    @Test
    void testStatutEnCoursQuandPaiementPartielAvantDeadline() {
        frais.addPaiement(new PaiementEspeces(1, 500.0, now)); 
        assertEquals(StatutFrais.EN_COURS, frais.getStatut(now), 
            "Le statut devrait être EN_COURS si le paiement est partiel et la deadline non dépassée.");
    }

    @Test
    void testStatutPayeQuandPaiementComplet() {
        frais.addPaiement(new PaiementCarte(1, 1500.0, now)); 
        assertEquals(StatutFrais.PAYE, frais.getStatut(now), 
            "Le statut devrait être PAYE si le montant total est payé.");
    }

    @Test
    void testStatutSurpayeQuandPaiementExcedentaire() {
        frais.addPaiement(new PaiementCarte(1, 2000.0, now));// Paiement supérieur de 2000 EUR
        assertEquals(StatutFrais.SURPAYE, frais.getStatut(now), 
            "Le statut devrait être SURPAYE si le montant payé dépasse le montant dû.");
    }

    @Test
    void testStatutEnRetardQuandPaiementPartielApresDeadline() {
        frais = new Frais(2, "Frais de scolarité", 1500.0, past, etudiant); 
        frais.addPaiement(new PaiementEspeces(2, 500.0, past)); 
    }
}