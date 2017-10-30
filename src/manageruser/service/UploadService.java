package manageruser.service;

import java.io.IOException;

import javax.servlet.ServletException;

/**
 * Upload file
 * @author Chu lun Kute
 *
 */
public interface UploadService {
	String upload() throws IOException, ServletException;
}
