package tsh.d94.lib.data.orm.lot;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import tsh.d94.lib.core.data.constant.UseStatCd;
import tsh.d94.lib.core.lifecycle.RequestLifeCycleVo;

@Component
@RequiredArgsConstructor
@Slf4j
public class MnLotStatReader {

	@Getter
	private final MnLotStatRepo repo;

	public MnLotStat getLotStat(RequestLifeCycleVo vo, String lotId) {
		return this.repo.findFirstByTenantAndLotIdAndUseStatCdOrderByModifiedAt(vo.getTenantId(),
			lotId, UseStatCd.Usable);
	}
}
