import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "professor")
public class Professor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private int id;

	@Column(name = "office_number")
	private String officeNumber;

	@Column(name = "research_area")
	private String researchArea;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id")
	@MapsId
	private Customer customer;

	public Professor() {

	}

	public Professor(String officeNumber, String researchArea) {
		this.officeNumber = officeNumber;
		this.researchArea = researchArea;
	}

	public int getId() {
		return id;
	}

	public String getOfficeNumber() {
		return officeNumber;
	}

	public String getResearchArea() {
		return researchArea;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setOfficeNumber(String officeNumber) {
		this.officeNumber = officeNumber;
	}

	public void setResearchArea(String researchArea) {
		this.researchArea = researchArea;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}