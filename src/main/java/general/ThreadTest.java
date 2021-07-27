//package general;
//
//import java.io.File;
//
//public class ThreadTest extends Thread {
//	
//	//private String url;
//	//public Downloader(String url);
//	this.url = url;
//	
//
//	public static void main(String[] args) {
//		
//		// t is just an object, not a thread
//		Thread t = new Thread(); 
//		
//		// unless you call t.start it won't be a thread yet
//		// when start is called, the immediate method that is invoked is the run method
//		
//		t.start();
//		
//		// run is starting point for any thread
//		// we have to over ride down
//		
//		
//		
//	}
//	
//	public void run() {
//		FileDownloader fd = new FileDownloader();
//		fd.download(this.url);
//		
//	}
//	
//	
//	class FileDownloader{
//		public File download(String url) {
//			File file;
//			return file;
//		}
//	}
//}
