package restaurante;

import java.util.ArrayList;
import java.util.List;

abstract class Menu{
    protected String nombrePlato;
    protected double valorMenu;
    protected double valorInicial;
    public double getSubtotal(){
        return valorMenu;
    }
    @Override
    public String toString(){
        return nombrePlato + ": $"+ valorMenu;
    }
}
class MenuAcarta extends Menu{
    private double valorGuarnicion;
    private double valorBebida;
    private double porcentajeServicio;

    public MenuAcarta(String nombrePlato,double valorMenu, double valorInicial,double valorGuarnicion, double valorBebida, double porcentajeServicio) {
        this.nombrePlato = nombrePlato;
        this.valorMenu = valorMenu;
        this.valorInicial = valorInicial;
        this.valorGuarnicion = valorGuarnicion;
        this.valorBebida = valorBebida;
        this.porcentajeServicio = porcentajeServicio;
    }
    public double getSubtotal(){
        double subtotal1 = valorMenu + valorGuarnicion + valorBebida;
        double servicio1 = (valorInicial * porcentajeServicio)/100;
        return subtotal1 + servicio1;
    }
    @Override
    public String toString(){
        return super.toString() + " (A La carta)";
    }
}
class MenuDía extends Menu{
    private double valorPostre;
    private double valorBebida;

    public MenuDía(String nombrePlato,double valorMenu, double valorInicial,double valorPostre, double valorBebida) {
        this.nombrePlato = nombrePlato;
        this.valorInicial = valorInicial;
        this.valorMenu = valorMenu;
        this.valorPostre = valorPostre;
        this.valorBebida = valorBebida;
    }
    public double getSubtotal(){
        return valorMenu +valorPostre + valorBebida;
    }
    @Override
    public String toString(){
        return super.toString() + "( Menu del dia)";
    }    
}
class MenuNinos extends Menu{
    private double valorHelado;
    private double valorPastel;

    public MenuNinos(String nombrePlato, double valorMenu,double valorInicial,double valorHelado, double valorPastel) {
        this.nombrePlato = nombrePlato;
        this.valorInicial = valorInicial;
        this.valorMenu = valorMenu;
        this.valorHelado = valorHelado;
        this.valorPastel = valorPastel;
    }
    public double getSubtotal(){
        return valorMenu + valorHelado + valorPastel;
    }
    @Override
    public String toString(){
        return super.toString() + "( Menu de Ninos)";
    }    
}
class MenuEconomico extends Menu{
    private double descuento;
    public MenuEconomico(String nombrePlato, double valorMenu, double valorInicial, double descuento) {
        this.nombrePlato = nombrePlato;
        this.valorMenu = valorMenu;
        this.valorInicial = valorInicial;
        this.descuento = descuento;
    }
    public double getSubtotal(){
        double descuentoAplicado = (valorInicial * descuento)/100;
        return valorMenu - descuentoAplicado;
    }
    @Override
    public String toString(){
        return super.toString() +"( Menu Económico)";
    }    
}
abstract class Cuenta{
    private String clinete;
    private List<Menu> menuList;
    private double iva;

    public Cuenta(String clinete, double iva) {
        this.clinete = clinete;
        this.menuList = new ArrayList<>();
        this.iva = iva;
    }
    public void agregarMenu(Menu menu){
        menuList.add(menu);
    }
    public double calcularTotal(){
        double subtotal = 0.0;
        for (Menu menu : menuList) {
            subtotal += menu.getSubtotal();
        }
        return subtotal + (subtotal * iva / 100 );
    }
    @Override
    public String toString(){
        StringBuilder sd = new StringBuilder();
        sd.append("Cliente: ").append(clinete).append("\n");
        sd.append("Subtotal: $").append(calcularTotal() / (1+iva/100)).append("\n");
        sd.append("IVA: ").append(iva).append("%").append("\n");
        sd.append("Menús: ").append("\n");
        for (Menu menu : menuList) {
            sd.append("- ").append(menu).append("\n");
        }
        sd.append("Total a Cancelar: $").append(calcularTotal()).append("\n");
        return sd.toString();
    }       
}

public class Restaurante {
    public static void main(String[] args) {
        MenuNinos menuNinos1 = new MenuNinos("Hamburguesa",10.0,8.0,2.0,1.5);
        MenuNinos menuNinos2 = new MenuNinos("Pizza",12.0,9.0,2.5,1.0);
        MenuEconomico menuEconomico1 = new MenuEconomico("Plato del dia", 15.0, 12.0, 20.0);
        MenuDía menuDia1 = new MenuDía("Pasta", 18.0, 15.0, 2.0, 1.5);
        MenuAcarta menuAcarta1 = new MenuAcarta("Filete de Res", 20.0, 18.0, 5.0, 3.0, 10.0);
        Cuenta cuenta = new Cuenta("Juan Perez", 12.0) {};
        cuenta.agregarMenu(menuNinos1);
        cuenta.agregarMenu(menuNinos2);
        cuenta.agregarMenu(menuEconomico1);
        cuenta.agregarMenu(menuDia1);
        cuenta.agregarMenu(menuAcarta1);
        System.out.println(cuenta.toString());
        
    } 
}
