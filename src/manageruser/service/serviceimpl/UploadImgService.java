package manageruser.service.serviceimpl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import manageruser.constant.Constant;
import manageruser.service.UploadService;

/**
 * Service upload anh len server
 * @author Chu lun Kute
 *
 */
public class UploadImgService implements UploadService {
	private String linkImage;
	private HttpServletRequest request;

	public UploadImgService(String linkImage, HttpServletRequest request) {
		super();
		this.linkImage = linkImage;
		this.request = request;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see manageruser.service.UploadService#upload()
	 */
	@Override
	public String upload() throws IOException, ServletException {
		Part part = request.getPart(linkImage);
		String fileName = part.getSubmittedFileName();

		fileName = System.currentTimeMillis() + fileName;
		String appPath = Constant.IMAGES_SAVE_PATH;
		File uploads = new File(appPath);
		File file = new File(uploads, fileName);
		InputStream input = part.getInputStream();
		Files.copy(input, file.toPath());
		return "images/" + fileName;
	}
}
