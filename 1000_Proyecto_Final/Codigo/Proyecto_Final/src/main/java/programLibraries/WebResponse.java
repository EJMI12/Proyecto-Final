package programLibraries;

public class WebResponse {
	
	private boolean status;
	private String content;
	
	
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	private String clean(String text) {
		
		text = text.trim().replaceAll("[\\n\\t]+", "");
		
			return text;
	}

	public String toJSON() {
		
		StringBuilder result = new StringBuilder("{");
		result.append(String.format("\"status\":%s,", this.status));
		result.append(String.format("\"sontent\":\"%s\"", this.clean(this.content)));
		
		result.append("}");
		return result.toString();
		
	}
	
public String toXML() {
		
		StringBuilder result = new StringBuilder("<response>");
		result.append(String.format("<status>%s</status>",this.status));
		result.append(String.format("<content>%s</content>",this.content));

		
		result.append("</response>");
		return result.toString();
		
	}
}
