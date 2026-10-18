package tsh.d94.lib.data.orm.movement.transferJob;

import org.hibernate.envers.Audited;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import tsh.d94.lib.core.data.orm.common.model.BaseModel;
import tsh.d94.lib.data.orm.MosTableConstant;

@Entity
@Table(
	name = MosTableConstant.MN_TRANSFER_JOB,
	uniqueConstraints = {
		@UniqueConstraint(name = MnTransferJob.UK01, columnNames = {"env", "sol_nm", "host", "port"})
	}
)
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@Audited    // History 자동 생성을 위함
public class MnTransferJob extends BaseModel {
	public static final String UK01 = "uk_mn_transfer_job_01";

	@Column(name = "JOB_ID")
	private String jobId;

	@Column(name = "JOB_STAT_CD")
	private String jobStatCd;

	@Column(name = "CARR_ID")
	private String carrId;

	@Column(name = "LOT_ID")
	private String lotId;

	@Column(name = "PRIORITY")
	private Long priority;

	@Column(name = "FROM_EQP_ID")
	private String fromEqpId;

	@Column(name = "FROM_PORT_ID")
	private String fromPortId;

	@Column(name = "TO_EQP_ID")
	private String toEqpId;

	@Column(name = "TO_PORT_ID")
	private String toPortId;

	@Column(name = "CRNT_EQP_ID")
	private String crntEqpId;

	@Column(name = "CRNT_PORT_ID")
	private String crntPortId;

}
