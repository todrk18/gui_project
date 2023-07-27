package dto;

//CREATE TABLE ORDER_TABLE1(
//SEQ NUMBER(8) PRIMARY KEY,
//ID VARCHAR2(30) NOT NULL,
//MENU VARCHAR2(200) NOT NULL,
//KIND VARCHAR2(200),
//ICE_SIZE VARCHAR2(200) NOT NULL,
//COUNT NUMBER(8) NOT NULL,
//PRICE NUMBER(8) NOT NULL,
//WDATE DATE NOT NULL
//);
//
//CREATE SEQUENCE SEQ_ORDER1
//START WITH 1
//INCREMENT BY 1;
//
//ALTER TABLE ORDER_TABLE1
//ADD CONSTRAINT FK_ORDER_TABLE1_ID FOREIGN KEY(ID)
//REFERENCES ORDER_MEMBER1(ID);
//
//


public class OrderDto {
	

	private int seq;
	private String id;
	private String menu;
	private String kind;
	private String size;
	private int count;
	private int price;
	private String wdate;
	
	public OrderDto() {
		// TODO Auto-generated constructor stub
	}
	
	public OrderDto(int seq, String id, String menu, 
			String kind, String size,int count, int price, String wdate) {
			
		super();
		this.seq = seq;
		this.id = id;
		this.menu = menu;
		this.kind = kind;
		this.size = size;
		this.count = count;
		this.price = price;
		this.wdate = wdate;
	}
	
	
	
	public OrderDto(String id, String menu, String kind, String size, int count,
			int price) {
		super();
		this.id = id;
		this.menu = menu;
		this.kind = kind;
		this.size = size;
		this.count = count;
		this.price = price;
	}

	public int getSeq() {
		return seq;
	}
	
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getWdate() {
		return wdate;
	}
	public void setWdate(String wdate) {
		this.wdate = wdate;
	}
	@Override
	public String toString() {
		return "OrderDto [seq=" + seq + ", id=" + id + ", menu=" + menu + ", kind=" + kind + ", size=" + size
				+ ", count=" + count + ", price=" + price + ", wdate=" + wdate
				+ "]";
	}	

}
