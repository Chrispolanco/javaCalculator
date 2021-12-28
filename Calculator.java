public class Calculator implements Runnable{

	private String name;
	private double errorConstant;

	public String correctOrIncorrect = ""; 
	public Integer count = 0; 
	public Integer correctCount = 0; 
	public Double random1; 
	public Double random2; 
	public String sign = ""; 
	
	public Calculator(String name) {
		this.name = name;
		this.errorConstant = Math.random();
	}
	
	//Parallel Runs
	@Override
	public void run(){
		randomNumbers();
	}

	//Generate random numbers to start process
	public void randomNumbers(){
		random1 = Math.random(); 
		random2 = Math.random(); 

		add(random1, random2); 
	}

	//Calculates correct calculation and calls upon method to obtain calculation that may have quantam error. Assigns sign the plus sign. 
	public void add(Double a, Double b) {
		double correctCalculation = a + b;
		double calculationQuantom = addQuantomError(correctCalculation);
		sign = " + "; 

		updateCorrectOrIncorrect(correctCalculation, calculationQuantom); 
	}

	//While count is less than 20 determins if calculation obtains via the addQuantomError is correct. Depending on the result assigns correctOrIncorrect. Count increases by one. 
	public void updateCorrectOrIncorrect(double correctCalculation, double calculation){
		while(count < 20){
			count++; 
			if(calculation == correctCalculation){
				correctOrIncorrect = "(correct)"; 
				correctCount++; 
				printCalculation(calculation); 
			}else{
				correctOrIncorrect = "(error)";
				printCalculation(calculation);
			}; 
		}
	}

	//Prints calculation and correctOrIncorrect variable. 
	public void printCalculation(double calculation){
		System.out.println(random1 + sign + random2 + " = " + calculation + "   " + correctOrIncorrect); 
		randomNumbers();
	}

	//Calculates correct calculation and calls upon method to obtain calculation that may have quantam error. Assigns sign the minus sign. 
	public void subtract(Double a, Double b) {
		double correctCalculation = a - b;
		double calculationQuantom = addQuantomError(correctCalculation);
		sign = " - "; 

		updateCorrectOrIncorrect(correctCalculation, calculationQuantom); 
	}


	//Determins whether the calculation will contain an error. 
	private double addQuantomError(double calculation) {
		if (Math.random() < this.errorConstant) {
			calculation = calculation + Math.random();
		}
		return calculation;
	}

	//Allows the name of the instance to be called. 
	public String getName() {
		return name;
	}

	//Determins the percentage of correct calculations out of 20. 
	public double getRatio(){
		double ratio = correctCount / 20.0; 
		return ratio; 
	}

}
