
import java.util.ArrayList;
import java.util.List;

// Clase para representar un boleto
class Ticket {
    private String attractionName;
    private double price;

    public Ticket(String attractionName, double price) {
        this.attractionName = attractionName;
        this.price = price;
    }

    public String getAttractionName() {
        return attractionName;
    }

    public double getPrice() {
        return price;
    }
}

// Clase para representar una atracción
class Attraction {
    private String name;
    private double basePrice;

    public Attraction(String name, double basePrice) {
        this.name = name;
        this.basePrice = basePrice;
    }

    public String getName() {
        return name;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public Ticket sellTicket() {
        return new Ticket(name, basePrice);
    }
}

// Clase para el parque de diversiones que maneja las atracciones
class AmusementPark {
    private List<Attraction> attractions = new ArrayList<>();

    public void addAttraction(Attraction attraction) {
        attractions.add(attraction);
    }

    public List<Attraction> getAttractions() {
        return attractions;
    }
}
