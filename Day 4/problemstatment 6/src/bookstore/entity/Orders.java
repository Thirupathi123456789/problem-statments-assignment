package bookstore.entity;

import java.sql.Timestamp;

public class Orders {
	int Order_Id;
	String Address;
	int Phone_No;
	String Cust_Name;
	Timestamp Order_Date;
	int Quantity;
	
	public Orders(String address, int phone_No, String cust_Name) {
		Address = address;
		Phone_No = phone_No;
		Cust_Name = cust_Name;
	}
	public Orders(int order_Id, String address, int phone_No, String cust_Name, Timestamp order_Date, int quantity) {
		Order_Id = order_Id;
		Address = address;
		Phone_No = phone_No;
		Cust_Name = cust_Name;
		Order_Date = order_Date;
		Quantity = quantity;
	}
	public int getOrder_Id() {
		return Order_Id;
	}
	public void setOrder_Id(int order_Id) {
		Order_Id = order_Id;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public int getPhone_No() {
		return Phone_No;
	}
	public void setPhone_No(int phone_No) {
		Phone_No = phone_No;
	}
	public String getCust_Name() {
		return Cust_Name;
	}
	public void setCust_Name(String cust_Name) {
		Cust_Name = cust_Name;
	}
	public Timestamp getOrder_Date() {
		return Order_Date;
	}
	public void setOrder_Date(Timestamp order_Date) {
		Order_Date = order_Date;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	@Override
	public String toString() {
		return "Orders [Order_Id=" + Order_Id + ", Address=" + Address + ", Phone_No=" + Phone_No + ", Cust_Name="
				+ Cust_Name + ", Order_Date=" + Order_Date + ", Quantity=" + Quantity + "]";
	}
	

}
