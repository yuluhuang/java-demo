/**
 * @Title
 * @Project java-demo
 * @Package com.yuluhuang.demo.htmlToWord
 * @Description
 * @author yoshikouamari
 * @date 2019-07-29 11:59
 * @version
 */
package com.yuluhuang.demo.htmlToWord;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.DocumentEntry;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
/**
 * @author yoshikouamari
 * @Description
 * @date 2019-07-29 11:59
 */
public class HtmlToDoc {
    /**
     * * 读取html文件到word
     * <p>
     * * @param filepath html文件的路径
     * <p>
     * * @return
     * <p>
     * * @throws Exception
     * <p>
     */

    public boolean writeWordFile(String filepath) throws Exception {

        boolean flag = false;

        ByteArrayInputStream bais = null;

        FileOutputStream fos = null;

        String path = "./";  //根据实际情况写路径

        try {

            if (!"".equals(path)) {

                File fileDir = new File(path);

                if (fileDir.exists()) {

                    String content = readFile(filepath);

                    byte b[] = content.getBytes();

                    bais = new ByteArrayInputStream(b);

                    POIFSFileSystem poifs = new POIFSFileSystem();

                    DirectoryEntry directory = poifs.getRoot();

                    DocumentEntry documentEntry = directory.createDocument("WordDocument", bais);

                    fos = new FileOutputStream("./12.doc");

                    poifs.writeFilesystem(fos);

                    bais.close();

                    fos.close();

                }

            }


        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            if (fos != null) fos.close();

            if (bais != null) bais.close();

        }

        return flag;

    }


    /**
     * 读取html文件到字符串
     *
     * @param filename
     * @return
     * @throws Exception
     */


    public String readFile(String filename) throws Exception {

        StringBuffer buffer = new StringBuffer("");

        BufferedReader br = null;

        try {

            br = new BufferedReader(new FileReader(filename));

            buffer = new StringBuffer();

            while (br.ready())

                buffer.append((char) br.read());

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            if (br != null) br.close();

        }

        return buffer.toString();

    }


    public static void main(String[] args) throws Exception {

        new HtmlToDoc().writeWordFile("/Volumes/storage/workspace/java/java-demo/demo/src/main/resources/table.html");

    }
}
