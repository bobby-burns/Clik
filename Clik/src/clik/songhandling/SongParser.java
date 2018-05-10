package clik.songhandling;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class SongParser {
	String filePath;
	File songFile;
	File[] paths;
	File selected;
	File osuFile;
	File Song;
	public SongParser() {
		
	}
	public void loadSong() {
		ClassLoader classLoader = getClass().getClassLoader();
		String resources = classLoader.getResource("resources").getFile();
		songFile = new File(resources);
		paths = songFile.listFiles();
		for (File rFiles : paths) {
			if(rFiles.getPath().endsWith(".osz")) {
				selected = rFiles;
				break;
			}
		}
		prepareData(selected);
	}
	public void prepareData(File song) {
		byte[] buffer = new byte[1024];
    	
	     try{
	    		
	    	//create output directory is not exists
	    	File folder = new File((songFile + File.separator + song.getName()).replace(".osz", ""));
	    	System.out.println(folder.getPath());
	    	if(!folder.exists()){
	    		folder.mkdir();
	    	} else {
	    		
	    	}
	    		
	    	//get the zip file content
	    	ZipInputStream zis = new ZipInputStream(new FileInputStream(song));
	    	//get the zipped file list entry
	    	ZipEntry ze = zis.getNextEntry();
	    		
	    	while(ze!=null){
	    			
	    	   String fileName = ze.getName();
	           File newFile = new File(folder + File.separator + fileName);
	                
	           System.out.println("file unzip : "+ newFile.getAbsoluteFile());
	                
	            //create all non exists folders
	            //else you will hit FileNotFoundException for compressed folder
	            new File(newFile.getParent()).mkdirs();
	              
	            FileOutputStream fos = new FileOutputStream(newFile);             

	            int len;
	            while ((len = zis.read(buffer)) > 0) {
	       		fos.write(buffer, 0, len);
	            }
	        		
	            fos.close();   
	            ze = zis.getNextEntry();
	    	}
	    	
	        zis.closeEntry();
	    	zis.close();
	    		
	    	System.out.println("Done");
	    		
	    }catch(IOException ex){
	       ex.printStackTrace(); 
	    }
	}
	

}
