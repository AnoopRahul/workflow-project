import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class WorkflowServiceTest {

    WorkflowService service = new WorkflowService();

    @Test
    void testApproveValid() {
        assertEquals(WorkflowState.APPROVED,
                service.approve(WorkflowState.UNDER_REVIEW));
    }

    @Test
    void testRejectValid() {
        assertEquals(WorkflowState.REJECTED,
                service.reject(WorkflowState.UNDER_REVIEW));
    }

    @Test
    void testInvalidApprove() {
        assertThrows(RuntimeException.class, () -> {
            service.approve(WorkflowState.DRAFT);
        });
    }

    @Test
    void testSubmitValid() {
        assertEquals(WorkflowState.SUBMITTED,
                service.submit(WorkflowState.DRAFT));
    }

    @Test
    void testResubmitValid() {
        assertEquals(WorkflowState.SUBMITTED,
                service.resubmit(WorkflowState.REJECTED));
    }

    @Test
    void testResubmitInvalid() {
        assertThrows(RuntimeException.class, () -> {
            service.resubmit(WorkflowState.APPROVED);
        });
    }
}