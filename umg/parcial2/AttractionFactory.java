// Interfaz para la fábrica de atracciones
interface AttractionFactory {
    Attraction createAttraction();
}

// Fábrica concreta para la atracción de montaña rusa
class RollerCoasterFactory implements AttractionFactory {
    @Override
    public Attraction createAttraction() {
        return new Attraction("Roller Coaster", 20.0); // Precio base
    }
}

// Fábrica concreta para la atracción de carrusel
class CarouselFactory implements AttractionFactory {
    @Override
    public Attraction createAttraction() {
        return new Attraction("Carousel", 10.0); // Precio base
    }
}
