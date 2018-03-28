package com.example.wangze.demo;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;


import com.example.wangze.jwt.XActivityManager;
import com.example.wangze.jwt.XBigDecimalUtil;
import com.example.wangze.util.EnviromentUtil;
import com.example.wangze.webcachedemo.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    private ListView listview;
    private TextView textview;
    ArrayList<String> list=new ArrayList<>();
    private InputStreamReader inputStreamReader;
    private FileOutputStream fileOutputStream;
    private StringBuilder sb;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        listview = findViewById(R.id.listview);
        textview = findViewById(R.id.textview);

        textview.setText(XBigDecimalUtil.add(new BigDecimal("1"),null).toString());

//        textview.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(Main2Activity.this, XDialogActivity.class));
//
//            }
//        });

        File rootDirectory = Environment.getRootDirectory();
        File dataDirectory = Environment.getDataDirectory();
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        File externalStoragePublicDirectory= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);
        File downloadCacheDirectory = Environment.getDownloadCacheDirectory();
        String externalStorageState = Environment.getExternalStorageState();
        boolean externalStorageRemovable = Environment.isExternalStorageRemovable();
        boolean externalStorageEmulated = Environment.isExternalStorageEmulated();
//     Environment.buildPaths();
//        Math

     /*   list.add("rootDirectory=="+getFilePath(rootDirectory));
        list.add("rootDirectory.getAbsolutePath()=="+rootDirectory.getAbsolutePath());
        list.add("dataDirectory=="+getFilePath(dataDirectory));
        list.add("externalStorageDirectory=="+getFilePath( externalStorageDirectory));
        list.add("externalStorageDirectory.getAbsolutePath()=="+externalStorageDirectory.getAbsolutePath());
        list.add("externalStoragePublicDirectory=="+getFilePath( externalStoragePublicDirectory));
        list.add("downloadCacheDirectory=="+getFilePath( downloadCacheDirectory));
        list.add("externalStorageState=="+externalStorageState);
        list.add("externalStorageRemovable=="+externalStorageRemovable+"");
        list.add("externalStorageEmulated=="+externalStorageEmulated+"");

        list.add("AllSdPaths=="+getAllSdPaths(this).length+"个");
        for(int i=0;i<getAllSdPaths(this).length;i++){
            list.add("AllSdPaths["+i+"]=="+getAllSdPaths(this)[i]);
        }

//        Context 中获取路径的方法

        list.add("getFilesDir=="+getFilePath(getFilesDir()));
        list.add("getCacheDir=="+getFilePath(getCacheDir()));
        list.add("getExternalFilesDir=="+getFilePath(getExternalFilesDir(Environment.DIRECTORY_ALARMS)));
        list.add("getExternalCacheDir=="+getFilePath(getExternalCacheDir()));
        File[] externalCacheDirs = getExternalCacheDirs();
        for (int i = 0; i <externalCacheDirs.length ; i++) {
            list.add("externalCacheDirs["+i+"]=="+externalCacheDirs[i]);
        }
        File[] externalFilesDirs = getExternalFilesDirs(Environment.DIRECTORY_PICTURES);
        for (int i = 0; i < externalFilesDirs.length; i++) {
            list.add("externalFilesDirs["+i+"]=="+externalFilesDirs[i]);
        }
        File[] externalMediaDirs = getExternalMediaDirs();
        for (int i = 0; i < externalMediaDirs.length; i++) {
            list.add("externalMediaDirs["+i+"]=="+externalMediaDirs[i]);
        }*/

        list.add("EnviromentUtil测试");
        listview.setVisibility(View.VISIBLE);
        list.add("rootDirectory=="+getFilePath(EnviromentUtil.getRootDirectory()));
        list.add("rootDirectory.getAbsolutePath()=="+EnviromentUtil.getRootDirectory().getAbsolutePath());
        list.add("dataDirectory=="+getFilePath(EnviromentUtil.getDataDirectory()));
        list.add("externalStorageDirectory=="+getFilePath( EnviromentUtil.getExternalStorageDirectory()));
        list.add("externalStorageDirectory.getAbsolutePath()=="+EnviromentUtil.getExternalStorageDirectory().getAbsolutePath());
        list.add("externalStoragePublicDirectory=="+getFilePath( EnviromentUtil.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC)));
        list.add("downloadCacheDirectory=="+getFilePath( EnviromentUtil.getDownloadCacheDirectory()));
        list.add("externalStorageState=="+EnviromentUtil.getExternalStorageState());
        list.add("externalStorageRemovable=="+EnviromentUtil.isExternalStorageRemovable()+"");
        list.add("externalStorageEmulated=="+EnviromentUtil.isExternalStorageEmulated()+"");
        list.add("externalStorageDirectoryIfMounted=="+EnviromentUtil.getExternalStorageDirectoryIfMounted()+"");

        list.add("AllSdPaths=="+EnviromentUtil.getAllSdPaths(this).length+"个");
        for(int i=0;i<EnviromentUtil.getAllSdPaths(this).length;i++){
            list.add("AllSdPaths["+i+"]=="+EnviromentUtil.getAllSdPaths(this)[i]);
        }

