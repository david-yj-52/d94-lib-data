package tsh.d94.lib.data.orm.carrier.carrStat;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import tsh.d94.lib.core.lifecycle.RequestLifeCycleVo;
import tsh.d94.lib.data.orm.carrier.carrLotRel.MnCarrLotRel;

@Component
@RequiredArgsConstructor
@Slf4j
public class MnCarrStatWriter {

	@Getter
	private final MnCarrStatRepo repo;
	private final MnCarrStatReader reader;

	public void updateWipStatCode(RequestLifeCycleVo vo, MnCarrLotRel rel, String wipStatCd) {
		this.updateWipStatCode(vo, rel.getCarrId(), wipStatCd);
	}

	public void updateWipStatCode(RequestLifeCycleVo vo, String carrId, String wipStatCd) {
		MnCarrStat stat = this.reader.getCarrStat(vo, carrId);
		stat.setWipStatCd(wipStatCd);
		this.repo.save(stat);
	}

}
