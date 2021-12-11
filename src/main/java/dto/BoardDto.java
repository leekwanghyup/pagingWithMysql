package dto;

public class BoardDto {
	
	private int bno;
	private String subject; 
	private String content;
	private String writer;
	
	public BoardDto() {
		// TODO Auto-generated constructor stub
	}

	public BoardDto(int bno, String subject, String content, String writer) {
		this.bno = bno;
		this.subject = subject;
		this.content = content;
		this.writer = writer;
	}

	@Override
	public String toString() {
		return "BoardDto [bno=" + bno + ", subject=" + subject + ", content=" + content + ", writer=" + writer + "]";
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}
}
