package tsh.d94.lib.data.orm.carrier.carrLotRel;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import tsh.d94.lib.core.data.constant.UseStatCd;
import tsh.d94.lib.core.lifecycle.RequestLifeCycleVo;

@Component
@RequiredArgsConstructor
@Slf4j
public class MnCarrLotRelReader {

	@Getter
	private final MnCarrLotRelRepo repo;

	public MnCarrLotRel getCarrLotRelByCarr(RequestLifeCycleVo vo, String carrId) {
		return this.repo.findFirstByCarrIdOrderAndUseStatCdOrderByModifiedAt(
			carrId, UseStatCd.Usable
		);

	}

	public MnCarrLotRel getCarrLotRelByLot(RequestLifeCycleVo vo, String lotId) {
		return this.repo.findFirstByLotIdOrderAndUseStatCdOrderByModifiedAt(
			lotId, UseStatCd.Usable
		);
	}
}
