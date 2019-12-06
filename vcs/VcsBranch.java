package vcs;

import utils.ErrorCodeManager;
import utils.OperationType;

import java.util.ArrayList;

public class VcsBranch extends VcsOperation {
    public VcsBranch(OperationType type, ArrayList<String> operationArgs) {
        super(type, operationArgs);
    }

    @Override
    /*
    * va executa VCSoperation pt operatia branch
     */
    public int execute(Vcs vcs) {
        String nameBranch = operationArgs.get(1);
        for (Branch b : vcs.getBranches()) {
            if (nameBranch.equals(b.getNameBranch())) {
                return ErrorCodeManager.VCS_BAD_CMD_CODE;
            }
        }
        vcs.getBranches().add(new Branch(nameBranch));
        return ErrorCodeManager.OK;
    }
}
