package co.basiru;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name= "authoorize_credit", schema="edureka")
public class AuthorizeCredit {
	private int id;
	private String name;
	private String cardNumber;
	private String cvv;
	private String amount;
	
	
	public AuthorizeCredit() {
		super();
	}


	public AuthorizeCredit( int id, String name, String cardNumber, String cvv, String amount) {
		super();
	    this.id = id;
		this.name = name;
		this.cardNumber = cardNumber;
		this.cvv = cvv;
		this.amount = amount;
	}
	
	
	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

    @Column(name = "name", length = 25)
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

    @Column(name = "cardNumber", length = 25)
	public String getCardNumber() {
		return cardNumber;
	}


	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

    @Column(name = "cvv", length = 25)
	public String getCvv() {
		return cvv;
	}


	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

    @Column(name = "amount", length = 10)
	public String getAmount() {
		return amount;
	}


	public void setAmount(String amount) {
		this.amount = amount;
	}


	@Override
	public String toString() {
		return "AuthorizeCredit [id=" + id + ", name=" + name + ", cardNumber=" + cardNumber + ", cvv=" + cvv + ", amount=" + amount
				+ "]";
	}
	
	
	
	

}
