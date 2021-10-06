package common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.testng.annotations.DataProvider;

public class WebBase {
	@DataProvider(name = "Data Login")
	public String[][] getloginData() {
		String[][] LoginData = { { "Admin", "admin123" }, { "ess", "ess123" } };
		return LoginData;
	}

	@DataProvider(name = "DataCSVLogin")
	public String[][] getLoginCSVData() throws IOException {
		String filename = "C:\\Users\\gsm\\eclipse-workspace\\orange-hrm-test15\\FiletoRead\\LoginData.csv";
		
		File file = new File(filename);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		int rowmax=rowcount(br);
		int colmmax=colmcount(br);

		String line;
		String loginData[][] = new String[rowmax][colmmax];

		int i = 0;
		while ((line = br.readLine()) != null) {
			String[] data = line.split(",");
			loginData[i] = data;
			i++;
		}
		return loginData;
	}
	public int  rowcount(BufferedReader br) throws IOException {
		int maxrow=0;
		String line;
		while( (line=br.readLine()) !=null) {
			maxrow++;
			}
		return maxrow;
		
	}
	public int  colmcount(BufferedReader br) throws IOException {

		int maxcolm=0;
		String line;
		while( (line=br.readLine()) !=null) {

			String data[]=line.split(",");
			maxcolm=data.length;
			
			}
		return maxcolm;
		
	}
}
