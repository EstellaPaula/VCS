package vcs;

import utils.ErrorCodeManager;
import utils.OperationType;

import java.util.ArrayList;

public class VcsCommit extends VcsOperation {

    public VcsCommit(OperationType type, ArrayList<String> operationArgs) {
        super(type, operationArgs);
    }

    @Override
    /*
    *   va executa VCSoperation pt operatia commit
     */
    public int execute(Vcs vcs) {
        if (vcs.getCommand().size() == 0) {
            return ErrorCodeManager.VCS_BAD_CMD_CODE;
        }
        String message = "";
        String lastArgument = operationArgs.remove(operationArgs.size() - 1);
        operationArgs.remove(0);
        for (String s : operationArgs) {
            if (!s.equals("-m")) {
                message += s + " ";
            }
        }
        message += lastArgument;

        for (Branch b : vcs.getBranches()) {
            if (b.getNameBranch().equals(vcs.getWorkBranch())) {
                b.getCommmit().add(new Commit(message, vcs.getActiveSnapshot()));
                int size;
                size = b.getCommmit().size();
                b.getCommmit().get(size - 1).setFileSnapshot(vcs.getActiveSnapshot());
            }
        }
        vcs.getCommand().clear();
        return ErrorCodeManager.OK;
    }
}