//        Context 中获取路径的方法

        list.add("getFilesDir=="+getFilePath(EnviromentUtil.getFilesDir(this)));
        list.add("getCacheDir=="+getFilePath(EnviromentUtil.getCacheDir(this)));
        list.add("getExternalFilesDir=="+getFilePath(EnviromentUtil.getExternalFilesDir(this,Environment.DIRECTORY_ALARMS)));
        list.add("getExternalCacheDir=="+getFilePath(EnviromentUtil.getExternalCacheDir(this)));
        File[] externalCacheDirs = EnviromentUtil.getExternalCacheDirs(this);
        for (int i = 0; i <externalCacheDirs.length ; i++) {
            list.add("externalCacheDirs["+i+"]=="+externalCacheDirs[i]);
        }
        File[] externalFilesDirs = EnviromentUtil.getExternalFilesDirs(this,Environment.DIRECTORY_PICTURES);
        for (int i = 0; i < externalFilesDirs.length; i++) {
            list.add("externalFilesDirs["+i+"]=="+externalFilesDirs[i]);
        }
        File[] externalMediaDirs = EnviromentUtil.getExternalMediaDirs(this);
        for (int i = 0; i < externalMediaDirs.length; i++) {
            list.add("externalMediaDirs["+i+"]=="+externalMediaDirs[i]);
        }

        listview.setAdapter(new ListViewAdapter(this,list));
//        ______________________________________FileUtil测试__________________________________________________

//       File file=new File(getFilesDir(),"bbb.txt");
//       if(!file.exists()){
//         boolean result;
//           try {
//               result=file.createNewFile();
//           } catch (IOException e) {
//               e.printStackTrace();
//               return;
//           }
//           if(!result){
//               return;
//           }
//       }
//        String s="";
//        Log.i("file.getAbsolutePath===",file.getAbsolutePath());
//        Log.i("file.getPath===",file.getPath());
////        file.setExecutable(true,true);
//
//        try {
//            inputStreamReader = new InputStreamReader(getResources().getAssets().open("aaa.txt"));
//
//            fileOutputStream = new FileOutputStream(file);
//            int len=0;
//            sb = new StringBuilder("");
//            byte[] buffer = new byte[1024];
//        while((len= inputStreamReader.read())!=-1){
//
//            fileOutputStream.write(buffer,0,len);
//            sb.append(new String(buffer,0,len));
//
//            fileOutputStream.flush();
//
//        }
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        finally {
//            try {
//                if(inputStreamReader!=null){
//                    inputStreamReader.close();
//                }
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            try {
//                if(fileOutputStream!=null){
//                    fileOutputStream.close();
//                }
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            Log.i("sb=",sb.toString());
//            textview.setText(sb.toString());
//        }

         File file=new File(getExternalFilesDir(Environment.DIRECTORY_MUSIC),"ccc.txt");
        boolean result;
         if(!file.exists()){
             try {
                 result = file.createNewFile();
             } catch (IOException e) {
                 e.printStackTrace();
                 return;
             }
             if(!result){
                return;
             }

         }



//        textview.setText(readAssetsTxt(this,"aaa"));
    }

    /**
     * 读取assets下的txt文件，返回utf-8 String
     * @param context
     * @param fileName 不包括后缀
     * @return
     */
    public static String readAssetsTxt(Context context,String fileName){
        try {
            //Return an AssetManager instance for your application's package
            InputStream is = context.getAssets().open(fileName+".txt");
            int size = is.available();
            // Read the entire asset into a local byte buffer.
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            // Convert the buffer into a string.
            String text = new String(buffer, "utf-8");
            // Finally stick the string into the text view.
            return text;
        } catch (IOException e) {
            // Should never happen!
//            throw new RuntimeException(e);
            e.printStackTrace();
        }
        return "读取错误，请检查文件名";
    }

    public String getFilePath(File file){
       return file.getPath();
    }



    /**
     * 得到所有的存储路径（内部存储+外部存储）
     *
     * @param context
     * @return
     */
    public static String[] getAllSdPaths(Context context) {
        Method mMethodGetPaths = null;
        String[] paths = null;
        //通过调用类的实例mStorageManager的getClass()获取StorageManager类对应的Class对象
        //getMethod("getVolumePaths")返回StorageManager类对应的Class对象的getVolumePaths方法，这里不带参数
        StorageManager mStorageManager = (StorageManager)context
                .getSystemService(context.STORAGE_SERVICE);//storage
        try {
            mMethodGetPaths = mStorageManager.getClass().getMethod("getVolumePaths");
            paths = (String[]) mMethodGetPaths.invoke(mStorageManager);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return paths;
    }

}
