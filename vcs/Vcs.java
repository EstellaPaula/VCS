package vcs;

import filesystem.FileSystemOperation;
import filesystem.FileSystemSnapshot;
import utils.OutputWriter;
import utils.Visitor;

import java.util.ArrayList;

public final class Vcs implements Visitor {
    private final OutputWriter outputWriter;
    private FileSystemSnapshot activeSnapshot;
    private ArrayList<String> command;
    private ArrayList<Branch> branches;
    private String workBranch;
    private String branchToCreate;


    /**
     * Vcs constructor.
     *
     * @param outputWriter the output writer
     */
    public Vcs(OutputWriter outputWriter) {
        this.outputWriter = outputWriter;
    }

    public FileSystemSnapshot getActiveSnapshot() {
        return activeSnapshot;
    }

    /**
     * Does initialisations.
     */
    public void init() {
        this.activeSnapshot = new FileSystemSnapshot(outputWriter);
        this.branches = new ArrayList<Branch>();
        this.branches.add(new Branch("master"));
        this.branches.get(0).getCommmit().add(new Commit("First commit", activeSnapshot));
        this.workBranch = "master";
        command = new ArrayList<String>();
    }

    public void setActiveSnapshot(FileSystemSnapshot activeSnapshot) {
        this.activeSnapshot = activeSnapshot;
    }

    public String getBranchToCreate() {
        return branchToCreate;
    }

    public void setBranchToCreate(String branchToCreate) {
        this.branchToCreate = branchToCreate;
    }

    public OutputWriter getOutputWriter() {
        return outputWriter;
    }

    public String getWorkBranch() {
        return workBranch;
    }

    public void setWorkBranch(String workBranch) {
        this.workBranch = workBranch;
    }

    /**
     * Visits a file system operation.
     *
     * @param fileSystemOperation the file system operation
     * @return the return code
     */
    public int visit(FileSystemOperation fileSystemOperation) {
        return fileSystemOperation.execute(this.activeSnapshot);
    }

    public ArrayList<Branch> getBranches() {
        return branches;
    }

    public void setBranches(ArrayList<Branch> branches) {
        this.branches = branches;
    }

    /**
     * Visits a vcs operation.
     *
     * @param vcsOperation the vcs operation
     * @return return code
     */
    @Override
    public int visit(VcsOperation vcsOperation) {
        return vcsOperation.execute(this);
    }

    public ArrayList<String> getCommand() {
        return command;
    }

    public void setCommand(ArrayList<String> command) {
        this.command = command;
    }

}
