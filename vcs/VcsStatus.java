package vcs;

import utils.ErrorCodeManager;
import utils.OperationType;

import java.util.ArrayList;

public class VcsStatus extends VcsOperation {
    public VcsStatus(OperationType type, ArrayList<String> operationArgs) {
        super(type, operationArgs);
    }

    @Override
    /*
     *   va executa VCSoperation pt operatia status
     */
    public int execute(Vcs vcs) {

        vcs.getOutputWriter().write("On branch: " + vcs.getWorkBranch() + "\n");
        vcs.getOutputWriter().write("Staged changes:\n");
        for (int i = 0; i < vcs.getCommand().size(); i++) {
            vcs.getOutputWriter().write(vcs.getCommand().get(i));
        }
        return ErrorCodeManager.OK;
    }
}
