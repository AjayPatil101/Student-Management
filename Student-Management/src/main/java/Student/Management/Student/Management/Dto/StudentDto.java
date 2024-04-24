package Student.Management.Student.Management.Dto;

public class StudentDto {
	private Long Id;
	private String FirstName;
	private String LastName;
	private String Email;
	
	public StudentDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StudentDto(Long id, String firstName, String lastName, String email) {
		super();
		Id = id;
		FirstName = firstName;
		LastName = lastName;
		Email = email;
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
}
