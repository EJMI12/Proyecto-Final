package programLibraries;

public class Validator {

    public static boolean isEmailAddress(String emailAddress) {
        if (emailAddress != null && emailAddress.trim().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            return true;
        }
        return false;
    }

    public static boolean isChannelName(String channelName) {
        if (channelName != null && channelName.trim().matches("^[a-zA-Z0-9_,]{3,20}$")) {
            return true;
        }
        return false;
    }

    public static boolean isLikes(String likes) {
        if (likes != null && likes.trim().matches("^[0-9]+$")) {
            return true;
        }
        return false;
    }

    public static boolean isViews(String views) {
        if (views != null && views.trim().matches("^[0-9]+$")) {
            return true;
        }
        return false;
    }

    public static boolean isIFrame(String iFrame) {
        if (iFrame != null && iFrame.trim().matches("<iframe\\s*width=\"(\\d+)\"\\s*height=\"(\\d+)\"\\s*src=\"([^\",\n\t]+)\"\\s*title=\"([^\",\n\t]+)\"\\s*frameborder=\"(\\d+)\"\\s*allow=\"([^\",\n\t]+)\"\\s*referrerpolicy=\"([^\",\n\t]+)\"\\s*allowfullscreen\\s*><\\/iframe>")) {
            return true;
        }
        return false;
    }

    public static String cleanDescription(String text) {
    	if (text != null) {
			text = text.trim().replace("[^\\w \táéíóúÁÉíÓÚüÜñÑ]", " ");
			text = text.replaceAll("\\n", "#");
		}
        return text;
    }
}