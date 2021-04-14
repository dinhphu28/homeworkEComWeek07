package meow;

import java.io.File;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

@Path("/image")
public class DownloadFileService {
	private static final String DIR_PATH = "./files";

	@GET
	@Path("/{id}")
	@Produces(MediaType.MULTIPART_FORM_DATA)
	public Response getFile(@PathParam("id") int id) {
        ArrayList<String> filespathArr = getFilesPath();

		File file = new File(DIR_PATH + "/" + filespathArr.get(id));
		ResponseBuilder response = Response.ok((Object) file);
		response.header("Content-Disposition",
			"attachment; filename=" + filespathArr.get(id));
		return response.build();

	}

    @GET
    @Path("/quantity")
    @Produces(MediaType.TEXT_PLAIN)
    public String getQuantity() {
        int nn = getFilesPath().size();
        return "" + nn;
    }

    private ArrayList<String> getFilesPath() {
        ArrayList<String> filespath = new ArrayList<String>();

        // String path = "./files";
        File directoryPath = new File(DIR_PATH);
        File fileList[] = directoryPath.listFiles();

        for(File file : fileList) {
            filespath.add("" + file.getName());
        }

        return filespath;
    }
}