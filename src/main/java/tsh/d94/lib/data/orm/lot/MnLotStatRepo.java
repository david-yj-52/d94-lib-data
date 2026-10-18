package tsh.d94.lib.data.orm.lot;

import org.springframework.stereotype.Repository;

import tsh.d94.lib.core.data.constant.UseStatCd;
import tsh.d94.lib.core.data.orm.common.repo.BaseJpaRepository;

@Repository
public interface MnLotStatRepo extends BaseJpaRepository<MnLotStat, String> {

	MnLotStat findFirstByTenantAndLotIdAndUseStatCdOrderByModifiedAt(String tenant, String lotId, UseStatCd useStatCd);
}
