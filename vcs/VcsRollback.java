package vcs;

import utils.ErrorCodeManager;
import utils.OperationType;

import java.util.ArrayList;

public class VcsRollback extends VcsOperation {

    public VcsRollback(OperationType type, ArrayList<String> operationArgs) {
        super(type, operationArgs);
    }

    @Override
    /*
    *   va executa VCSoperation pt operatia rollback
     */
    public int execute(Vcs vcs) {
        Branch workingBranch = new Branch();
        vcs.getCommand().clear();
        for (Branch b : vcs.getBranches()) {
            if (b.getNameBranch().equals(vcs.getWorkBranch())) {
                workingBranch = b;
            }
        }
        int size = workingBranch.getCommmit().size() - 1;
        vcs.setActiveSnapshot(workingBranch.getCommmit().get(size).getFileSnapshot());
        return ErrorCodeManager.OK;
    }
}
