package dto;

//CREATE TABLE MENU_TABLE1(
//SEQ NUMBER(8) PRIMARY KEY,
//Menu VARCHAR(40) NOT NULL,
//SMALL_PRICE NUMBER(8) NOT NULL,
//MEDIUM_PRICE NUMBER(8) NOT NULL,
//LARGE_PIRCE NUMBER(8) NOT NULL
//);

public class MenuDto {
	

	private int seq;
	private String menu;
	private int smallSize;
	private int mediumSize;
	private int LargeSize;

	public MenuDto() {
		// TODO Auto-generated constructor stub
	}

	public MenuDto(int seq, String menu, int smallSize, int mediumSize, int largeSize) {
		super();
		this.seq = seq;
		this.menu = menu;
		this.smallSize = smallSize;
		this.mediumSize = mediumSize;
		LargeSize = largeSize;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public int getSmallSize() {
		return smallSize;
	}

	public void setSmallSize(int smallSize) {
		this.smallSize = smallSize;
	}

	public int getMediumSize() {
		return mediumSize;
	}

	public void setMediumSize(int mediumSize) {
		this.mediumSize = mediumSize;
	}

	public int getLargeSize() {
		return LargeSize;
	}

	public void setLargeSize(int largeSize) {
		LargeSize = largeSize;
	}

	@Override
	public String toString() {
		return "MenuDto [seq=" + seq + ", menu=" + menu + ", smallSize=" + smallSize + ", mediumSize=" + mediumSize
				+ ", LargeSize=" + LargeSize + "]";
	}

	
	


}
