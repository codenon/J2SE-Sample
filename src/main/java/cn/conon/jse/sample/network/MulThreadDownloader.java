package cn.conon.jse.sample.network;

import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

public class MulThreadDownloader {

	public static void main(String[] args) throws Exception{
		String path = "http://logging.apache.org/log4j/2.x/log4j-users-guide.pdf";
		int threadsize = 3;
		new MulThreadDownloader().download(path, threadsize);
	}
	
	private static String getFilename(String path){
		return path.substring(path.lastIndexOf("/")+ 1 );
	}

	private void download(String path, int threadsize) throws Exception{
		URL downloadUrl = new URL(path);
		HttpURLConnection conn = (HttpURLConnection) downloadUrl.openConnection();
		conn.setConnectTimeout(5000);
		conn.setRequestMethod("GET");
		int length = conn.getContentLength();
		File localFile = new File(getFilename(path));
		RandomAccessFile accessFile = new RandomAccessFile(localFile, "rwd");
		accessFile.setLength(length);
		accessFile.close();
		//计算每一条线程负责下载的数据量
		int block = length % threadsize==0 ? length / threadsize : length / threadsize+1;
		for(int threadid=0 ; threadid < threadsize ; threadid++){
			new DownloadThread(downloadUrl, localFile, block, threadid).start();
		}
	}
	
	private int downloadlength = 0;
	private synchronized void addlength(int length){
		downloadlength += length;
		System.out.println("已经下载长度:"+ downloadlength);
	}

	private final class DownloadThread extends Thread{
		private URL downloadUrl;
		private File localFile;
		private int block;
		private int threadid;
		
		public DownloadThread(URL downloadUrl, File localFile, int block, int threadid) {
			this.downloadUrl = downloadUrl;
			this.localFile = localFile;
			this.block = block;
			this.threadid = threadid;			
		}

		public void run() {
			int startposition = threadid  * block ;//从网络文件的什么位置下载
			int endposition = (threadid+1) * block -1;//下载到什么位置结束			
			try {
				RandomAccessFile accessFile = new RandomAccessFile(localFile, "rwd");
				accessFile.seek(startposition);//从本地文件指定位置写入数据
				HttpURLConnection conn = (HttpURLConnection) downloadUrl.openConnection();
				conn.setConnectTimeout(5000);
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Range", "bytes="+ startposition+ "-"+ endposition);
				InputStream inStream = conn.getInputStream();
				byte[] buffer = new byte[1024];
				int len = 0;
				while( (len = inStream.read(buffer)) != -1){
					accessFile.write(buffer, 0, len);
					addlength(len);					
				}
				accessFile.close();
				inStream.close();
				System.out.println("第"+ (threadid+1)+ "线程下载完成");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("第"+ (threadid+1)+ "线程下载失败");
			}
		}
	}
}
