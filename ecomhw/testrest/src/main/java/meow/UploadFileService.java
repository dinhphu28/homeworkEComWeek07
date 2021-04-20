package meow;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Base64;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

import org.apache.commons.io.FileUtils;


@Path("/file")
public class UploadFileService {
	@POST
	@Path("/upload")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response uploadFile(
		@FormDataParam("file") InputStream uploadedInputStream,
		@FormDataParam("file") FormDataContentDisposition fileDetail) {

		String filesPath = "./files";
		File directoryPath = new File(filesPath);
		if(!directoryPath.exists()) {
            boolean bool = directoryPath.mkdir();
        }

		String uploadedFileLocation = filesPath +"/" + fileDetail.getFileName();
		writeToFile(uploadedInputStream, uploadedFileLocation);
		String output = "File uploaded to: " + uploadedFileLocation;
		return Response.status(200).entity(output).build();
	}

	@POST
	@Path("/uploadjson")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response uploadJson(jsonupload dt) {
		String srcData = dt.getSrc();
		String title = dt.getTitle();

		String filesPath = "./files";
		File directoryPath = new File(filesPath);
		if(!directoryPath.exists()) {
            boolean bool = directoryPath.mkdir();
        }

		String uploadedFileLocation = filesPath + "/" + title;

		byte[] decodedBytes = Base64.getDecoder().decode(srcData);

		try {
			FileUtils.writeByteArrayToFile(new File(uploadedFileLocation), decodedBytes);
			
			return Response.status(Status.CREATED).entity(title).build();
		} catch (Exception e) {
			e.printStackTrace();
			//TODO: handle exception
		}

		return Response.status(Status.BAD_REQUEST).entity("Base64 string error!").build();
	}

	private void writeToFile(InputStream uploadedInputStream,
		String uploadedFileLocation) {

		try {
			OutputStream out = new FileOutputStream(new File(
					uploadedFileLocation));
			int read = 0;
			byte[] bytes = new byte[1024];

			out = new FileOutputStream(new File(uploadedFileLocation));
			while ((read = uploadedInputStream.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
