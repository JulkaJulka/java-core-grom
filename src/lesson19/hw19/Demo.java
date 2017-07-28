package lesson19.hw19;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Arrays;

/**
 * Created by user on 21.07.2017.
 */
public class Demo {
    public static void main(String[] args) throws Exception {
File file1 = new File(23, "name1", "doc", 100 );
        File file2 = new File(24, "name2", "img",100);

        File file3 = new File(56, "tes", "png", 1000);
        //File file4 = new File(null);

        File[] files = {file2, file1, file2,null,null};
        File[] files2 = {file2, null, null};


        String[] formatSupportedStorage1 = {"img", "jpg", "png", "pdf", "doc"};

        Storage storage1 = new Storage(234,null,formatSupportedStorage1, 10);
        Storage storageTo = new Storage(235, files2, formatSupportedStorage1, 1000);
        Storage[] storages = {storage1,null};





      System.out.println("files " +  Arrays.toString(files));
        Controller controller = new Controller(storages);

       // System.out.println(controller.checkFormatsSupported(storage1, file3));

       // controller.showFiles(files);
        //System.out.println(controller.findById(storage1,23));
      //
       //  System.out.println(controller.put(storage1, file3));

       // System.out.println("files after put " +  Arrays.toString(files));

        controller.delete(storage1, file1);
       // System.out.println();
        System.out.println("files after delete " +  Arrays.toString(files));

       /* System.out.println(controller.delete(storage1, file2));
        System.out.println("files after delete " +  Arrays.toString(files));*/

       // System.out.println(controller.transferFile(storage1, storageTo, 23));
        System.out.println("files " +  Arrays.toString(files));
       // System.out.println("files2 " +  Arrays.toString(files2));

       // System.out.println(controller.findById(storage1,29));


    }
}
