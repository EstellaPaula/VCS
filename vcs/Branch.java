package vcs;

import java.util.ArrayList;

public class Branch {
    private String nameBranch;
    private ArrayList<Commit> commmit = new ArrayList<Commit>();

    public Branch() {

    }

    public Branch(String name) {
        this.nameBranch = name;
    }

    /*
     *   returneaza comenzile din "stagging"
     */
    public ArrayList<Commit> getCommmit() {
        return commmit;
    }

    /*
    * returneaza commitul cu id-ul respectiv
     */
    public Commit getCommitById(int id) {
        for (Commit c : this.commmit) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    /*
     *   suprascrie getBranch
     */
    public String getNameBranch() {
        return nameBranch;
    }
}
