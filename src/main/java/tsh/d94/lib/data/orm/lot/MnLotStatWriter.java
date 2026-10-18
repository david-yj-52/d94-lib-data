package tsh.d94.lib.data.orm.lot;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import tsh.d94.lib.core.lifecycle.RequestLifeCycleVo;
import tsh.d94.lib.data.orm.carrier.carrLotRel.MnCarrLotRel;

@Component
@RequiredArgsConstructor
@Slf4j
public class MnLotStatWriter {

	@Getter
	private final MnLotStatRepo repo;

	private final MnLotStatReader reader;

	public void updateWipStatCode(RequestLifeCycleVo vo, MnCarrLotRel rel, String wipStatCd) {
		this.updateWipStatCode(vo, rel.getLotId(), wipStatCd);
	}

	private void updateWipStatCode(RequestLifeCycleVo vo, String lotId, String wipStatCd) {
		MnLotStat lotStat = this.reader.getLotStat(vo, lotId);
		lotStat.setWipStatCd(wipStatCd);
		this.repo.save(lotStat);
	}

}
