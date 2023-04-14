package lib;

import java.time.LocalDate;
import java.time.Month;
import java.util.LinkedList;
import java.util.List;
import java.util.Date;

public class Employee extends Person {

	private String employeeId;
	
	private Date dateJoined;
	private int monthWorkingInYear;
	
	
	private int monthlySalary;
	private int otherMonthlyIncome;
	private int annualDeductible;
	
	private String spouseName;
	private String spouseIdNumber;

	private List<String> childNames;
	private List<String> childIdNumbers;
	
	public Employee(String employeeId, String firstName, String lastName, String idNumber, String address, boolean isForeigner, boolean gender, Date dateJoined) {
		this.employeeId = employeeId;
		super.setFirstName(firstName);
		super.setLastName(lastName);
		super.setIdNumber(idNumber);
		super.setAddress(address);
		this.setIsForeigner(isForeigner);
		this.setGender(gender);
		this.dateJoined = dateJoined;
		
		childNames = new LinkedList<String>();
		childIdNumbers = new LinkedList<String>();
	}
	
	
	public void setMonthlySalary(int grade) {	
		if (grade == 1) {
			monthlySalary = 3000000;
		}else if (grade == 2) {
			monthlySalary = 5000000;
		}else if (grade == 3) {
			monthlySalary = 7000000;
		}

		if (super.getIsForeigner()) {
			monthlySalary = (int) (monthlySalary * 1.5);
		}
	}
	
	public void setAnnualDeductible(int deductible) {	
		this.annualDeductible = deductible;
	}
	
	public void setAdditionalIncome(int income) {	
		this.otherMonthlyIncome = income;
	}
	
	public void setSpouse(String spouseName, String spouseIdNumber) {
		this.spouseName = spouseName;
		this.spouseIdNumber = spouseIdNumber;
	}
	
	public void addChild(String childName, String childIdNumber) {
		childNames.add(childName);
		childIdNumbers.add(childIdNumber);
	}
	
	public int getAnnualIncomeTax() {
		
		//Menghitung berapa lama pegawai bekerja dalam setahun ini, jika pegawai sudah bekerja dari tahun sebelumnya maka otomatis dianggap 12 bulan.
		LocalDate date = LocalDate.now();
		
		if (date.getYear() == dateJoined.getYear()) {
			monthWorkingInYear = date.getMonthValue() - dateJoined.getMonth();
		}else {
			monthWorkingInYear = 12;
		}

		int annualNetIncome = getAnnualIncome(monthlySalary, otherMonthlyIncome, monthWorkingInYear) - annualDeductible;
		
		return TaxFunction.calculateTax(annualNetIncome, spouseIdNumber.equals(""), childIdNumbers.size());
	}

	public int getAnnualIncome(int monthlySalary, int otherMonthlyIncome, int monthWorkingInYear){
		return (monthlySalary + otherMonthlyIncome) * monthWorkingInYear;
	}
}
