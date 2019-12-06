package vcs;

import filesystem.FileSystemSnapshot;
import utils.IDGenerator;

public class Commit {
    private int id;
    private String message;
    private FileSystemSnapshot fileSnapshot;

    public Commit() {

    }

    public Commit(String name, FileSystemSnapshot snapshot) {
        this.message = name;
        this.id = IDGenerator.generateCommitID();
        this.fileSnapshot = snapshot.cloneFileSystem();
    }

    /*
    *   va salva o copie a snapshot-ului
     */
    public void setFileSnapshot(FileSystemSnapshot fileSnapshot) {
        this.fileSnapshot = fileSnapshot.cloneFileSystem();
    }

    /*
    *   va returna filesnapshot-ul
     */
    public FileSystemSnapshot getFileSnapshot() {
        return fileSnapshot;
    }

    /*
    *   va returna mesajul
     */
    public String getMessage() {
        return message;
    }

    /*
    * va seta mesajul
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /*
    *   va returna id-ul
     */
    public int getId() {
        return id;
    }

    /*
    * va returna id-ul
     */
    public void setId(int id) {
        this.id = id;
    }
}
