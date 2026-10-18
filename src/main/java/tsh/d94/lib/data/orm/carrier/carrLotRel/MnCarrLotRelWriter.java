package tsh.d94.lib.data.orm.carrier.carrLotRel;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import tsh.d94.lib.core.lifecycle.RequestLifeCycleVo;
import tsh.d94.lib.data.orm.carrier.carrStat.MnCarrStatWriter;
import tsh.d94.lib.data.orm.lot.MnLotStatWriter;

@Component
@RequiredArgsConstructor
@Slf4j
public class MnCarrLotRelWriter {

	@Getter
	private final MnCarrLotRelRepo repo;

	private final MnCarrLotRelReader reader;
	private final MnCarrStatWriter carrWriter;
	private final MnLotStatWriter lotWriter;

	public void updateWipStatCodeByCarr(RequestLifeCycleVo vo, String carrId, String wipStatCode) {

		MnCarrLotRel rel = this.reader.getCarrLotRelByCarr(vo, carrId);

		if (rel == null) {
			this.carrWriter.updateWipStatCode(vo, carrId, wipStatCode);
		} else {
			this.carrWriter.updateWipStatCode(vo, rel, wipStatCode);
			this.lotWriter.updateWipStatCode(vo, rel, wipStatCode);
		}
	}

}
