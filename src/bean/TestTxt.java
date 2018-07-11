package bean;

import java.io.File;

public class TestTxt {
	private File TxtInfo;
	private File bookPic;
	private String bookPicFileName;
	private String bookPicContentType;
	private String TxtInfoFileName;
	private String TxtInfoContentType;
	private String ebookName;
	private String ebookWriter;
	private String ebookWriterName;
	public String getEbookWriterName() {
		return ebookWriterName;
	}
	public void setEbookWriterName(String ebookWriterName) {
		this.ebookWriterName = ebookWriterName;
	}
	private String ebookAbstract;
	private String ebookTime;
	public TestTxt() {
		super();
		TxtInfo = null;
		this.bookPic = null;
		this.bookPicFileName = "..";
		this.bookPicContentType = "..";
		TxtInfoFileName = "..";
		TxtInfoContentType = "..";
		this.ebookName = "..";
		this.ebookWriter = "..";
		this.ebookAbstract = "..";
		this.ebookTime="..";
	}
	public String getEbookTime() {
		return ebookTime;
	}
	public void setEbookTime(String ebookTime) {
		this.ebookTime = ebookTime;
	}
	public File getBookPic() {
		return bookPic;
	}
	public void setBookPic(File bookPic) {
		this.bookPic = bookPic;
	}
	public String getBookPicFileName() {
		return bookPicFileName;
	}
	public void setBookPicFileName(String bookPicFileName) {
		this.bookPicFileName = bookPicFileName;
	}
	public String getBookPicContentType() {
		return bookPicContentType;
	}
	public void setBookPicContentType(String bookPicContentType) {
		this.bookPicContentType = bookPicContentType;
	}
	public String getEbookName() {
		return ebookName;
	}
	public void setEbookName(String ebookName) {
		this.ebookName = ebookName;
	}
	public String getEbookWriter() {
		return ebookWriter;
	}
	public void setEbookWriter(String ebookWriter) {
		this.ebookWriter = ebookWriter;
	}
	public String getEbookAbstract() {
		return ebookAbstract;
	}
	public void setEbookAbstract(String ebookAbstract) {
		this.ebookAbstract = ebookAbstract;
	}
	public File getTxtInfo() {
		return TxtInfo;
	}
	public void setTxtInfo(File txtInfo) {
		TxtInfo = txtInfo;
	}
	public String getTxtInfoFileName() {
		return TxtInfoFileName;
	}
	public void setTxtInfoFileName(String txtInfoFileName) {
		TxtInfoFileName = txtInfoFileName;
	}
	public String getTxtInfoContentType() {
		return TxtInfoContentType;
	}
	public void setTxtInfoContentType(String txtInfoContentType) {
		TxtInfoContentType = txtInfoContentType;
	}

}
