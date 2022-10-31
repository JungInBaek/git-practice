package vo;


public class ItemVO {

	private String code;
	private int price;
	private String name;
	private int quantity;
	private String etc;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getEtc() {
		return etc;
	}
	public void setEtc(String etc) {
		this.etc = etc;
	}
	
	@Override
	public String toString() {
		return "ItemVO [code=" + code + ", price=" + price + ", name=" + name + ", quantity=" + quantity + ", etc="
				+ etc + "]";
	}
	
}
