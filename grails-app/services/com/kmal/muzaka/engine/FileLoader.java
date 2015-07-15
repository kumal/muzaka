package com.kmal.muzaka.engine;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class FileLoader {

	public static void main(String[] args) {

		

	} 
	
	
	public void prepareForDownLoad(ArrayList<HashMap<String, String>> list){
			
		String songUrl = "#";		
		String songName ="";
		
		
        
        for (int i = 0; i<list.size();i++ ) {    	
        	
        	HashMap<String, String> tmpData = (HashMap<String, String>) list.get(i);
            Set<String> key = tmpData.keySet();
            Iterator<String> it = key.iterator();
            while (it.hasNext()) {
                songName = (String)it.next();
                songUrl = (String) tmpData.get(songName);

                System.out.println("Key: "+songName +" & Data: "+songUrl);
                if(!songUrl.equalsIgnoreCase("#")){
                	saveMp3(songName, songUrl);
                }
                it.remove(); // avoids a ConcurrentModificationException
            }
        	
        }
		
		
		
		
	}
	
	public void saveMp3(String songName, String url){
		
		// -----------------------------------------------------//
				// Step 1: Start creating a few objects we'll need.
				// -----------------------------------------------------//

				URL u;
				InputStream is = null;
				DataInputStream dis;
				String s;

				try {

					// ------------------------------------------------------------//
					// Step 2: Create the URL. //
					// ------------------------------------------------------------//
					// Note: Put your real URL here, or better yet, read it as a //
					// command-line arg, or read it from a file. //
					// ------------------------------------------------------------//

					u = new URL(url);

					
					 //Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxy.muc", 8080)); // or whatever your proxy is
				//	 HttpURLConnection ucc = (HttpURLConnection)u.openConnection(proxy);
					 
					 HttpURLConnection uc = (HttpURLConnection)u.openConnection();
					// ----------------------------------------------//
					// Step 3: Open an input stream from the url. //
					// ----------------------------------------------//
					
					is = uc.getInputStream();
					
					// -------------------------------------------------------------//
					// Step 4: //
					// -------------------------------------------------------------//
					// Convert the InputStream to a buffered DataInputStream. //
					// Buffering the stream makes the reading faster; the //
					// readLine() method of the DataInputStream makes the reading //
					// easier. //
					// -------------------------------------------------------------//

					dis = new DataInputStream(new BufferedInputStream(is));

					// ------------------------------------------------------------//
					// Step 5: //
					// ------------------------------------------------------------//
					// Now just read each record of the input stream, and print //
					// it out. Note that it's assumed that this problem is run //
					// from a command-line, not from an application or applet. //
					// ------------------------------------------------------------//

				/**	while ((s = dis.readLine()) != null) {
						System.out.println(s);
					}
					**/
					String dir = "C:/temp/AlbaCrawl/";
					File destination = new File(dir);
					destination.mkdirs();
					
					File fullPath = new File(dir+getValidFileName(songName)+".mp3");
					OutputStream outstream = new FileOutputStream(fullPath);
					
				    byte[] buffer = new byte[4096];
				    int len;
				    while ((len = is.read(buffer)) > 0) {
				        outstream.write(buffer, 0, len);
				    }
				    outstream.close();
					

				} catch (MalformedURLException mue) {

					System.out.println("Ouch - a MalformedURLException happened.");
					mue.printStackTrace();
					System.exit(1);

				} catch (IOException ioe) {

					System.out.println("Oops- an IOException happened.");
					ioe.printStackTrace();
					System.exit(1);

				} finally {

					// ---------------------------------//
					// Step 6: Close the InputStream //
					// ---------------------------------//

					try {
						is.close();
					} catch (IOException ioe) {
						// just going to ignore this one
					}

				} // end of 'finally' clause
	}
	
	
	
	public static boolean validateFileName(String fileName) {
	    return fileName.matches("^[^.\\\\/:*?\"<>|]?[^\\\\/:*?\"<>|]*") 
	    && getValidFileName(fileName).length()>0;
	}

	public static String getValidFileName(String fileName) {
	    String newFileName = fileName.replaceAll("^[.\\\\/:*?\"<>|]?[\\\\/:*?\"<>|]*", "");
	    if(newFileName.length()==0)
	        throw new IllegalStateException(
	                "File Name " + fileName + " results in a empty fileName!");
	    return newFileName;
	}
	
}
