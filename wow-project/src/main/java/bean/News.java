package bean;

public class News extends SqlSendable{
private String title;
private String brief;
private String imgLink;



public String getImgLink() {
	return imgLink;
}
public void setImgLink(String imgLink) {
	this.imgLink = imgLink;
}
public News(String title, String brief,String imgLink) {
	super();
	this.title = title;
	this.brief = brief;
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
