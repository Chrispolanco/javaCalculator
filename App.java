public class App {

    //Prints out the success rate of each crystal. 
    public static void printResult(String num, Calculator crystal)  {
        System.out.println("Crystal " + num + " Success rate: " + crystal.getRatio());  
    } 
    public static void main(String[] args){
        Calculator crystal1 = new Calculator("crystal1"); 
        Thread myCalculator1 = new Thread(crystal1); 

        Calculator crystal2 = new Calculator("crystal2"); 
        Thread myCalculator2 = new Thread(crystal2); 

        System.out.println("Calculator Crystal 1:"); 
        myCalculator1.start();
        try {
            myCalculator1.join();
        } 
        catch (InterruptedException e) {
        }

        System.out.println(); 

        System.out.println("Calculator Crystal 2:"); 
        myCalculator2.start();
        try {
            myCalculator2.join();
        } 
        catch (InterruptedException e) {
        }

        System.out.println(); 

        printResult("1", crystal1);
        printResult("2", crystal2);

        if(crystal1.getRatio() > crystal2.getRatio()){
            System.out.println("Crystal 1 is better"); 
        }else{
            System.out.println("Crystal 2 is better"); 
        }
    }
    
}
