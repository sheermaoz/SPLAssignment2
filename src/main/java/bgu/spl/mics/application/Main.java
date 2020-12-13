package bgu.spl.mics.application;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import bgu.spl.mics.application.passiveObjects.*;
import bgu.spl.mics.application.services.C3POMicroservice;
import bgu.spl.mics.application.services.HanSoloMicroservice;
import bgu.spl.mics.application.services.LandoMicroservice;
import bgu.spl.mics.application.services.LeiaMicroservice;
import bgu.spl.mics.application.services.R2D2Microservice;
import bgu.spl.mics.Future;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/** This is the Main class of the application. You should parse the input file,
 * create the different components of the application, and run the system.
 * In the end, you should output a JSON.
 */
public class Main {
    public static CountDownLatch latch;

    
    public static void main(String[] args) {
        int ewoksNum = 0;
        latch = new CountDownLatch(2);
        Attack[] attacks = new Attack[0];
        int LandoDuration = 0;
        int R2D2Duration = 0;
        Gson gson = new Gson();

        try
        {
            FileReader reader = new FileReader("input.json");
            Input input = gson.fromJson(reader, Input.class);
            attacks = input.getAttacks();
            LandoDuration = input.getLando();
            R2D2Duration = input.getR2D2();
            ewoksNum = input.getEwoks();
            System.out.println(attacks.length);
            

        }
        catch (FileNotFoundException e) {e.printStackTrace();}
        Diary diary = Diary.getInstance();
        Runnable leia = new LeiaMicroservice(attacks);
        Runnable han = new HanSoloMicroservice();
        Runnable c3po = new C3POMicroservice();
        Runnable r2d2 = new R2D2Microservice(R2D2Duration);
        Runnable lando = new LandoMicroservice(LandoDuration);
        System.out.println("Created all microservices");
        Thread leiaThread = new Thread(leia);
        Thread hanThread = new Thread(han);
        Thread c3poThread = new Thread(c3po);
        Thread r2d2Thread = new Thread(r2d2);
        Thread landoThread = new Thread(lando);
        System.out.println("Created all threads");
        Ewoks ewoks = Ewoks.getInstance();
        Ewoks.init(ewoksNum);

        hanThread.start();
        c3poThread.start();
        r2d2Thread.start();
        landoThread.start();
        leiaThread.start();
        System.out.println("started all threads");
        try 
        {
            leiaThread.join();
            hanThread.join();
            c3poThread.join();
            r2d2Thread.join();
            landoThread.join();
        }
        catch(Exception e){}

        System.out.println("Closed all microservices");
        Gson outputGson  = new GsonBuilder().setPrettyPrinting().create();
        try
        {
            FileWriter writer = new FileWriter("Output.json");
            outputGson.toJson(diary, writer);
            writer.flush();
            writer.close();

        }
        catch (IOException e ){e.printStackTrace();}
        System.out.println("Finished json");


        //Ewoks ewoks = Ewoks.getInstance(ewoksNum);
        



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


