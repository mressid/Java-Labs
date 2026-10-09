import java.util.ArrayList;
import java.util.UUID;

public class Reservation {
    private String _reservationId;
    private ArrayList<MemberReservedWithOrder> membersReserved;
    private Document _targetDocument;
    private Integer _lastOrder;

    public Reservation(String reservationId, Document targetDocument) {
        this._reservationId = (reservationId != null && !reservationId.isBlank())
                ? reservationId
                : UUID.randomUUID().toString();
        this.membersReserved = new ArrayList<>();
        this._targetDocument = targetDocument;
        this._lastOrder = 0;
    }

    public Reservation(Document targetDocument) {
        this(UUID.randomUUID().toString(), targetDocument);
    }

    public String getReservationId() {
        return _reservationId;
    }

    public Document getTargetDocument() {
        return _targetDocument;
    }

    public ArrayList<MemberReservedWithOrder> getMembersReserved() {
        return membersReserved;
    }

    public Integer getLastOrder() {
        return _lastOrder;
    }

    public String ajouterMembre(Membre membre) {
        if (membre == null) {
            return "membre invalide";
        }

        for (MemberReservedWithOrder item : membersReserved) {
            if (item.membre().getIdMembre().equals(membre.getIdMembre())) {
                return "membre déjà dans la liste de réservation";
            }
        }

        _lastOrder++;
        MemberReservedWithOrder entry = new MemberReservedWithOrder(membre, _lastOrder);
        membersReserved.add(entry);

        return "réservation ajoutée avec succès (ordre " + _lastOrder + ")";
    }

    public MemberReservedWithOrder notifierPremierMembre() {
        if (membersReserved.isEmpty()) {
            System.out.println("Aucune réservation en attente pour : " + _targetDocument.getTitre());
            return null;
        }

        MemberReservedWithOrder prochain = membersReserved.remove(0);
        System.out.println("Notification : Le document '" + _targetDocument.getTitre() +
                "' est maintenant disponible pour " + prochain.membre().getNom() + " " + prochain.membre().getPrenom() +
                " (Ordre d'attente : " + prochain.order() + ")");
        return prochain;
    }

    public boolean hasReservations() {
        return !membersReserved.isEmpty();
    }

    public int getNombreReservations() {
        return membersReserved.size();
    }

    public void afficherReservations() {
        System.out.println("=== Liste d'attente pour : " + _targetDocument.getTitre() + " ===");
        if (membersReserved.isEmpty()) {
            System.out.println("Aucune réservation en cours.");
            return;
        }

        for (MemberReservedWithOrder item : membersReserved) {
            System.out.println(" - Ordre " + item.order() + " : " +
                    item.membre().getNom() + " " + item.membre().getPrenom() +
                    " (ID: " + item.membre().getIdMembre() + ")");
        }
    }
}

