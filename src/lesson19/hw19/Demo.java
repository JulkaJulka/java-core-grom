package lesson19.hw19;
import java.util.Arrays;
public class Demo {
    public static void main(String[] args) throws Exception {
        File file1 = new File(23, "name", "doc", 100);
        File file2 = new File(24, "name", "img", 100);

        File file3 = new File(0, "tes", "png", 1000);
        File file5 = new File(78, "hdl", "png", 1000);
        File file6 = new File(78, "hdl", "xls", 1000);
        File file7 = new File(25, "named", "img", 100);
        File file8 = new File(79, "name", "img", 100);
        File file9 = new File(80, "name", "img", 25);
         // File file10 = new File(81, null, null, 1);
        File file11 = new File(82, "test", "doc",40);
        File file12 = new File(83, "test", "doc",40);


        File[] files = {file2, file1, file2, null, null};
        File[] files2 = {file2, null, null};
        File[] files3 = {file2, null, null};
        File[] files4 = {file7,null};
        File[] files5 = {file7, file8 };



        String[] formatSupportedStorage1 = {"img", "jpg", "png", "pdf", "doc"};

        Storage storage1 = new Storage(234, files, formatSupportedStorage1, 3);
        Storage storageTo = new Storage(235, files2, formatSupportedStorage1, 1000);
        Storage storage2 = new Storage(236, files3, formatSupportedStorage1, 100);
        Storage storage3 = new Storage(236, files3, formatSupportedStorage1, 150);
        Storage storageFrom = new Storage(237, files4, formatSupportedStorage1, 130);

        Storage storageFrom2 = new Storage(238, files5,formatSupportedStorage1,250);

        File[] files6 = {file11, null};
        File[] files7 = {file12, null};
        File[] files8 = {file11, file12,null,null};
        File[] files9 = {file12, null};

        Storage storageFrom13 = new Storage(239, files6,formatSupportedStorage1,1000);
        Storage storageTo13  = new Storage(240,files7,formatSupportedStorage1,500);

        Storage storageFrom14 = new Storage(241, files6,formatSupportedStorage1,100);
        Storage storageTo14  = new Storage(242,files8,formatSupportedStorage1,81);



      //  System.out.println("files " + Arrays.toString(files));
        Controller controller = new Controller();

        System.out.println("---Test14_transferAll_storageTo has not enough space");
        //Storage storageFrom14 = new Storage(241, files6,formatSupportedStorage1,100);
        //Storage storageTo14  = new Storage(242,files8,formatSupportedStorage1,81);
        try {
            System.out.println(controller.transferAll(storageFrom14, storageTo14));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println("---Test13_transferAll with nullFile");
        try {
            System.out.println(controller.transferAll(storageFrom13, storageTo13));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println("---Test12_transferAll successfully---");
        controller.transferAll(storageFrom2,storageTo);
       System.out.println(Arrays.toString(storageTo.getFiles()));


        System.out.println("---Test11_transferAll with full position storage---");
        //File file2 = new File(24, "name", "img", 100);
        //File file7 = new File(25, "named", "img", 100);
        //File[] files2 = {file2, null, null};
        //File[] files4 = {file7,null};
        //Storage storageFrom = new Storage(237, files4, formatSupportedStorage1, 130);
        //Storage storageTo = new Storage(235, files2, formatSupportedStorage1, 1000);

        try {
            System.out.println(controller.transferAll(storageFrom, storageTo));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println("---Test1_above SizeOfStorage");
        // storage1.getStorageSize() == 3
        // Storage storage1 = new Storage(234,files,formatSupportedStorage1, 3);
        // File[] files = {file2, file1, file2,null,null};
        System.out.println(controller.checkSizeOfStorage(storage1));
        System.out.println();

        System.out.println("---Test2_empty place in storage---");
        // storageTo.getStorageSize() == 1000
        // Storage storageTo = new Storage(235, files2, formatSupportedStorage1, 1000);
        // File[] files = {file2, file1, file2,null,null};
        System.out.println(controller.checkSizeOfStorage(storageTo));
        System.out.println();

       /* System.out.println("---Test6_put file with existing name File in storage---");
        // storageTo.getStorageSize() == 1000
        // Storage storageTo = new Storage(235, files2, formatSupportedStorage1, 1000);
        // File[] files = {file2, file1, file2,null,null};
        // File file6 = new File(78, "hdl","xls", 1000);
        System.out.println(controller.put(storage2, file8));

        System.out.println();*/

        System.out.println("---Test5_put file with existing ID in storage---");
        // storageTo.getStorageSize() == 1000
        // Storage storageTo = new Storage(235, files2, formatSupportedStorage1, 1000);
        // File[] files = {file2, file1, file2,null,null};
        // File file6 = new File(78, "hdl","xls", 1000);

        try {
            System.out.println(controller.put(storageTo, file7));
            System.out.println();
        } catch (Exception e) {
            if (e.getMessage().equals("File with Id " + file7.getId() +
                    " already exists in storage " + storageTo.getId() +
                    " Storage can't save files with the same ID. ")) {
                System.out.println("Test Pass");
            } else {
                System.out.println("Test Fail");
            }
        }


        System.out.println("---Test4_put file with wrong format---");
        // storageTo.getStorageSize() == 1000
        // Storage storageTo = new Storage(235, files2, formatSupportedStorage1, 1000);
        // File[] files = {file2, file1, file2,null,null};
        // File file6 = new File(78, "hdl","xls", 1000);
        try {
            System.out.println(controller.put(storageTo, file6));
            System.out.println();
        } catch (Exception e) {
            if (e.getMessage().equals("Format " + file6.getFormat() +
                    " is not supported by storage " + storageTo.getId())) {
                System.out.println("Test Pass");
            } else {
                System.out.println("Test Fail");
            }
        }

        System.out.println("---Test3_put file in storage with not enough space---");
        // storageTo.getStorageSize() == 1000
        // Storage storageTo = new Storage(235, files2, formatSupportedStorage1, 1000);
        // File[] files = {file2, file1, file2,null,null};
        //Storage storage1 = new Storage(234,files,formatSupportedStorage1, 3);
        //File file5 = new File(78, "hdl","png", 1000);
        try {
            System.out.println(controller.put(storage1, file5));
            System.out.println();
        } catch (Exception e) {
            if (e.getMessage().equals("Not enough space int storage with Id " + storage1.getId())) {
                System.out.println("Not enough space int storage with Id " + storage1.getId());
                System.out.println("Test Pass");
            } else {
                System.out.println("Test Fail");
            }
        }


        System.out.println("--- Test6_ checkSizeFileInComparisonSizeStorage(storage,file)()_" +
                "Not enough space int storage with Id for File---");
        //Storage storage2 = new Storage(236,files3,formatSupportedStorage1,100)
        // File file8 = new File(79, "name", "img",100);
        // File[] files3 = {file2,null};
        //File file2 = new File(24, "name", "img",100);
        System.out.println(controller.checkSizeFileInComparisonSizeStorage(storage2, file8));

        System.out.println("--- Test7_ put()_Not enough space int storage with Id for File---");
        //Storage storage2 = new Storage(236,files3,formatSupportedStorage1,100)
        // File file8 = new File(79, "name", "img",100);
        // File[] files3 = {file2,null};
        //File file2 = new File(24, "name", "img",100);
        try {
            System.out.println(controller.put(storage2, file8));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (e.getMessage().equals("Not enough space int storage with Id " + storage2.getId())) {
                System.out.println("Test Pass");
            } else {
                System.out.println("Test Fail");
            }

        }
        System.out.println("---Test8_put file size 25 in storage with free space 50");
        //File file9 = new File(80, "name", "img",25);
        // File[] files3 = {file2,null};
        //Storage storage3 = new Storage(236,files3,formatSupportedStorage1,50);
        //File file2 = new File(24, "name", "img",100);
        if (controller.put(storage3, file9) == file9) {
            System.out.println(file9);
            System.out.println("Test Pass");
            System.out.println(Arrays.toString(files3));
        } else {
            System.out.println("Test Fail");
        }


     /*   System.out.println("---Test9_put null file in storage with free space 50");
        //File file10 = new File(81,null,null,1);
        // File[] files3 = {file2,null};
        //Storage storage3 = new Storage(236,files3,formatSupportedStorage1,50);
        //File file2 = new File(24, "name", "img",100);

        try {
            System.out.println(controller.put(storage1, file10));
        } catch (Exception e){
            System.out.println(e.getMessage());
            if(e.getMessage().equals("File  is not detected.")){
                System.out.println("Test Pass");
            } else {
                System.out.println("Test Fail");
            }
        }
        /*if(checkLengthFileName(file10.getName()) == null)
            System.out.println(file9);
            System.out.println("Test Pass");
        } else{
            System.out.println("Test Fail");*/


    }
}








        // System.out.println(controller.checkFormatsSupported(storage1, file3));

       // controller.showFiles(files);
        //System.out.println(controller.findById(storage1,23));
      //
        // System.out.println(controller.put(storage1, file5));

       // System.out.println("files after put " +  Arrays.toString(files));

       // controller.delete(storage1, file1);
       // System.out.println();
       // System.out.println("files after delete " +  Arrays.toString(files));

       /* System.out.println(controller.delete(storage1, file2));
        System.out.println("files after delete " +  Arrays.toString(files));*/

       // System.out.println(controller.transferFile(storage1, storageTo, 23));
       // System.out.println("files " +  Arrays.toString(files));
       // System.out.println("files2 " +  Arrays.toString(files2));

       // System.out.println(controller.findById(storage1,29));




