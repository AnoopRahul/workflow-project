import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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
}