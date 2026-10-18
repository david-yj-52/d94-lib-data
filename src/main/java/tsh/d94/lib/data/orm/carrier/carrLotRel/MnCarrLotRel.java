package tsh.d94.lib.data.orm.carrier.carrLotRel;

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
	name = MosTableConstant.MN_CARR_STAT,
	uniqueConstraints = {
		@UniqueConstraint(name = MnCarrLotRel.UK01, columnNames = {"env", "sol_nm", "host", "port"})
	}
)
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@Audited    // History 자동 생성을 위함
public class MnCarrLotRel extends BaseModel {
	public static final String UK01 = "uk_mn_carr_lot_rel_01";

	@Column(name = "LOT_ID")
	private String lotId;

	@Column(name = "CARR_ID")
	private String carrId;

	@Column(name = "CARR_TYP")
	private String carrTyp;

	@Column(name = "USE_CNT")
	private Long useCnt;

}
