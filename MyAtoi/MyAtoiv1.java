public class MyAtoiv1{
    public static void main(String[] args) {
        System.out.println("Result: " + myAtoi("42"));
        System.out.println("Result: " + myAtoi("-042"));
        System.out.println("Result: " + myAtoi("1337c0d3"));
    }

    public static int myAtoi(String s){
        if(s == null || s.length() == 0){return 0;}
        if(!s.startsWith("-") || !s.startsWith("+")){return Integer.parseInt(s);}
        try{
            String aux = "";
            while (s.startsWith("[+-]?[0-9]+")){
                aux += s.charAt(0);
                s = s.substring(1);
            }
            return Integer.parseInt(aux);
        }catch(Exception e){
            return 0;
        }
    }
}
