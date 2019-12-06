
VCS

"Context" class implemented with the cases of "trackable" operations: for each touch, makedir, changedir, remove, writetofile commands, the modifications are added to the "commamnd" string list, from the VCS class, which represents the stagging.
In the "ErrorCodeMananager" class I filled in boxes for VCS errors, in the "OperationFactory" class we filled in boxes for each vcs command (STATUS, BRANCH, COMMIT, LOG, CHECKOUT, ROLLBACK), in the "OperationParser" class I completed the houses for VCS operations, and in the "OperationType" class I completed with the VCS commands.
We created the following classes:
-Branch, with the nameBranch fields, and a "commit" list that holds the commits in a branch and
the appropriate getter and setter methods, together with a getCommitById method;

-Commit, with the id, message, and fileSnapshot fields, and getter and setter methods for them;

-Vcs, with the outputWriter fields, activeSnapshot, an array of "command" Strings, which represents staggering, an array of Branches "branches", a String workBranch, which keeps the current branch name and a String branchToCreate, which keeps the name of the branch to be created;

-VcsBranch - Creates a new branch with the same structure of the file system as the one described by the current branch commit, if there is not already a branch with the respective name, otherwise the specific error code is generated;

-VcsCheckout - All commits that were given after commit x will be deleted, and returned to the preceding filesnapshot, or from the branch, if the parameters are valid, otherwise the specific error codes are generated;

-VcsCommit - Generates a new commit, by applying the changes made in the current staging commit; The new commit will have the current commit as a parent;

-VcsInvalidOperation - error specific to VCS commands;

-VcsLog - Displays all commits given on the current branch;

-VcsOperation

-VcsRollback - Clear the staging and bring the filesystem snapshot to the version given by the last commit;

-VcsStatus - The command lists the branch name we are in and the changes that are in staging;