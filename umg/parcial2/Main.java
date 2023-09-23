import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Clase para representar un boleto
class Ticket {
    private String NombreJuego;
    private double precioJuego;

    public Ticket(String attractionName, double price) {
        this.NombreJuego = attractionName;
        this.precioJuego = price;
    }

    public String getAttractionName() {
        return NombreJuego;
    }

    public double getprecioJuego() {
        return precioJuego;
    }
}

// Clase para representar una atracción
class Attraction {
    private String name;
    private double precio;

    public Attraction(String name, double basePrice) {
        this.name = name;
        this.precio = basePrice;
    }

    public String getName() {
        return name;
    }

    public double getprecio() {
        return precio;
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
        return new Ticket(attraction.getName() + " Regular Ticket", attraction.getprecio());
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
        double vipPrice = attraction.getprecio() * 1.5; 
        return new Ticket(attraction.getName() + " VIP Ticket", vipPrice);
    }
}

public class Main {
    public static void main(String[] args) {
        AmusementPark park = new AmusementPark();
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario la información de las atracciones
        while (true) {
            System.out.print("Ingrese el nombre de la atracción (o 'fin' para terminar): ");
            String attractionName = scanner.nextLine();

            if (attractionName.equalsIgnoreCase("fin")) {
                break;
            }

            System.out.print("Ingrese el precio base de la atracción: ");
            double basePrice = Double.parseDouble(scanner.nextLine());

            Attraction attraction = new Attraction(attractionName, basePrice);
            park.addAttraction(attraction);
        }

        // Vender boletos usando el patrón Abstract Factory
        for (Attraction attraction : park.getAttractions()) {
            TicketFactory regularTicketFactory = new RegularTicketFactory(attraction);
            TicketFactory vipTicketFactory = new VipTicketFactory(attraction);

            Ticket regularTicket = regularTicketFactory.createTicket();
            Ticket vipTicket = vipTicketFactory.createTicket();

            System.out.println("Selling " + regularTicket.getAttractionName() + " for $" + regularTicket.getprecioJuego());
            System.out.println("Selling " + vipTicket.getAttractionName() + " for $" + vipTicket.getprecioJuego());
        }

        // Cerrar el scanner
        scanner.close();
    }
}
