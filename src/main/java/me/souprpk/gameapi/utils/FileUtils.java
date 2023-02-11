package me.souprpk.gameapi.utils;

import java.io.*;

public class FileUtils {

    public static void copy(File source, File destination) throws IOException {
        if (source.isDirectory()){
            if (!destination.exists())
                destination.mkdir();

            String[] files = source.list();
            if (files == null) return;

            for (String file : files) {
                File newSource = new File(source, file);
                File newDestination = new File(source, file);
                copy(newSource, newDestination);
            }

        }else{
            InputStream in = new FileInputStream(source);
            OutputStream out = new FileOutputStream(destination);

            byte[] buffer = new byte[1024];

            int length;
            // copy the file in bytes
            while((length = in.read(buffer))> 0){
                out.write(buffer, 0 , length);
            }

            in.close();
            out.close();
        }
    }

    public static void delete(File file) {
        if(file.isDirectory()){
            File[] files = file.listFiles();
            if(files == null) return;
            for(File child : files){
                delete(child);
            }
            //if(!file.delete())
            //Bukkit.getConsoleSender().sendMessage(ChatColor.RED + file.getName());
        }
        file.delete();
    }
}
