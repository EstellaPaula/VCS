package vcs;

import utils.ErrorCodeManager;
import utils.OperationType;

import java.util.ArrayList;

public class VcsLog extends VcsOperation {

    public VcsLog(OperationType type, ArrayList<String> operationArgs) {
        super(type, operationArgs);
    }

    @Override
    /*
     *   va executa VCSoperation pt operatia log
     */
    public int execute(Vcs vcs) {
        for (Branch b : vcs.getBranches()) {
            if (b.getNameBranch().equals(vcs.getWorkBranch())) {
                int size = b.getCommmit().size() - 1;
                Commit lastCommit = b.getCommmit().remove(size);
                for (Commit c : b.getCommmit()) {
                    vcs.getOutputWriter().write("Commit id: " + c.getId() + "\n");
                    vcs.getOutputWriter().write("Message: ");
                    vcs.getOutputWriter().write(c.getMessage());
                    vcs.getOutputWriter().write("\n\n");
                }
                vcs.getOutputWriter().write("Commit id: " + lastCommit.getId() + "\n");
                vcs.getOutputWriter().write("Message: ");
                vcs.getOutputWriter().write(lastCommit.getMessage());
                vcs.getOutputWriter().write("\n");
                b.getCommmit().add(lastCommit);
            }
        }
        return ErrorCodeManager.OK;
    }
}
