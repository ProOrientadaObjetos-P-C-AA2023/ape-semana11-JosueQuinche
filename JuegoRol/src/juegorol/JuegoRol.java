package juegorol;
abstract class Personaje{
    private String nombrePersonaje;
    private int puntosVida;
    public int nivelExperiencia;

    public Personaje(String nombrePersonaje, int puntosVida, int nivelExperiencia) {
        this.nombrePersonaje = nombrePersonaje;
        this.puntosVida = puntosVida;
        this.nivelExperiencia = nivelExperiencia;
    }
    public abstract void atacar();
    public abstract void defender();
    public void subirNivel(){
        nivelExperiencia++;
        System.out.println(nombrePersonaje+"subio de nivel.\nNUEVO NIVEL:"+nivelExperiencia);
    }

    public String getNombrePersonaje() {
        return nombrePersonaje;
    }

    public void setNombrePersonaje(String nombrePersonaje) {
        this.nombrePersonaje = nombrePersonaje;
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public void setPuntosVida(int puntosVida) {
        this.puntosVida = puntosVida;
    }

    public int getNivelExperiencia() {
        return nivelExperiencia;
    }

    public void setNivelExperiencia(int nivelExperiencia) {
        this.nivelExperiencia = nivelExperiencia;
    }
    
}
abstract class Guerreros extends Personaje{

    public Guerreros(String nombrePersonaje, int puntosVida, int nivelExperiencia) {
        super(nombrePersonaje, puntosVida, nivelExperiencia);
    }
    @Override 
    public void atacar(){
        System.out.println("El guerrero" + getNombrePersonaje() + " ataca con su espada.");
    }
    @Override
    public void defender(){
        System.out.println("El guerrero" + getNombrePersonaje() + " se defiende con su escudo.");
   }
    public void ataqueEspada(){
        System.out.println("El guerrero" + getNombrePersonaje() + " realiza un ataque especial con su espada.");
    }    
}
abstract class Magos extends Personaje{

    public Magos(String nombrePersonaje, int puntosVida, int nivelExperiencia) {
        super(nombrePersonaje, puntosVida, nivelExperiencia);
    }
    public void atacar(){
        System.out.println("El mago" + getNombrePersonaje() + " lanza un hechizo.");  
    }
    public void defender(){
        System.out.println("El mago" + getNombrePersonaje() + " se defeinde con su escudo magico.");
    }
    public void lanzarHechizo(){
        System.out.println("El mago" + getNombrePersonaje() + " lanza un hechizo poderoso");
    }
}
abstract class Arqueros extends Personaje{

    public Arqueros(String nombrePersonaje, int puntosVida, int nivelExperiencia) {
        super(nombrePersonaje, puntosVida, nivelExperiencia);
    }
    public void atacar(){
        System.out.println("El arquero" + getNombrePersonaje() + "dispara una flecha.");
    }
    public void defender(){
        System.out.println("El arquero" + getNombrePersonaje() + "se defiende con su agilidad.");
    }
    public void disparaFlechas(){
        System.out.println("El arquero" + getNombrePersonaje() + "dispara una flecha explosiva.");
    }
}
public class JuegoRol {
    public static void main(String[] args) {
        Guerreros guerrero1 = new Guerreros(" Conan ",100,1) {};
        Magos mago1 = new Magos(" Grandalf ",80,1) {};
        Arqueros arqueros1 = new Arqueros("Legolas ",90,1) {};
        guerrero1.atacar();
        mago1.defender();
        arqueros1.subirNivel();
        guerrero1.ataqueEspada();
        mago1.lanzarHechizo();
        arqueros1.disparaFlechas();       
    }
    
}
