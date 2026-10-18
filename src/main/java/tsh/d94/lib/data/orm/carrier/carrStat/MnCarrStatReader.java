package tsh.d94.lib.data.orm.carrier.carrStat;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import tsh.d94.lib.core.data.constant.UseStatCd;
import tsh.d94.lib.core.lifecycle.RequestLifeCycleVo;

@Component
@RequiredArgsConstructor
@Slf4j
public class MnCarrStatReader {

	@Getter
	private final MnCarrStatRepo repo;

	public MnCarrStat getCarrStat(RequestLifeCycleVo vo, String carrId) {
		return this.getFirstCarrStat(vo, carrId);
	}

	private MnCarrStat getFirstCarrStat(RequestLifeCycleVo vo, String carrId) {
		MnCarrStat stat = repo.findFirstByTenantAndCarrIdAndUseStatCdOrderByModifiedAt(
			vo.getTenantId(), carrId, UseStatCd.Usable);
		if (stat == null) {
			throw new NullPointerException("not found carr: " + carrId);
		}
		return stat;
	}
}
