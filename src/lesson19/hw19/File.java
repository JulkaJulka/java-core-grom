package lesson19.hw19;
public class File {
    private long id;
    private String name;
    private String format;
    private long size;

    public File(long id, String name, String format, long size) throws Exception {
        if (!checkLengthFileName(name))
            throw new Exception(" File name can't be more 10 chars. File with this name can't be created");

        this.id = id;
        this.name = name;
        this.format = format;
        this.size = size;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFormat() {
        return format;
    }

    public long getSize() {
        return size;
    }

    public static boolean checkLengthFileName(String word) throws Exception{
        if(word == null )
            throw new Exception("File  is not detected.");
        if (word.isEmpty())
            return false;
        int limitLengthOfNameFile = 10;

        if(word.length() > limitLengthOfNameFile)
            return false;
        return true;
    }
}
