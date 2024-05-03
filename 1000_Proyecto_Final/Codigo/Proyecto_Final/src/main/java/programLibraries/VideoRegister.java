package programLibraries;

public class VideoRegister {

	private String emailAddress;
	private String channelName;
	private String description;
	private String likes;
	private String views;
	private String iFrame;
	private String videoType;
	
	public String getVideoType() {
		return videoType;
	}
	public void setVideoType(String videoType) {
		this.videoType = videoType;
	}
	public VideoRegister(String emailAddress, String channelName, String description,String videoType, String likes, String views,
			String iFrame) {
		super();
		this.emailAddress = emailAddress;
		this.channelName = channelName;
		this.description = description;
		this.likes = likes;
		this.views = views;
		this.iFrame = iFrame;
		this.videoType = videoType;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getChannelName() {
		return channelName;
	}
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLikes() {
		return likes;
	}
	public void setLikes(String likes) {
		this.likes = likes;
	}
	public String getViews() {
		return views;
	}
	public void setViews(String views) {
		this.views = views;
	}
	public String getiFrame() {
		return iFrame;
	}
	public void setiFrame(String iFrame) {
		this.iFrame = iFrame;
	}
	
	
	@Override
	public String toString() {
		return "VideoRegister [emailAddress=" + emailAddress + ", channelName=" + channelName + ", description="
				+ description + ", likes=" + likes + ", views=" + views + ", iFrame=" + iFrame + ", videoType="
				+ videoType + "]";
	}
	public String toCSV() {

        return emailAddress + "," + channelName + "," + description +","+videoType +"," + likes + "," + views + "," + iFrame;

    }
	
	
}
