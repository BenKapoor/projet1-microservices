package eu.ensup.domaine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Bill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Date billingDate;
	private Long customerId;
	@Transient
	private Customer customer;
	@Transient
	@OneToMany(mappedBy = "bill")
	private Collection<ProductItem> productItems = new ArrayList<ProductItem>();
	
	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bill(Date billingDate, Long customerId, Customer customer, Collection<ProductItem> productItems) {
		super();
		this.billingDate = billingDate;
		this.customerId = customerId;
		this.customer = customer;
		this.productItems = productItems;
	}
	@Override
	public String toString() {
		return "Bill [id=" + id + ", billingDate=" + billingDate + ", customerId=" + customerId + ", customer="
				+ customer + ", productItems=" + productItems + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getBillingDate() {
		return billingDate;
	}
	public void setBillingDate(Date billingDate) {
		this.billingDate = billingDate;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Collection<ProductItem> getProductItems() {
		return productItems;
	}
	public void setProductItems(Collection<ProductItem> productItems) {
		this.productItems = productItems;
	}
}
