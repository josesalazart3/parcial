import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

// Interfaz para la fábrica de boletos
interface TicketFactory {
    Ticket createTicket();
}

// Fábrica concreta para boletos regulares
class RegularTicketFactory implements TicketFactory {
    private Attraction attraction;

    public RegularTicketFactory(Attraction attraction) {
        this.attraction = attraction;
    }

    @Override
    public Ticket createTicket() {
        return new Ticket(attraction.getName() + " Regular Ticket", attraction.getBasePrice());
    }
}

// Fábrica concreta para boletos VIP
class VipTicketFactory implements TicketFactory {
    private Attraction attraction;

    public VipTicketFactory(Attraction attraction) {
        this.attraction = attraction;
    }

    @Override
    public Ticket createTicket() {
        double vipPrice = attraction.getBasePrice() * 1.5; // Precio VIP
        return new Ticket(attraction.getName() + " VIP Ticket", vipPrice);
    }
}

   

