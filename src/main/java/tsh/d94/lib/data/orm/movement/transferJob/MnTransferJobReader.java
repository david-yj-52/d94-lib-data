package tsh.d94.lib.data.orm.movement.transferJob;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import tsh.d94.lib.core.lifecycle.RequestLifeCycleVo;

@Component
@RequiredArgsConstructor
@Slf4j
public class MnTransferJobReader {

	@Getter
	private final MnTransferJobRepo repo;

	public MnTransferJob fetchJobMatchedWithDestInfo(RequestLifeCycleVo vo, List<MnTransferJob> jobList, String eqpId,
		String portId) {

		if (jobList.size() == 1) {
			return jobList.getFirst();
		} else {
			List<MnTransferJob> matched = jobList.stream()
				.filter(job -> Objects.equals(job.getToEqpId(), eqpId) &&
					Objects.equals(job.getToPortId(), portId))
				.toList();
			return matched.getFirst();
		}
	}

	public List<MnTransferJob> fetchJob(RequestLifeCycleVo vo, String jobId, String carrId) {

		List<MnTransferJob> jobList = this.repo.findByTenantIdAndCarrIdAndJobIdOrderByModifiedAt(
			vo.getTenantId(), carrId, jobId
		);

		if (jobList.isEmpty()) {
			log.error("job not found. carrId:{}, jobId:{}", carrId, jobId);
			throw new NullPointerException("job not found. carrId:" + carrId + " jobId: " + jobId);
		}
		if (jobList.size() > 1) {
			log.warn("job is over 1. find out reason.");
			// TODO let developer knows this.
		}

		return jobList;
	}
}
