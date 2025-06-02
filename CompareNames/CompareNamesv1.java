public class CompareNamesv1{
    public static void main(String[] args){
        System.out.println(compare("Resumen_Teoria_Redes_Protocolos_BulletsEnNegrita_250602_120554","Resumen_Teoria_Redes_Protocolos_BulletsEnNegrita"));
    }

    public static String compare(String s1, String s2){
        if(s1.equalsIgnoreCase(s2)){return "Both names are the same";}
        if(s1.length() != s2.length()){return "Names are different";}
        s1 = s1.toLowerCase(); s2 = s2.toLowerCase();
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){return "Names are different" + "["+ s1.substring(i)+"],[" + "["+ s2.substring(i)+"]";}
        }
        return "Both names are the same";
    }
}
