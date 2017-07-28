package lesson19.hw19;

/**
 * Created by user on 21.07.2017.
 */
public class Controller {
    private Storage[] storage;

    public Controller(Storage[] storage) {
        this.storage = storage;
    }

    public File findById(Storage storage, long id) {

        for (int i = 0; i < storage.getFiles().length && i < storage.getStorageSize(); i++) {
            for (File file : storage.getFiles()) {
                if (file != null && id == file.getId())
                    return file;
            }

        }
        return null;

    }

    public File put(Storage storage, File file) {

        int countNull = 0;

        for (File el : storage.getFiles()) {
            if (el == null)
                countNull++;
        }

        if (file == null)
            return null;

        if (countNull == 0)
            return null;

        File putFile = findById(storage, file.getId());

       if (putFile != null)
            return null;
        int limitLengthOfFileName = 10;

        try {
            for (int i = 0; i < storage.getFiles().length && i < storage.getStorageSize(); i++) {
                if (storage.getFiles()[i] == null && checkFormatsSupported(storage, file)
                        && file.getName().length() <= limitLengthOfFileName ) {
                    storage.getFiles()[i] = file;
                    break;
                }
            }
//??? чем отличается от fori
      /* for (File el: storage.getFiles()) {
            if(el == null)
                el = file;
                break;
        }*/
        return file;
    }catch (Exception e){
            System.err.println( storage + " something");
            return null;

    }


    }

    public File delete(Storage storage, File file) {
        if (file == null)
            return null;

        File deleteFile = findById(storage, file.getId());
        if (deleteFile != null) {
            for (int i = 0; i < storage.getFiles().length; i++) {
                if (storage.getFiles()[i] == deleteFile) {
                    storage.getFiles()[i] = null;
                    break;
                }
            }
            return file;
        }


        return null;
    }

    public void showFiles(File[] files) {
        for (int i = 0; i < files.length; i++) {

            System.out.print(files[i] + " ");
        }
        System.out.println();
    }

   // public boolean checkPresentFile(Storage storage, File file){}

    /* public File[] transferAll(Storage storageFrom, Storage storageTo){
         int countFilesFromStorage = 0;
         for (File file: storageFrom.getFiles()) {
             if(file != null)
                 countFilesFromStorage++;
         }

         int countFreePositionToStorage = 0;
         for (File file: storageTo.getFiles()) {
             if(file == null)
                 countFreePositionToStorage++;
         }

         if(countFilesFromStorage == 0 || countFreePositionToStorage == 0)
             return null;

         for (int i = 0; i <storageTo.getFiles().length ; i++) {
             for (int j = 0; j <storageFrom.getFiles().length ; j++) {
                 if (storageFrom.getFiles()[j] != null &&
                         storageTo.getFiles()[i] == null) {
                     storageTo.getFiles()[i] = storageFrom.getFiles()[j];
                 }
                 }

             }
         }

     }*/
    public File transferFile(Storage storageFrom, Storage storageTo, long id) {
        File transferFile = findById(storageFrom, id);
        if (transferFile == null)
            return null;
        for (int i = 0; i <storageTo.getFiles().length ; i++) {
            if(storageTo.getFiles()[i] == transferFile &&
                    storageTo.getFiles()[i].getName() == transferFile.getName()){
                return null;
            }
        }
        int countNullStorageTo = 0;
        for (File file : storageTo.getFiles()) {
            if (file == null)
                countNullStorageTo++;
        }
        if (countNullStorageTo > 0) {
            for (int i = 0; i < storageTo.getFiles().length; i++) {
                if (storageTo.getFiles()[i] == null) {
                    storageTo.getFiles()[i] = transferFile;
                    break;
                }
            }
            for (int i = 0; i < storageFrom.getFiles().length; i++) {
                if (storageFrom.getFiles()[i] == transferFile) {
                    storageFrom.getFiles()[i] = null;
                }
            }
            return transferFile;
        }
        return null;
    }

    public boolean checkFormatsSupported(Storage storage, File file){
        if(file == null || storage.getFormatsSupported() == null)
            return false;
        boolean status = true;
     /*   for (int i = 0; i < storage.getFormatsSupported().length ; i++) {
            if(storage.getFormatsSupported()[i] == file.getFormat()){
                status = true;
            break;}
            else {
                status = false;}
        }*/
        for (String el: storage.getFormatsSupported()) {
            if(el == file.getFormat()){
                status = true;
                break;
            } else {
                   status = false;
          }
        }
        return status;

    }
}
