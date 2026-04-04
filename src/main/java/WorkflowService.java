public class WorkflowService {

    public WorkflowState submit(WorkflowState state) {
        if (state == WorkflowState.DRAFT) {
            return WorkflowState.SUBMITTED;
        }
        throw new RuntimeException("Invalid transition");
    }
// change for jenkin test
    public WorkflowState review(WorkflowState state) {
        if (state == WorkflowState.SUBMITTED) {
            return WorkflowState.UNDER_REVIEW;
        }
        throw new RuntimeException("Invalid transition");
    }

    public WorkflowState approve(WorkflowState state) {
        if (state == WorkflowState.UNDER_REVIEW) {
            return WorkflowState.APPROVED;
        }
        throw new RuntimeException("Invalid transition");
    }

    public WorkflowState reject(WorkflowState state) {
        if (state == WorkflowState.UNDER_REVIEW) {
            return WorkflowState.REJECTED;
        }
        throw new RuntimeException("Invalid transition");
    }
    public WorkflowState resubmit(WorkflowState state) {
    if (state == WorkflowState.REJECTED) {
        return WorkflowState.SUBMITTED;
    }
    throw new RuntimeException("Invalid transition");
}
}