package bgu.spl.mics.application;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.FileReader;
import java.util.List;
import java.util.concurrent.TimeUnit;
import bgu.spl.mics.application.passiveObjects.Ewoks;
import bgu.spl.mics.Future;
import com.google.gson.Gson;

/** This is the Main class of the application. You should parse the input file,
 * create the different components of the application, and run the system.
 * In the end, you should output a JSON.
 */
public class Main {
	public static void main(String[] args) {
		int ewoksNum = 0;
		int R2D2Dur = 0;
		int LandoDur = 0;
		Gson gson = new Gson();

		try
		{
			FileReader reader = new FileReader("input.json");
			Input input = gson.fromJson(reader, Input.class);
			ewoksNum = input.getEwoks();
			R2D2Dur = input.getR2D2();
			LandoDur = input.getLando();
			System.out.println(input.getAttacks()[0].getSerials());
		}
		catch (Exception e) {System.out.println();}

		Ewoks ewoks = Ewoks.getInstance(ewoksNum);



		/*List<Integer> f = new ArrayList<Integer>();
		f.add(5);
		f.add(7);
		f.add(3);
		f.add(9);
		f.add(1);
		for(int i=0; i<f.size(); i++){
			System.out.print(f.get(i)+" ");
		}
		int[] r = new int[f.size()];
		for(int i=0; i<f.size(); i++){
			r[i] = f.get(i);
		}
		Arrays.sort(r);
		System.out.println();
		for(int b : r){
			System.out.print(b+" ");
		}*/


		/*int[] a = {2,1,6,3};
		for(int b : a){
			System.out.print(b+" ");
		}
		System.out.println();
		Arrays.sort(a, 0, a.length);
		for(int b : a){
			System.out.print(b+" ");
		}*/



		//tests
		/*Runnable r = new A();
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);

		t1.start();*/

		/*long start=System.currentTimeMillis();
		for(int i=0;i<=100000;i++){}
		System.out.println(System.currentTimeMillis()-start);
		*/

		/*Future<Boolean> future = new Future<Boolean>();
		future.get(5, TimeUnit.SECONDS);*/
	}
}


