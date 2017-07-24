package lesson19.hw19;

/**
 * Created by user on 21.07.2017.
 */
public class Controller {
    private Storage[] storage;

    public Controller(Storage[] storage) {
        this.storage = storage;
    }

    public File findById(Storage storage, long id){

        for (int i = 0; i < storage.getFiles().length && i < storage.getStorageSize() ; i++) {
            for (File file : storage.getFiles()) {
                if(file != null && id == file.getId())
                    return file;
            }

            }
            return null;

    }

    private File put(Storage storage, File file){
if(file == null)
    return null;

        int countNull = 0;
        int index = 0;
        for (File el:storage.getFiles()) {
            if(el == null)
                countNull++;
        }
        index++;

        if(countNull == 0)
            return null;
        return file;

    }
    private void delete(Storage storage, File file){

    }
    private void  transferAll(Storage storageFrom, Storage storageTo){

    }
    private void transferFile(Storage storageFrom, Storage storageTo, long id){

    }
}
