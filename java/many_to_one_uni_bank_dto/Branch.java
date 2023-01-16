package many_to_one_uni_bank_dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Branch {
	@Id
	private int id;
	private int ifsc;
	private String name;
	private String address;
	private String manager;
	private long phone;
	private Bank bank;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIfsc() {
		return ifsc;
	}
	public void setIfsc(int ifsc) {
		this.ifsc = ifsc;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public Bank getBank() {
		return bank;
	}
	public void setBank(Bank bank) {
		this.bank = bank;
	}
	@Override
	public String toString() {
		return "Branch [id=" + id + ", ifsc=" + ifsc + ", name=" + name + ", address=" + address + ", manager="
				+ manager + ", phone=" + phone + ", bank=" + bank + "]";
	}
	

}
