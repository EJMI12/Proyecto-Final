package programLibraries.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import programLibraries.VideoRegister;
import programLibraries.Configuration;
import programLibraries.Validator;
import programLibraries.WebResponse;
import programLibraries.YouTubeCSV;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
 * Servlet implementation class VideoRegistry
 */
public class VideoRegistry extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /*
     * @see HttpServlet#HttpServlet()
     */
    public VideoRegistry() {
        super();
    }

    /*
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	if (
				request.getParameter("emailAddress")!= null && Validator.isEmailAddress(request.getParameter("emailAddress")) &&
				request.getParameter("channelName")!= null && Validator.isChannelName(request.getParameter("channelName")) &&
				request.getParameter("description")!= null &&
				request.getParameter("likes")!= null && Validator.isLikes(request.getParameter("likes")) &&
				request.getParameter("views")!= null&& Validator.isViews(request.getParameter("views")) &&
				request.getParameter("iFrame")!= null && Validator.isIFrame(request.getParameter("iFrame"))&&
				request.getParameter("videoType")!=null
				) {
    		
    	}
			String emailAddress = request.getParameter("emailAddress");
			String channelName = request.getParameter("channelName");
			String description = Validator.cleanDescription(request.getParameter("description"));
			String likes = request.getParameter("likes");
			String views= request.getParameter("views");
			String iFrame= request.getParameter("iFrame");
			String videoType= request.getParameter("videoType");

        VideoRegister video = new VideoRegister(emailAddress, channelName, description,videoType, likes, views, iFrame);
        WebResponse webResponse = new WebResponse();
        YouTubeCSV youtubeCSV = new YouTubeCSV();

        if (youtubeCSV.save(video)) {
            webResponse.setStatus(true);
            webResponse.setContent("se ha efectuado el registro de forma satisfactoria");

            // Check file existence and accessibility
            Path filePath = Paths.get(Configuration.DATA_MODEL_FILE_NAME);
            if (Files.exists(filePath) && Files.isWritable(filePath)) {
                webResponse.setContent("se ha creado el archivo " + Configuration.DATA_MODEL_FILE_NAME);
            } else {
                webResponse.setContent("Error. No se ha podido crear el archivo " + Configuration.DATA_MODEL_FILE_NAME);
            }
        } else {
            webResponse.setStatus(false);
            webResponse.setContent("Error. No se ha podido guardar el registro");
        }

        // Check webResponse status before sending response
        response.setHeader("Content-Type", "application/json");
        if (webResponse.isStatus()) {
            response.getWriter().append(webResponse.toJSON());
        } else {
            // Send error response with appropriate status code (e.g., 500)
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, webResponse.getContent());
        }
    }

    /*
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
