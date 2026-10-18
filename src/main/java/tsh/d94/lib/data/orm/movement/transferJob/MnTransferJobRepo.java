package tsh.d94.lib.data.orm.movement.transferJob;

import java.util.List;

import org.springframework.stereotype.Repository;

import tsh.d94.lib.core.data.orm.common.repo.BaseJpaRepository;

@Repository
public interface MnTransferJobRepo extends BaseJpaRepository<MnTransferJob, String> {

	List<MnTransferJob> findByTenantIdAndCarrIdOrderByModifiedAt(String tenantId, String carrId);

	List<MnTransferJob> findByTenantIdAndCarrIdAndJobIdOrderByModifiedAt(String tenantId, String carrId, String jobId);

}
