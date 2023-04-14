package lib;

public class TaxFunction {
	
	public static int calculateTax(int annualNetIncome, boolean isMarried, int numberOfChildren) {
		
		int tax = 0;
		
		if (numberOfChildren > 3) {
			numberOfChildren = 3;
		}
		
		int nonTaxableIncome = 0;
		if(!isMarried && numberOfChildren <=0){
			nonTaxableIncome = 54000000;
		}else if (isMarried) {
			nonTaxableIncome = 54000000 + 4500000;
		}else if (numberOfChildren > 0) {
			nonTaxableIncome = 54000000 + (4500000 * numberOfChildren);
		}

		tax = (int) Math.round(0.05 * (annualNetIncome - nonTaxableIncome));
		
		if (tax < 0) {
			return 0;
		}else {
			return tax;
		}
			 
	}
	
}
