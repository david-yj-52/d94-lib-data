package tsh.d94.lib.data.orm.carrier.carrStat;

import org.springframework.stereotype.Repository;

import tsh.d94.lib.core.data.constant.UseStatCd;
import tsh.d94.lib.core.data.orm.common.repo.BaseJpaRepository;

@Repository
public interface MnCarrStatRepo extends BaseJpaRepository<MnCarrStat, String> {

	MnCarrStat findFirstByTenantAndCarrIdAndUseStatCdOrderByModifiedAt(String tenant, String carrId,
		UseStatCd useStatCd);
}
