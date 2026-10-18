package tsh.d94.lib.data.orm.port;

import java.time.LocalDateTime;

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
	name = MosTableConstant.MN_PORT_STAT,
	uniqueConstraints = {
		@UniqueConstraint(name = MnPortStat.UK01, columnNames = {"env", "sol_nm", "host", "port"})
	}
)
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@Audited    // History 자동 생성을 위함
public class MnPortStat extends BaseModel {
	public static final String UK01 = "uk_mn_port_stat_01";

	@Column(name = "PORT_ID")
	private String portId;

	@Column(name = "EQP_ID")
	private String eqpId;

	@Column(name = "CARR_ID")
	private String carrId;

	// TODO 추후 ENUM화
	@Column(name = "PORT_STAT")
	private String portStat;

	@Column(name = "LOAD_TM")
	private LocalDateTime loadTm;

	@Column(name = "UN_LOAD_TM")
	private LocalDateTime unLoadTm;

}
