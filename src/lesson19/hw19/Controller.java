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
        if(storage.getFiles() == null)
            return null;

        for (int i = 0; i < storage.getFiles().length; i++) {
            for (File file : storage.getFiles()) {
                if (file != null && id == file.getId())
                    return file;
            }

        }
        return null;

    }

    public File put(Storage storage, File file) throws Exception {
        if (file == null)
            throw new Exception("Putted file  is not detected");

       /* int countNull = 0;
        int countFullPositions = 0;

        for (File el : storage.getFiles()) {
            if (el == null) {
                countNull++;
                countFullPositions++;
            }
            if (countFullPositions == storage.getStorageSize())
                throw new Exception("Storage " + storage.getId() + " is full");*/

        File putFile = findById(storage, file.getId());

        if (putFile != null)
            throw new Exception("File with Id " + file.getId() +
                    " already exists in storage " + storage.getId() + " Storage can't save files with the same ID. ");

        if (!checkFormatsSupported(storage, file))
            throw new Exception("Format " + file.getFormat() + " is not supported by storage " + storage.getId());

        int limitLengthOfFileName = 10;

        if (file.getName().length() > limitLengthOfFileName)
            throw new Exception("The name of file with Id " + file.getId() + " is wrong. The name " +
                    file.getName() + " exceeds limit of length ("+ limitLengthOfFileName + " chars). It can not put to" +
                    "storsge with Id " + storage.getId() );

        if(file.getId() <= 0)
            throw new Exception("Id " + file.getId() +
                    " isn't unacceptable. File can't put to storage with Id " + storage.getId());

        if(!checkWithoutSpecSymbol(file.getName()))
            throw new Exception("File's name " + file.getName() + " is wrong. It must be contain only chars." +
                    " File can't put to storage " + storage.getId());

        if(!checkIdStorage(storage))
            throw new Exception("Storage Id " + storage.getId() + " is wrong.");

        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i] == null) {
                storage.getFiles()[i] = file;
                return file;
            }
        }
        throw new Exception("Storage "+storage.getId() +"is not empty");

    }


//??? чем отличается от fori
      /* for (File el: storage.getFiles()) {
            if(el == null)
                el = file;
                break;
        }*/
       // return file;





    public void delete(Storage storage, File file) throws Exception {
        if (file == null)
            throw new Exception("Deleted file with Id " + file.getId() + " is null.");

        int limitLengthOfFileName = 10;

        if(storage == null)
            throw new Exception("Storage with Id " + storage.getId() + " is not detected.");

        if (file.getName().length() > limitLengthOfFileName)
            throw new Exception("The name of file with Id " + file.getId() + " is wrong. The name " +
                    file.getName() + " exceeds limit of length ("+ limitLengthOfFileName + " chars)");

        File deleteFile = findById(storage, file.getId());
        if (deleteFile != null) {
            for (int i = 0; i < storage.getFiles().length; i++) {
                if (storage.getFiles()[i] == deleteFile) {
                    storage.getFiles()[i] = null;
                    break;
                }

            }
        }

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

    public static boolean checkWithoutSpecSymbol(String word) {
        if (word.isEmpty())
            return false;
        char[] symbals = word.toCharArray();
        for (char c : symbals) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }

        return true;
    }

    public static boolean checkIdStorage(Storage storage){
        if(storage == null)
            return false;
        if(storage.getId() <= 0)
            return false;
        return true;

    }
}
