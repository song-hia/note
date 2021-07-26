package vo;

import java.sql.Date;

public class NoteVO {

	int id;
	String memo;
	Date write_date;
	
	public NoteVO() {}

	public NoteVO(int id, String memo, Date write_date) {
		this.id = id;
		this.memo = memo;
		this.write_date = write_date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Date getWrite_date() {
		return write_date;
	}

	public void setWrite_date(Date write_date) {
		this.write_date = write_date;
	}	
	
}
