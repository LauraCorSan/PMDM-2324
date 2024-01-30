package InicioProyecto;

import com.example.pmdm_2324.R;

import java.io.Serializable;
import java.util.ArrayList;

public class Consejo implements Serializable {
    String titulo;
    String descripcion;
    int edadMeses;
    int icono;


    public Consejo(String titulo, String descripcion, int meses) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.edadMeses = meses;
        this.icono = R.drawable.anonimo_;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getEdadMeses() {
        return edadMeses;
    }

    public int getIcono() {
        return icono;
    }

    public void setIcono(int icono) {
        this.icono = icono;
    }

    public static ArrayList<Consejo> generador() {
        ArrayList<Consejo> consejillos = new ArrayList<Consejo>();

        consejillos.add(new Consejo("Establecer una rutina", "Los niños pequeños prosperan con rutinas predecibles. Establece horarios regulares para comer, dormir y jugar. Esto brinda seguridad y estructura a su día.", 14));
        consejillos.add(new Consejo("Seguridad en el hogar", "Asegúrate de que el entorno de tu bebé sea seguro. Usa protectores en enchufes, mantén objetos pequeños fuera de su alcance y asegura muebles para evitar accidentes.", 7));
        consejillos.add(new Consejo("Amamantar o alimentar con cuidado", "i eliges amamantar, busca apoyo y sigue una buena técnica. Si alimentas con biberón, hazlo con calma y disfruta del tiempo de alimentación", 0));
        consejillos.add(new Consejo("Fomentar el apego seguro", "Responde rápidamente a las necesidades emocionales de tu bebé. Brinda consuelo y afecto para construir un apego seguro, lo que es fundamental para su desarrollo emocional y social", 1));
        consejillos.add(new Consejo("Comunicación positiva", "Habla con tu bebé regularmente, aunque no entienda todas las palabras. Usa un tono de voz suave y afectuoso. La comunicación positiva contribuye al desarrollo del lenguaje", 1));
        consejillos.add(new Consejo("Promover la independencia", "A medida que los niños crecen, dales oportunidades para desarrollar habilidades independientes como comer solos, vestirse y lavarse las manos", 16));
        consejillos.add(new Consejo("Establecer límites claros", "Aunque los niños pequeños aún no comprenden completamente las reglas, establecer límites claros les brinda seguridad. Sé consistente y explícales de manera simple las expectativas.", 12));
        consejillos.add(new Consejo("Dormir lo suficiente", "El sueño es crucial para el desarrollo. Establece hábitos de sueño saludables y crea un ambiente tranquilo y oscuro para las siestas y la noche", 0));
        consejillos.add(new Consejo("Promover la estimulación sensorial", "Los niños pequeños aprenden a través de sus sentidos. Proporciónales experiencias sensoriales como tocar, oler, probar y escuchar diferentes cosas.", 6));
        consejillos.add(new Consejo("Evitar la sobreestimulación", "Si bien la estimulación es esencial, evita la sobreestimulación. Respeta las señales de cansancio y da a tu hijo tiempo para descansar", 4));
        consejillos.add(new Consejo("Cuida de ti mismo", "La crianza puede ser agotadora. Asegúrate de cuidar tu bienestar físico y emocional. Tómate descansos cuando sea necesario y busca apoyo de amigos, familiares o grupos de apoyo", 0));
        consejillos.add(new Consejo("Promover la socialización", "Proporciona oportunidades para que interactúen con otros niños. Las interacciones sociales son cruciales para el desarrollo de habilidades sociales y emocionales", 8));
        consejillos.add(new Consejo("Limitar el tiempo frente a las pantallas", "Evita el exceso de tiempo frente a la televisión, tabletas o teléfonos. Limita el tiempo de pantalla y elige programas educativos y apropiados para su edad", 4));
        consejillos.add(new Consejo("Celebrar los logros", "Celebra los pequeños logros y hitos de tu hijo. Esto refuerza su autoestima y fomenta una actitud positiva hacia el aprendizaje", 8));
        consejillos.add(new Consejo("Involucrarlos en las tareas diarias", "Involucra a tu hijo en tareas diarias simples, como guardar juguetes, vestirse o ayudar con la comida. Esto fomenta la responsabilidad y la autonomía", 16));
        consejillos.add(new Consejo("Fomentar la expresión creativa", "Proporciona materiales para que exploren su creatividad, como papel, crayones y juguetes de construcción. La expresión creativa es fundamental para el desarrollo cognitivo y emocional", 14));
        consejillos.add(new Consejo("Estimular el juego al aire libre", "El juego al aire libre es esencial para su desarrollo físico y emocional. Proporciónales tiempo para jugar fuera, explorar la naturaleza y disfrutar del aire fresco.", 16));
        consejillos.add(new Consejo("Fomentar la resolución de problemas", "Anima a tu hijo a resolver problemas por sí mismo en la medida de lo posible. Esto desarrolla habilidades de resolución de problemas y autoeficacia.", 19));
        consejillos.add(new Consejo("Promover hábitos saludables", "Establece hábitos saludables desde el principio, como una dieta equilibrada, buenos hábitos de sueño y prácticas de higiene personal.", 0));

        //Rangos
        int iconoRango = 0;
        for (Consejo consejito : consejillos) {

            if (consejito.getEdadMeses() < 6) {
                iconoRango = R.drawable.helado;
            }
            if (consejito.getEdadMeses() >= 6 && consejito.getEdadMeses() < 12) {
                iconoRango = R.drawable.tijera;
            }
            if (consejito.getEdadMeses() >= 12 && consejito.getEdadMeses() < 18) {
                iconoRango = R.drawable.papel;
            }
            if (consejito.getEdadMeses() >= 18 && consejito.getEdadMeses() < 24) {
                iconoRango = R.drawable.piedra;
            }
            if (consejito.getEdadMeses() >= 24 && consejito.getEdadMeses() < 30) {
                iconoRango = R.drawable.check;
            }
            if (consejito.getEdadMeses() >= 30 && consejito.getEdadMeses() < 36) {
                iconoRango = R.drawable.check_morado;
            }

            consejito.setIcono(iconoRango);
        }

        return consejillos;
    }
}
