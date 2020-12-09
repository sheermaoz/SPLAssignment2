package bgu.spl.mics.application;

import java.io.FileReader;
import java.util.concurrent.TimeUnit;

import bgu.spl.mics.Future;
import com.google.gson.Gson;

/** This is the Main class of the application. You should parse the input file,
 * create the different components of the application, and run the system.
 * In the end, you should output a JSON.
 */
public class Main {
	public static void main(String[] args) {
		Gson gson = new Gson();
		try
		{
			FileReader reader = new FileReader("input.json");
			Input input = gson.fromJson(reader, Input.class);
			System.out.println(input.getAttacks()[0].getDuration());
		}
		catch (Exception e)
		{
			System.out.println();
		}

		//tests
		/*long start=System.currentTimeMillis();
		for(int i=0;i<=100000;i++){}
		System.out.println(System.currentTimeMillis()-start);
		*/

		/*Future<Boolean> future = new Future<Boolean>();
		future.get(5, TimeUnit.SECONDS);*/
	}
}
