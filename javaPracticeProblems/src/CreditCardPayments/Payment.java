package CreditCardPayments;

public class Payment {

	/*
	 * Id     CustomerName     AmountPaid     CardType [ Master/VISA/AMEX ]    
	 * CardNumber     ExpiryDate [ MM/YY ]
	 */
	private int id;
	private String customerName;
	private double amountPaid;
	private String cardType;
	private long cardNumber;
	private String expiryDate;

	public Payment() {
		super();
	}

	public Payment(int id, String customerName, double amountPaid, String cardType, long cardNumber, String expiryDate) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.amountPaid = amountPaid;
		this.cardType = cardType;
		this.cardNumber = cardNumber;
		this.expiryDate = expiryDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public double getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(float amountPaid) {
		this.amountPaid = amountPaid;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

}
