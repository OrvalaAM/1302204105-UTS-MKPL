package lib;

public class Person {
    private String firstName;
	private String lastName;
	private String idNumber;
	private String address;
    private boolean isForeigner;
	private boolean gender;

	public void setFirstName(String firstName){
		this.firstName = firstName;
	}

	public void setLastName(String lastName){
		this.lastName = lastName;
	}

	public void setIdNumber(String idNumber){
		this.idNumber = idNumber;
	}

	public void setAddress(String address){
		this.address = address;
	}

	public void setIsForeigner(boolean isForeigner){
		this.isForeigner = isForeigner;
	}

	public void setGender(boolean gender){
		this.gender = gender;
	}

	public boolean getIsForeigner(){
		return this.isForeigner;
	}

}