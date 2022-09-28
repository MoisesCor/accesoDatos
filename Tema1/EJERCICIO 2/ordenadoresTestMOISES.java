package entregasMJG.Ejercicio2;

public class ordenadoresTestMOISES {
    public static void main(String[] args) {
        portatiles portatil1 = new portatiles("Coisar", "iCore i9", 700,"CHGDG", 2.5);
        portatiles portatil2 = new portatiles("HP-21", "intel 20", 1000,"XKKT", 1.0);

        sobremesa sobreme1 = new sobremesa("Vengeance", "promax", 2000," PKJD", " gamer");
        sobremesa sobreme2 = new sobremesa("corpor", "endrive", 2500,"OPOPD", " refrigerada anticongelante");

        portatil1.getCaracterisiticas();

        portatil2.getCaracterisiticas();
        sobreme1.getCaracterisiticas();
        sobreme2.getCaracterisiticas();



    }
}
