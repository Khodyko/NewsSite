package bean;

public class News {
private String title;
private String brief;
private String fullText;
public String getFullText() {
	return fullText;
}
public void setFulText(String fullText) {
	this.fullText = fullText;
}
private String imgLink;



public String getImgLink() {
	return imgLink;
}
public void setImgLink(String imgLink) {
	this.imgLink = imgLink;
}
public News(String title,String fullText, String brief,String imgLink) {
	super();
	this.title = title;
	this.brief = brief;
	this.fullText=fullText;
	this.imgLink=imgLink;
	
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getBrief() {
	return brief;
}
public void setBrief(String brief) {
	this.brief = brief;
}

}
