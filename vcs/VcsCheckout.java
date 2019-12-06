package vcs;

import utils.ErrorCodeManager;
import utils.OperationType;

import java.util.ArrayList;

public class VcsCheckout extends VcsOperation {

    public VcsCheckout(OperationType type, ArrayList<String> operationArgs) {
        super(type, operationArgs);
    }

    @Override
    /*
     *   va executa VCSoperation pt operatia checkout
     */
    public int execute(Vcs vcs) {
        Branch currentBranch = new Branch();
        int ok = 0;
        int indexCommitDeSters = 0;
        Commit commitDeSters = new Commit();

        if (vcs.getCommand().size() != 0) {
            return ErrorCodeManager.VCS_STAGED_OP_CODE;
        }

        String argument = operationArgs.get(1);
        for (Branch b : vcs.getBranches()) {
            if (b.getNameBranch().equals(vcs.getWorkBranch())) {
                currentBranch = b;
            }
        }
        if (argument.equals("-c")) {
            int id = Integer.parseInt(operationArgs.get(2));
            for (Commit c : currentBranch.getCommmit()) {
                if (c.getId() == id) {
                    ok = 1;
                }
            }
            if (ok == 0) {
                return ErrorCodeManager.VCS_BAD_PATH_CODE;
            }
            for (int i = 0; i < currentBranch.getCommmit().size(); i++) {
                commitDeSters = currentBranch.getCommmit().get(i);
                if (commitDeSters.getId() > id) {
                    currentBranch.getCommmit().remove(i);
                    i--;
                }
            }
            vcs.setActiveSnapshot(currentBranch.getCommitById(id).getFileSnapshot());
        }

        if (!argument.equals("-c")) {
            indexCommitDeSters = 0;
            for (Branch b : vcs.getBranches()) {
                if (b.getNameBranch().equals(argument)) {
                    ok = 1;
                    indexCommitDeSters = vcs.getBranches().indexOf(b);
                    vcs.setWorkBranch(argument);
                }
            }
            if (ok == 0) {
                return ErrorCodeManager.VCS_BAD_CMD_CODE;
            }
            indexCommitDeSters += 1;
            vcs.getBranches().subList(indexCommitDeSters, vcs.getBranches().size()).clear();
        }

        return ErrorCodeManager.OK;
    }
}
