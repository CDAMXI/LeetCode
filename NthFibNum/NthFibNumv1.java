public class NthFibNumv1{
    public static void main(String[] args){
        System.out.println("The 5th value of the Fibonacci sequence is: " + NthFibNum(5));
    }

    public static long NthFibNum(int n){
        if(n <= 1){return n;}
        else{return NthFibNum(n - 1) + NthFibNum(n - 2);}
    }
}
