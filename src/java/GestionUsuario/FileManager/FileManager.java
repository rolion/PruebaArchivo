package GestionUsuario.FileManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import GestionUsuario.Entidades.EGrupo;
import GestionUsuario.Entidades.EUsuario;
import GestionUsuario.Util.GV;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Lion
 */
public class FileManager {
    private static final String path=System.getProperty("user.dir")+"\\archivos";
    private final String nameFile="usuario.txt";
    private static File file=new File(System.getProperty("user.dir")+"\\archivos");
    private static Writer fileWriter;
    private static BufferedWriter bufferedWriter;
    private static Gson gson=new Gson();
    
    public static boolean writeToFile(Object object,String mfile){
        boolean rslt=false;
        file.mkdirs();
        System.out.print("Direccion archivo------>>>>>>"+file.getAbsolutePath()+"\n");
        if(!existObj(object, mfile)){
            if(file!=null && file.exists() ){
                try(PrintWriter out = new PrintWriter(
                        new BufferedWriter(new FileWriter(
                                System.getProperty("user.dir")+"\\archivos"+"\\"+mfile, true)))) {

                        out.println(gson.toJson(object));

                }catch (Exception e) {
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                }
            }
        }
        return rslt;
    }
    public static boolean writeListToFile(List lobject, String mfile){
        boolean rstl=false;
        file.mkdirs();
        if(file!=null && file.exists() ){
            try(PrintWriter out = new PrintWriter(
                    new BufferedWriter(new FileWriter(
                            path+"\\"+mfile, true)))) {
                for (Object lobject1 : lobject) {
                    out.println(gson.toJson(lobject1));
                }

            }catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return rstl;
    }
    public static boolean existObj(Object o, String mfile){
        boolean rslt=false;
        try(BufferedReader br = new BufferedReader(new FileReader(path+"\\"+mfile))) {
                StringBuilder sb = new StringBuilder();
                String line = br.readLine();
               
                while (line != null) {
                    try{
                        Object mObject= gson.fromJson(line,o.getClass());
                        if(o.equals(mObject))
                            rslt=true;
                    }catch(JsonSyntaxException jse){
                        System.out.println("No es su tipo");
                    }
                    if(rslt==false)
                        line = br.readLine();
                    else
                        line=null;
                }
            }catch(Exception e){
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        
        return rslt;
    }
    public static List<Object> getAllObject(Object ob, String mfile) {
        List rslt=null;
        file.mkdirs();
         if(file!=null && file.exists() ){
            try(BufferedReader br = new BufferedReader(new FileReader(path+"\\"+mfile))) {
                StringBuilder sb = new StringBuilder();
                String line = br.readLine();
                rslt= new ArrayList<>();
                while (line != null) {
                    try{
                        Object mObject= gson.fromJson(line, ob.getClass());
                        rslt.add(mObject);
                    }catch(JsonSyntaxException jse){
                        System.out.println("No es su tipo");
                    }
                    line = br.readLine();
                }
            }catch(Exception e){
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
         }
        return rslt;
    }
    public static void validarGrupoAdmin(){
        //se valida que el grupo admin exista si no existe se lo crea;
        EGrupo grupo = new EGrupo("administrador");
        List lg= FileManager.getAllObject(grupo, GV.nameArchivoGrupo);
        if(lg!=null && lg.size()>0){
            for (Object lg1 : lg) {
                if(grupo.equals(lg1)){
                    return ;
                }
            }
        }
        FileManager.writeToFile(grupo, GV.nameArchivoGrupo);
    }
    public static void validarCuentaAdmin(){
        //se valida que la cuenta del admin exista y si no existe se la crea;
        EUsuario user= new EUsuario("admin","admin","administrador");
            List lu=FileManager.getAllObject(user, GV.nameArchivoUsuario);
            if(lu!= null && lu.size()>0){
                for (Object lu1 : lu) {
                    if(user.equals(lu1))
                        return;
                }
            }
            FileManager.writeToFile(user, GV.nameArchivoUsuario);
    }
    
    private void validarFile(){
        if(!file.exists())
            file.mkdirs();
    
    }
    
    
}
