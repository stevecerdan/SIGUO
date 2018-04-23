package gob.osinergmin.sibad.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;

import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.compress.archivers.ArchiveOutputStream;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ZipUtil {
	
	private static final Logger LOG = LoggerFactory.getLogger(ZipUtil.class);	    
     
    public static void addAllFilesFromDirectoryToZip(String sourceFolder, String fileDestination) throws Exception {
        File source = new File(sourceFolder);
        File destination = new File(fileDestination);
        destination.delete();
        addFilesToZip(source, destination);
    }

    /**
     * Add all files from the source directory to the destination zip file
     *
     * @param source      the directory with files to add
     * @param destination the zip file that should contain the files
     * @throws IOException      if the io fails
     * @throws ArchiveException if creating or adding to the archive fails
     */
    private static void addFilesToZip(File source, File destination) throws IOException, ArchiveException {
        OutputStream archiveStream = new FileOutputStream(destination);
        ArchiveOutputStream archive = new ArchiveStreamFactory().createArchiveOutputStream(ArchiveStreamFactory.ZIP, archiveStream);

        Collection<File> fileList = FileUtils.listFiles(source, null, true);

        for (File file : fileList) {
            String entryName = getEntryName(source, file);
            ZipArchiveEntry entry = new ZipArchiveEntry(entryName);
            archive.putArchiveEntry(entry);

            BufferedInputStream input = new BufferedInputStream(new FileInputStream(file));

            IOUtils.copy(input, archive);
            input.close();
            archive.closeArchiveEntry();
        }

        archive.finish();
        archiveStream.close();
    }

    /**
     * Remove the leading part of each entry that contains the source directory name
     * @param source the directory where the file entry is found
     * @param file   the file that is about to be added
     * @return the name of an archive entry
     * @throws IOException if the io fails
     */
    private static String getEntryName(File source, File file) throws IOException {
        int index = source.getAbsolutePath().length() + 1;
        String path = file.getCanonicalPath();
        return path.substring(index);
    }

    
    public static String generateFileName(String sourceFolder, String fileName){
		String fileNameResult = null;
		String fullFileName = sourceFolder + File.separator + fileName;
		File fullFile = new File(fullFileName);
		if(fullFile.exists()){
			boolean newNameFileFound = false;
			int counter = 1;			
			while(!newNameFileFound){
				String newFileName = appendVersionToFileName(fileName, counter);
				fullFile = new File(sourceFolder + File.separator + newFileName);
				if(!fullFile.exists()){
					newNameFileFound = true;
					fileNameResult = newFileName;
				}
				counter++;				
			}
		}else{
			fileNameResult = fileName;
		}
		return fileNameResult;
	}
	
	public static String appendVersionToFileName(String fileName, int version){
		String fileNameResult = "";
		if(fileName.indexOf(".") > 0){
			fileNameResult = fileName.substring(0, fileName.indexOf(".")) + " (" + version + ")." + fileName.substring(fileName.indexOf(".") + 1);
		}else{
			fileNameResult = fileName + " ("+version+")";
		}		
		return fileNameResult;
	}
	
}
